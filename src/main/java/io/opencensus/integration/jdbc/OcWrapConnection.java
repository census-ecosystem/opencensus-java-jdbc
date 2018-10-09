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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.EnumSet;
import java.util.concurrent.Executor;

/**
 * Wraps and instruments a {@link Connection} instance with tracing and metrics using OpenCensus.
 */
public class OcWrapConnection implements Connection {
  private final Connection connection;
  private final boolean shouldAnnotateSpansWithSQL;
  private EnumSet<TraceOption> startOptions;

  public OcWrapConnection(Connection connection, EnumSet<TraceOption> opts) {
    this.connection = connection;
    this.shouldAnnotateSpansWithSQL = Observability.shouldAnnotateSpansWithSQL(opts);
    this.startOptions = opts;
  }

  @Override
  public void abort(Executor executor) throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#abort-java.util.concurrent.Executor-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.abort");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.abort(executor);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void clearWarnings() throws SQLException {
    // This method may directly touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#clearWarnings--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.clearWarnings");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.clearWarnings();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void close() throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#close--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.close");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.close();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void commit() throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#commit--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.commit");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.commit();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Array createArrayOf(String typeName, Object[] elements) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#createArrayOf-java.lang.String-java.lang.Object:A-
    return this.connection.createArrayOf(typeName, elements);
  }

  @Override
  public java.sql.Blob createBlob() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#createBlob--
    return this.connection.createBlob();
  }

  @Override
  public java.sql.Clob createClob() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#createClob--
    return this.connection.createClob();
  }

  @Override
  public java.sql.NClob createNClob() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#createNClob--
    return this.connection.createNClob();
  }

  @Override
  public java.sql.SQLXML createSQLXML() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#createSQLXML--
    return this.connection.createSQLXML();
  }

  @Override
  public java.sql.Statement createStatement() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#createStatement--
    java.sql.Statement stmt = this.connection.createStatement();
    return new OcWrapStatement(stmt, this.startOptions);
  }

  @Override
  public java.sql.Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#createStatement-int-int-
    java.sql.Statement stmt = this.connection.createStatement(resultSetType, resultSetConcurrency);
    return new OcWrapStatement(stmt, this.startOptions);
  }

  @Override
  public java.sql.Statement createStatement(
      int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#createStatement-int-int-int-
    java.sql.Statement stmt =
        this.connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    return new OcWrapStatement(stmt, this.startOptions);
  }

  @Override
  public java.sql.Struct createStruct(String typeName, Object[] attributes) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#createStruct-java.lang.String-java.lang.Object:A-
    return this.connection.createStruct(typeName, attributes);
  }

  @Override
  public boolean getAutoCommit() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getAutoCommit--
    return this.connection.getAutoCommit();
  }

  @Override
  public String getCatalog() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getCatalog--
    return this.connection.getCatalog();
  }

  @Override
  public java.util.Properties getClientInfo() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getClientInfo--
    return this.connection.getClientInfo();
  }

  @Override
  public String getClientInfo(String name) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getClientInfo-java.lang.String-
    return this.connection.getClientInfo(name);
  }

  @Override
  public int getHoldability() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getHoldability--
    return this.connection.getHoldability();
  }

  @Override
  public java.sql.DatabaseMetaData getMetaData() throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getMetaData--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.getMetaData");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getMetaData();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getNetworkTimeout() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getNetworkTimeout--
    return this.connection.getNetworkTimeout();
  }

  @Override
  public String getSchema() throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getSchema--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.getSchema");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getSchema();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getTransactionIsolation() throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getTransactionIsolation--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.getTransactionIsolation");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getTransactionIsolation();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.util.Map<String, Class<?>> getTypeMap() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getTypeMap--
    return this.connection.getTypeMap();
  }

  @Override
  public java.sql.SQLWarning getWarnings() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#getWarnings--
    return this.connection.getWarnings();
  }

  @Override
  public boolean isClosed() throws SQLException {
    // This method doesn't touch the database:
    return this.connection.isClosed();
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    // This method doesn't touch the database:
    return this.connection.isReadOnly();
  }

  @Override
  public boolean isValid(int timeout) throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#isValid-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.isValid");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.isValid(timeout);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public String nativeSQL(String SQL) throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#nativeSQL-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.nativeSQL", this.shouldAnnotateSpansWithSQL, SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.nativeSQL(SQL);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.CallableStatement prepareCall(String SQL) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#prepareCall-java.lang.String-
    java.sql.CallableStatement cstmt = this.connection.prepareCall(SQL);
    return new OcWrapCallableStatement(cstmt, this.startOptions);
  }

  @Override
  public java.sql.CallableStatement prepareCall(
      String SQL, int resultSetType, int resultSetConcurrency) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#prepareCall-java.lang.String-int-int-
    java.sql.CallableStatement cstmt =
        this.connection.prepareCall(SQL, resultSetType, resultSetConcurrency);
    return new OcWrapCallableStatement(cstmt, this.startOptions);
  }

  @Override
  public java.sql.CallableStatement prepareCall(
      String SQL, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#prepareCall-java.lang.String-int-int-int-
    java.sql.CallableStatement cstmt =
        this.connection.prepareCall(SQL, resultSetType, resultSetConcurrency, resultSetHoldability);
    return new OcWrapCallableStatement(cstmt, this.startOptions);
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(String SQL) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#prepareStatement-java.lang.String-
    java.sql.PreparedStatement pstmt = this.connection.prepareStatement(SQL);
    return new OcWrapPreparedStatement(pstmt, this.startOptions);
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(String SQL, int autoGeneratedKeys)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#prepareStatement-java.lang.String-int-
    java.sql.PreparedStatement pstmt = this.connection.prepareStatement(SQL, autoGeneratedKeys);
    return new OcWrapPreparedStatement(pstmt, this.startOptions);
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(String SQL, int[] columnIndices)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#prepareStatement-java.lang.String-int:A-
    java.sql.PreparedStatement pstmt = this.connection.prepareStatement(SQL, columnIndices);
    return new OcWrapPreparedStatement(pstmt, this.startOptions);
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(String SQL, String[] columnNames)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#prepareStatement-java.lang.String-java.lang.String:A-
    java.sql.PreparedStatement pstmt = this.connection.prepareStatement(SQL, columnNames);
    return new OcWrapPreparedStatement(pstmt, this.startOptions);
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(
      String SQL, int resultSetType, int resultSetConcurrency) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#prepareStatement-java.lang.String-int-int
    java.sql.PreparedStatement pstmt =
        this.connection.prepareStatement(SQL, resultSetType, resultSetConcurrency);
    return new OcWrapPreparedStatement(pstmt, this.startOptions);
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(
      String SQL, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#prepareStatement-java.lang.String-int-int-int-
    java.sql.PreparedStatement pstmt =
        this.connection.prepareStatement(
            SQL, resultSetType, resultSetConcurrency, resultSetHoldability);
    return new OcWrapPreparedStatement(pstmt, this.startOptions);
  }

  @Override
  public void releaseSavepoint(java.sql.Savepoint savepoint) throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#releaseSavepoint-java.sql.Savepoint-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.releaseSavepoint");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.releaseSavepoint(savepoint);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void rollback() throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#rollback--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.rollback");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.rollback();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void rollback(java.sql.Savepoint savepoint) throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#rollback-java.sql.Savepoint-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.rollback");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.rollback(savepoint);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setAutoCommit(boolean autoCommit) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setAutoCommit-boolean-
    this.connection.setAutoCommit(autoCommit);
  }

  @Override
  public void setCatalog(String catalog) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setCatalog-java.lang.String-
    this.connection.setCatalog(catalog);
  }

  @Override
  public void setClientInfo(java.util.Properties properties)
      throws java.sql.SQLClientInfoException {
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setClientInfo-java.util.Properties-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setClientInfo");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setClientInfo(properties);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setClientInfo(String name, String value) throws java.sql.SQLClientInfoException {
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setClientInfo-java.lang.String-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setClientInfo");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setClientInfo(name, value);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setHoldability(int holdability) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setHoldability-int-
    this.connection.setHoldability(holdability);
  }

  @Override
  public void setNetworkTimeout(java.util.concurrent.Executor executor, int milliseconds)
      throws SQLException {
    // This method may touch the database or incur some expenses:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setNetworkTimeout-java.util.concurrent.Executor-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setNetowrkTimeout");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setNetworkTimeout(executor, milliseconds);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setReadOnly(boolean readOnly) throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setReadOnly-boolean-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setReadOnly");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setReadOnly(readOnly);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Savepoint setSavepoint() throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setSavepoint--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setSavepoint");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.setSavepoint();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Savepoint setSavepoint(String name) throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setSavepoint-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setSavepoint");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.setSavepoint(name);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setSchema(String schema) throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setSchema-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setSavepoint");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setSchema(schema);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setTransactionIsolation(int level) throws SQLException {
    // This method directly touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setTransactionIsolation-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setTransactionIsolation");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setTransactionIsolation(level);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setTypeMap(java.util.Map<String, Class<?>> map) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html#setTypeMap-java.util.Map-
    this.connection.setTypeMap(map);
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Wrapper.html#isWrapperFor-java.lang.Class-
    return this.connection.isWrapperFor(iface);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Wrapper.html#unwrap-java.lang.Class-
    return this.connection.unwrap(iface);
  }
}
