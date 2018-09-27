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
import io.opencensus.integration.jdbc.Observability.TraceOption;
import io.opencensus.integration.jdbc.Observability.TrackingOperation;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.EnumSet;
import java.util.Properties;
import java.util.logging.Logger;

/*
 * OcWrapDriver is a class that wraps and instruments a sql.Driver
 * instance wit htracing and metrics using OpenCensus.
 */
public class OcWrapDriver implements java.sql.Driver {
  private final java.sql.Driver driver;

  public OcWrapDriver(java.sql.Driver driver) throws SQLException {
    this.driver = driver;
  }

  @Override
  public boolean acceptsURL(String url) throws SQLException {
    return this.driver.acceptsURL(url);
  }

  @Override
  public java.sql.Connection connect(String url, Properties info) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Driver.connect", "connect");

    try (Scope ws = trackingOperation.withSpan()) {
      // Retrieve the raw connection then wrap it with the OpenCensus instrumented
      // Connection class instance to provide metrics and traces per call.
      java.sql.Connection conn = this.driver.connect(url, info);
      return new OcWrapConnection(conn, EnumSet.noneOf(TraceOption.class));
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean jdbcCompliant() {
    return this.driver.jdbcCompliant();
  }

  @Override
  public int getMajorVersion() {
    return this.driver.getMajorVersion();
  }

  @Override
  public int getMinorVersion() {
    return this.driver.getMinorVersion();
  }

  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    return this.driver.getParentLogger();
  }

  @Override
  public java.sql.DriverPropertyInfo[] getPropertyInfo(String url, Properties info)
      throws SQLException {
    return this.driver.getPropertyInfo(url, info);
  }
}
