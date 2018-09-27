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

public class OcWrapPreparedStatement implements java.sql.PreparedStatement {
  private final java.sql.PreparedStatement preparedStatement;
  private final boolean shouldAnnotateSpansWithSQL;

  public OcWrapPreparedStatement(java.sql.PreparedStatement pstmt, EnumSet<TraceOption> opts)
      throws SQLException {
    this.preparedStatement = pstmt;
    this.shouldAnnotateSpansWithSQL = Observability.shouldAnnotateSpansWithSQL(opts);
  }

  public OcWrapPreparedStatement(
      java.sql.PreparedStatement pstmt, boolean shouldAnnotateSpansWithSQL) {
    this.preparedStatement = pstmt;
    this.shouldAnnotateSpansWithSQL = shouldAnnotateSpansWithSQL;
  }

  @Override
  public void addBatch() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.addBatch", "addBatch");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.addBatch();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void addBatch(String SQL) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.addBatch",
            "addBatch",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.addBatch(SQL);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void cancel() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.cancel", "cancel");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.cancel();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void clearBatch() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.createBatch", "createBatch");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.clearBatch();
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
            "java.sql.PreparedStatement.clearWarnings", "clearWarnings");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.clearWarnings();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void clearParameters() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.clearParameters", "clearParameters");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.clearParameters();
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
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.close", "close");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.close();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void closeOnCompletion() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.closeOnCompletion", "closeOnCompletion");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.closeOnCompletion();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.execute", "execute");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute(SQL);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL, String[] columnNames) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute(SQL, columnNames);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL, int[] columnIndices) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute(SQL, columnIndices);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL, int autoGeneratedKeys) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute(SQL, autoGeneratedKeys);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int[] executeBatch() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeBatch", "executeBatch");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeBatch();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSet executeQuery(String SQL) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeQuery",
            "executeQuery",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.ResultSet rs = this.preparedStatement.executeQuery(SQL);
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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate(SQL);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL, int autoGeneratedKeys) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate(SQL, autoGeneratedKeys);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL, int[] columnIndices) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate(SQL, columnIndices);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL, String[] columnNames) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate(SQL, columnNames);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSet executeQuery() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeQuery", "executeQuery");

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.ResultSet rs = this.preparedStatement.executeQuery();
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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate", "executeUpdate");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getFetchDirection() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getFetchDirection", "getFetchDirection");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getFetchDirection();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getFetchSize() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getFetchSize", "getFetchSize");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getFetchSize();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSet getGeneratedKeys() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getGeneratedKeys", "getGeneratedKeys");

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.ResultSet rs = this.preparedStatement.getGeneratedKeys();
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getMaxFieldSize() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMaxFieldSize", "getMaxFieldSize");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getMaxFieldSize();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getMaxRows() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMaxRows", "getMaxRows");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getMaxRows();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSetMetaData getMetaData() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMetaData", "getMetaData");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getMetaData();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean getMoreResults(int current) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMoreResults", "getMoreResults");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getMoreResults(current);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean getMoreResults() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMoreResults", "getMoreResults");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getMoreResults();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSet getResultSet() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getResultSet", "getResultSet");

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.ResultSet rs = this.preparedStatement.getResultSet();
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getResultSetConcurrency() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getResultSetConcurrency", "getResultSetConcurrency");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getResultSetConcurrency();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getQueryTimeout() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getQueryTimeout", "getQueryTimeout");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getQueryTimeout();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Connection getConnection() throws SQLException {
    return this.preparedStatement.getConnection();
  }

  @Override
  public java.sql.ParameterMetaData getParameterMetaData() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getParameterMetaData", "getParameterMetaData");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getParameterMetaData();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getResultSetHoldability", "getResultSetHoldability");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getResultSetHoldability();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getResultSetType() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getResultSetType", "getResultSetType");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getResultSetType();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getUpdateCount() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getUpdateCount", "getUpdateCount");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getUpdateCount();
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
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getWarnings", "getWarnings");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.getWarnings();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setArray(int parameterIndex, java.sql.Array x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setArray", "setArray");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setArray(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setAsciiStream", "setAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setAsciiStream(parameterIndex, stream);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream, int length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setAsciiStream", "setAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setAsciiStream(parameterIndex, stream, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setAsciiStream", "setAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setAsciiStream(parameterIndex, stream, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setBigDecimal(int parameterIndex, java.math.BigDecimal x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBigDecimal", "setBigDecimal");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setBigDecimal(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBinaryStream", "setBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setBinaryStream(parameterIndex, stream);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream, int length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBinaryStream", "setBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setBinaryStream(parameterIndex, stream, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBinaryStream", "setBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setBinaryStream(parameterIndex, stream, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setBlob(int parameterIndex, java.sql.Blob x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setBlob", "setBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setBlob(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setBlob(int parameterIndex, java.io.InputStream x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setBlob", "setBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setBlob(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setBlob(int parameterIndex, java.io.InputStream inputStream, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setBlob", "setBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setBlob(parameterIndex, inputStream, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setBoolean(int parameterIndex, boolean x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBoolean", "setBoolean");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setBoolean(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setByte(int parameterIndex, byte x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setByte", "setByte");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setByte(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setBytes(int parameterIndex, byte[] x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBytes", "setBytes");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setBytes(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setCharacterStream", "setCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setCharacterStream(parameterIndex, reader);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader, int length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setCharacterStream", "setCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setCharacterStream(parameterIndex, reader, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setCharacterStream", "setCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setCharacterStream(parameterIndex, reader, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setClob(int parameterIndex, java.sql.Clob x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setClob", "setClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setClob(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setClob(int parameterIndex, java.io.Reader reader) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setClob", "setClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setClob(parameterIndex, reader);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setClob(int parameterIndex, java.io.Reader reader, long length) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setClob", "setClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setClob(parameterIndex, reader, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setDate(int parameterIndex, java.sql.Date x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setDate", "setDate");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setDate(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setDate(int parameterIndex, java.sql.Date x, java.util.Calendar cal)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setDate", "setDate");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setDate(parameterIndex, x, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setDouble(int parameterIndex, double x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setDouble", "setDouble");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setDouble(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setFloat(int parameterIndex, float x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setFloat", "setFloat");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setFloat(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setInt(int parameterIndex, int x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setInt", "setInt");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setFloat(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setLong(int parameterIndex, long x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setLong", "setLong");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setLong(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setNCharacterStream(int parameterIndex, java.io.Reader value) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNCharacterStream", "setNCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setNCharacterStream(parameterIndex, value);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setNCharacterStream(int parameterIndex, java.io.Reader value, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNCharacterStream", "setNCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setNCharacterStream(parameterIndex, value, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setNClob(int parameterIndex, java.sql.NClob value) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNClob", "setNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setNClob(parameterIndex, value);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setNClob(int parameterIndex, java.io.Reader reader) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNClob", "setNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setNClob(parameterIndex, reader);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setNClob(int parameterIndex, java.io.Reader reader, long length) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNClob", "setNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setNClob(parameterIndex, reader, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setNString(int parameterIndex, String value) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNString", "setNString");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setNString(parameterIndex, value);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setNull", "setNull");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setNull(parameterIndex, sqlType);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setNull", "setNull");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setNull(parameterIndex, sqlType, typeName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setObject(int parameterIndex, Object x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setObject", "setObject");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setObject(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setObject", "setObject");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setObject(parameterIndex, x, targetSqlType);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setObject", "setObject");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setRef(int parameterIndex, java.sql.Ref x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setRef", "setRef");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setRef(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setRowId(int parameterIndex, java.sql.RowId x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setRowId", "setRowId");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setRowId(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setShort(int parameterIndex, short x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setShort", "setShort");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setShort(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setSQLXML(int parameterIndex, java.sql.SQLXML xmlObject) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setSQLXML", "setSQLXML");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setSQLXML(parameterIndex, xmlObject);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setString(int parameterIndex, String x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setString", "setString");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setString(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setTime(int parameterIndex, java.sql.Time x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setTime", "setTime");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setTime(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setTime(int parameterIndex, java.sql.Time x, java.util.Calendar cal)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setTime", "setTime");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setTime(parameterIndex, x, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setTimestamp(int parameterIndex, java.sql.Timestamp x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setTimestamp", "setTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setTimestamp(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setTimestamp(int parameterIndex, java.sql.Timestamp x, java.util.Calendar cal)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setTimestamp", "setTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setTimestamp(parameterIndex, x, cal);
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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setUnicodeStream", "setUnicodeStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setUnicodeStream(parameterIndex, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setURL(int parameterIndex, java.net.URL x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setURL", "setURL");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setURL(parameterIndex, x);
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
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.isClosed", "isClosed");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.isClosed();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.isCloseOnCompletion", "isCloseOnCompletion");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.isCloseOnCompletion();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isPoolable() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.isPoolable", "isPoolable");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.isPoolable();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setCursorName(String cursorName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setCursorName", "setCursorName");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setCursorName(cursorName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setEscapeProcessing(boolean enable) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setEscapeProcessing", "setEscapeProcessing");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setEscapeProcessing(enable);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setFetchDirection", "setFetchDirection");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setFetchDirection(direction);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setFetchSize", "setFetchSize");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setFetchSize(rows);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setMaxFieldSize(int max) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setMaxFieldSize", "setMaxFieldSize");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setMaxFieldSize(max);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setMaxRows(int max) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setMaxRows", "setMaxRows");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setMaxRows(max);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setPoolable(boolean poolable) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setPoolable", "setPoolable");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setPoolable(poolable);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setQueryTimeout", "setQueryTimeout");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setQueryTimeout(seconds);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return this.preparedStatement.isWrapperFor(iface);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return this.preparedStatement.unwrap(iface);
  }
}
