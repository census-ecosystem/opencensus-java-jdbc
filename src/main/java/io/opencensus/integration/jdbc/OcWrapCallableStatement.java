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

public class OcWrapCallableStatement implements java.sql.CallableStatement {
  private final java.sql.CallableStatement callableStatement;
  private final boolean shouldAnnotateSpansWithSQL;

  public OcWrapCallableStatement(
      java.sql.CallableStatement callableStatement, EnumSet<TraceOption> opts) throws SQLException {
    this.callableStatement = callableStatement;
    this.shouldAnnotateSpansWithSQL = Observability.shouldAnnotateSpansWithSQL(opts);
  }

  @Override
  public void addBatch() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.addBatch", "addBatch");

    try {
      this.callableStatement.addBatch();
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
            "java.sql.CallableStatement.addBatch",
            "addBatch",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try {
      this.callableStatement.addBatch(SQL);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.cancel", "cancel");

    try {
      this.callableStatement.cancel();
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
            "java.sql.CallableStatement.createBatch", "createBatch");

    try {
      this.callableStatement.clearBatch();
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
            "java.sql.CallableStatement.clearWarnings", "clearWarnings");

    try {
      this.callableStatement.clearWarnings();
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
            "java.sql.CallableStatement.clearParameters", "clearParameters");

    try {
      this.callableStatement.clearParameters();
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.close", "close");

    try {
      this.callableStatement.close();
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
            "java.sql.CallableStatement.closeOnCompletion", "closeOnCompletion");

    try {
      this.callableStatement.closeOnCompletion();
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.execute", "execute");

    try {
      return this.callableStatement.execute();
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
            "java.sql.CallableStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);

    try {
      return this.callableStatement.execute(SQL);
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
            "java.sql.CallableStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);

    try {
      return this.callableStatement.execute(SQL, columnNames);
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
            "java.sql.CallableStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);

    try {
      return this.callableStatement.execute(SQL, columnIndices);
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
            "java.sql.CallableStatement.execute", "execute", this.shouldAnnotateSpansWithSQL, SQL);

    try {
      return this.callableStatement.execute(SQL, autoGeneratedKeys);
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
            "java.sql.CallableStatement.executeBatch", "executeBatch");

    try {
      return this.callableStatement.executeBatch();
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
            "java.sql.CallableStatement.executeQuery",
            "executeQuery",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try {
      java.sql.ResultSet rs = this.callableStatement.executeQuery(SQL);
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
            "java.sql.CallableStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try {
      return this.callableStatement.executeUpdate(SQL);
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
            "java.sql.CallableStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try {
      return this.callableStatement.executeUpdate(SQL, autoGeneratedKeys);
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
            "java.sql.CallableStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try {
      return this.callableStatement.executeUpdate(SQL, columnIndices);
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
            "java.sql.CallableStatement.executeUpdate",
            "executeUpdate",
            this.shouldAnnotateSpansWithSQL,
            SQL);

    try {
      return this.callableStatement.executeUpdate(SQL, columnNames);
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
            "java.sql.CallableStatement.executeQuery", "executeQuery");

    try {
      java.sql.ResultSet rs = this.callableStatement.executeQuery();
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
            "java.sql.CallableStatement.executeUpdate", "executeUpdate");

    try {
      return this.callableStatement.executeUpdate();
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
            "java.sql.CallableStatement.getFetchDirection", "getFetchDirection");

    try {
      return this.callableStatement.getFetchDirection();
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
            "java.sql.CallableStatement.getFetchSize", "getFetchSize");

    try {
      return this.callableStatement.getFetchSize();
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
            "java.sql.CallableStatement.getGeneratedKeys", "getGeneratedKeys");

    try {
      java.sql.ResultSet rs = this.callableStatement.getGeneratedKeys();
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
            "java.sql.CallableStatement.getMaxFieldSize", "getMaxFieldSize");

    try {
      return this.callableStatement.getMaxFieldSize();
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
            "java.sql.CallableStatement.getMaxRows", "getMaxRows");

    try {
      return this.callableStatement.getMaxRows();
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
            "java.sql.CallableStatement.getMetaData", "getMetaData");

    try {
      return this.callableStatement.getMetaData();
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
            "java.sql.CallableStatement.getMoreResults", "getMoreResults");

    try {
      return this.callableStatement.getMoreResults(current);
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
            "java.sql.CallableStatement.getMoreResults", "getMoreResults");

    try {
      return this.callableStatement.getMoreResults();
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
            "java.sql.CallableStatement.getResultSet", "getResultSet");

    try {
      java.sql.ResultSet rs = this.callableStatement.getResultSet();
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
            "java.sql.CallableStatement.getResultSetConcurrency", "getResultSetConcurrency");

    try {
      return this.callableStatement.getResultSetConcurrency();
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
            "java.sql.CallableStatement.getQueryTimeout", "getQueryTimeout");

    try {
      return this.callableStatement.getQueryTimeout();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Connection getConnection() throws SQLException {
    return this.callableStatement.getConnection();
  }

  @Override
  public java.sql.ParameterMetaData getParameterMetaData() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getParameterMetaData", "getParameterMetaData");

    try {
      return this.callableStatement.getParameterMetaData();
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
            "java.sql.CallableStatement.getResultSetHoldability", "getResultSetHoldability");

    try {
      return this.callableStatement.getResultSetHoldability();
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
            "java.sql.CallableStatement.getResultSetType", "getResultSetType");

    try {
      return this.callableStatement.getResultSetType();
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
            "java.sql.CallableStatement.getUpdateCount", "getUpdateCount");

    try {
      return this.callableStatement.getUpdateCount();
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
            "java.sql.CallableStatement.getWarnings", "getWarnings");

    try {
      return this.callableStatement.getWarnings();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Array getArray(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getArray", "getArray");

    try {
      return this.callableStatement.getArray(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Array getArray(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getArray", "getArray");

    try {
      return this.callableStatement.getArray(parameterName);
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
            "java.sql.CallableStatement.setArray", "setArray");

    try {
      this.callableStatement.setArray(parameterIndex, x);
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
            "java.sql.CallableStatement.setAsciiStream", "setAsciiStream");

    try {
      this.callableStatement.setAsciiStream(parameterIndex, stream);
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
            "java.sql.CallableStatement.setAsciiStream", "setAsciiStream");

    try {
      this.callableStatement.setAsciiStream(parameterIndex, stream, length);
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
            "java.sql.CallableStatement.setAsciiStream", "setAsciiStream");

    try {
      this.callableStatement.setAsciiStream(parameterIndex, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setAsciiStream(String parameterName, java.io.InputStream stream) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setAsciiStream", "setAsciiStream");

    try {
      this.callableStatement.setAsciiStream(parameterName, stream);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setAsciiStream(String parameterName, java.io.InputStream stream, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setAsciiStream", "setAsciiStream");

    try {
      this.callableStatement.setAsciiStream(parameterName, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setAsciiStream(String parameterName, java.io.InputStream stream, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setAsciiStream", "setAsciiStream");

    try {
      this.callableStatement.setAsciiStream(parameterName, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.math.BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getBigDecimal", "getBigDecimal");

    try {
      return this.callableStatement.getBigDecimal(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.math.BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getBigDecimal", "getBigDecimal");

    try {
      return this.callableStatement.getBigDecimal(parameterIndex, scale);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.math.BigDecimal getBigDecimal(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getBigDecimal", "getBigDecimal");

    try {
      return this.callableStatement.getBigDecimal(parameterName);
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
            "java.sql.CallableStatement.setBigDecimal", "setBigDecimal");

    try {
      this.callableStatement.setBigDecimal(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBigDecimal(String parameterName, java.math.BigDecimal x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setBigDecimal", "setBigDecimal");

    try {
      this.callableStatement.setBigDecimal(parameterName, x);
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
            "java.sql.CallableStatement.setBinaryStream", "setBinaryStream");

    try {
      this.callableStatement.setBinaryStream(parameterIndex, stream);
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
            "java.sql.CallableStatement.setBinaryStream", "setBinaryStream");

    try {
      this.callableStatement.setBinaryStream(parameterIndex, stream, length);
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
            "java.sql.CallableStatement.setBinaryStream", "setBinaryStream");

    try {
      this.callableStatement.setBinaryStream(parameterIndex, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBinaryStream(String parameterName, java.io.InputStream stream)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setBinaryStream", "setBinaryStream");

    try {
      this.callableStatement.setBinaryStream(parameterName, stream);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBinaryStream(String parameterName, java.io.InputStream stream, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setBinaryStream", "setBinaryStream");

    try {
      this.callableStatement.setBinaryStream(parameterName, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBinaryStream(String parameterName, java.io.InputStream stream, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setBinaryStream", "setBinaryStream");

    try {
      this.callableStatement.setBinaryStream(parameterName, stream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Blob getBlob(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getBlob", "getBlob");

    try {
      return this.callableStatement.getBlob(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Blob getBlob(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getBlob", "getBlob");

    try {
      return this.callableStatement.getBlob(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setBlob", "setBlob");

    try {
      this.callableStatement.setBlob(parameterIndex, x);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setBlob", "setBlob");

    try {
      this.callableStatement.setBlob(parameterIndex, x);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setBlob", "setBlob");

    try {
      this.callableStatement.setBlob(parameterIndex, inputStream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBlob(String parameterName, java.sql.Blob x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setBlob", "setBlob");

    try {
      this.callableStatement.setBlob(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBlob(String parameterName, java.io.InputStream x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setBlob", "setBlob");

    try {
      this.callableStatement.setBlob(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBlob(String parameterName, java.io.InputStream inputStream, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setBlob", "setBlob");

    try {
      this.callableStatement.setBlob(parameterName, inputStream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean getBoolean(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getBoolean", "getBoolean");

    try {
      return this.callableStatement.getBoolean(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean getBoolean(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getBoolean", "getBoolean");

    try {
      return this.callableStatement.getBoolean(parameterName);
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
            "java.sql.CallableStatement.setBoolean", "setBoolean");

    try {
      this.callableStatement.setBoolean(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBoolean(String parameterName, boolean x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setBoolean", "setBoolean");

    try {
      this.callableStatement.setBoolean(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public byte getByte(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getByte", "getByte");

    try {
      return this.callableStatement.getByte(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public byte getByte(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getByte", "getByte");

    try {
      return this.callableStatement.getByte(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setByte", "setByte");

    try {
      this.callableStatement.setByte(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setByte(String parameterName, byte x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setByte", "setByte");

    try {
      this.callableStatement.setByte(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public byte[] getBytes(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getBytes", "getBytes");

    try {
      return this.callableStatement.getBytes(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public byte[] getBytes(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getBytes", "getBytes");

    try {
      return this.callableStatement.getBytes(parameterName);
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
            "java.sql.CallableStatement.setBytes", "setBytes");

    try {
      this.callableStatement.setBytes(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setBytes(String parameterName, byte[] x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setBytes", "setBytes");

    try {
      this.callableStatement.setBytes(parameterName, x);
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
            "java.sql.CallableStatement.setCharacterStream", "setCharacterStream");

    try {
      this.callableStatement.setCharacterStream(parameterIndex, reader);
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
            "java.sql.CallableStatement.setCharacterStream", "setCharacterStream");

    try {
      this.callableStatement.setCharacterStream(parameterIndex, reader, length);
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
            "java.sql.CallableStatement.setCharacterStream", "setCharacterStream");

    try {
      this.callableStatement.setCharacterStream(parameterIndex, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setCharacterStream(String parameterName, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setCharacterStream", "setCharacterStream");

    try {
      this.callableStatement.setCharacterStream(parameterName, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setCharacterStream(String parameterName, java.io.Reader reader, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setCharacterStream", "setCharacterStream");

    try {
      this.callableStatement.setCharacterStream(parameterName, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setCharacterStream(String parameterName, java.io.Reader reader, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setCharacterStream", "setCharacterStream");

    try {
      this.callableStatement.setCharacterStream(parameterName, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Clob getClob(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getClob", "getClob");

    try {
      return this.callableStatement.getClob(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Clob getClob(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getClob", "getClob");

    try {
      return this.callableStatement.getClob(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setClob", "setClob");

    try {
      this.callableStatement.setClob(parameterIndex, x);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setClob", "setClob");

    try {
      this.callableStatement.setClob(parameterIndex, reader);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setClob", "setClob");

    try {
      this.callableStatement.setClob(parameterIndex, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setClob(String parameterName, java.sql.Clob x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setClob", "setClob");

    try {
      this.callableStatement.setClob(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setClob(String parameterName, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setClob", "setClob");

    try {
      this.callableStatement.setClob(parameterName, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setClob(String parameterName, java.io.Reader reader, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setClob", "setClob");

    try {
      this.callableStatement.setClob(parameterName, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Date getDate(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getDate", "getDate");

    try {
      return this.callableStatement.getDate(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Date getDate(int parameterIndex, java.util.Calendar cal) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getDate", "getDate");

    try {
      return this.callableStatement.getDate(parameterIndex, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Date getDate(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getDate", "getDate");

    try {
      return this.callableStatement.getDate(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Date getDate(String parameterName, java.util.Calendar cal) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getDate", "getDate");

    try {
      return this.callableStatement.getDate(parameterName, cal);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setDate", "setDate");

    try {
      this.callableStatement.setDate(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setDate(String parameterName, java.sql.Date x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setDate", "setDate");

    try {
      this.callableStatement.setDate(parameterName, x);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setDate", "setDate");

    try {
      this.callableStatement.setDate(parameterIndex, x, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setDate(String parameterName, java.sql.Date x, java.util.Calendar cal)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setDate", "setDate");

    try {
      this.callableStatement.setDate(parameterName, x, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public double getDouble(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getDouble", "getDouble");

    try {
      return this.callableStatement.getDouble(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public double getDouble(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getDouble", "getDouble");

    try {
      return this.callableStatement.getDouble(parameterName);
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
            "java.sql.CallableStatement.setDouble", "setDouble");

    try {
      this.callableStatement.setDouble(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setDouble(String parameterName, double x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setDouble", "setDouble");

    try {
      this.callableStatement.setDouble(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public float getFloat(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getFloat", "getFloat");

    try {
      return this.callableStatement.getFloat(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public float getFloat(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getFloat", "getFloat");

    try {
      return this.callableStatement.getFloat(parameterName);
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
            "java.sql.CallableStatement.setFloat", "setFloat");

    try {
      this.callableStatement.setFloat(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setFloat(String parameterName, float x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setFloat", "setFloat");

    try {
      this.callableStatement.setFloat(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getInt(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getInt", "getInt");

    try {
      return this.callableStatement.getInt(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getInt(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getInt", "getInt");

    try {
      return this.callableStatement.getInt(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setInt", "setInt");

    try {
      this.callableStatement.setInt(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setInt(String parameterName, int x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setInt", "setInt");

    try {
      this.callableStatement.setInt(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public long getLong(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getLong", "getLong");

    try {
      return this.callableStatement.getLong(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public long getLong(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getLong", "getLong");

    try {
      return this.callableStatement.getLong(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setLong", "setLong");

    try {
      this.callableStatement.setLong(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setLong(String parameterName, long x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setLong", "setLong");

    try {
      this.callableStatement.setLong(parameterName, x);
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
            "java.sql.CallableStatement.setNCharacterStream", "setNCharacterStream");

    try {
      this.callableStatement.setNCharacterStream(parameterIndex, value);
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
            "java.sql.CallableStatement.setNCharacterStream", "setNCharacterStream");

    try {
      this.callableStatement.setNCharacterStream(parameterIndex, value, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNCharacterStream(String parameterName, java.io.Reader value) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setNCharacterStream", "setNCharacterStream");

    try {
      this.callableStatement.setNCharacterStream(parameterName, value);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNCharacterStream(String parameterName, java.io.Reader value, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setNCharacterStream", "setNCharacterStream");

    try {
      this.callableStatement.setNCharacterStream(parameterName, value, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNClob(String parameterName, java.sql.NClob value) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setNClob", "setNClob");

    try {
      this.callableStatement.setNClob(parameterName, value);
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
            "java.sql.CallableStatement.setNClob", "setNClob");

    try {
      this.callableStatement.setNClob(parameterIndex, value);
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
            "java.sql.CallableStatement.setNClob", "setNClob");

    try {
      this.callableStatement.setNClob(parameterIndex, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNClob(String parameterName, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setNClob", "setNClob");

    try {
      this.callableStatement.setNClob(parameterName, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNClob(String parameterName, java.io.Reader reader, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setNClob", "setNClob");

    try {
      this.callableStatement.setNClob(parameterName, reader, length);
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
            "java.sql.CallableStatement.setNClob", "setNClob");

    try {
      this.callableStatement.setNClob(parameterIndex, reader, length);
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
            "java.sql.CallableStatement.setNString", "setNString");

    try {
      this.callableStatement.setNString(parameterIndex, value);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNString(String parameterName, String value) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setNString", "setNString");

    try {
      this.callableStatement.setNString(parameterName, value);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setNull", "setNull");

    try {
      this.callableStatement.setNull(parameterIndex, sqlType);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNull(String parameterName, int sqlType) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setNull", "setNull");

    try {
      this.callableStatement.setNull(parameterName, sqlType);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setNull", "setNull");

    try {
      this.callableStatement.setNull(parameterIndex, sqlType, typeName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setNull(String parameterName, int sqlType, String typeName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setNull", "setNull");

    try {
      this.callableStatement.setNull(parameterName, sqlType, typeName);
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
            "java.sql.CallableStatement.setObject", "setObject");

    try {
      this.callableStatement.setObject(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setObject(String parameterName, Object x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setObject", "setObject");

    try {
      this.callableStatement.setObject(parameterName, x);
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
            "java.sql.CallableStatement.setObject", "setObject");

    try {
      this.callableStatement.setObject(parameterIndex, x, targetSqlType);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setObject(String parameterName, Object x, int targetSqlType) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setObject", "setObject");

    try {
      this.callableStatement.setObject(parameterName, x, targetSqlType);
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
            "java.sql.CallableStatement.setObject", "setObject");

    try {
      this.callableStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setObject(String parameterName, Object x, int targetSqlType, int scaleOrLength)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setObject", "setObject");

    try {
      this.callableStatement.setObject(parameterName, x, targetSqlType, scaleOrLength);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Ref getRef(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getRef", "getRef");

    try {
      return this.callableStatement.getRef(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Ref getRef(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getRef", "getRef");

    try {
      return this.callableStatement.getRef(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setRef", "setRef");

    try {
      this.callableStatement.setRef(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.RowId getRowId(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getRowId", "getRowId");

    try {
      return this.callableStatement.getRowId(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.RowId getRowId(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getRowId", "getRowId");

    try {
      return this.callableStatement.getRowId(parameterName);
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
            "java.sql.CallableStatement.setRowId", "setRowId");

    try {
      this.callableStatement.setRowId(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setRowId(String parameterName, java.sql.RowId x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setRowId", "setRowId");

    try {
      this.callableStatement.setRowId(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public short getShort(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getShort", "getShort");

    try {
      return this.callableStatement.getShort(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public short getShort(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getShort", "getShort");

    try {
      return this.callableStatement.getShort(parameterName);
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
            "java.sql.CallableStatement.setShort", "setShort");

    try {
      this.callableStatement.setShort(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setShort(String parameterName, short x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setShort", "setShort");

    try {
      this.callableStatement.setShort(parameterName, x);
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
            "java.sql.CallableStatement.setSQLXML", "setSQLXML");

    try {
      this.callableStatement.setSQLXML(parameterIndex, xmlObject);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setSQLXML(String parameterName, java.sql.SQLXML xmlObject) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setSQLXML", "setSQLXML");

    try {
      this.callableStatement.setSQLXML(parameterName, xmlObject);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public String getString(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getString", "getString");

    try {
      return this.callableStatement.getString(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public String getString(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getString", "getString");

    try {
      return this.callableStatement.getString(parameterName);
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
            "java.sql.CallableStatement.setString", "setString");

    try {
      this.callableStatement.setString(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setString(String parameterName, String x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setString", "setString");

    try {
      this.callableStatement.setString(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Time getTime(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getTime", "getTime");

    try {
      return this.callableStatement.getTime(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Time getTime(int parameterIndex, java.util.Calendar cal) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getTime", "getTime");

    try {
      return this.callableStatement.getTime(parameterIndex, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Time getTime(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getTime", "getTime");

    try {
      return this.callableStatement.getTime(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Time getTime(String parameterName, java.util.Calendar cal) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getTime", "getTime");

    try {
      return this.callableStatement.getTime(parameterName, cal);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setTime", "setTime");

    try {
      this.callableStatement.setTime(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setTime(String parameterName, java.sql.Time x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setTime", "setTime");

    try {
      this.callableStatement.setTime(parameterName, x);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setTime", "setTime");

    try {
      this.callableStatement.setTime(parameterIndex, x, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setTime(String parameterName, java.sql.Time x, java.util.Calendar cal)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setTime", "setTime");

    try {
      this.callableStatement.setTime(parameterName, x, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Timestamp getTimestamp(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getTimestamp", "getTimestamp");

    try {
      return this.callableStatement.getTimestamp(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Timestamp getTimestamp(int parameterIndex, java.util.Calendar cal)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getTimestamp", "getTimestamp");

    try {
      return this.callableStatement.getTimestamp(parameterIndex, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Timestamp getTimestamp(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getTimestamp", "getTimestamp");

    try {
      return this.callableStatement.getTimestamp(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Timestamp getTimestamp(String parameterName, java.util.Calendar cal)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getTimestamp", "getTimestamp");

    try {
      return this.callableStatement.getTimestamp(parameterName, cal);
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
            "java.sql.CallableStatement.setTimestamp", "setTimestamp");

    try {
      this.callableStatement.setTimestamp(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setTimestamp(String parameterName, java.sql.Timestamp x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setTimestamp", "setTimestamp");

    try {
      this.callableStatement.setTimestamp(parameterName, x);
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
            "java.sql.CallableStatement.setTimestamp", "setTimestamp");

    try {
      this.callableStatement.setTimestamp(parameterIndex, x, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setTimestamp(String parameterName, java.sql.Timestamp x, java.util.Calendar cal)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.setTimestamp", "setTimestamp");

    try {
      this.callableStatement.setTimestamp(parameterName, x, cal);
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
            "java.sql.CallableStatement.setUnicodeStream", "setUnicodeStream");

    try {
      this.callableStatement.setUnicodeStream(parameterIndex, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.net.URL getURL(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getURL", "getURL");

    try {
      return this.callableStatement.getURL(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.net.URL getURL(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.getURL", "getURL");

    try {
      return this.callableStatement.getURL(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setURL", "setURL");

    try {
      this.callableStatement.setURL(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void setURL(String parameterName, java.net.URL x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.setURL", "setURL");

    try {
      this.callableStatement.setURL(parameterName, x);
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
            "java.sql.CallableStatement.isClosed", "isClosed");

    try {
      return this.callableStatement.isClosed();
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
            "java.sql.CallableStatement.isCloseOnCompletion", "isCloseOnCompletion");

    try {
      return this.callableStatement.isCloseOnCompletion();
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
            "java.sql.CallableStatement.isPoolable", "isPoolable");

    try {
      return this.callableStatement.isPoolable();
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
            "java.sql.CallableStatement.setCursorName", "setCursorName");

    try {
      this.callableStatement.setCursorName(cursorName);
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
            "java.sql.CallableStatement.setEscapeProcessing", "setEscapeProcessing");

    try {
      this.callableStatement.setEscapeProcessing(enable);
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
            "java.sql.CallableStatement.setFetchDirection", "setFetchDirection");

    try {
      this.callableStatement.setFetchDirection(direction);
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
            "java.sql.CallableStatement.setFetchSize", "setFetchSize");

    try {
      this.callableStatement.setFetchSize(rows);
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
            "java.sql.CallableStatement.setMaxFieldSize", "setMaxFieldSize");

    try {
      this.callableStatement.setMaxFieldSize(max);
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
            "java.sql.CallableStatement.setMaxRows", "setMaxRows");

    try {
      this.callableStatement.setMaxRows(max);
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
            "java.sql.CallableStatement.setPoolable", "setPoolable");

    try {
      this.callableStatement.setPoolable(poolable);
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
            "java.sql.CallableStatement.setQueryTimeout", "setQueryTimeout");

    try {
      this.callableStatement.setQueryTimeout(seconds);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return this.callableStatement.isWrapperFor(iface);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return this.callableStatement.unwrap(iface);
  }

  @Override
  public Object getObject(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getObject", "getObject");

    try {
      return this.callableStatement.getObject(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getObject", "getObject");

    try {
      return this.callableStatement.getObject(parameterIndex, type);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public Object getObject(int parameterIndex, java.util.Map<String, Class<?>> map)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getObject", "getObject");

    try {
      return this.callableStatement.getObject(parameterIndex, map);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public Object getObject(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getObject", "getObject");

    try {
      return this.callableStatement.getObject(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getObject", "getObject");

    try {
      return this.callableStatement.getObject(parameterName, type);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public Object getObject(String parameterName, java.util.Map<String, Class<?>> map)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getObject", "getObject");

    try {
      return this.callableStatement.getObject(parameterName, map);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.SQLXML getSQLXML(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getSQLXML", "getSQLXML");

    try {
      return this.callableStatement.getSQLXML(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.SQLXML getSQLXML(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getSQLXML", "getSQLXML");

    try {
      return this.callableStatement.getSQLXML(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public String getNString(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getNString", "getNString");

    try {
      return this.callableStatement.getNString(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public String getNString(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getNString", "getNString");

    try {
      return this.callableStatement.getNString(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.io.Reader getNCharacterStream(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getNCharacterStream", "getNCharacterStream");

    try {
      return this.callableStatement.getNCharacterStream(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.io.Reader getNCharacterStream(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getNCharacterStream", "getNCharacterStream");

    try {
      return this.callableStatement.getNCharacterStream(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.io.Reader getCharacterStream(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getCharacterStream", "getCharacterStream");

    try {
      return this.callableStatement.getCharacterStream(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.io.Reader getCharacterStream(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getCharacterStream", "getCharacterStream");

    try {
      return this.callableStatement.getCharacterStream(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.NClob getNClob(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getNClob", "getNClob");

    try {
      return this.callableStatement.getNClob(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.NClob getNClob(String parameterName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.getNClob", "getNClob");

    try {
      return this.callableStatement.getNClob(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.registerOutParameter", "registerOutParameter");

    try {
      this.callableStatement.registerOutParameter(parameterIndex, sqlType);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.registerOutParameter", "registerOutParameter");

    try {
      this.callableStatement.registerOutParameter(parameterIndex, sqlType, scale);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void registerOutParameter(int parameterIndex, int sqlType, String typeName)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.registerOutParameter", "registerOutParameter");

    try {
      this.callableStatement.registerOutParameter(parameterIndex, sqlType, typeName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void registerOutParameter(String parameterName, int sqlType) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.registerOutParameter", "registerOutParameter");

    try {
      this.callableStatement.registerOutParameter(parameterName, sqlType);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void registerOutParameter(String parameterName, int sqlType, int scale)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.registerOutParameter", "registerOutParameter");

    try {
      this.callableStatement.registerOutParameter(parameterName, sqlType, scale);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void registerOutParameter(String parameterName, int sqlType, String typeName)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.CallableStatement.registerOutParameter", "registerOutParameter");

    try {
      this.callableStatement.registerOutParameter(parameterName, sqlType, typeName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean wasNull() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.CallableStatement.wasNull", "wasNull");

    try {
      return this.callableStatement.wasNull();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }
}
