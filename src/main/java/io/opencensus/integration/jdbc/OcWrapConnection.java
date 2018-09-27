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
import java.util.EnumSet;
import java.util.concurrent.Executor;

/*
 * OcWrapConnection is a class that wraps a java.sql.Connection and instruments
 * each of its methods with tracing and metrixs using OpenCensus
 */
public class OcWrapConnection implements java.sql.Connection {
  private final java.sql.Connection connection;
  private final boolean shouldAnnotateSpansWithSQL;
  private EnumSet<TraceOption> startOptions;

  public OcWrapConnection(java.sql.Connection connection, EnumSet<TraceOption> opts) {
    this.connection = connection;
    this.shouldAnnotateSpansWithSQL = Observability.shouldAnnotateSpansWithSQL(opts);
    this.startOptions = opts;
  }

  @Override
  public void abort(Executor executor) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.abort", "abort");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.clearWarnings", "clearWarnings");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.close", "close");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.commit", "commit");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.createArrayOf", "createArrayOf");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.createArrayOf(typeName, elements);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Blob createBlob() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.createBlob", "createBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.createBlob();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Clob createClob() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.createClob", "createClob");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.createClob();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.NClob createNClob() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.createNClob", "createNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.createNClob();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.SQLXML createSQLXML() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.createSQLXML", "createSQLXML");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.createSQLXML();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Statement createStatement() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.createStatement", "createStatement");

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.Statement stmt = this.connection.createStatement();
      return new OcWrapStatement(stmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.createStatement", "createStatement");

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.Statement stmt =
          this.connection.createStatement(resultSetType, resultSetConcurrency);
      return new OcWrapStatement(stmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Statement createStatement(
      int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.createStatement", "createStatement");

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.Statement stmt =
          this.connection.createStatement(
              resultSetType, resultSetConcurrency, resultSetHoldability);
      return new OcWrapStatement(stmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Struct createStruct(String typeName, Object[] attributes) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.createStruct", "createStruct");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.createStruct(typeName, attributes);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean getAutoCommit() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.getAutoCommit", "getAutoCommit");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getAutoCommit();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public String getCatalog() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.getCatalog", "getCatalog");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getCatalog();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.util.Properties getClientInfo() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.getClientInfo", "getClientInfo");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getClientInfo();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public String getClientInfo(String name) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.getClientInfo", "getClientInfo");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getClientInfo(name);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getHoldability() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.getHoldability", "getHoldability");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getHoldability();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.DatabaseMetaData getMetaData() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.getMetaData", "getMetaData");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.getNetworkTimeout", "getNetworkTimeout");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getNetworkTimeout();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public String getSchema() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.getSchema", "getSchema");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.getTransactionIsolation", "getTransactionIsolation");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.getTypeMap", "getTypeMap");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getTypeMap();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.SQLWarning getWarnings() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.getWarnings", "getWarnings");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.getWarnings();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isClosed() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.isClosed", "isClosed");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.isClosed();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.isReadOnly", "isReadOnly");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.connection.isReadOnly();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isValid(int timeout) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.isValid", "isValid");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.nativeSQL", "nativeSQL", this.shouldAnnotateSpansWithSQL, SQL);

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.prepareCall", "prepareCall", this.shouldAnnotateSpansWithSQL, SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.CallableStatement cstmt = this.connection.prepareCall(SQL);
      return new OcWrapCallableStatement(cstmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.CallableStatement prepareCall(
      String SQL, int resultSetType, int resultSetConcurrency) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.prepareCall", "prepareCall", this.shouldAnnotateSpansWithSQL, SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.CallableStatement cstmt =
          this.connection.prepareCall(SQL, resultSetType, resultSetConcurrency);
      return new OcWrapCallableStatement(cstmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.CallableStatement prepareCall(
      String SQL, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.prepareCall", "prepareCall", this.shouldAnnotateSpansWithSQL, SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.CallableStatement cstmt =
          this.connection.prepareCall(
              SQL, resultSetType, resultSetConcurrency, resultSetHoldability);
      return new OcWrapCallableStatement(cstmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(String SQL) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.prepareStatement",
            "prepareStatement",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.PreparedStatement pstmt = this.connection.prepareStatement(SQL);
      return new OcWrapPreparedStatement(pstmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(String SQL, int autoGeneratedKeys)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.prepareStatement",
            "prepareStatement",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.PreparedStatement pstmt = this.connection.prepareStatement(SQL, autoGeneratedKeys);
      return new OcWrapPreparedStatement(pstmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(String SQL, int[] columnIndices)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.prepareStatement",
            "prepareStatement",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.PreparedStatement pstmt = this.connection.prepareStatement(SQL, columnIndices);
      return new OcWrapPreparedStatement(pstmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(String SQL, String[] columnNames)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.prepareStatement",
            "prepareStatement",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.PreparedStatement pstmt = this.connection.prepareStatement(SQL, columnNames);
      return new OcWrapPreparedStatement(pstmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(
      String SQL, int resultSetType, int resultSetConcurrency) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.prepareStatement",
            "prepareStatement",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.PreparedStatement pstmt =
          this.connection.prepareStatement(SQL, resultSetType, resultSetConcurrency);
      return new OcWrapPreparedStatement(pstmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.PreparedStatement prepareStatement(
      String SQL, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.prepareStatement",
            "prepareStatement",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.PreparedStatement pstmt =
          this.connection.prepareStatement(
              SQL, resultSetType, resultSetConcurrency, resultSetHoldability);
      return new OcWrapPreparedStatement(pstmt, this.startOptions);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void releaseSavepoint(java.sql.Savepoint savepoint) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.releaseSavepoint", "releaseSavepoint");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.rollback", "rollback");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.rollback", "rollback");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.setAutoCommit", "setAutoCommit");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setAutoCommit(autoCommit);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setCatalog(String catalog) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setCatalog", "setCatalog");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setCatalog(catalog);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setClientInfo(java.util.Properties properties)
      throws java.sql.SQLClientInfoException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.setClientInfo", "setClientInfo");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.setClientInfo", "setClientInfo");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.setHoldability", "setHoldability");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setHoldability(holdability);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setNetworkTimeout(java.util.concurrent.Executor executor, int milliseconds)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.setNetowrkTimeout", "setNetowrkTimeout");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setReadOnly", "setReadOnly");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.setSavepoint", "setSavepoint");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.setSavepoint", "setSavepoint");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.setSavepoint", "setSavepoint");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.Connection.setTransactionIsolation", "setTransactionIsolation");

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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.Connection.setTypeMap", "setTypeMap");

    try (Scope ws = trackingOperation.withSpan()) {
      this.connection.setTypeMap(map);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return this.connection.isWrapperFor(iface);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return this.connection.unwrap(iface);
  }
}
