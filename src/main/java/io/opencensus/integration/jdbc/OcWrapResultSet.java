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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#clearWarnings--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.clearWarnings");

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
    // This method goes to the database directly:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#close--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.close");

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
    // This method goes to the database directly:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#deleteRow--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.deleteRow");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#findColumn-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.findColumn");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#first--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.first");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#insertRow--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.insertRow");

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
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateObject-int-java.lang.Object-
    this.resultSet.updateObject(columnIndex, x);
  }

  @Override
  public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateObject-int-java.lang.Object-int-
    this.resultSet.updateObject(columnIndex, x, scaleOrLength);
  }

  @Override
  public void updateObject(String columnLabel, Object x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateObject-java.lang.String-java.lang.Object-
    this.resultSet.updateObject(columnLabel, x);
  }

  @Override
  public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateObject-java.lang.String-java.lang.Object-int-
    this.resultSet.updateObject(columnLabel, x, scaleOrLength);
  }

  @Override
  public void updateTimestamp(int columnIndex, java.sql.Timestamp x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateTimestamp-int-java.sql.Timestamp-
    this.resultSet.updateTimestamp(columnIndex, x);
  }

  @Override
  public void updateTimestamp(String columnName, java.sql.Timestamp x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateTimestamp-java.lang.String-java.sql.Timestamp-
    this.resultSet.updateTimestamp(columnName, x);
  }

  @Override
  public void updateTime(int columnIndex, java.sql.Time x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateTime-int-java.sql.Time-
    this.resultSet.updateTime(columnIndex, x);
  }

  @Override
  public void updateTime(String columnName, java.sql.Time x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateTime-java.lang.String-java.sql.Time-
    this.resultSet.updateTime(columnName, x);
  }

  @Override
  public void updateDate(int columnIndex, java.sql.Date x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateDate-int-java.sql.Date-
    this.resultSet.updateDate(columnIndex, x);
  }

  @Override
  public void updateDate(String columnName, java.sql.Date x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateDate-java.lang.String-java.sql.Date-
    this.resultSet.updateDate(columnName, x);
  }

  @Override
  public void updateBytes(int columnIndex, byte[] x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBytes-int-byte:A-
    this.resultSet.updateBytes(columnIndex, x);
  }

  @Override
  public void updateBytes(String columnName, byte[] x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBytes-java.lang.String-byte:A-
    this.resultSet.updateBytes(columnName, x);
  }

  @Override
  public void updateString(int columnIndex, String x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateString-int-java.lang.String-
    this.resultSet.updateString(columnIndex, x);
  }

  @Override
  public void updateString(String columnName, String x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateString-java.lang.String-java.lang.String-
    this.resultSet.updateString(columnName, x);
  }

  @Override
  public void updateBigDecimal(int columnIndex, java.math.BigDecimal x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBigDecimal-int-java.math.BigDecimal-
    this.resultSet.updateBigDecimal(columnIndex, x);
  }

  @Override
  public void updateBigDecimal(String columnName, java.math.BigDecimal x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBigDecimal-java.lang.String-java.math.BigDecimal-
    this.resultSet.updateBigDecimal(columnName, x);
  }

  @Override
  public void updateDouble(int columnIndex, double x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateDouble-int-double-
    this.resultSet.updateDouble(columnIndex, x);
  }

  @Override
  public void updateDouble(String columnName, double x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateDouble-java.lang.String-double-
    this.resultSet.updateDouble(columnName, x);
  }

  @Override
  public void updateFloat(int columnIndex, float x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateFloat-int-float-
    this.resultSet.updateFloat(columnIndex, x);
  }

  @Override
  public void updateFloat(String columnName, float x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateFloat-java.lang.String-float-
    this.resultSet.updateFloat(columnName, x);
  }

  @Override
  public void updateLong(int columnIndex, long x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateLong-int-long-
    this.resultSet.updateLong(columnIndex, x);
  }

  @Override
  public void updateLong(String columnName, long x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateLong-java.lang.String-long-
    this.resultSet.updateLong(columnName, x);
  }

  @Override
  public void updateInt(int columnIndex, int x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateInt-int-int-
    this.resultSet.updateInt(columnIndex, x);
  }

  @Override
  public void updateInt(String columnName, int x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateInt-java.lang.String-int-
    this.resultSet.updateInt(columnName, x);
  }

  @Override
  public void updateShort(int columnIndex, short x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateShort-int-short-
    this.resultSet.updateShort(columnIndex, x);
  }

  @Override
  public void updateShort(String columnName, short x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateShort-java.lang.String-short-
    this.resultSet.updateShort(columnName, x);
  }

  @Override
  public void updateByte(int columnIndex, byte x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateByte-int-byte-
    this.resultSet.updateByte(columnIndex, x);
  }

  @Override
  public void updateByte(String columnName, byte x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateByte-java.lang.String-byte-
    this.resultSet.updateByte(columnName, x);
  }

  @Override
  public void updateBoolean(int columnIndex, boolean x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBoolean-int-boolean-
    this.resultSet.updateBoolean(columnIndex, x);
  }

  @Override
  public void updateBoolean(String columnName, boolean x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBoolean-java.lang.String-boolean-
    this.resultSet.updateBoolean(columnName, x);
  }

  @Override
  public void updateNull(int columnIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNull-int-
    this.resultSet.updateNull(columnIndex);
  }

  @Override
  public void updateNull(String columnName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNull-java.lang.String-
    this.resultSet.updateNull(columnName);
  }

  @Override
  public boolean rowDeleted() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#rowDeleted--
    return this.resultSet.rowDeleted();
  }

  @Override
  public boolean rowInserted() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#rowInserted--
    return this.resultSet.rowInserted();
  }

  @Override
  public boolean rowUpdated() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#rowUpdated--
    return this.resultSet.rowUpdated();
  }

  @Override
  public int getConcurrency() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getConcurrency--
    return this.resultSet.getConcurrency();
  }

  @Override
  public int getType() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getType--
    return this.resultSet.getType();
  }

  @Override
  public int getFetchDirection() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getFetchDirection--
    return this.resultSet.getFetchDirection();
  }

  @Override
  public int getFetchSize() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getFetchSize--
    return this.resultSet.getFetchSize();
  }

  @Override
  public java.sql.ResultSetMetaData getMetaData() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getMetaData--
    return this.resultSet.getMetaData();
  }

  @Override
  public java.sql.SQLWarning getWarnings() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getWarnings--
    return this.resultSet.getWarnings();
  }

  @Override
  public java.sql.Array getArray(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getArray-int-
    return this.resultSet.getArray(parameterIndex);
  }

  @Override
  public java.sql.Array getArray(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getArray-java.lang.String-
    return this.resultSet.getArray(parameterName);
  }

  @Override
  public java.math.BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBigDecimal-int-
    return this.resultSet.getBigDecimal(columnIndex);
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.math.BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBigDecimal-int-int-
    return this.resultSet.getBigDecimal(columnIndex, scale);
  }

  @Override
  public java.math.BigDecimal getBigDecimal(String columnLabel) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBigDecimal-java.lang.String-
    return this.resultSet.getBigDecimal(columnLabel);
  }

  @SuppressWarnings("deprecation")
  @Override
  public java.math.BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBigDecimal-java.lang.String-int-
    return this.resultSet.getBigDecimal(columnLabel, scale);
  }

  @Override
  public java.sql.Blob getBlob(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBlob-int-
    return this.resultSet.getBlob(parameterIndex);
  }

  @Override
  public java.sql.Blob getBlob(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBlob-java.lang.String-
    return this.resultSet.getBlob(parameterName);
  }

  @Override
  public void updateBlob(int parameterIndex, java.sql.Blob x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBlob-int-java.sql.Blob-
    this.resultSet.updateBlob(parameterIndex, x);
  }

  @Override
  public void updateBlob(int parameterIndex, java.io.InputStream inputStream) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBlob-int-java.io.InputStream-
    this.resultSet.updateBlob(parameterIndex, inputStream);
  }

  @Override
  public void updateBlob(int parameterIndex, java.io.InputStream inputStream, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBlob-int-java.io.InputStream-long-
    this.resultSet.updateBlob(parameterIndex, inputStream, length);
  }

  @Override
  public void updateBlob(String parameterName, java.sql.Blob x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBlob-java.lang.String-java.sql.Blob-
    this.resultSet.updateBlob(parameterName, x);
  }

  @Override
  public void updateBlob(String parameterName, java.io.InputStream inputStream)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBlob-java.lang.String-java.io.InputStream-
    this.resultSet.updateBlob(parameterName, inputStream);
  }

  @Override
  public void updateBlob(String parameterName, java.io.InputStream inputStream, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBlob-java.lang.String-java.io.InputStream-long-
    this.resultSet.updateBlob(parameterName, inputStream, length);
  }

  @Override
  public boolean getBoolean(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBoolean-int-
    return this.resultSet.getBoolean(parameterIndex);
  }

  @Override
  public boolean getBoolean(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBoolean-java.lang.String-
    return this.resultSet.getBoolean(parameterName);
  }

  @Override
  public java.sql.Clob getClob(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getClob-int-
    return this.resultSet.getClob(parameterIndex);
  }

  @Override
  public java.sql.Clob getClob(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getClob-java.lang.String-
    return this.resultSet.getClob(parameterName);
  }

  @Override
  public void updateClob(int columnIndex, java.sql.Clob clob) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateClob-int-java.sql.Clob-
    this.resultSet.updateClob(columnIndex, clob);
  }

  @Override
  public void updateClob(int columnIndex, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateClob-int-java.io.Reader-
    this.resultSet.updateClob(columnIndex, reader);
  }

  @Override
  public void updateClob(int columnIndex, java.io.Reader reader, long length) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateClob-int-java.io.Reader-long-
    this.resultSet.updateClob(columnIndex, reader, length);
  }

  @Override
  public void updateClob(String columnLabel, java.sql.Clob clob) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateClob-java.lang.String-java.sql.Clob-
    this.resultSet.updateClob(columnLabel, clob);
  }

  @Override
  public void updateClob(String columnLabel, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateClob-java.lang.String-java.io.Reader-
    this.resultSet.updateClob(columnLabel, reader);
  }

  @Override
  public void updateClob(String columnLabel, java.io.Reader reader, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateClob-java.lang.String-java.io.Reader-long-
    this.resultSet.updateClob(columnLabel, reader, length);
  }

  @Override
  public java.sql.Date getDate(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getDate-int-
    return this.resultSet.getDate(parameterIndex);
  }

  @Override
  public java.sql.Date getDate(int parameterIndex, java.util.Calendar cal) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getDate-int-java.util.Calendar-
    return this.resultSet.getDate(parameterIndex, cal);
  }

  @Override
  public java.sql.Date getDate(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getDate-java.lang.String-
    return this.resultSet.getDate(parameterName);
  }

  @Override
  public java.sql.Date getDate(String parameterName, java.util.Calendar cal) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getDate-java.lang.String-java.util.Calendar-
    return this.resultSet.getDate(parameterName, cal);
  }

  @Override
  public double getDouble(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getDouble-int-
    return this.resultSet.getDouble(parameterIndex);
  }

  @Override
  public double getDouble(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getDouble-java.lang.String-
    return this.resultSet.getDouble(parameterName);
  }

  @Override
  public float getFloat(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getFloat-int-
    return this.resultSet.getFloat(parameterIndex);
  }

  @Override
  public float getFloat(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getFloat-java.lang.String-
    return this.resultSet.getFloat(parameterName);
  }

  @Override
  public int getInt(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getInt-int-
    return this.resultSet.getInt(parameterIndex);
  }

  @Override
  public int getInt(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getInt-java.lang.String-
    return this.resultSet.getInt(parameterName);
  }

  @Override
  public long getLong(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getLong-java.lang.String-
    return this.resultSet.getLong(parameterIndex);
  }

  @Override
  public long getLong(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getLong-java.lang.String-
    return this.resultSet.getLong(parameterName);
  }

  @Override
  public java.sql.Ref getRef(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getRef-int-
    return this.resultSet.getRef(parameterIndex);
  }

  @Override
  public java.sql.Ref getRef(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getRef-java.lang.String-
    return this.resultSet.getRef(parameterName);
  }

  @Override
  public java.sql.RowId getRowId(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getRowId-int-
    return this.resultSet.getRowId(parameterIndex);
  }

  @Override
  public java.sql.RowId getRowId(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getRowId-java.lang.String-
    return this.resultSet.getRowId(parameterName);
  }

  @Override
  public short getShort(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getShort-int-
    return this.resultSet.getShort(parameterIndex);
  }

  @Override
  public short getShort(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getShort-java.lang.String-
    return this.resultSet.getShort(parameterName);
  }

  @Override
  public String getString(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getString-int-
    return this.resultSet.getString(parameterIndex);
  }

  @Override
  public String getString(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getString-java.lang.String-
    return this.resultSet.getString(parameterName);
  }

  @Override
  public java.sql.Time getTime(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getTime-int-
    return this.resultSet.getTime(parameterIndex);
  }

  @Override
  public java.sql.Time getTime(int parameterIndex, java.util.Calendar cal) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getTime-int-java.util.Calendar-
    return this.resultSet.getTime(parameterIndex, cal);
  }

  @Override
  public java.sql.Time getTime(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getTime-java.lang.String-
    return this.resultSet.getTime(parameterName);
  }

  @Override
  public java.sql.Time getTime(String parameterName, java.util.Calendar cal) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getTime-java.lang.String-java.util.Calendar-
    return this.resultSet.getTime(parameterName, cal);
  }

  @Override
  public java.net.URL getURL(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getURL-int-
    return this.resultSet.getURL(parameterIndex);
  }

  @Override
  public java.net.URL getURL(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getURL-java.lang.String-
    return this.resultSet.getURL(parameterName);
  }

  @Override
  public boolean isClosed() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#isClosed--
    return this.resultSet.isClosed();
  }

  @Override
  public boolean isLast() throws SQLException {
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#isLast--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isLast");

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
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#isAfterLast--
    return this.resultSet.isAfterLast();
  }

  @Override
  public boolean isFirst() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#isFirst--
    return this.resultSet.isFirst();
  }

  @Override
  public String getCursorName() throws SQLException {
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getCursorName--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getCursorName");

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
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBytes-int-
    return this.resultSet.getBytes(columnIndex);
  }

  @Override
  public byte getByte(int columnIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getByte-int-
    return this.resultSet.getByte(columnIndex);
  }

  @Override
  public byte getByte(String columnLabel) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getByte-java.lang.String-
    return this.resultSet.getByte(columnLabel);
  }

  @Override
  public byte[] getBytes(String columnLabel) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBytes-java.lang.String-
    return this.resultSet.getBytes(columnLabel);
  }

  @Override
  public java.io.InputStream getBinaryStream(int columnIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBinaryStream-int-
    return this.resultSet.getBinaryStream(columnIndex);
  }

  @Override
  public java.io.InputStream getBinaryStream(String columnLabel) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getBinaryStream-java.lang.String-
    return this.resultSet.getBinaryStream(columnLabel);
  }

  @Override
  public java.io.InputStream getAsciiStream(int columnIndex) throws SQLException {
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getAsciiStream-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getAsciiStream");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getAsciiStream-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getAsciiStream");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getUnicodeStream-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getUnicodeStream");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getUnicodeStream-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getUnicodeStream");

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
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#isBeforeFirst--
    return this.resultSet.isBeforeFirst();
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#setFetchDirection-int-
    this.resultSet.setFetchDirection(direction);
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#setFetchSize-int-
    this.resultSet.setFetchSize(rows);
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
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getObject-int-
    return this.resultSet.getObject(parameterIndex);
  }

  @Override
  public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getObject-int-java.lang.Class-
    return this.resultSet.getObject(parameterIndex, type);
  }

  @Override
  public Object getObject(int parameterIndex, java.util.Map<String, Class<?>> map)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getObject-int-java.util.Map-
    return this.resultSet.getObject(parameterIndex, map);
  }

  @Override
  public Object getObject(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getObject-java.lang.String-
    return this.resultSet.getObject(parameterName);
  }

  @Override
  public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getObject-java.lang.String-java.lang.Class-
    return this.resultSet.getObject(parameterName, type);
  }

  @Override
  public Object getObject(String parameterName, java.util.Map<String, Class<?>> map)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getObject-java.lang.String-java.util.Map-
    return this.resultSet.getObject(parameterName, map);
  }

  @Override
  public java.sql.SQLXML getSQLXML(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getSQLXML-int-
    return this.resultSet.getSQLXML(parameterIndex);
  }

  @Override
  public java.sql.SQLXML getSQLXML(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getSQLXML-java.lang.String-
    return this.resultSet.getSQLXML(parameterName);
  }

  @Override
  public String getNString(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getNString-int-
    return this.resultSet.getNString(parameterIndex);
  }

  @Override
  public String getNString(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getNString-java.lang.String-
    return this.resultSet.getNString(parameterName);
  }

  @Override
  public java.io.Reader getNCharacterStream(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getNCharacterStream-int-
    return this.resultSet.getNCharacterStream(parameterIndex);
  }

  @Override
  public java.io.Reader getNCharacterStream(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getNCharacterStream-java.lang.String-
    return this.resultSet.getNCharacterStream(parameterName);
  }

  @Override
  public java.io.Reader getCharacterStream(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getCharacterStream-int-
    return this.resultSet.getCharacterStream(parameterIndex);
  }

  @Override
  public java.io.Reader getCharacterStream(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getCharacterStream-java.lang.String-
    return this.resultSet.getCharacterStream(parameterName);
  }

  @Override
  public void updateCharacterStream(int parameterIndex, java.io.Reader x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateCharacterStream-int-java.io.Reader-
    this.resultSet.updateCharacterStream(parameterIndex, x);
  }

  @Override
  public void updateCharacterStream(int parameterIndex, java.io.Reader x, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateCharacterStream-int-java.io.Reader-int-
    this.resultSet.updateCharacterStream(parameterIndex, x, length);
  }

  @Override
  public void updateCharacterStream(int parameterIndex, java.io.Reader x, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateCharacterStream-int-java.io.Reader-long-
    this.resultSet.updateCharacterStream(parameterIndex, x, length);
  }

  @Override
  public void updateCharacterStream(String parameterName, java.io.Reader x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateCharacterStream-java.lang.String-java.io.Reader-
    this.resultSet.updateCharacterStream(parameterName, x);
  }

  @Override
  public void updateCharacterStream(String parameterName, java.io.Reader x, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateCharacterStream-java.lang.String-java.io.Reader-int-
    this.resultSet.updateCharacterStream(parameterName, x, length);
  }

  @Override
  public void updateCharacterStream(String parameterName, java.io.Reader x, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateCharacterStream-java.lang.String-java.io.Reader-long-
    this.resultSet.updateCharacterStream(parameterName, x, length);
  }

  @Override
  public void updateBinaryStream(int columnIndex, java.io.InputStream x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBinaryStream-int-java.io.InputStream-
    this.resultSet.updateBinaryStream(columnIndex, x);
  }

  @Override
  public void updateBinaryStream(int columnIndex, java.io.InputStream x, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBinaryStream-int-java.io.InputStream-int-
    this.resultSet.updateBinaryStream(columnIndex, x, length);
  }

  @Override
  public void updateBinaryStream(int columnIndex, java.io.InputStream x, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBinaryStream-int-java.io.InputStream-long-
    this.resultSet.updateBinaryStream(columnIndex, x, length);
  }

  @Override
  public void updateBinaryStream(String columnLabel, java.io.InputStream x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBinaryStream-java.lang.String-java.io.InputStream-
    this.resultSet.updateBinaryStream(columnLabel, x);
  }

  @Override
  public void updateBinaryStream(String columnLabel, java.io.InputStream x, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBinaryStream-java.lang.String-java.io.InputStream-int-
    this.resultSet.updateBinaryStream(columnLabel, x, length);
  }

  @Override
  public void updateBinaryStream(String columnLabel, java.io.InputStream x, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateBinaryStream-java.lang.String-java.io.InputStream-long-
    this.resultSet.updateBinaryStream(columnLabel, x, length);
  }

  @Override
  public void updateAsciiStream(int columnIndex, java.io.InputStream x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateAsciiStream-int-java.io.InputStream-
    this.resultSet.updateAsciiStream(columnIndex, x);
  }

  @Override
  public void updateAsciiStream(int columnIndex, java.io.InputStream x, int length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateAsciiStream-int-java.io.InputStream-int-
    this.resultSet.updateAsciiStream(columnIndex, x, length);
  }

  @Override
  public void updateAsciiStream(int columnIndex, java.io.InputStream x, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateAsciiStream-int-java.io.InputStream-long-
    this.resultSet.updateAsciiStream(columnIndex, x, length);
  }

  @Override
  public void updateAsciiStream(String columnLabel, java.io.InputStream x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateAsciiStream-java.lang.String-java.io.InputStream-
    this.resultSet.updateAsciiStream(columnLabel, x);
  }

  @Override
  public void updateAsciiStream(String columnLabel, java.io.InputStream x, int length)
      throws SQLException {
    // This method doesn't go over the weekend:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateAsciiStream-java.lang.String-java.io.InputStream-int-
    this.resultSet.updateAsciiStream(columnLabel, x, length);
  }

  @Override
  public void updateAsciiStream(String columnLabel, java.io.InputStream x, long length)
      throws SQLException {
    // This method doesn't go over the weekend:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateAsciiStream-java.lang.String-java.io.InputStream-long-
    this.resultSet.updateAsciiStream(columnLabel, x, length);
  }

  @Override
  public void updateNCharacterStream(int columnIndex, java.io.Reader x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNCharacterStream-int-java.io.Reader-
    this.resultSet.updateNCharacterStream(columnIndex, x);
  }

  @Override
  public void updateNCharacterStream(int columnIndex, java.io.Reader x, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNCharacterStream-int-java.io.Reader-long-
    this.resultSet.updateNCharacterStream(columnIndex, x, length);
  }

  @Override
  public void updateNCharacterStream(String columnLabel, java.io.Reader x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNCharacterStream-java.lang.String-java.io.Reader-
    this.resultSet.updateNCharacterStream(columnLabel, x);
  }

  @Override
  public void updateNCharacterStream(String columnLabel, java.io.Reader x, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNCharacterStream-java.lang.String-java.io.Reader-long-
    this.resultSet.updateNCharacterStream(columnLabel, x, length);
  }

  @Override
  public java.sql.NClob getNClob(int parameterIndex) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getNClob-int-
    return this.resultSet.getNClob(parameterIndex);
  }

  @Override
  public void updateSQLXML(int columnIndex, java.sql.SQLXML xmlObject) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateSQLXML-int-java.sql.SQLXML-
    this.resultSet.updateSQLXML(columnIndex, xmlObject);
  }

  @Override
  public void updateSQLXML(String columnName, java.sql.SQLXML xmlObject) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateSQLXML-java.lang.String-java.sql.SQLXML-
    this.resultSet.updateSQLXML(columnName, xmlObject);
  }

  @Override
  public void updateNString(String columnLabel, String nString) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNString-int-java.lang.String-
    this.resultSet.updateNString(columnLabel, nString);
  }

  @Override
  public void updateNString(int columnIndex, String nString) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNString-java.lang.String-java.lang.String-
    this.resultSet.updateNString(columnIndex, nString);
  }

  @Override
  public int getHoldability() throws SQLException {
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getHoldability--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getHoldability");

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
    // This method goes to the database directly:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateRow--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRow");

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
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateRowId-int-java.sql.RowId-
    this.resultSet.updateRowId(columnIndex, x);
  }

  @Override
  public void updateRowId(String columnLabel, java.sql.RowId x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateRowId-java.lang.String-java.sql.RowId-
    this.resultSet.updateRowId(columnLabel, x);
  }

  @Override
  public void updateArray(int columnIndex, java.sql.Array x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateArray-int-java.sql.Array-
    this.resultSet.updateArray(columnIndex, x);
  }

  @Override
  public void updateArray(String columnLabel, java.sql.Array x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateArray-java.lang.String-java.sql.Array-
    this.resultSet.updateArray(columnLabel, x);
  }

  @Override
  public void updateRef(int columnIndex, java.sql.Ref x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateRef-int-java.sql.Ref-
    this.resultSet.updateRef(columnIndex, x);
  }

  @Override
  public void updateRef(String columnLabel, java.sql.Ref x) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateRef-java.lang.String-java.sql.Ref-
    this.resultSet.updateRef(columnLabel, x);
  }

  @Override
  public java.sql.Timestamp getTimestamp(int parameterIndex) throws SQLException {
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getTimestamp-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTimestamp");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getTimestamp-int-java.util.Calendar-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTimestamp");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getTimestamp-java.lang.String-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTimestamp");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getTimestamp-java.lang.String-java.util.Calendar-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTimestamp");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#moveToCurrentRow--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.moveToCurrentRow");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#moveToInsertRow--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.moveToInsertRow");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#last--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.last");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#afterLast--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.afterLast");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#beforeFirst--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.beforeFirst");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#next--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.next");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#previous--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.previous");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#absolute-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.absolute");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getRow--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRow");

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
    // This method may touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#relative-int-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.relative");

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
    // This method goes to the database directly:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#cancelRowUpdates--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.cancelRowUpdates");

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
    // This method goes to the database directly:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#refreshRow--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.ResultSet.refreshRow");

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
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getStatement--
    return this.resultSet.getStatement();
  }

  @Override
  public java.sql.NClob getNClob(String parameterName) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#getNClob-java.lang.String-
    return this.resultSet.getNClob(parameterName);
  }

  @Override
  public void updateNClob(int columnIndex, java.sql.NClob nclob) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNClob-int-java.sql.NClob-
    this.resultSet.updateNClob(columnIndex, nclob);
  }

  @Override
  public void updateNClob(int columnIndex, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNClob-int-java.io.Reader-
    this.resultSet.updateNClob(columnIndex, reader);
  }

  @Override
  public void updateNClob(int columnIndex, java.io.Reader reader, long length) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNClob-int-java.io.Reader-long-
    this.resultSet.updateNClob(columnIndex, reader, length);
  }

  @Override
  public void updateNClob(String columnLabel, java.sql.NClob nclob) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNClob-java.lang.String-java.sql.NClob-
    this.resultSet.updateNClob(columnLabel, nclob);
  }

  @Override
  public void updateNClob(String columnLabel, java.io.Reader reader) throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNClob-java.lang.String-java.io.Reader-
    this.resultSet.updateNClob(columnLabel, reader);
  }

  @Override
  public void updateNClob(String columnLabel, java.io.Reader reader, long length)
      throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#updateNClob-java.lang.String-java.io.Reader-long-
    this.resultSet.updateNClob(columnLabel, reader, length);
  }

  @Override
  public boolean wasNull() throws SQLException {
    // This method doesn't touch the database:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html#wasNull--
    return this.resultSet.wasNull();
  }
}
