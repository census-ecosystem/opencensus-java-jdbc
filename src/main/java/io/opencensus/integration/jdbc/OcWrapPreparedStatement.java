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

import io.opencensus.integration.jdbc.Observability.TraceOption;
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
      java.sql.PreparedStatement pstmt, boolean shouldAnnotateSpansWithSQL) throws SQLException {
    this.preparedStatement = pstmt;
    this.shouldAnnotateSpansWithSQL = shouldAnnotateSpansWithSQL;
  }

  @Override
  public void addBatch() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.addBatch", "addBatch");

    try {
      this.preparedStatement.addBatch();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void addBatch(String SQL) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.addBatch",
            "addBatch",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try {
      this.preparedStatement.addBatch(SQL);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void cancel() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.cancel", "cancel");

    try {
      this.preparedStatement.cancel();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void clearBatch() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.createBatch", "createBatch");

    try {
      this.preparedStatement.clearBatch();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void clearWarnings() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.clearWarnings", "clearWarnings");

    try {
      this.preparedStatement.clearWarnings();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void clearParameters() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.clearParameters", "clearParameters");

    try {
      this.preparedStatement.clearParameters();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void close() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.close", "close");

    try {
      this.preparedStatement.close();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void closeOnCompletion() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.closeOnCompletion", "closeOnCompletion");

    try {
      this.preparedStatement.closeOnCompletion();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean execute() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.execute", "execute");

    try {
      return this.preparedStatement.execute();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean execute(String SQL) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);
    try {
      return this.preparedStatement.execute(SQL);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean execute(String SQL, String[] columnNames) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);
    try {
      return this.preparedStatement.execute(SQL, columnNames);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean execute(String SQL, int[] columnIndices) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);
    try {
      return this.preparedStatement.execute(SQL, columnIndices);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean execute(String SQL, int autoGeneratedKeys) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);
    try {
      return this.preparedStatement.execute(SQL, autoGeneratedKeys);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int[] executeBatch() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeBatch", "executeBatch");

    try {
      return this.preparedStatement.executeBatch();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.ResultSet executeQuery(String SQL) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeQuery",
            "executeQuery",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try {
      java.sql.ResultSet rs = this.preparedStatement.executeQuery(SQL);
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int executeUpdate(String SQL) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try {
      return this.preparedStatement.executeUpdate(SQL);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int executeUpdate(String SQL, int autoGeneratedKeys) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try {
      return this.preparedStatement.executeUpdate(SQL, autoGeneratedKeys);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int executeUpdate(String SQL, int[] columnIndices) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);
    try {
      return this.preparedStatement.executeUpdate(SQL, columnIndices);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int executeUpdate(String SQL, String[] columnNames) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try {
      return this.preparedStatement.executeUpdate(SQL, columnNames);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.ResultSet executeQuery() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeQuery", "executeQuery");

    try {
      java.sql.ResultSet rs = this.preparedStatement.executeQuery();
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int executeUpdate() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate", "executeUpdate");

    try {
      return this.preparedStatement.executeUpdate();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getFetchDirection() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getFetchDirection", "getFetchDirection");

    try {
      return this.preparedStatement.getFetchDirection();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getFetchSize() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getFetchSize", "getFetchSize");

    try {
      return this.preparedStatement.getFetchSize();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.ResultSet getGeneratedKeys() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getGeneratedKeys", "getGeneratedKeys");

    try {
      java.sql.ResultSet rs = this.preparedStatement.getGeneratedKeys();
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getMaxFieldSize() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMaxFieldSize", "getMaxFieldSize");

    try {
      return this.preparedStatement.getMaxFieldSize();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getMaxRows() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMaxRows", "getMaxRows");

    try {
      return this.preparedStatement.getMaxRows();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.ResultSetMetaData getMetaData() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMetaData", "getMetaData");

    try {
      return this.preparedStatement.getMetaData();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean getMoreResults(int current) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMoreResults", "getMoreResults");

    try {
      return this.preparedStatement.getMoreResults(current);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean getMoreResults() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getMoreResults", "getMoreResults");

    try {
      return this.preparedStatement.getMoreResults();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.ResultSet getResultSet() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getResultSet", "getResultSet");

    try {
      java.sql.ResultSet rs = this.preparedStatement.getResultSet();
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getResultSetConcurrency() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getResultSetConcurrency", "getResultSetConcurrency");

    try {
      return this.preparedStatement.getResultSetConcurrency();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getQueryTimeout() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getQueryTimeout", "getQueryTimeout");

    try {
      return this.preparedStatement.getQueryTimeout();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Connection getConnection() throws SQLException {
    return this.preparedStatement.getConnection();
  }

  @Override
  public java.sql.ParameterMetaData getParameterMetaData() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getParameterMetaData", "getParameterMetaData");

    try {
      return this.preparedStatement.getParameterMetaData();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getResultSetHoldability", "getResultSetHoldability");

    try {
      return this.preparedStatement.getResultSetHoldability();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getResultSetType() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getResultSetType", "getResultSetType");

    try {
      return this.preparedStatement.getResultSetType();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getUpdateCount() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getUpdateCount", "getUpdateCount");

    try {
      return this.preparedStatement.getUpdateCount();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.SQLWarning getWarnings() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.getWarnings", "getWarnings");

    try {
      return this.preparedStatement.getWarnings();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setArray(int parameterIndex, java.sql.Array x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setArray", "setArray");

    try {
      this.preparedStatement.setArray(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setAsciiStream", "setAsciiStream");

    try {
      this.preparedStatement.setAsciiStream(parameterIndex, stream);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setAsciiStream", "setAsciiStream");

    try {
      this.preparedStatement.setAsciiStream(parameterIndex, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setAsciiStream", "setAsciiStream");

    try {
      this.preparedStatement.setAsciiStream(parameterIndex, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBigDecimal(int parameterIndex, java.math.BigDecimal x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBigDecimal", "setBigDecimal");

    try {
      this.preparedStatement.setBigDecimal(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBinaryStream", "setBinaryStream");

    try {
      this.preparedStatement.setBinaryStream(parameterIndex, stream);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBinaryStream", "setBinaryStream");

    try {
      this.preparedStatement.setBinaryStream(parameterIndex, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBinaryStream", "setBinaryStream");

    try {
      this.preparedStatement.setBinaryStream(parameterIndex, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBlob(int parameterIndex, java.sql.Blob x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setBlob", "setBlob");

    try {
      this.preparedStatement.setBlob(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBlob(int parameterIndex, java.io.InputStream x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setBlob", "setBlob");

    try {
      this.preparedStatement.setBlob(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBlob(int parameterIndex, java.io.InputStream inputStream, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setBlob", "setBlob");

    try {
      this.preparedStatement.setBlob(parameterIndex, inputStream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBoolean(int parameterIndex, boolean x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBoolean", "setBoolean");

    try {
      this.preparedStatement.setBoolean(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setByte(int parameterIndex, byte x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setByte", "setByte");

    try {
      this.preparedStatement.setByte(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBytes(int parameterIndex, byte[] x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setBytes", "setBytes");

    try {
      this.preparedStatement.setBytes(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setCharacterStream", "setCharacterStream");

    try {
      this.preparedStatement.setCharacterStream(parameterIndex, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setCharacterStream", "setCharacterStream");

    try {
      this.preparedStatement.setCharacterStream(parameterIndex, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setCharacterStream", "setCharacterStream");

    try {
      this.preparedStatement.setCharacterStream(parameterIndex, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setClob(int parameterIndex, java.sql.Clob x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setClob", "setClob");

    try {
      this.preparedStatement.setClob(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setClob(int parameterIndex, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setClob", "setClob");

    try {
      this.preparedStatement.setClob(parameterIndex, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setClob(int parameterIndex, java.io.Reader reader, long length) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setClob", "setClob");

    try {
      this.preparedStatement.setClob(parameterIndex, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setDate(int parameterIndex, java.sql.Date x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setDate", "setDate");

    try {
      this.preparedStatement.setDate(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setDate(int parameterIndex, java.sql.Date x, java.util.Calendar cal)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setDate", "setDate");

    try {
      this.preparedStatement.setDate(parameterIndex, x, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setDouble(int parameterIndex, double x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setDouble", "setDouble");

    try {
      this.preparedStatement.setDouble(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setFloat(int parameterIndex, float x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setFloat", "setFloat");

    try {
      this.preparedStatement.setFloat(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setInt(int parameterIndex, int x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setInt", "setInt");

    try {
      this.preparedStatement.setFloat(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setLong(int parameterIndex, long x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setLong", "setLong");

    try {
      this.preparedStatement.setLong(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNCharacterStream(int parameterIndex, java.io.Reader value) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNCharacterStream", "setNCharacterStream");

    try {
      this.preparedStatement.setNCharacterStream(parameterIndex, value);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNCharacterStream(int parameterIndex, java.io.Reader value, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNCharacterStream", "setNCharacterStream");

    try {
      this.preparedStatement.setNCharacterStream(parameterIndex, value, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNClob(int parameterIndex, java.sql.NClob value) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNClob", "setNClob");

    try {
      this.preparedStatement.setNClob(parameterIndex, value);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNClob(int parameterIndex, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNClob", "setNClob");

    try {
      this.preparedStatement.setNClob(parameterIndex, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNClob(int parameterIndex, java.io.Reader reader, long length) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNClob", "setNClob");

    try {
      this.preparedStatement.setNClob(parameterIndex, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNString(int parameterIndex, String value) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setNString", "setNString");

    try {
      this.preparedStatement.setNString(parameterIndex, value);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setNull", "setNull");

    try {
      this.preparedStatement.setNull(parameterIndex, sqlType);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setNull", "setNull");

    try {
      this.preparedStatement.setNull(parameterIndex, sqlType, typeName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setObject(int parameterIndex, Object x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setObject", "setObject");

    try {
      this.preparedStatement.setObject(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setObject", "setObject");

    try {
      this.preparedStatement.setObject(parameterIndex, x, targetSqlType);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setObject", "setObject");

    try {
      this.preparedStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setRef(int parameterIndex, java.sql.Ref x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setRef", "setRef");

    try {
      this.preparedStatement.setRef(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setRowId(int parameterIndex, java.sql.RowId x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setRowId", "setRowId");

    try {
      this.preparedStatement.setRowId(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setShort(int parameterIndex, short x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setShort", "setShort");

    try {
      this.preparedStatement.setShort(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setSQLXML(int parameterIndex, java.sql.SQLXML xmlObject) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setSQLXML", "setSQLXML");

    try {
      this.preparedStatement.setSQLXML(parameterIndex, xmlObject);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setString(int parameterIndex, String x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setString", "setString");

    try {
      this.preparedStatement.setString(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setTime(int parameterIndex, java.sql.Time x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setTime", "setTime");

    try {
      this.preparedStatement.setTime(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setTime(int parameterIndex, java.sql.Time x, java.util.Calendar cal)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setTime", "setTime");

    try {
      this.preparedStatement.setTime(parameterIndex, x, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setTimestamp(int parameterIndex, java.sql.Timestamp x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setTimestamp", "setTimestamp");

    try {
      this.preparedStatement.setTimestamp(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setTimestamp(int parameterIndex, java.sql.Timestamp x, java.util.Calendar cal)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setTimestamp", "setTimestamp");

    try {
      this.preparedStatement.setTimestamp(parameterIndex, x, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public void setUnicodeStream(int parameterIndex, java.io.InputStream x, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setUnicodeStream", "setUnicodeStream");

    try {
      this.preparedStatement.setUnicodeStream(parameterIndex, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setURL(int parameterIndex, java.net.URL x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setURL", "setURL");

    try {
      this.preparedStatement.setURL(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean isClosed() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.isClosed", "isClosed");

    try {
      return this.preparedStatement.isClosed();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.isCloseOnCompletion", "isCloseOnCompletion");

    try {
      return this.preparedStatement.isCloseOnCompletion();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean isPoolable() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.isPoolable", "isPoolable");

    try {
      return this.preparedStatement.isPoolable();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setCursorName(String cursorName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setCursorName", "setCursorName");

    try {
      this.preparedStatement.setCursorName(cursorName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setEscapeProcessing(boolean enable) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setEscapeProcessing", "setEscapeProcessing");

    try {
      this.preparedStatement.setEscapeProcessing(enable);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setFetchDirection", "setFetchDirection");

    try {
      this.preparedStatement.setFetchDirection(direction);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setFetchSize", "setFetchSize");

    try {
      this.preparedStatement.setFetchSize(rows);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setMaxFieldSize(int max) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setMaxFieldSize", "setMaxFieldSize");

    try {
      this.preparedStatement.setMaxFieldSize(max);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setMaxRows(int max) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setMaxRows", "setMaxRows");

    try {
      this.preparedStatement.setMaxRows(max);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setPoolable(boolean poolable) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setPoolable", "setPoolable");

    try {
      this.preparedStatement.setPoolable(poolable);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.setQueryTimeout", "setQueryTimeout");

    try {
      this.preparedStatement.setQueryTimeout(seconds);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
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
