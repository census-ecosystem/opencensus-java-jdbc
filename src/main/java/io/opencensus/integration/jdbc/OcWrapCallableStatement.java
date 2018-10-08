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
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.EnumSet;

/**
 * Wraps and instruments a {@link CallableStatement} instance with tracing and metrics using
 * OpenCensus.
 */
public class OcWrapCallableStatement implements CallableStatement {
  private final CallableStatement callableStatement;
  private final boolean shouldAnnotateSpansWithSQL;

  public OcWrapCallableStatement(CallableStatement callableStatement, EnumSet<TraceOption> opts) {
    this.callableStatement = callableStatement;
    this.shouldAnnotateSpansWithSQL = Observability.shouldAnnotateSpansWithSQL(opts);
  }

  @Override
  public void addBatch() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#addBatch--
    this.callableStatement.addBatch();
  }

  @Override
  public void addBatch(String SQL) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#addBatch-java.lang.String-
    this.callableStatement.addBatch(SQL);
  }

  @Override
  public void cancel() throws SQLException {
    // This method touches the database connection:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#cancel--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.cancel", "cancel");

    try (Scope ws = trackingOperation.withSpan()) {
      this.callableStatement.cancel();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void clearBatch() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#clearBatch--
    this.callableStatement.clearBatch();
  }

  @Override
  public void clearWarnings() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#clearWarnings--
    this.callableStatement.clearWarnings();
  }

  @Override
  public void clearParameters() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#clearParameters--
    this.callableStatement.clearParameters();
  }

  @Override
  public void close() throws SQLException {
    // This method touches the database connection:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#close--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.close", "close");

    try (Scope ws = trackingOperation.withSpan()) {
      this.callableStatement.close();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void closeOnCompletion() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#closeOnCompletion--
    this.callableStatement.closeOnCompletion();
  }

  @Override
  public boolean execute() throws SQLException {
    // This method touches the database connection:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#execute--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.execute", "execute");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.execute();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL) throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#execute-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.execute(SQL);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL, String[] columnNames) throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#execute-java.lang.String-java.lang.String:A-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.execute(SQL, columnNames);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL, int[] columnIndices) throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#execute-java.lang.String-int:A-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.execute(SQL, columnIndices);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL, int autoGeneratedKeys) throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#execute-java.lang.String-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.execute(SQL, autoGeneratedKeys);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int[] executeBatch() throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#executeBatch--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.executeBatch", "executeBatch");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.executeBatch();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSet executeQuery(String SQL) throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#executeQuery-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.executeQuery",
            "executeQuery",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.ResultSet rs = this.callableStatement.executeQuery(SQL);
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL) throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#executeUpdate-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.executeUpdate(SQL);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL, int autoGeneratedKeys) throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#executeUpdate-java.lang.String-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.executeUpdate(SQL, autoGeneratedKeys);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL, int[] columnIndices) throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#executeUpdate-java.lang.String-java.lang.String:A-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.executeUpdate(SQL, columnIndices);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL, String[] columnNames) throws SQLException {
    // This method touches the database connection:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#executeUpdate-java.lang.String-java.lang.String:A-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.executeUpdate(SQL, columnNames);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSet executeQuery() throws SQLException {
    // This method touches the database connection:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#executeQuery--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.executeQuery", "executeQuery");

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.ResultSet rs = this.callableStatement.executeQuery();
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate() throws SQLException {
    // This method touches the database connection:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#executeUpdate--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.executeUpdate", "executeUpdate");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.executeUpdate();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getFetchDirection() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getFetchDirection--
    return this.callableStatement.getFetchDirection();
  }

  @Override
  public int getFetchSize() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getFetchSize--
    return this.callableStatement.getFetchSize();
  }

  @Override
  public java.sql.ResultSet getGeneratedKeys() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getGeneratedKeys--
    java.sql.ResultSet rs = this.callableStatement.getGeneratedKeys();
    return new OcWrapResultSet(rs);
  }

  @Override
  public int getMaxFieldSize() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getMaxFieldSize--
    return this.callableStatement.getMaxFieldSize();
  }

  @Override
  public int getMaxRows() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getMaxRows--
    return this.callableStatement.getMaxRows();
  }

  @Override
  public java.sql.ResultSetMetaData getMetaData() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#getMetaData--
    return this.callableStatement.getMetaData();
  }

  @Override
  public boolean getMoreResults(int current) throws SQLException {
    // This method may directly touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getMoreResults-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getMoreResults", "getMoreResults");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.getMoreResults(current);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean getMoreResults() throws SQLException {
    // This method may directly touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getMoreResults--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getMoreResults", "getMoreResults");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.callableStatement.getMoreResults();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSet getResultSet() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getResultSet--
    java.sql.ResultSet rs = this.callableStatement.getResultSet();
    return new OcWrapResultSet(rs);
  }

  @Override
  public int getResultSetConcurrency() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getResultSetConcurrency--
    return this.callableStatement.getResultSetConcurrency();
  }

  @Override
  public int getQueryTimeout() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getQueryTimeout--
    return this.callableStatement.getQueryTimeout();
  }

  @Override
  public java.sql.Connection getConnection() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getConnection--
    return this.callableStatement.getConnection();
  }

  @Override
  public java.sql.ParameterMetaData getParameterMetaData() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#getParameterMetaData--
    return this.callableStatement.getParameterMetaData();
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getResultSetHoldability--
    return this.callableStatement.getResultSetHoldability();
  }

  @Override
  public int getResultSetType() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getResultSetType--
    return this.callableStatement.getResultSetType();
  }

  @Override
  public int getUpdateCount() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getUpdateCount--
    return this.callableStatement.getUpdateCount();
  }

  @Override
  public java.sql.SQLWarning getWarnings() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getWarnings--
    return this.callableStatement.getWarnings();
  }

  @Override
  public java.sql.Array getArray(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getArray-int-
    return this.callableStatement.getArray(parameterIndex);
  }

  @Override
  public java.sql.Array getArray(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getArray-java.lang.String-
    return this.callableStatement.getArray(parameterName);
  }

  @Override
  public void setArray(int parameterIndex, java.sql.Array x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setArray-int-java.sql.Array-
    this.callableStatement.setArray(parameterIndex, x);
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setAsciiStream-java.lang.String-java.io.InputStream-
    this.callableStatement.setAsciiStream(parameterIndex, stream);
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setAsciiStream-java.lang.String-java.io.InputStream-int-
    this.callableStatement.setAsciiStream(parameterIndex, stream, length);
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setAsciiStream-java.lang.String-java.io.InputStream-long-
    this.callableStatement.setAsciiStream(parameterIndex, stream, length);
  }

  @Override
  public void setAsciiStream(String parameterName, java.io.InputStream stream) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setAsciiStream-int-java.io.InputStream-
    this.callableStatement.setAsciiStream(parameterName, stream);
  }

  @Override
  public void setAsciiStream(String parameterName, java.io.InputStream stream, int length)
      throws SQLException {
    // This method doesn't touch the database:
    this.callableStatement.setAsciiStream(parameterName, stream, length);
  }

  @Override
  public void setAsciiStream(String parameterName, java.io.InputStream stream, long length)
      throws SQLException {
    // This method doesn't touch the database:
    this.callableStatement.setAsciiStream(parameterName, stream, length);
  }

  @Override
  public java.math.BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getBigDecimal-int-
    return this.callableStatement.getBigDecimal(parameterIndex);
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.math.BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getBigDecimal-int-int-
    return this.callableStatement.getBigDecimal(parameterIndex, scale);
  }

  @Override
  public java.math.BigDecimal getBigDecimal(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getBigDecimal-java.lang.String-
    return this.callableStatement.getBigDecimal(parameterName);
  }

  @Override
  public void setBigDecimal(int parameterIndex, java.math.BigDecimal x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setBigDecimal-java.lang.String-java.math.BigDecimal-
    this.callableStatement.setBigDecimal(parameterIndex, x);
  }

  @Override
  public void setBigDecimal(String parameterName, java.math.BigDecimal x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBigDecimal-int-java.math.BigDecimal-
    this.callableStatement.setBigDecimal(parameterName, x);
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setBinaryStream-java.lang.String-java.io.InputStream-
    this.callableStatement.setBinaryStream(parameterIndex, stream);
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setBinaryStream-java.lang.String-java.io.InputStream-int-
    this.callableStatement.setBinaryStream(parameterIndex, stream, length);
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setBinaryStream-java.lang.String-java.io.InputStream-long-
    this.callableStatement.setBinaryStream(parameterIndex, stream, length);
  }

  @Override
  public void setBinaryStream(String parameterName, java.io.InputStream stream)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBinaryStream-int-java.io.InputStream-
    this.callableStatement.setBinaryStream(parameterName, stream);
  }

  @Override
  public void setBinaryStream(String parameterName, java.io.InputStream stream, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBinaryStream-int-java.io.InputStream-int-
    this.callableStatement.setBinaryStream(parameterName, stream, length);
  }

  @Override
  public void setBinaryStream(String parameterName, java.io.InputStream stream, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBinaryStream-int-java.io.InputStream-long-
    this.callableStatement.setBinaryStream(parameterName, stream, length);
  }

  @Override
  public java.sql.Blob getBlob(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getBlob-int-
    return this.callableStatement.getBlob(parameterIndex);
  }

  @Override
  public java.sql.Blob getBlob(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getBlob-java.lang.String-
    return this.callableStatement.getBlob(parameterName);
  }

  @Override
  public void setBlob(int parameterIndex, java.sql.Blob x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setBlob-java.lang.String-java.sql.Blob-
    this.callableStatement.setBlob(parameterIndex, x);
  }

  @Override
  public void setBlob(int parameterIndex, java.io.InputStream x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setBlob-java.lang.String-java.io.InputStream-
    this.callableStatement.setBlob(parameterIndex, x);
  }

  @Override
  public void setBlob(int parameterIndex, java.io.InputStream inputStream, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setBlob-java.lang.String-java.io.InputStream-long-
    this.callableStatement.setBlob(parameterIndex, inputStream, length);
  }

  @Override
  public void setBlob(String parameterName, java.sql.Blob x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBlob-int-java.sql.Blob-
    this.callableStatement.setBlob(parameterName, x);
  }

  @Override
  public void setBlob(String parameterName, java.io.InputStream x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBlob-int-java.io.InputStream-
    this.callableStatement.setBlob(parameterName, x);
  }

  @Override
  public void setBlob(String parameterName, java.io.InputStream inputStream, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBlob-int-java.io.InputStream-long-
    this.callableStatement.setBlob(parameterName, inputStream, length);
  }

  @Override
  public boolean getBoolean(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getBoolean-int-
    return this.callableStatement.getBoolean(parameterIndex);
  }

  @Override
  public boolean getBoolean(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getBoolean-java.lang.String-
    return this.callableStatement.getBoolean(parameterName);
  }

  @Override
  public void setBoolean(int parameterIndex, boolean x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setBoolean-java.lang.String-boolean-
    this.callableStatement.setBoolean(parameterIndex, x);
  }

  @Override
  public void setBoolean(String parameterName, boolean x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBoolean-int-boolean-
    this.callableStatement.setBoolean(parameterName, x);
  }

  @Override
  public byte getByte(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getByte-int-
    return this.callableStatement.getByte(parameterIndex);
  }

  @Override
  public byte getByte(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getByte-java.lang.String-
    return this.callableStatement.getByte(parameterName);
  }

  @Override
  public void setByte(int parameterIndex, byte x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setByte-java.lang.String-byte-
    this.callableStatement.setByte(parameterIndex, x);
  }

  @Override
  public void setByte(String parameterName, byte x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setByte-int-byte-
    this.callableStatement.setByte(parameterName, x);
  }

  @Override
  public byte[] getBytes(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getBytes-int-
    return this.callableStatement.getBytes(parameterIndex);
  }

  @Override
  public byte[] getBytes(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getBytes-java.lang.String-
    return this.callableStatement.getBytes(parameterName);
  }

  @Override
  public void setBytes(int parameterIndex, byte[] x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBytes-int-byte:A-
    this.callableStatement.setBytes(parameterIndex, x);
  }

  @Override
  public void setBytes(String parameterName, byte[] x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setBytes-java.lang.String-byte:A-
    this.callableStatement.setBytes(parameterName, x);
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setCharacterStream-java.lang.String-java.io.Reader-
    this.callableStatement.setCharacterStream(parameterIndex, reader);
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setCharacterStream-java.lang.String-java.io.Reader-int-
    this.callableStatement.setCharacterStream(parameterIndex, reader, length);
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setCharacterStream-java.lang.String-java.io.Reader-long-
    this.callableStatement.setCharacterStream(parameterIndex, reader, length);
  }

  @Override
  public void setCharacterStream(String parameterName, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setCharacterStream-int-java.io.Reader-
    this.callableStatement.setCharacterStream(parameterName, reader);
  }

  @Override
  public void setCharacterStream(String parameterName, java.io.Reader reader, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setCharacterStream-int-java.io.Reader-int-
    this.callableStatement.setCharacterStream(parameterName, reader, length);
  }

  @Override
  public void setCharacterStream(String parameterName, java.io.Reader reader, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setCharacterStream-int-java.io.Reader-long-
    this.callableStatement.setCharacterStream(parameterName, reader, length);
  }

  @Override
  public java.sql.Clob getClob(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getClob-int-
    return this.callableStatement.getClob(parameterIndex);
  }

  @Override
  public java.sql.Clob getClob(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getClob-java.lang.String-
    return this.callableStatement.getClob(parameterName);
  }

  @Override
  public void setClob(int parameterIndex, java.sql.Clob x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setClob-java.lang.String-java.sql.Clob-
    this.callableStatement.setClob(parameterIndex, x);
  }

  @Override
  public void setClob(int parameterIndex, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setClob-java.lang.String-java.io.Reader-
    this.callableStatement.setClob(parameterIndex, reader);
  }

  @Override
  public void setClob(int parameterIndex, java.io.Reader reader, long length) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setClob-java.lang.String-java.io.Reader-long-
    this.callableStatement.setClob(parameterIndex, reader, length);
  }

  @Override
  public void setClob(String parameterName, java.sql.Clob x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setClob-int-java.sql.Clob-
    this.callableStatement.setClob(parameterName, x);
  }

  @Override
  public void setClob(String parameterName, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setClob-int-java.io.Reader-
    this.callableStatement.setClob(parameterName, reader);
  }

  @Override
  public void setClob(String parameterName, java.io.Reader reader, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setClob-int-java.io.Reader-long-
    this.callableStatement.setClob(parameterName, reader, length);
  }

  @Override
  public java.sql.Date getDate(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getDate-int-
    return this.callableStatement.getDate(parameterIndex);
  }

  @Override
  public java.sql.Date getDate(int parameterIndex, java.util.Calendar cal) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getDate-int-java.util.Calendar-
    return this.callableStatement.getDate(parameterIndex, cal);
  }

  @Override
  public java.sql.Date getDate(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getDate-string-
    return this.callableStatement.getDate(parameterName);
  }

  @Override
  public java.sql.Date getDate(String parameterName, java.util.Calendar cal) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getDate-string-java.util.Calendar-
    return this.callableStatement.getDate(parameterName, cal);
  }

  @Override
  public void setDate(int parameterIndex, java.sql.Date x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setDate-int-java.sql.Date-
    this.callableStatement.setDate(parameterIndex, x);
  }

  @Override
  public void setDate(String parameterName, java.sql.Date x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setDate-java.lang.String-java.sql.Date-
    this.callableStatement.setDate(parameterName, x);
  }

  @Override
  public void setDate(int parameterIndex, java.sql.Date x, java.util.Calendar cal)
      throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setDate-int-java.sql.Date-java.util.Calendar-
    this.callableStatement.setDate(parameterIndex, x, cal);
  }

  @Override
  public void setDate(String parameterName, java.sql.Date x, java.util.Calendar cal)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setDate-java.lang.String-java.sql.Date-java.util.Calendar-
    this.callableStatement.setDate(parameterName, x, cal);
  }

  @Override
  public double getDouble(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getDouble-int-
    return this.callableStatement.getDouble(parameterIndex);
  }

  @Override
  public double getDouble(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getDouble-java.lang.String-
    return this.callableStatement.getDouble(parameterName);
  }

  @Override
  public void setDouble(int parameterIndex, double x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setDouble-java.lang.String-double-
    this.callableStatement.setDouble(parameterIndex, x);
  }

  @Override
  public void setDouble(String parameterName, double x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setDouble-int-double-
    this.callableStatement.setDouble(parameterName, x);
  }

  @Override
  public float getFloat(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getFloat-int-
    return this.callableStatement.getFloat(parameterIndex);
  }

  @Override
  public float getFloat(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getFloat-java.lang.String-
    return this.callableStatement.getFloat(parameterName);
  }

  @Override
  public void setFloat(int parameterIndex, float x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setFloat-java.lang.String-float-
    this.callableStatement.setFloat(parameterIndex, x);
  }

  @Override
  public void setFloat(String parameterName, float x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setFloat-int-float-
    this.callableStatement.setFloat(parameterName, x);
  }

  @Override
  public int getInt(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getInt-int-
    return this.callableStatement.getInt(parameterIndex);
  }

  @Override
  public int getInt(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getInt-java.lang.String-
    return this.callableStatement.getInt(parameterName);
  }

  @Override
  public void setInt(int parameterIndex, int x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setInt-java.lang.String-int-
    this.callableStatement.setInt(parameterIndex, x);
  }

  @Override
  public void setInt(String parameterName, int x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setInt-int-int-
    this.callableStatement.setInt(parameterName, x);
  }

  @Override
  public long getLong(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getLong-int-
    return this.callableStatement.getLong(parameterIndex);
  }

  @Override
  public long getLong(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getLong-java.lang.String-
    return this.callableStatement.getLong(parameterName);
  }

  @Override
  public void setLong(int parameterIndex, long x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setLong-java.lang.String-long-
    this.callableStatement.setLong(parameterIndex, x);
  }

  @Override
  public void setLong(String parameterName, long x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setLong-int-long-
    this.callableStatement.setLong(parameterName, x);
  }

  @Override
  public void setNCharacterStream(int parameterIndex, java.io.Reader value) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setNCharacterStream-java.lang.String-java.io.Reader-
    this.callableStatement.setNCharacterStream(parameterIndex, value);
  }

  @Override
  public void setNCharacterStream(int parameterIndex, java.io.Reader value, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setNCharacterStream-java.lang.String-java.io.Reader-long-
    this.callableStatement.setNCharacterStream(parameterIndex, value, length);
  }

  @Override
  public void setNCharacterStream(String parameterName, java.io.Reader value) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNCharacterStream-int-java.io.Reader-
    this.callableStatement.setNCharacterStream(parameterName, value);
  }

  @Override
  public void setNCharacterStream(String parameterName, java.io.Reader value, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNCharacterStream-int-java.io.Reader-long-
    this.callableStatement.setNCharacterStream(parameterName, value, length);
  }

  @Override
  public void setNClob(String parameterName, java.sql.NClob value) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setNClob-java.lang.String-java.sql.NClob-
    this.callableStatement.setNClob(parameterName, value);
  }

  @Override
  public void setNClob(int parameterIndex, java.sql.NClob value) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNClob-int-java.sql.NClob-
    this.callableStatement.setNClob(parameterIndex, value);
  }

  @Override
  public void setNClob(int parameterIndex, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNClob-int-java.io.Reader-
    this.callableStatement.setNClob(parameterIndex, reader);
  }

  @Override
  public void setNClob(String parameterName, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setNClob-java.lang.String-java.io.Reader-
    this.callableStatement.setNClob(parameterName, reader);
  }

  @Override
  public void setNClob(String parameterName, java.io.Reader reader, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setNClob-java.lang.String-java.io.Reader-long-
    this.callableStatement.setNClob(parameterName, reader, length);
  }

  @Override
  public void setNClob(int parameterIndex, java.io.Reader reader, long length) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNClob-int-java.io.Reader-long-
    this.callableStatement.setNClob(parameterIndex, reader, length);
  }

  @Override
  public void setNString(int parameterIndex, String value) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setNString-java.lang.String-java.lang.String-
    this.callableStatement.setNString(parameterIndex, value);
  }

  @Override
  public void setNString(String parameterName, String value) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNString-int-java.lang.String-
    this.callableStatement.setNString(parameterName, value);
  }

  @Override
  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNull-int-int-
    this.callableStatement.setNull(parameterIndex, sqlType);
  }

  @Override
  public void setNull(String parameterName, int sqlType) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setNull-java.lang.String-int-
    this.callableStatement.setNull(parameterName, sqlType);
  }

  @Override
  public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNull-int-int-java.lang.String-
    this.callableStatement.setNull(parameterIndex, sqlType, typeName);
  }

  @Override
  public void setNull(String parameterName, int sqlType, String typeName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setNull-java.lang.String-int-java.lang.String-
    this.callableStatement.setNull(parameterName, sqlType, typeName);
  }

  @Override
  public void setObject(int parameterIndex, Object x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setObject-int-java.lang.Object-
    this.callableStatement.setObject(parameterIndex, x);
  }

  @Override
  public void setObject(String parameterName, Object x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setObject-java.lang.String-java.lang.Object-
    this.callableStatement.setObject(parameterName, x);
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setObject-int-java.lang.Object-int-
    this.callableStatement.setObject(parameterIndex, x, targetSqlType);
  }

  @Override
  public void setObject(String parameterName, Object x, int targetSqlType) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setObject-java.lang.String-java.lang.Object-int-
    this.callableStatement.setObject(parameterName, x, targetSqlType);
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength)
      throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setObject-int-java.lang.Object-int-int-
    this.callableStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
  }

  @Override
  public void setObject(String parameterName, Object x, int targetSqlType, int scaleOrLength)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setObject-java.lang.String-java.lang.Object-java.sql.SQLType-int-
    this.callableStatement.setObject(parameterName, x, targetSqlType, scaleOrLength);
  }

  @Override
  public java.sql.Ref getRef(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getRef-int-
    return this.callableStatement.getRef(parameterIndex);
  }

  @Override
  public java.sql.Ref getRef(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getRef-java.lang.String-
    return this.callableStatement.getRef(parameterName);
  }

  @Override
  public void setRef(int parameterIndex, java.sql.Ref x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setRef-int-java.sql.Ref-
    this.callableStatement.setRef(parameterIndex, x);
  }

  @Override
  public java.sql.RowId getRowId(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getRowId-int-
    return this.callableStatement.getRowId(parameterIndex);
  }

  @Override
  public java.sql.RowId getRowId(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getRowId-java.lang.String-
    return this.callableStatement.getRowId(parameterName);
  }

  @Override
  public void setRowId(int parameterIndex, java.sql.RowId x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setRowId-int-java.sql.RowId-
    this.callableStatement.setRowId(parameterIndex, x);
  }

  @Override
  public void setRowId(String parameterName, java.sql.RowId x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setRowId-java.lang.String-java.sql.RowId-
    this.callableStatement.setRowId(parameterName, x);
  }

  @Override
  public short getShort(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getShort-int-
    return this.callableStatement.getShort(parameterIndex);
  }

  @Override
  public short getShort(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getShort-java.lang.String-
    return this.callableStatement.getShort(parameterName);
  }

  @Override
  public void setShort(int parameterIndex, short x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setShort-int-short-
    this.callableStatement.setShort(parameterIndex, x);
  }

  @Override
  public void setShort(String parameterName, short x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setShort-java.lang.String-short-
    this.callableStatement.setShort(parameterName, x);
  }

  @Override
  public void setSQLXML(int parameterIndex, java.sql.SQLXML xmlObject) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setSQLXML-int-java.sql.SQLXML-
    this.callableStatement.setSQLXML(parameterIndex, xmlObject);
  }

  @Override
  public void setSQLXML(String parameterName, java.sql.SQLXML xmlObject) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setSQLXML-java.lang.String-java.sql.SQLXML-
    this.callableStatement.setSQLXML(parameterName, xmlObject);
  }

  @Override
  public String getString(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getString-int-
    return this.callableStatement.getString(parameterIndex);
  }

  @Override
  public String getString(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getString-string-
    return this.callableStatement.getString(parameterName);
  }

  @Override
  public void setString(int parameterIndex, String x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setString-int-java.lang.String-
    this.callableStatement.setString(parameterIndex, x);
  }

  @Override
  public void setString(String parameterName, String x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setString-java.lang.String-java.lang.String-
    this.callableStatement.setString(parameterName, x);
  }

  @Override
  public java.sql.Time getTime(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getTime-int-
    return this.callableStatement.getTime(parameterIndex);
  }

  @Override
  public java.sql.Time getTime(int parameterIndex, java.util.Calendar cal) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getTime-int-java.util.Calendar-
    return this.callableStatement.getTime(parameterIndex, cal);
  }

  @Override
  public java.sql.Time getTime(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getTime-java.lang.String-
    return this.callableStatement.getTime(parameterName);
  }

  @Override
  public java.sql.Time getTime(String parameterName, java.util.Calendar cal) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getTime-java.lang.String-java.util.Calendar-
    return this.callableStatement.getTime(parameterName, cal);
  }

  @Override
  public void setTime(int parameterIndex, java.sql.Time x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setTime-int-java.sql.Time-
    this.callableStatement.setTime(parameterIndex, x);
  }

  @Override
  public void setTime(String parameterName, java.sql.Time x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setTime-java.lang.String-java.sql.Time-
    this.callableStatement.setTime(parameterName, x);
  }

  @Override
  public void setTime(int parameterIndex, java.sql.Time x, java.util.Calendar cal)
      throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setTime-int-java.sql.Time-java.util.Calendar-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setTime", "setTime");

    try (Scope ws = trackingOperation.withSpan()) {
      this.callableStatement.setTime(parameterIndex, x, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setTime(String parameterName, java.sql.Time x, java.util.Calendar cal)
      throws SQLException {
    // This method touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setTime-java.lang.String-java.sql.Time-java.util.Calendar-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setTime", "setTime");

    try (Scope ws = trackingOperation.withSpan()) {
      this.callableStatement.setTime(parameterName, x, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Timestamp getTimestamp(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getTimestamp-int-
    return this.callableStatement.getTimestamp(parameterIndex);
  }

  @Override
  public java.sql.Timestamp getTimestamp(int parameterIndex, java.util.Calendar cal)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getTimestamp-int-java.util.Calendar-
    return this.callableStatement.getTimestamp(parameterIndex, cal);
  }

  @Override
  public java.sql.Timestamp getTimestamp(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getTimestamp-java.lang.String-
    return this.callableStatement.getTimestamp(parameterName);
  }

  @Override
  public java.sql.Timestamp getTimestamp(String parameterName, java.util.Calendar cal)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getTimestamp-java.lang.String-java.util.Calendar-
    return this.callableStatement.getTimestamp(parameterName, cal);
  }

  @Override
  public void setTimestamp(int parameterIndex, java.sql.Timestamp x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setTimestamp-int-java.sql.Timestamp-
    this.callableStatement.setTimestamp(parameterIndex, x);
  }

  @Override
  public void setTimestamp(String parameterName, java.sql.Timestamp x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setTimestamp-java.lang.String-java.sql.Timestamp-
    this.callableStatement.setTimestamp(parameterName, x);
  }

  @Override
  public void setTimestamp(int parameterIndex, java.sql.Timestamp x, java.util.Calendar cal)
      throws SQLException {
    // This method touches the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setTimestamp-int-java.sql.Timestamp-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setTimestamp", "setTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      this.callableStatement.setTimestamp(parameterIndex, x, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setTimestamp(String parameterName, java.sql.Timestamp x, java.util.Calendar cal)
      throws SQLException {
    // This method touches the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setTimestamp-java.lang.String-java.sql.Timestamp-java.util.Calendar-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setTimestamp", "setTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      this.callableStatement.setTimestamp(parameterName, x, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public void setUnicodeStream(int parameterIndex, java.io.InputStream x, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setUnicodeStream-int-java.io.InputStream-int-
    this.callableStatement.setUnicodeStream(parameterIndex, x, length);
  }

  @Override
  public java.net.URL getURL(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getURL-int-
    return this.callableStatement.getURL(parameterIndex);
  }

  @Override
  public java.net.URL getURL(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getURL-java.lang.String-
    return this.callableStatement.getURL(parameterName);
  }

  @Override
  public void setURL(int parameterIndex, java.net.URL x) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setURL-int-java.net.URL-
    this.callableStatement.setURL(parameterIndex, x);
  }

  @Override
  public void setURL(String parameterName, java.net.URL x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#setURL-java.lang.String-java.net.URL-
    this.callableStatement.setURL(parameterName, x);
  }

  @Override
  public boolean isClosed() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#isClosed--
    return this.callableStatement.isClosed();
  }

  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#isCloseOnCompletion--
    return this.callableStatement.isCloseOnCompletion();
  }

  @Override
  public boolean isPoolable() throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#isPoolable--
    return this.callableStatement.isPoolable();
  }

  @Override
  public void setCursorName(String cursorName) throws SQLException {
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#setCursorName-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setCursorName", "setCursorName");

    try (Scope ws = trackingOperation.withSpan()) {
      this.callableStatement.setCursorName(cursorName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setEscapeProcessing(boolean enable) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#setEscapeProcessing-boolean-
    this.callableStatement.setEscapeProcessing(enable);
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#setFetchDirection-int-
    this.callableStatement.setFetchDirection(direction);
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#setFetchSize-int-
    this.callableStatement.setFetchSize(rows);
  }

  @Override
  public void setMaxFieldSize(int max) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#setMaxFieldSize-int-
    this.callableStatement.setMaxFieldSize(max);
  }

  @Override
  public void setMaxRows(int max) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#setMaxRows-int-
    this.callableStatement.setMaxRows(max);
  }

  @Override
  public void setPoolable(boolean poolable) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#setPoolable-boolean-
    this.callableStatement.setPoolable(poolable);
  }

  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#setQueryTimeout-int-
    this.callableStatement.setQueryTimeout(seconds);
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Wrapper.html#isWrapperFor-java.lang.Class-
    return this.callableStatement.isWrapperFor(iface);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    // This method doesn't touch the database:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Wrapper.html#unwrap-java.lang.Class-
    return this.callableStatement.unwrap(iface);
  }

  @Override
  public Object getObject(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getObject-int-
    return this.callableStatement.getObject(parameterIndex);
  }

  @Override
  public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getObject-int-java.lang.Class-
    return this.callableStatement.getObject(parameterIndex, type);
  }

  @Override
  public Object getObject(int parameterIndex, java.util.Map<String, Class<?>> map)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getObject-int-java.util.Map-
    return this.callableStatement.getObject(parameterIndex, map);
  }

  @Override
  public Object getObject(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getObject-java.lang.String-
    return this.callableStatement.getObject(parameterName);
  }

  @Override
  public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getObject-java.lang.String-java.lang.Class-
    return this.callableStatement.getObject(parameterName, type);
  }

  @Override
  public Object getObject(String parameterName, java.util.Map<String, Class<?>> map)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getObject-java.lang.String-java.util.Map-
    return this.callableStatement.getObject(parameterName, map);
  }

  @Override
  public java.sql.SQLXML getSQLXML(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getSQLXML-int-
    return this.callableStatement.getSQLXML(parameterIndex);
  }

  @Override
  public java.sql.SQLXML getSQLXML(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getSQLXML-java.lang.String-
    return this.callableStatement.getSQLXML(parameterName);
  }

  @Override
  public String getNString(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getNString-int-
    return this.callableStatement.getNString(parameterIndex);
  }

  @Override
  public String getNString(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getNString-java.lang.String-
    return this.callableStatement.getNString(parameterName);
  }

  @Override
  public java.io.Reader getNCharacterStream(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getNCharacterStream-int-
    return this.callableStatement.getNCharacterStream(parameterIndex);
  }

  @Override
  public java.io.Reader getNCharacterStream(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getNCharacterStream-java.lang.String-
    return this.callableStatement.getNCharacterStream(parameterName);
  }

  @Override
  public java.io.Reader getCharacterStream(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getCharacterStream-int-
    return this.callableStatement.getCharacterStream(parameterIndex);
  }

  @Override
  public java.io.Reader getCharacterStream(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getCharacterStream-java.lang.String-
    return this.callableStatement.getCharacterStream(parameterName);
  }

  @Override
  public java.sql.NClob getNClob(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getNClob-int-
    return this.callableStatement.getNClob(parameterIndex);
  }

  @Override
  public java.sql.NClob getNClob(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#getNClob-java.lang.String-
    return this.callableStatement.getNClob(parameterName);
  }

  @Override
  public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#registerOutParameter-int-int-
    this.callableStatement.registerOutParameter(parameterIndex, sqlType);
  }

  @Override
  public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#registerOutParameter-int-int-int-
    this.callableStatement.registerOutParameter(parameterIndex, sqlType, scale);
  }

  @Override
  public void registerOutParameter(int parameterIndex, int sqlType, String typeName)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#registerOutParameter-java.lang.String-int-java.lang.String-
    this.callableStatement.registerOutParameter(parameterIndex, sqlType, typeName);
  }

  @Override
  public void registerOutParameter(String parameterName, int sqlType) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#registerOutParameter-java.lang.String-int-
    this.callableStatement.registerOutParameter(parameterName, sqlType);
  }

  @Override
  public void registerOutParameter(String parameterName, int sqlType, int scale)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#registerOutParameter-java.lang.String-int-int-
    this.callableStatement.registerOutParameter(parameterName, sqlType, scale);
  }

  @Override
  public void registerOutParameter(String parameterName, int sqlType, String typeName)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#registerOutParameter-java.lang.String-int-java.lang.String-
    this.callableStatement.registerOutParameter(parameterName, sqlType, typeName);
  }

  @Override
  public boolean wasNull() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/CallableStatement.html#wasNull--
    return this.callableStatement.wasNull();
  }
}
