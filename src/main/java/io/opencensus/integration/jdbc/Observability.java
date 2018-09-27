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
import io.opencensus.tags.TagContext;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public final class Observability {

  private static final StatsRecorder statsRecorder = Stats.getStatsRecorder();
  private static final Tagger tagger = Tags.getTagger();
  private static final Tracer tracer = Tracing.getTracer();

  private static final TagValue DETECTED_OS_NAME =
      TagValue.create(System.getProperty("os.name", ""));
  private static final TagValue DETECTED_ARCH = TagValue.create(System.getProperty("os.arch", ""));
  private static final TagValue DETECTED_OS_VERSION =
      TagValue.create(System.getProperty("os.version", ""));
  private static final TagValue DETECTED_JAVA_VERSION =
      TagValue.create(System.getProperty("java.version", ""));

  // Units of measurement
  private static final String BYTES = "By";
  private static final String DIMENSIONLESS = "1";
  private static final String MILLISECONDS = "ms";

  // Tag keys
  public static final TagKey KEY_METHOD = TagKey.create("method");
  public static final TagKey KEY_PHASE = TagKey.create("phase");
  public static final TagKey KEY_REASON = TagKey.create("reason");
  public static final TagKey KEY_TYPE = TagKey.create("type");

  // Measures
  public static final MeasureLong MEASURE_CALLS =
      MeasureLong.create("java.sql/calls", "The number of calls to the server", DIMENSIONLESS);
  public static final MeasureLong MEASURE_ERRORS =
      MeasureLong.create("java.sql/errors", "The number of errors encountered", DIMENSIONLESS);
  public static final MeasureLong MEASURE_KEY_LENGTH =
      MeasureLong.create("java.sql/key_length", "Records the lengths of keys", BYTES);
  public static final MeasureDouble MEASURE_LATENCY_MS =
      MeasureDouble.create(
          "java.sql/latency", "The latency of calls in milliseconds", MILLISECONDS);
  public static final MeasureLong MEASURE_VALUE_LENGTH =
      MeasureLong.create("java.sql/value_length", "Records the lengths of values", BYTES);

  // Default distribution buckets.
  private static final Aggregation DEFAULT_BYTES_DISTRIBUTION =
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
  private static final Aggregation DEFAULT_MILLISECONDS_DISTRIBUTION =
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

  private static TagContext buildTagContextWithSystemProperties(Map<TagKey, TagValue> tags) {
    TagContextBuilder tagContextBuilder = tagger.currentBuilder();
    for (Map.Entry<TagKey, TagValue> tag : tags.entrySet()) {
      tagContextBuilder.put(tag.getKey(), tag.getValue());
    }
    return tagContextBuilder.build();
  }

  private static void recordTaggedStat(
      TagKey tagKey, String tagValue, MeasureLong measureLong, long value) {
    recordStatWithTags(
        measureLong, value, Collections.singletonMap(tagKey, TagValue.create(tagValue)));
  }

  private static void recordTaggedStat(
      TagKey tagKey, String tagValue, MeasureDouble measureDouble, double value) {
    statsRecorder
        .newMeasureMap()
        .put(measureDouble, value)
        .record(
            buildTagContextWithSystemProperties(
                Collections.singletonMap(tagKey, TagValue.create(tagValue))));
  }

  private static void recordStatWithTags(
      MeasureLong measureLong, long value, Map<TagKey, TagValue> tags) {
    statsRecorder
        .newMeasureMap()
        .put(measureLong, value)
        .record(buildTagContextWithSystemProperties(tags));
  }

  public enum TraceOption {
    NONE,
    ANNOTATE_TRACES_WITH_SQL
  }

  static boolean shouldAnnotateSpansWithSQL(EnumSet<TraceOption> opts) {
    for (TraceOption opt : opts) {
      if (opt == TraceOption.ANNOTATE_TRACES_WITH_SQL) {
        return true;
      }
    }

    return false;
  }

  // TrackingOperation records both the metric latency in milliseconds, and the span created by
  // tracing the calling function.
  static final class TrackingOperation {
    private final Span span;
    private final long startTimeNs;
    private final String method;
    private boolean closed;

    TrackingOperation(String name, String method) {
      this(name, method, null);
    }

    TrackingOperation(String name, String method, String sql) {
      startTimeNs = System.nanoTime();
      span = tracer.spanBuilder(name).startSpan();
      this.method = method;
      if (sql != null) {
        span.putAttribute("sql", AttributeValue.stringAttributeValue(sql));
      }
    }

    @SuppressWarnings("MustBeClosedChecker")
    Scope withSpan() {
      return tracer.withSpan(span);
    }

    void end() {
      if (closed) return;

      try {
        // Record the number of calls of the made method.
        recordTaggedStat(KEY_METHOD, this.method, MEASURE_CALLS, 1L);

        long totalTimeNs = System.nanoTime() - this.startTimeNs;
        double timeSpentMs = ((double) totalTimeNs) / 1e6;

        // Finally record the latency of the entire call.
        recordTaggedStat(KEY_METHOD, this.method, MEASURE_LATENCY_MS, timeSpentMs);
      } finally {
        closed = true;
      }
    }

    // Ends and Annotates the underlying span with the description of the exception and also sets
    // its status to indicate the exception but it also increments the number of errors by 1,
    // adding tags: "method", "reason" to the recorded metric.
    void endWithException(Exception e) {
      String detail = e.toString();
      span.setStatus(Status.INTERNAL.withDescription(detail));
      Map<TagKey, TagValue> tags = new HashMap<>();
      tags.put(KEY_REASON, TagValue.create(detail));
      tags.put(KEY_METHOD, TagValue.create(this.method));
      recordStatWithTags(MEASURE_ERRORS, 1, tags);
    }
  }

  static TrackingOperation createRoundtripTrackingSpan(String spanName, String method) {
    return new TrackingOperation(spanName, method);
  }

  static TrackingOperation createRoundtripTrackingSpan(
      String spanName, String method, boolean canRecordSQL, String sql) {
    return new TrackingOperation(spanName, method, canRecordSQL ? sql : null);
  }

  public static void registerAllViews() {
    Aggregation countAggregation = Aggregation.Count.create();

    View[] views =
        new View[] {
          View.create(
              Name.create("java.sql/client/latency"),
              "The distribution of the latencies of various calls in milliseconds",
              MEASURE_LATENCY_MS,
              DEFAULT_MILLISECONDS_DISTRIBUTION,
              Arrays.asList(KEY_METHOD, KEY_PHASE, KEY_REASON, KEY_TYPE)),
          View.create(
              Name.create("java.sql/client/calls"),
              "The number of various calls of methods",
              MEASURE_CALLS,
              countAggregation,
              Arrays.asList(KEY_METHOD, KEY_PHASE, KEY_REASON, KEY_TYPE)),
          View.create(
              Name.create("java.sql/client/errors"),
              "The number of errors encountered",
              MEASURE_ERRORS,
              countAggregation,
              Arrays.asList(KEY_METHOD, KEY_PHASE, KEY_REASON, KEY_TYPE)),
          View.create(
              Name.create("java.sql/client/key_length"),
              "The distribution of lengths of keys",
              MEASURE_KEY_LENGTH,
              DEFAULT_BYTES_DISTRIBUTION,
              Arrays.asList(KEY_METHOD, KEY_PHASE, KEY_REASON, KEY_TYPE)),
          View.create(
              Name.create("java.sql/client/value_length"),
              "The distribution of lengths of values",
              MEASURE_VALUE_LENGTH,
              DEFAULT_BYTES_DISTRIBUTION,
              Arrays.asList(KEY_METHOD, KEY_PHASE, KEY_REASON, KEY_TYPE))
        };

    ViewManager viewManager = Stats.getViewManager();

    for (View v : views) {
      viewManager.registerView(v);
    }
  }
}
