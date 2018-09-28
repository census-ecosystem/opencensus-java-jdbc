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
import io.opencensus.integration.jdbc.Observability.TrackingOperation;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Wraps and instruments a {@link ResultSet} instance with tracing and metrics using OpenCensus. */
public class OcWrapResultSet implements ResultSet {
  private final ResultSet resultSet;

  public OcWrapResultSet(ResultSet rs) {
    this.resultSet = rs;
  }

  @Override
  public void clearWarnings() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.clearWarnings", "clearWarnings");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.clearWarnings();
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.close", "close");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.close();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void deleteRow() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.deleteRow", "deleteRow");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.deleteRow();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int findColumn(String columnLabel) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.findColumn", "findColumn");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.findColumn(columnLabel);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean first() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.first", "first");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.first();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void insertRow() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.insertRow", "insertRow");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.insertRow();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateObject(int columnIndex, Object x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateObject", "updateObject");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateObject(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateObject", "updateObject");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateObject(columnIndex, x, scaleOrLength);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateObject(String columnLabel, Object x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateObject", "updateObject");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateObject(columnLabel, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateObject", "updateObject");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateObject(columnLabel, x, scaleOrLength);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateTimestamp(int columnIndex, java.sql.Timestamp x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateTimestamp", "updateTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateTimestamp(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateTimestamp(String columnName, java.sql.Timestamp x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateTimestamp", "updateTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateTimestamp(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateTime(int columnIndex, java.sql.Time x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateTime", "updateTime");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateTime(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateTime(String columnName, java.sql.Time x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateTime", "updateTime");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateTime(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateDate(int columnIndex, java.sql.Date x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateDate", "updateDate");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateDate(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateDate(String columnName, java.sql.Date x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateDate", "updateDate");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateDate(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBytes(int columnIndex, byte[] x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBytes", "updateBytes");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBytes(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBytes(String columnName, byte[] x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBytes", "updateBytes");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBytes(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateString(int columnIndex, String x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateString", "updateString");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateString(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateString(String columnName, String x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateString", "updateString");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateString(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBigDecimal(int columnIndex, java.math.BigDecimal x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBigDecimal", "updateBigDecimal");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBigDecimal(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBigDecimal(String columnName, java.math.BigDecimal x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBigDecimal", "updateBigDecimal");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBigDecimal(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateDouble(int columnIndex, double x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateDouble", "updateDouble");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateDouble(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateDouble(String columnName, double x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateDouble", "updateDouble");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateDouble(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateFloat(int columnIndex, float x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateFloat", "updateFloat");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateFloat(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateFloat(String columnName, float x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateFloat", "updateFloat");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateFloat(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateLong(int columnIndex, long x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateLong", "updateLong");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateLong(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateLong(String columnName, long x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateLong", "updateLong");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateLong(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateInt(int columnIndex, int x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateInt", "updateInt");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateInt(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateInt(String columnName, int x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateInt", "updateInt");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateInt(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateShort(int columnIndex, short x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateShort", "updateShort");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateShort(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateShort(String columnName, short x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateShort", "updateShort");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateShort(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateByte(int columnIndex, byte x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateByte", "updateByte");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateByte(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateByte(String columnName, byte x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateByte", "updateByte");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateByte(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBoolean(int columnIndex, boolean x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBoolean", "updateBoolean");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBoolean(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBoolean(String columnName, boolean x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBoolean", "updateBoolean");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBoolean(columnName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNull(int columnIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNull", "updateNull");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNull(columnIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNull(String columnName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNull", "updateNull");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNull(columnName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean rowDeleted() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.rowDeleted", "rowDeleted");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.rowDeleted();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean rowInserted() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.rowInserted", "rowInserted");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.rowInserted();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean rowUpdated() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.rowUpdated", "rowUpdated");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.rowUpdated();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getConcurrency() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getConcurrency", "getConcurrency");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getConcurrency();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getType() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getType", "getType");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getType();
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
            "java.sql.ResultSet.getFetchDirection", "getFetchDirection");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getFetchDirection();
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
            "java.sql.ResultSet.getFetchSize", "getFetchSize");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getFetchSize();
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getMetaData", "getMetaData");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getMetaData();
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getWarnings", "getWarnings");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getWarnings();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Array getArray(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getArray", "getArray");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getArray(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Array getArray(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getArray", "getArray");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getArray(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.math.BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBigDecimal", "getBigDecimal");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBigDecimal(columnIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.math.BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBigDecimal", "getBigDecimal");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBigDecimal(columnIndex, scale);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.math.BigDecimal getBigDecimal(String columnLabel) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBigDecimal", "getBigDecimal");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBigDecimal(columnLabel);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.math.BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBigDecimal", "getBigDecimal");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBigDecimal(columnLabel, scale);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Blob getBlob(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBlob", "getBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBlob(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Blob getBlob(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBlob", "getBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBlob(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBlob(int parameterIndex, java.sql.Blob x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBlob(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBlob(int parameterIndex, java.io.InputStream inputStream) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBlob(parameterIndex, inputStream);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBlob(int parameterIndex, java.io.InputStream inputStream, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBlob(parameterIndex, inputStream, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBlob(String parameterName, java.sql.Blob x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBlob(parameterName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBlob(String parameterName, java.io.InputStream inputStream)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBlob(parameterName, inputStream);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBlob(String parameterName, java.io.InputStream inputStream, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBlob(parameterName, inputStream, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean getBoolean(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBoolean", "getBoolean");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBoolean(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean getBoolean(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBoolean", "getBoolean");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBoolean(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Clob getClob(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getClob", "getClob");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getClob(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Clob getClob(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getClob", "getClob");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getClob(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateClob(int columnIndex, java.sql.Clob clob) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateClob(columnIndex, clob);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateClob(int columnIndex, java.io.Reader reader) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateClob(columnIndex, reader);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateClob(int columnIndex, java.io.Reader reader, long length) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateClob(columnIndex, reader, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateClob(String columnLabel, java.sql.Clob clob) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateClob(columnLabel, clob);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateClob(String columnLabel, java.io.Reader reader) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateClob(columnLabel, reader);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateClob(String columnLabel, java.io.Reader reader, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateClob(columnLabel, reader, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Date getDate(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getDate(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Date getDate(int parameterIndex, java.util.Calendar cal) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getDate(parameterIndex, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Date getDate(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getDate(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Date getDate(String parameterName, java.util.Calendar cal) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getDate(parameterName, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public double getDouble(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDouble", "getDouble");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getDouble(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public double getDouble(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDouble", "getDouble");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getDouble(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public float getFloat(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getFloat", "getFloat");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getFloat(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public float getFloat(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getFloat", "getFloat");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getFloat(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getInt(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getInt", "getInt");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getInt(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getInt(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getInt", "getInt");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getInt(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public long getLong(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getLong", "getLong");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getLong(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public long getLong(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getLong", "getLong");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getLong(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Ref getRef(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRef", "getRef");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getRef(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Ref getRef(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRef", "getRef");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getRef(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.RowId getRowId(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRowId", "getRowId");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getRowId(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.RowId getRowId(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRowId", "getRowId");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getRowId(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public short getShort(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getShort", "getShort");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getShort(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public short getShort(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getShort", "getShort");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getShort(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public String getString(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getString", "getString");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getString(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public String getString(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getString", "getString");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getString(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Time getTime(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getTime(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Time getTime(int parameterIndex, java.util.Calendar cal) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getTime(parameterIndex, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Time getTime(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getTime(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Time getTime(String parameterName, java.util.Calendar cal) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getTime(parameterName, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.net.URL getURL(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getURL", "getURL");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getURL(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.net.URL getURL(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getURL", "getURL");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getURL(parameterName);
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
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isClosed", "isClosed");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.isClosed();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isLast() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isLast", "isLast");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.isLast();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isAfterLast() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isAfterLast", "isAfterLast");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.isAfterLast();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isFirst() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isFirst", "isFirst");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.isFirst();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public String getCursorName() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getCursorName", "getCursorName");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getCursorName();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public byte[] getBytes(int columnIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBytes", "getBytes");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBytes(columnIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public byte getByte(int columnIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getByte", "getByte");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getByte(columnIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public byte getByte(String columnLabel) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getByte", "getByte");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getByte(columnLabel);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public byte[] getBytes(String columnLabel) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBytes", "getBytes");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBytes(columnLabel);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.io.InputStream getBinaryStream(int columnIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBinaryStream", "getBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBinaryStream(columnIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.io.InputStream getBinaryStream(String columnLabel) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getBinaryStream", "getBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getBinaryStream(columnLabel);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.io.InputStream getAsciiStream(int columnIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getAsciiStream", "getAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getAsciiStream(columnIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.io.InputStream getAsciiStream(String columnLabel) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getAsciiStream", "getAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getAsciiStream(columnLabel);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.io.InputStream getUnicodeStream(int columnIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getUnicodeStream", "getUnicodeBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getUnicodeStream(columnIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.io.InputStream getUnicodeStream(String columnLabel) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getUnicodeStream", "getUnicodeBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getUnicodeStream(columnLabel);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean isBeforeFirst() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.isBeforeFirst", "isBeforeFirst");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.isBeforeFirst();
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
            "java.sql.ResultSet.setFetchDirection", "setFetchDirection");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.setFetchDirection(direction);
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
            "java.sql.ResultSet.setFetchSize", "setFetchSize");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.setFetchSize(rows);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
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
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getObject(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getObject(parameterIndex, type);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public Object getObject(int parameterIndex, java.util.Map<String, Class<?>> map)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getObject(parameterIndex, map);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public Object getObject(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getObject(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getObject(parameterName, type);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public Object getObject(String parameterName, java.util.Map<String, Class<?>> map)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getObject(parameterName, map);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.SQLXML getSQLXML(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getSQLXML", "getSQLXML");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getSQLXML(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.SQLXML getSQLXML(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getSQLXML", "getSQLXML");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getSQLXML(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public String getNString(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNString", "getNString");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getNString(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public String getNString(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNString", "getNString");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getNString(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.io.Reader getNCharacterStream(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getNCharacterStream", "getNCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getNCharacterStream(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.io.Reader getNCharacterStream(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getNCharacterStream", "getNCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getNCharacterStream(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.io.Reader getCharacterStream(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getCharacterStream", "getCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getCharacterStream(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.io.Reader getCharacterStream(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getCharacterStream", "getCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getCharacterStream(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateCharacterStream(int parameterIndex, java.io.Reader x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateCharacterStream(parameterIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateCharacterStream(int parameterIndex, java.io.Reader x, int length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateCharacterStream(parameterIndex, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateCharacterStream(int parameterIndex, java.io.Reader x, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateCharacterStream(parameterIndex, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateCharacterStream(String parameterName, java.io.Reader x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateCharacterStream(parameterName, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateCharacterStream(String parameterName, java.io.Reader x, int length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateCharacterStream(parameterName, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateCharacterStream(String parameterName, java.io.Reader x, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateCharacterStream(parameterName, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBinaryStream(int columnIndex, java.io.InputStream x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBinaryStream(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBinaryStream(int columnIndex, java.io.InputStream x, int length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBinaryStream(columnIndex, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBinaryStream(int columnIndex, java.io.InputStream x, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBinaryStream(columnIndex, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBinaryStream(String columnLabel, java.io.InputStream x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBinaryStream(columnLabel, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBinaryStream(String columnLabel, java.io.InputStream x, int length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBinaryStream(columnLabel, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateBinaryStream(String columnLabel, java.io.InputStream x, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateBinaryStream(columnLabel, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateAsciiStream(int columnIndex, java.io.InputStream x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateAsciiStream(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateAsciiStream(int columnIndex, java.io.InputStream x, int length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateAsciiStream(columnIndex, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateAsciiStream(int columnIndex, java.io.InputStream x, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateAsciiStream(columnIndex, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateAsciiStream(String columnLabel, java.io.InputStream x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateAsciiStream(columnLabel, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateAsciiStream(String columnLabel, java.io.InputStream x, int length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateAsciiStream(columnLabel, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateAsciiStream(String columnLabel, java.io.InputStream x, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateAsciiStream(columnLabel, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNCharacterStream(int columnIndex, java.io.Reader x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNCharacterStream(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNCharacterStream(int columnIndex, java.io.Reader x, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNCharacterStream(columnIndex, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNCharacterStream(String columnLabel, java.io.Reader x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNCharacterStream(columnLabel, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNCharacterStream(String columnLabel, java.io.Reader x, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNCharacterStream(columnLabel, x, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.NClob getNClob(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNClob", "getNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getNClob(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateSQLXML(int columnIndex, java.sql.SQLXML xmlObject) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateSQLXML", "updateSQLXML");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateSQLXML(columnIndex, xmlObject);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateSQLXML(String columnName, java.sql.SQLXML xmlObject) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateSQLXML", "updateSQLXML");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateSQLXML(columnName, xmlObject);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNString(String columnLabel, String nString) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNString", "updateNString");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNString(columnLabel, nString);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNString(int columnIndex, String nString) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.updateNString", "updateNString");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNString(columnIndex, nString);
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
            "java.sql.ResultSet.getHoldability", "getHoldability");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getHoldability();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateRow() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRow", "updateRow");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateRow();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateRowId(int columnIndex, java.sql.RowId x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRowId", "updateRowId");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateRowId(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateRowId(String columnLabel, java.sql.RowId x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRowId", "updateRowId");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateRowId(columnLabel, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateArray(int columnIndex, java.sql.Array x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateArray", "updateArray");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateArray(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateArray(String columnLabel, java.sql.Array x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateArray", "updateArray");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateArray(columnLabel, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateRef(int columnIndex, java.sql.Ref x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRef", "updateRef");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateRef(columnIndex, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateRef(String columnLabel, java.sql.Ref x) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRef", "updateRef");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateRef(columnLabel, x);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Timestamp getTimestamp(int parameterIndex) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getTimestamp", "getTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getTimestamp(parameterIndex);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Timestamp getTimestamp(int parameterIndex, java.util.Calendar cal)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getTimestamp", "getTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getTimestamp(parameterIndex, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Timestamp getTimestamp(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getTimestamp", "getTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getTimestamp(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Timestamp getTimestamp(String parameterName, java.util.Calendar cal)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getTimestamp", "getTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getTimestamp(parameterName, cal);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void moveToCurrentRow() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.moveToCurrentRow", "moveToCurrentRow");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.moveToCurrentRow();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void moveToInsertRow() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.moveToInsertRow", "moveToInsertRow");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.moveToInsertRow();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean last() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.last", "last");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.last();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void afterLast() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.afterLast", "afterLast");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.afterLast();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void beforeFirst() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.beforeFirst", "beforeFirst");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.beforeFirst();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean next() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.next", "next");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.next();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean previous() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.previous", "previous");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.previous();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean absolute(int rows) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.absolute", "absolute");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.absolute(rows);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getRow() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRow", "getRow");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getRow();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean relative(int rows) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.relative", "relative");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.relative(rows);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void cancelRowUpdates() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.cancelRowUpdates", "cancelRowUpdates");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.cancelRowUpdates();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void refreshRow() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.refreshRow", "refreshRow");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.refreshRow();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.Statement getStatement() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.ResultSet.getStatement", "getStatement");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getStatement();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.NClob getNClob(String parameterName) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNClob", "getNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.getNClob(parameterName);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNClob(int columnIndex, java.sql.NClob nclob) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNClob(columnIndex, nclob);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNClob(int columnIndex, java.io.Reader reader) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNClob(columnIndex, reader);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNClob(int columnIndex, java.io.Reader reader, long length) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNClob(columnIndex, reader, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNClob(String columnLabel, java.sql.NClob nclob) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNClob(columnLabel, nclob);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNClob(String columnLabel, java.io.Reader reader) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNClob(columnLabel, reader);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void updateNClob(String columnLabel, java.io.Reader reader, long length)
      throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

    try (Scope ws = trackingOperation.withSpan()) {
      this.resultSet.updateNClob(columnLabel, reader, length);
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean wasNull() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.wasNull", "wasNull");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.resultSet.wasNull();
    } catch (Exception e) {
      trackingOperation.endWithException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }
}
