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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import io.opencensus.integration.jdbc.Observability.TrackingOperation;
import io.opencensus.stats.Aggregation.Distribution;
import io.opencensus.stats.BucketBoundaries;
import io.opencensus.stats.Measure.MeasureDouble;
import io.opencensus.stats.MeasureMap;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewManager;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagContextBuilder;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanBuilder;
import io.opencensus.trace.Status;
import io.opencensus.trace.Tracer;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/** Tests for {@link Observability}. */
@RunWith(JUnit4.class)
public class ObservabilityTest {

  @Mock private ViewManager mockViewManager;
  @Mock private Tagger mockTagger;
  @Mock private StatsRecorder mockStatsRecorder;
  @Mock private Tracer mockTracer;

  @Mock private MeasureMap mockMeasureMap;
  @Mock private TagContextBuilder mockTagContextBuilder;
  @Mock private TagContext mockTagContext;
  @Mock private Span mockSpan;
  @Mock private SpanBuilder mockSpanBuilder;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    Mockito.doNothing().when(mockViewManager).registerView(any(View.class));
    Mockito.when(mockTagger.currentBuilder()).thenReturn(mockTagContextBuilder);
    Mockito.when(mockTagContextBuilder.put(any(TagKey.class), any(TagValue.class)))
        .thenReturn(mockTagContextBuilder);
    Mockito.when(mockTagContextBuilder.build()).thenReturn(mockTagContext);
    Mockito.when(mockStatsRecorder.newMeasureMap()).thenReturn(mockMeasureMap);
    Mockito.when(mockMeasureMap.put(any(MeasureDouble.class), anyDouble()))
        .thenReturn(mockMeasureMap);
    Mockito.doNothing().when(mockMeasureMap).record(any(TagContext.class));
    Mockito.when(mockTracer.spanBuilderWithExplicitParent(anyString(), anyObject()))
        .thenReturn(mockSpanBuilder);
    Mockito.when(mockSpanBuilder.startSpan()).thenReturn(mockSpan);
    Mockito.doNothing().when(mockSpan).putAttribute(anyString(), any(AttributeValue.class));
  }

  @Test
  public void testConstants() {
    assertThat(Observability.JAVA_SQL_METHOD).isEqualTo(TagKey.create("java_sql_method"));
    assertThat(Observability.JAVA_SQL_ERROR).isEqualTo(TagKey.create("java_sql_error"));
    assertThat(Observability.JAVA_SQL_STATUS).isEqualTo(TagKey.create("java_sql_status"));
    assertThat(Observability.VALUE_OK).isEqualTo(TagValue.create("OK"));
    assertThat(Observability.VALUE_ERROR).isEqualTo(TagValue.create("ERROR"));
    assertThat(Observability.MEASURE_LATENCY_MS)
        .isEqualTo(
            MeasureDouble.create("java.sql/latency", "The latency of calls in milliseconds", "ms"));
    assertThat(Observability.DEFAULT_MILLISECONDS_DISTRIBUTION)
        .isEqualTo(
            Distribution.create(
                BucketBoundaries.create(
                    Arrays.asList(
                        // [0ms, 0.001ms, 0.005ms, 0.01ms, 0.05ms, 0.1ms, 0.5ms, 1ms, 1.5ms, 2ms,
                        // 2.5ms,
                        // 5ms, 10ms, 25ms, 50ms, 100ms, 200ms, 400ms, 600ms, 800ms, 1s, 1.5s, 2s,
                        // 2.5s,
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
                        500000.0))));
  }

  @Test
  public void registerAllViews() {
    Observability.registerAllViews(mockViewManager);
    Mockito.verify(mockViewManager, Mockito.times(1))
        .registerView(Observability.SQL_CLIENT_CALLS_VIEW);
    Mockito.verify(mockViewManager, Mockito.times(1))
        .registerView(Observability.SQL_CLIENT_LATENCY_VIEW);
  }

  @Test
  public void trackingOperation_withSpan() {
    TrackingOperation trackingOperation =
        new TrackingOperation("method", "update", mockStatsRecorder, mockTagger, mockTracer);
    trackingOperation.withSpan();
    Mockito.verify(mockTracer, Mockito.times(1)).spanBuilderWithExplicitParent("method", null);
    Mockito.verify(mockSpanBuilder, Mockito.times(1)).startSpan();
    Mockito.verify(mockSpan, Mockito.times(1))
        .putAttribute("sql", AttributeValue.stringAttributeValue("update"));
  }

  @Test
  public void trackingOperation_end() {
    TrackingOperation trackingOperation =
        new TrackingOperation("method", "update", mockStatsRecorder, mockTagger, mockTracer);
    trackingOperation.end();
    Mockito.verify(mockTagger, Mockito.times(1)).currentBuilder();
    Mockito.verify(mockTagContextBuilder, Mockito.times(1))
        .put(eq(Observability.JAVA_SQL_METHOD), eq(TagValue.create("method")));
    Mockito.verify(mockTagContextBuilder, Mockito.times(1))
        .put(eq(Observability.JAVA_SQL_STATUS), eq(Observability.VALUE_OK));
    Mockito.verify(mockStatsRecorder, Mockito.times(1)).newMeasureMap();
    Mockito.verify(mockMeasureMap, Mockito.times(1))
        .put(eq(Observability.MEASURE_LATENCY_MS), anyDouble());
    Mockito.verify(mockMeasureMap, Mockito.times(1)).record(any(TagContext.class));
    Mockito.verify(mockSpan, Mockito.times(1)).end();
  }

  @Test
  public void trackingOperation_end_recordException() {
    TrackingOperation trackingOperation =
        new TrackingOperation("method", "update", mockStatsRecorder, mockTagger, mockTracer);
    IllegalArgumentException exception = new IllegalArgumentException("message");
    trackingOperation.recordException(exception);
    trackingOperation.end();
    Mockito.verify(mockTagger, Mockito.times(1)).currentBuilder();
    Mockito.verify(mockTagContextBuilder, Mockito.times(1))
        .put(eq(Observability.JAVA_SQL_METHOD), eq(TagValue.create("method")));
    Mockito.verify(mockTagContextBuilder, Mockito.times(1))
        .put(eq(Observability.JAVA_SQL_ERROR), eq(TagValue.create(exception.toString())));
    Mockito.verify(mockTagContextBuilder, Mockito.times(1))
        .put(eq(Observability.JAVA_SQL_STATUS), eq(Observability.VALUE_ERROR));
    Mockito.verify(mockSpan, Mockito.times(1))
        .setStatus(eq(Status.UNKNOWN.withDescription(exception.toString())));
    Mockito.verify(mockStatsRecorder, Mockito.times(1)).newMeasureMap();
    Mockito.verify(mockMeasureMap, Mockito.times(1))
        .put(eq(Observability.MEASURE_LATENCY_MS), anyDouble());
    Mockito.verify(mockMeasureMap, Mockito.times(1)).record(any(TagContext.class));
    Mockito.verify(mockSpan, Mockito.times(1)).end();
  }
}
