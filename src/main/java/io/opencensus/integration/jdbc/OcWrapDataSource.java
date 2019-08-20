// Copyright 2019, OpenCensus Authors
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

import io.opencensus.integration.jdbc.Observability.TraceOption;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.EnumSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 * Wraps and instruments a {@link javax.sql.DataSource} instance with tracing and metrics using
 * OpenCensus.
 */
public class OcWrapDataSource implements DataSource {

  private final DataSource delegate;
  private final EnumSet<TraceOption> options;

  public static OcWrapDataSource wrap(final DataSource dataSource, final Set<TraceOption> options) {
    return new OcWrapDataSource(dataSource, options);
  }

  private OcWrapDataSource(final DataSource delegate, final Set<TraceOption> options) {
    this.delegate = delegate;
    this.options = EnumSet.copyOf(options);
  }

  @Override
  public Connection getConnection() throws SQLException {
    return wrapConnection(delegate.getConnection());
  }

  @Override
  public Connection getConnection(final String username, final String password)
      throws SQLException {
    return wrapConnection(delegate.getConnection(username, password));
  }

  @Override
  public <T> T unwrap(final Class<T> iface) throws SQLException {
    return delegate.unwrap(iface);
  }

  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    return delegate.isWrapperFor(iface);
  }

  @Override
  public PrintWriter getLogWriter() throws SQLException {
    return delegate.getLogWriter();
  }

  @Override
  public void setLogWriter(final PrintWriter out) throws SQLException {
    delegate.setLogWriter(out);
  }

  @Override
  public void setLoginTimeout(final int seconds) throws SQLException {
    delegate.setLoginTimeout(seconds);
  }

  @Override
  public int getLoginTimeout() throws SQLException {
    return delegate.getLoginTimeout();
  }

  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    return delegate.getParentLogger();
  }

  private OcWrapConnection wrapConnection(final Connection connection) {
    return new OcWrapConnection(connection, options);
  }
}
