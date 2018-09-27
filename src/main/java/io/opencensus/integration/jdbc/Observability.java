// Copyright 2018, OpenCensus Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package io.opencensus.integration.jdbc;

import io.opencensus.common.Scope;
import io.opencensus.stats.Aggregation;
import io.opencensus.stats.Aggregation.Distribution;
import io.opencensus.stats.BucketBoundaries;
import io.opencensus.stats.Measure.MeasureDouble;
import io.opencensus.stats.Measure.MeasureLong;
import io.opencensus.stats.Stats;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.stats.View;
import io.opencensus.stats.View.Name;
import io.opencensus.stats.ViewManager;
import io.opencensus.tags.TagContextBuilder;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Observability {
  private static final StatsRecorder statsRecorder = Stats.getStatsRecorder();
  private static final Tagger tagger = Tags.getTagger();
  private static final Tracer tracer = Tracing.getTracer();

  private static final String DETECTED_OS_NAME = System.getProperty("os.name", "");
  private static final String DETECTED_ARCH = System.getProperty("os.arch", "");
  private static final String DETECTED_OS_VERSION = System.getProperty("os.version", "");
  private static final String DETECTED_JAVA_VERSION = System.getProperty("java.version", "");

  // Units of measurement
  private static final String BYTES = "By";
  private static final String DIMENSIONLESS = "1";
  private static final String MILLISECONDS = "ms";

  // Tag keys
  public static final TagKey keyMethod = TagKey.create("method");
  public static final TagKey keyPhase = TagKey.create("phase");
  public static final TagKey keyReason = TagKey.create("reason");
  public static final TagKey keyType = TagKey.create("type");
  private static final TagKey keyArchitecture = TagKey.create("arch");
  private static final TagKey keyJavaVersion = TagKey.create("java_version");
  private static final TagKey keyOSName = TagKey.create("os_name");
  private static final TagKey keyOSVersion = TagKey.create("os_version");

  private static List<TagKeyPair> mandatorySystemTagKeyPairs =
      Arrays.asList(
          tagKeyPair(keyArchitecture, DETECTED_ARCH),
          tagKeyPair(keyJavaVersion, DETECTED_JAVA_VERSION),
          tagKeyPair(keyOSName, DETECTED_OS_NAME),
          tagKeyPair(keyOSVersion, DETECTED_OS_VERSION));

  // Measures
  public static final MeasureLong mCalls =
      MeasureLong.create("java.sql/calls", "The number of calls to the server", DIMENSIONLESS);
  public static final MeasureLong mErrors =
      MeasureLong.create("java.sql/errors", "The number of errors encountered", DIMENSIONLESS);
  public static final MeasureLong mKeyLength =
      MeasureLong.create("java.sql/key_length", "Records the lengths of keys", DIMENSIONLESS);
  public static final MeasureDouble mLatencyMs =
      MeasureDouble.create(
          "java.sql/latency", "The latency of calls in milliseconds", MILLISECONDS);
  public static final MeasureLong mValueLength =
      MeasureLong.create("java.sql/value_length", "Records the lengths of values", DIMENSIONLESS);

  private static Scope buildTagContextAndScopeWithSystemProperties(TagKeyPair... pairs) {
    TagContextBuilder tb = tagger.emptyBuilder();
    for (TagKeyPair kvp : pairs) {
      tb.put(kvp.key, TagValue.create(kvp.value));
    }

    // It is imperative that we record the various mandatory OS and System identifiers.
    // See Issue https://github.com/opencensus-integrations/ocjdbc/issues/4
    // As they are very useful in helping disambiguate between processes.
    for (TagKeyPair mandatoryKVP : mandatorySystemTagKeyPairs) {
      tb.put(mandatoryKVP.key, TagValue.create(mandatoryKVP.value));
    }
    return tagger.withTagContext(tb.build());
  }

  public static void recordTaggedStat(TagKey key, String value, MeasureLong ml, int i) {
    recordTaggedStat(key, value, ml, new Long(i));
  }

  public static void recordTaggedStat(TagKey key, String value, MeasureLong ml, Long l) {
    Scope ss = buildTagContextAndScopeWithSystemProperties(tagKeyPair(key, value));
    statsRecorder.newMeasureMap().put(ml, l).record();
    ss.close();
  }

  public static void recordTaggedStat(TagKey key, String value, MeasureDouble md, Double d) {
    Scope ss = buildTagContextAndScopeWithSystemProperties(tagKeyPair(key, value));
    statsRecorder.newMeasureMap().put(md, d).record();
    ss.close();
  }

  public static void recordStatWithTags(MeasureLong ml, long l, TagKeyPair... pairs) {
    Scope ss = buildTagContextAndScopeWithSystemProperties(pairs);
    statsRecorder.newMeasureMap().put(ml, l).record();
    ss.close();
  }

  public enum TraceOption {
    NONE,
    ANNOTATE_TRACES_WITH_SQL;
  }

  public static final TraceOption OPTION_ANNOTATE_TRACES_WITH_SQL =
      TraceOption.ANNOTATE_TRACES_WITH_SQL;

  public static boolean shouldAnnotateSpansWithSQL(TraceOption... opts) {
    for (TraceOption opt : opts) {
      if (opt == TraceOption.ANNOTATE_TRACES_WITH_SQL) {
        return true;
      }
    }

    return false;
  }

  // RoundtripTrackingSpan records both the metric latency in
  // milliseconds, and the span created by tracing the calling function.
  public static class RoundtripTrackingSpan implements AutoCloseable {
    private Span span;
    private Scope spanScope;
    private long startTimeNs;
    private String method;
    private boolean closed;

    @SuppressWarnings("MustBeClosedChecker") // Span closed in end().
    public RoundtripTrackingSpan(String name, String method) {
      this.startTimeNs = System.nanoTime();
      this.spanScope = tracer.spanBuilder(name).startScopedSpan();
      this.span = tracer.getCurrentSpan();
      this.method = method;
    }

    public RoundtripTrackingSpan(
        String name, String method, boolean shouldAnnotateWithSQL, String SQL) {
      this(name, method);
      if (shouldAnnotateWithSQL)
        this.span.putAttribute("sql", AttributeValue.stringAttributeValue(SQL));
    }

    public void end() {
      if (this.closed) return;

      try {
        // Record the number of calls of the made method.
        recordTaggedStat(keyMethod, this.method, mCalls, 1);

        long totalTimeNs = System.nanoTime() - this.startTimeNs;
        double timeSpentMs = (new Double(totalTimeNs)) / 1e6;

        // Finally record the latency of the entire call.
        recordTaggedStat(keyMethod, this.method, mLatencyMs, timeSpentMs);
      } finally {
        this.spanScope.close();
        this.closed = true;
      }
    }

    @Override
    public void close() {
      this.end();
    }

    /*
     * recordException annotates the underlying span with the description of the exception
     * and also sets its status to indicate the exception but it also increments the number
     * of errors by 1, adding tags: "method", "reason" to the recorded metric.
     * */
    public void recordException(Exception e) {
      String detail = e.toString();
      this.span.setStatus(Status.INTERNAL.withDescription(detail));
      recordStatWithTags(
          mErrors, 1, tagKeyPair(keyReason, detail), tagKeyPair(keyMethod, this.method));
    }
  }

  public static RoundtripTrackingSpan createRoundtripTrackingSpan(String spanName, String method) {
    return new RoundtripTrackingSpan(spanName, method);
  }

  public static RoundtripTrackingSpan createRoundtripTrackingSpan(
      String spanName, String method, boolean canRecordSQL, String SQL) {
    return new RoundtripTrackingSpan(spanName, method, canRecordSQL, SQL);
  }

  public static class TagKeyPair {
    private TagKey key;
    private String value;

    public TagKeyPair(TagKey key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  public static TagKeyPair tagKeyPair(TagKey key, String value) {
    return new TagKeyPair(key, value);
  }

  private static List<TagKey> addMandatorySystemTagKeys(TagKey... customTagKeys) {
    List<TagKey> out = new ArrayList<TagKey>();
    for (TagKey tagKey : customTagKeys) out.add(tagKey);

    for (TagKeyPair kvp : mandatorySystemTagKeyPairs) out.add(kvp.key);

    return out;
  }

  public static void registerAllViews() {
    Aggregation defaultBytesDistribution =
        Distribution.create(
            BucketBoundaries.create(
                Arrays.asList(
                    // [0, 1KB,  2KB,    4KB,    16KB,    64KB,    256KB,    1MB,       4MB,
                    // 16MB,       64MB,       256MB,       1GB,          2GB,          4GB]
                    0.0,
                    1024.0,
                    2048.0,
                    4096.0,
                    16384.0,
                    65536.0,
                    262144.0,
                    1048576.0,
                    4194304.0,
                    16777216.0,
                    67108864.0,
                    268435456.0,
                    1073741824.0,
                    2147483648.0,
                    4294967296.0)));

    Aggregation defaultMillisecondsDistribution =
        Distribution.create(
            BucketBoundaries.create(
                Arrays.asList(
                    // [0ms, 0.001ms, 0.005ms, 0.01ms, 0.05ms, 0.1ms, 0.5ms, 1ms, 1.5ms, 2ms, 2.5ms,
                    // 5ms, 10ms, 25ms, 50ms, 100ms, 200ms, 400ms, 600ms, 800ms, 1s, 1.5s, 2s, 2.5s,
                    // 5s, 10s, 20s, 40s, 100s, 200s, 500s]
                    0.0,
                    0.001,
                    0.005,
                    0.01,
                    0.05,
                    0.1,
                    0.5,
                    1.0,
                    1.5,
                    2.0,
                    2.5,
                    5.0,
                    10.0,
                    25.0,
                    50.0,
                    100.0,
                    200.0,
                    400.0,
                    600.0,
                    800.0,
                    1000.0,
                    1500.0,
                    2000.0,
                    2500.0,
                    5000.0,
                    10000.0,
                    20000.0,
                    40000.0,
                    100000.0,
                    200000.0,
                    500000.0)));

    Aggregation countAggregation = Aggregation.Count.create();
    List<TagKey> noKeys = new ArrayList<TagKey>();

    View[] views =
        new View[] {
          View.create(
              Name.create("java.sql/client/latency"),
              "The distribution of the latencies of various calls in milliseconds",
              mLatencyMs,
              defaultMillisecondsDistribution,
              addMandatorySystemTagKeys(keyMethod, keyPhase, keyReason, keyType)),
          View.create(
              Name.create("java.sql/client/calls"),
              "The number of various calls of methods",
              mCalls,
              countAggregation,
              addMandatorySystemTagKeys(keyMethod, keyPhase, keyReason, keyType)),
          View.create(
              Name.create("java.sql/client/errors"),
              "The number of errors encountered",
              mErrors,
              countAggregation,
              addMandatorySystemTagKeys(keyMethod, keyPhase, keyReason, keyType)),
          View.create(
              Name.create("java.sql/client/key_length"),
              "The distribution of lengths of keys",
              mKeyLength,
              defaultBytesDistribution,
              addMandatorySystemTagKeys(keyMethod, keyPhase, keyReason, keyType)),
          View.create(
              Name.create("java.sql/client/value_length"),
              "The distribution of lengths of values",
              mValueLength,
              defaultBytesDistribution,
              addMandatorySystemTagKeys(keyMethod, keyPhase, keyReason, keyType))
        };

    ViewManager vmgr = Stats.getViewManager();

    for (View v : views) {
      vmgr.registerView(v);
    }
  }
}
