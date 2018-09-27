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

import java.sql.SQLException;

public class OcWrapResultSet implements java.sql.ResultSet {
  private final java.sql.ResultSet resultSet;

  public OcWrapResultSet(java.sql.ResultSet rs) throws SQLException {
    this.resultSet = rs;
  }

  @Override
  public void clearWarnings() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.clearWarnings", "clearWarnings");

    try {
      this.resultSet.clearWarnings();
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.close", "close");

    try {
      this.resultSet.close();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void deleteRow() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.deleteRow", "deleteRow");

    try {
      this.resultSet.deleteRow();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int findColumn(String columnLabel) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.findColumn", "findColumn");

    try {
      return this.resultSet.findColumn(columnLabel);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean first() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.first", "first");

    try {
      return this.resultSet.first();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void insertRow() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.insertRow", "insertRow");

    try {
      this.resultSet.insertRow();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateObject(int columnIndex, Object x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateObject", "updateObject");

    try {
      this.resultSet.updateObject(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateObject", "updateObject");

    try {
      this.resultSet.updateObject(columnIndex, x, scaleOrLength);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateObject(String columnLabel, Object x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateObject", "updateObject");

    try {
      this.resultSet.updateObject(columnLabel, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateObject", "updateObject");

    try {
      this.resultSet.updateObject(columnLabel, x, scaleOrLength);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateTimestamp(int columnIndex, java.sql.Timestamp x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateTimestamp", "updateTimestamp");

    try {
      this.resultSet.updateTimestamp(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateTimestamp(String columnName, java.sql.Timestamp x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateTimestamp", "updateTimestamp");

    try {
      this.resultSet.updateTimestamp(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateTime(int columnIndex, java.sql.Time x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateTime", "updateTime");

    try {
      this.resultSet.updateTime(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateTime(String columnName, java.sql.Time x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateTime", "updateTime");

    try {
      this.resultSet.updateTime(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateDate(int columnIndex, java.sql.Date x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateDate", "updateDate");

    try {
      this.resultSet.updateDate(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateDate(String columnName, java.sql.Date x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateDate", "updateDate");

    try {
      this.resultSet.updateDate(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBytes(int columnIndex, byte[] x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBytes", "updateBytes");

    try {
      this.resultSet.updateBytes(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBytes(String columnName, byte[] x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBytes", "updateBytes");

    try {
      this.resultSet.updateBytes(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateString(int columnIndex, String x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateString", "updateString");

    try {
      this.resultSet.updateString(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateString(String columnName, String x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateString", "updateString");

    try {
      this.resultSet.updateString(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBigDecimal(int columnIndex, java.math.BigDecimal x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBigDecimal", "updateBigDecimal");

    try {
      this.resultSet.updateBigDecimal(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBigDecimal(String columnName, java.math.BigDecimal x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBigDecimal", "updateBigDecimal");

    try {
      this.resultSet.updateBigDecimal(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateDouble(int columnIndex, double x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateDouble", "updateDouble");

    try {
      this.resultSet.updateDouble(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateDouble(String columnName, double x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateDouble", "updateDouble");

    try {
      this.resultSet.updateDouble(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateFloat(int columnIndex, float x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateFloat", "updateFloat");

    try {
      this.resultSet.updateFloat(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateFloat(String columnName, float x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateFloat", "updateFloat");

    try {
      this.resultSet.updateFloat(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateLong(int columnIndex, long x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateLong", "updateLong");

    try {
      this.resultSet.updateLong(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateLong(String columnName, long x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateLong", "updateLong");

    try {
      this.resultSet.updateLong(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateInt(int columnIndex, int x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateInt", "updateInt");

    try {
      this.resultSet.updateInt(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateInt(String columnName, int x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateInt", "updateInt");

    try {
      this.resultSet.updateInt(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateShort(int columnIndex, short x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateShort", "updateShort");

    try {
      this.resultSet.updateShort(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateShort(String columnName, short x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateShort", "updateShort");

    try {
      this.resultSet.updateShort(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateByte(int columnIndex, byte x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateByte", "updateByte");

    try {
      this.resultSet.updateByte(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateByte(String columnName, byte x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateByte", "updateByte");

    try {
      this.resultSet.updateByte(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBoolean(int columnIndex, boolean x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBoolean", "updateBoolean");

    try {
      this.resultSet.updateBoolean(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBoolean(String columnName, boolean x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBoolean", "updateBoolean");

    try {
      this.resultSet.updateBoolean(columnName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNull(int columnIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNull", "updateNull");

    try {
      this.resultSet.updateNull(columnIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNull(String columnName) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNull", "updateNull");

    try {
      this.resultSet.updateNull(columnName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean rowDeleted() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.rowDeleted", "rowDeleted");

    try {
      return this.resultSet.rowDeleted();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean rowInserted() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.rowInserted", "rowInserted");

    try {
      return this.resultSet.rowInserted();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean rowUpdated() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.rowUpdated", "rowUpdated");

    try {
      return this.resultSet.rowUpdated();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getConcurrency() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getConcurrency", "getConcurrency");

    try {
      return this.resultSet.getConcurrency();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getType() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getType", "getType");

    try {
      return this.resultSet.getType();
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
            "java.sql.ResultSet.getFetchDirection", "getFetchDirection");

    try {
      return this.resultSet.getFetchDirection();
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
            "java.sql.ResultSet.getFetchSize", "getFetchSize");

    try {
      return this.resultSet.getFetchSize();
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getMetaData", "getMetaData");

    try {
      return this.resultSet.getMetaData();
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getWarnings", "getWarnings");

    try {
      return this.resultSet.getWarnings();
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getArray", "getArray");

    try {
      return this.resultSet.getArray(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getArray", "getArray");

    try {
      return this.resultSet.getArray(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.math.BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBigDecimal", "getBigDecimal");

    try {
      return this.resultSet.getBigDecimal(columnIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.math.BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBigDecimal", "getBigDecimal");

    try {
      return this.resultSet.getBigDecimal(columnIndex, scale);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.math.BigDecimal getBigDecimal(String columnLabel) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBigDecimal", "getBigDecimal");

    try {
      return this.resultSet.getBigDecimal(columnLabel);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.math.BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBigDecimal", "getBigDecimal");

    try {
      return this.resultSet.getBigDecimal(columnLabel, scale);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBlob", "getBlob");

    try {
      return this.resultSet.getBlob(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBlob", "getBlob");

    try {
      return this.resultSet.getBlob(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBlob(int parameterIndex, java.sql.Blob x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try {
      this.resultSet.updateBlob(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBlob(int parameterIndex, java.io.InputStream inputStream) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try {
      this.resultSet.updateBlob(parameterIndex, inputStream);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBlob(int parameterIndex, java.io.InputStream inputStream, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try {
      this.resultSet.updateBlob(parameterIndex, inputStream, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBlob(String parameterName, java.sql.Blob x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try {
      this.resultSet.updateBlob(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBlob(String parameterName, java.io.InputStream inputStream)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try {
      this.resultSet.updateBlob(parameterName, inputStream);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBlob(String parameterName, java.io.InputStream inputStream, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try {
      this.resultSet.updateBlob(parameterName, inputStream, length);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBoolean", "getBoolean");

    try {
      return this.resultSet.getBoolean(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBoolean", "getBoolean");

    try {
      return this.resultSet.getBoolean(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getClob", "getClob");

    try {
      return this.resultSet.getClob(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getClob", "getClob");

    try {
      return this.resultSet.getClob(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateClob(int columnIndex, java.sql.Clob clob) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try {
      this.resultSet.updateClob(columnIndex, clob);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateClob(int columnIndex, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try {
      this.resultSet.updateClob(columnIndex, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateClob(int columnIndex, java.io.Reader reader, long length) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try {
      this.resultSet.updateClob(columnIndex, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateClob(String columnLabel, java.sql.Clob clob) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try {
      this.resultSet.updateClob(columnLabel, clob);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateClob(String columnLabel, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try {
      this.resultSet.updateClob(columnLabel, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateClob(String columnLabel, java.io.Reader reader, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try {
      this.resultSet.updateClob(columnLabel, reader, length);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

    try {
      return this.resultSet.getDate(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

    try {
      return this.resultSet.getDate(parameterIndex, cal);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

    try {
      return this.resultSet.getDate(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

    try {
      return this.resultSet.getDate(parameterName, cal);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDouble", "getDouble");

    try {
      return this.resultSet.getDouble(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDouble", "getDouble");

    try {
      return this.resultSet.getDouble(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getFloat", "getFloat");

    try {
      return this.resultSet.getFloat(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getFloat", "getFloat");

    try {
      return this.resultSet.getFloat(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getInt", "getInt");

    try {
      return this.resultSet.getInt(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getInt", "getInt");

    try {
      return this.resultSet.getInt(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getLong", "getLong");

    try {
      return this.resultSet.getLong(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getLong", "getLong");

    try {
      return this.resultSet.getLong(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRef", "getRef");

    try {
      return this.resultSet.getRef(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRef", "getRef");

    try {
      return this.resultSet.getRef(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRowId", "getRowId");

    try {
      return this.resultSet.getRowId(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRowId", "getRowId");

    try {
      return this.resultSet.getRowId(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getShort", "getShort");

    try {
      return this.resultSet.getShort(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getShort", "getShort");

    try {
      return this.resultSet.getShort(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getString", "getString");

    try {
      return this.resultSet.getString(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getString", "getString");

    try {
      return this.resultSet.getString(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

    try {
      return this.resultSet.getTime(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

    try {
      return this.resultSet.getTime(parameterIndex, cal);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

    try {
      return this.resultSet.getTime(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

    try {
      return this.resultSet.getTime(parameterName, cal);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getURL", "getURL");

    try {
      return this.resultSet.getURL(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getURL", "getURL");

    try {
      return this.resultSet.getURL(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isClosed", "isClosed");

    try {
      return this.resultSet.isClosed();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean isLast() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isLast", "isLast");

    try {
      return this.resultSet.isLast();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean isAfterLast() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isAfterLast", "isAfterLast");

    try {
      return this.resultSet.isAfterLast();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean isFirst() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isFirst", "isFirst");

    try {
      return this.resultSet.isFirst();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public String getCursorName() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getCursorName", "getCursorName");

    try {
      return this.resultSet.getCursorName();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public byte[] getBytes(int columnIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBytes", "getBytes");

    try {
      return this.resultSet.getBytes(columnIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public byte getByte(int columnIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getByte", "getByte");

    try {
      return this.resultSet.getByte(columnIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public byte getByte(String columnLabel) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getByte", "getByte");

    try {
      return this.resultSet.getByte(columnLabel);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public byte[] getBytes(String columnLabel) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBytes", "getBytes");

    try {
      return this.resultSet.getBytes(columnLabel);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.io.InputStream getBinaryStream(int columnIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBinaryStream", "getBinaryStream");

    try {
      return this.resultSet.getBinaryStream(columnIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.io.InputStream getBinaryStream(String columnLabel) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBinaryStream", "getBinaryStream");

    try {
      return this.resultSet.getBinaryStream(columnLabel);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.io.InputStream getAsciiStream(int columnIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getAsciiStream", "getAsciiStream");

    try {
      return this.resultSet.getAsciiStream(columnIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.io.InputStream getAsciiStream(String columnLabel) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getAsciiStream", "getAsciiStream");

    try {
      return this.resultSet.getAsciiStream(columnLabel);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.io.InputStream getUnicodeStream(int columnIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getUnicodeStream", "getUnicodeBinaryStream");

    try {
      return this.resultSet.getUnicodeStream(columnIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.io.InputStream getUnicodeStream(String columnLabel) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getUnicodeStream", "getUnicodeBinaryStream");

    try {
      return this.resultSet.getUnicodeStream(columnLabel);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean isBeforeFirst() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.isBeforeFirst", "isBeforeFirst");

    try {
      return this.resultSet.isBeforeFirst();
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
            "java.sql.ResultSet.setFetchDirection", "setFetchDirection");

    try {
      this.resultSet.setFetchDirection(direction);
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
            "java.sql.ResultSet.setFetchSize", "setFetchSize");

    try {
      this.resultSet.setFetchSize(rows);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return this.resultSet.isWrapperFor(iface);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return this.resultSet.unwrap(iface);
  }

  @Override
  public Object getObject(int parameterIndex) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try {
      return this.resultSet.getObject(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try {
      return this.resultSet.getObject(parameterIndex, type);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try {
      return this.resultSet.getObject(parameterIndex, map);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try {
      return this.resultSet.getObject(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try {
      return this.resultSet.getObject(parameterName, type);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try {
      return this.resultSet.getObject(parameterName, map);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getSQLXML", "getSQLXML");

    try {
      return this.resultSet.getSQLXML(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getSQLXML", "getSQLXML");

    try {
      return this.resultSet.getSQLXML(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNString", "getNString");

    try {
      return this.resultSet.getNString(parameterIndex);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNString", "getNString");

    try {
      return this.resultSet.getNString(parameterName);
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
            "java.sql.ResultSet.getNCharacterStream", "getNCharacterStream");

    try {
      return this.resultSet.getNCharacterStream(parameterIndex);
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
            "java.sql.ResultSet.getNCharacterStream", "getNCharacterStream");

    try {
      return this.resultSet.getNCharacterStream(parameterName);
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
            "java.sql.ResultSet.getCharacterStream", "getCharacterStream");

    try {
      return this.resultSet.getCharacterStream(parameterIndex);
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
            "java.sql.ResultSet.getCharacterStream", "getCharacterStream");

    try {
      return this.resultSet.getCharacterStream(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateCharacterStream(int parameterIndex, java.io.Reader x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try {
      this.resultSet.updateCharacterStream(parameterIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateCharacterStream(int parameterIndex, java.io.Reader x, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try {
      this.resultSet.updateCharacterStream(parameterIndex, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateCharacterStream(int parameterIndex, java.io.Reader x, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try {
      this.resultSet.updateCharacterStream(parameterIndex, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateCharacterStream(String parameterName, java.io.Reader x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try {
      this.resultSet.updateCharacterStream(parameterName, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateCharacterStream(String parameterName, java.io.Reader x, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try {
      this.resultSet.updateCharacterStream(parameterName, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateCharacterStream(String parameterName, java.io.Reader x, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try {
      this.resultSet.updateCharacterStream(parameterName, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBinaryStream(int columnIndex, java.io.InputStream x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try {
      this.resultSet.updateBinaryStream(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBinaryStream(int columnIndex, java.io.InputStream x, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try {
      this.resultSet.updateBinaryStream(columnIndex, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBinaryStream(int columnIndex, java.io.InputStream x, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try {
      this.resultSet.updateBinaryStream(columnIndex, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBinaryStream(String columnLabel, java.io.InputStream x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try {
      this.resultSet.updateBinaryStream(columnLabel, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBinaryStream(String columnLabel, java.io.InputStream x, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try {
      this.resultSet.updateBinaryStream(columnLabel, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateBinaryStream(String columnLabel, java.io.InputStream x, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try {
      this.resultSet.updateBinaryStream(columnLabel, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateAsciiStream(int columnIndex, java.io.InputStream x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try {
      this.resultSet.updateAsciiStream(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateAsciiStream(int columnIndex, java.io.InputStream x, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try {
      this.resultSet.updateAsciiStream(columnIndex, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateAsciiStream(int columnIndex, java.io.InputStream x, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try {
      this.resultSet.updateAsciiStream(columnIndex, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateAsciiStream(String columnLabel, java.io.InputStream x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try {
      this.resultSet.updateAsciiStream(columnLabel, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateAsciiStream(String columnLabel, java.io.InputStream x, int length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try {
      this.resultSet.updateAsciiStream(columnLabel, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateAsciiStream(String columnLabel, java.io.InputStream x, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try {
      this.resultSet.updateAsciiStream(columnLabel, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNCharacterStream(int columnIndex, java.io.Reader x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

    try {
      this.resultSet.updateNCharacterStream(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNCharacterStream(int columnIndex, java.io.Reader x, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

    try {
      this.resultSet.updateNCharacterStream(columnIndex, x, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNCharacterStream(String columnLabel, java.io.Reader x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

    try {
      this.resultSet.updateNCharacterStream(columnLabel, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNCharacterStream(String columnLabel, java.io.Reader x, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

    try {
      this.resultSet.updateNCharacterStream(columnLabel, x, length);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNClob", "getNClob");

    try {
      return this.resultSet.getNClob(parameterIndex);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateSQLXML(int columnIndex, java.sql.SQLXML xmlObject) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateSQLXML", "updateSQLXML");

    try {
      this.resultSet.updateSQLXML(columnIndex, xmlObject);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateSQLXML(String columnName, java.sql.SQLXML xmlObject) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateSQLXML", "updateSQLXML");

    try {
      this.resultSet.updateSQLXML(columnName, xmlObject);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNString(String columnLabel, String nString) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNString", "updateNString");

    try {
      this.resultSet.updateNString(columnLabel, nString);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNString(int columnIndex, String nString) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNString", "updateNString");

    try {
      this.resultSet.updateNString(columnIndex, nString);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getHoldability() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getHoldability", "getHoldability");

    try {
      return this.resultSet.getHoldability();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateRow() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRow", "updateRow");

    try {
      this.resultSet.updateRow();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateRowId(int columnIndex, java.sql.RowId x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRowId", "updateRowId");

    try {
      this.resultSet.updateRowId(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateRowId(String columnLabel, java.sql.RowId x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRowId", "updateRowId");

    try {
      this.resultSet.updateRowId(columnLabel, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateArray(int columnIndex, java.sql.Array x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateArray", "updateArray");

    try {
      this.resultSet.updateArray(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateArray(String columnLabel, java.sql.Array x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateArray", "updateArray");

    try {
      this.resultSet.updateArray(columnLabel, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateRef(int columnIndex, java.sql.Ref x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRef", "updateRef");

    try {
      this.resultSet.updateRef(columnIndex, x);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateRef(String columnLabel, java.sql.Ref x) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRef", "updateRef");

    try {
      this.resultSet.updateRef(columnLabel, x);
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
            "java.sql.ResultSet.getTimestamp", "getTimestamp");

    try {
      return this.resultSet.getTimestamp(parameterIndex);
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
            "java.sql.ResultSet.getTimestamp", "getTimestamp");

    try {
      return this.resultSet.getTimestamp(parameterIndex, cal);
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
            "java.sql.ResultSet.getTimestamp", "getTimestamp");

    try {
      return this.resultSet.getTimestamp(parameterName);
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
            "java.sql.ResultSet.getTimestamp", "getTimestamp");

    try {
      return this.resultSet.getTimestamp(parameterName, cal);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void moveToCurrentRow() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.moveToCurrentRow", "moveToCurrentRow");

    try {
      this.resultSet.moveToCurrentRow();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void moveToInsertRow() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.moveToInsertRow", "moveToInsertRow");

    try {
      this.resultSet.moveToInsertRow();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean last() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.last", "last");

    try {
      return this.resultSet.last();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void afterLast() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.afterLast", "afterLast");

    try {
      this.resultSet.afterLast();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void beforeFirst() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.beforeFirst", "beforeFirst");

    try {
      this.resultSet.beforeFirst();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean next() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.next", "next");

    try {
      return this.resultSet.next();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean previous() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.previous", "previous");

    try {
      return this.resultSet.previous();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean absolute(int rows) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.absolute", "absolute");

    try {
      return this.resultSet.absolute(rows);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public int getRow() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRow", "getRow");

    try {
      return this.resultSet.getRow();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public boolean relative(int rows) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.relative", "relative");

    try {
      return this.resultSet.relative(rows);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void cancelRowUpdates() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.cancelRowUpdates", "cancelRowUpdates");

    try {
      this.resultSet.cancelRowUpdates();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void refreshRow() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.refreshRow", "refreshRow");

    try {
      this.resultSet.refreshRow();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public java.sql.Statement getStatement() throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getStatement", "getStatement");

    try {
      return this.resultSet.getStatement();
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNClob", "getNClob");

    try {
      return this.resultSet.getNClob(parameterName);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNClob(int columnIndex, java.sql.NClob nclob) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try {
      this.resultSet.updateNClob(columnIndex, nclob);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNClob(int columnIndex, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try {
      this.resultSet.updateNClob(columnIndex, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNClob(int columnIndex, java.io.Reader reader, long length) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try {
      this.resultSet.updateNClob(columnIndex, reader, length);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNClob(String columnLabel, java.sql.NClob nclob) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try {
      this.resultSet.updateNClob(columnLabel, nclob);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNClob(String columnLabel, java.io.Reader reader) throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try {
      this.resultSet.updateNClob(columnLabel, reader);
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }

  @Override
  public void updateNClob(String columnLabel, java.io.Reader reader, long length)
      throws SQLException {
    Observability.RoundtripTrackingSpan span =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try {
      this.resultSet.updateNClob(columnLabel, reader, length);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.wasNull", "wasNull");

    try {
      return this.resultSet.wasNull();
    } catch (Exception e) {
      span.recordException(e);
      throw e;
    } finally {
      span.close();
    }
  }
}
