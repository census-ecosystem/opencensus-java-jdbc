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

package io.opencensus.ocjdbc;

import java.sql.SQLException;

import io.opencensus.ocjdbc.Observability;

public class ResultSet implements java.sql.ResultSet {
    private java.sql.ResultSet rs;

    public ResultSet(java.sql.ResultSet rs) throws SQLException {
        this.rs = rs;
    }

    @Override
    public void clearWarnings() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.clearWarnings", "clearWarnings");

        try {
            this.rs.clearWarnings();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void close() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.close", "close");

        try {
            this.rs.close();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void deleteRow() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.deleteRow", "deleteRow");

        try {
            this.rs.deleteRow();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int findColumn(String columnLabel) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.findColumn", "findColumn");

        try {
            return this.rs.findColumn(columnLabel);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean first() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.first", "first");

        try {
            return this.rs.first();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void insertRow() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.insertRow", "insertRow");

        try {
            this.rs.insertRow();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateObject(int columnIndex, Object x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateObject", "updateObject");

        try {
            this.rs.updateObject(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateObject", "updateObject");

        try {
            this.rs.updateObject(columnIndex, x, scaleOrLength);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateObject(String columnLabel, Object x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateObject", "updateObject");

        try {
            this.rs.updateObject(columnLabel, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateObject", "updateObject");

        try {
            this.rs.updateObject(columnLabel, x, scaleOrLength);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateTimestamp(int columnIndex, java.sql.Timestamp x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateTimestamp", "updateTimestamp");

        try {
            this.rs.updateTimestamp(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateTimestamp(String columnName, java.sql.Timestamp x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateTimestamp", "updateTimestamp");

        try {
            this.rs.updateTimestamp(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateTime(int columnIndex, java.sql.Time x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateTime", "updateTime");

        try {
            this.rs.updateTime(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateTime(String columnName, java.sql.Time x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateTime", "updateTime");

        try {
            this.rs.updateTime(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateDate(int columnIndex, java.sql.Date x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateDate", "updateDate");

        try {
            this.rs.updateDate(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateDate(String columnName, java.sql.Date x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateDate", "updateDate");

        try {
            this.rs.updateDate(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBytes", "updateBytes");

        try {
            this.rs.updateBytes(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBytes(String columnName, byte[] x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBytes", "updateBytes");

        try {
            this.rs.updateBytes(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateString(int columnIndex, String x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateString", "updateString");

        try {
            this.rs.updateString(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateString(String columnName, String x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateString", "updateString");

        try {
            this.rs.updateString(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBigDecimal(int columnIndex, java.math.BigDecimal x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBigDecimal", "updateBigDecimal");

        try {
            this.rs.updateBigDecimal(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBigDecimal(String columnName, java.math.BigDecimal x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBigDecimal", "updateBigDecimal");

        try {
            this.rs.updateBigDecimal(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateDouble(int columnIndex, double x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateDouble", "updateDouble");

        try {
            this.rs.updateDouble(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateDouble(String columnName, double x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateDouble", "updateDouble");

        try {
            this.rs.updateDouble(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateFloat(int columnIndex, float x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateFloat", "updateFloat");

        try {
            this.rs.updateFloat(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateFloat(String columnName, float x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateFloat", "updateFloat");

        try {
            this.rs.updateFloat(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateLong(int columnIndex, long x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateLong", "updateLong");

        try {
            this.rs.updateLong(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateLong(String columnName, long x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateLong", "updateLong");

        try {
            this.rs.updateLong(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateInt(int columnIndex, int x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateInt", "updateInt");

        try {
            this.rs.updateInt(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateInt(String columnName, int x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateInt", "updateInt");

        try {
            this.rs.updateInt(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateShort(int columnIndex, short x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateShort", "updateShort");

        try {
            this.rs.updateShort(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateShort(String columnName, short x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateShort", "updateShort");

        try {
            this.rs.updateShort(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateByte(int columnIndex, byte x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateByte", "updateByte");

        try {
            this.rs.updateByte(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateByte(String columnName, byte x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateByte", "updateByte");

        try {
            this.rs.updateByte(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBoolean", "updateBoolean");

        try {
            this.rs.updateBoolean(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBoolean(String columnName, boolean x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBoolean", "updateBoolean");

        try {
            this.rs.updateBoolean(columnName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNull(int columnIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNull", "updateNull");

        try {
            this.rs.updateNull(columnIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNull(String columnName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNull", "updateNull");

        try {
            this.rs.updateNull(columnName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean rowDeleted() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.rowDeleted", "rowDeleted");

        try {
            return this.rs.rowDeleted();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean rowInserted() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.rowInserted", "rowInserted");

        try {
            return this.rs.rowInserted();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean rowUpdated() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.rowUpdated", "rowUpdated");

        try {
            return this.rs.rowUpdated();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getConcurrency() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getConcurrency", "getConcurrency");

        try {
            return this.rs.getConcurrency();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getType() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getType", "getType");

        try {
            return this.rs.getType();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getFetchDirection() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getFetchDirection", "getFetchDirection");

        try {
            return this.rs.getFetchDirection();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getFetchSize() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getFetchSize", "getFetchSize");

        try {
            return this.rs.getFetchSize();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.ResultSetMetaData getMetaData() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getMetaData", "getMetaData");

        try {
            return this.rs.getMetaData();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.SQLWarning getWarnings() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getWarnings", "getWarnings");

        try {
            return this.rs.getWarnings();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Array getArray(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getArray", "getArray");

        try {
            return this.rs.getArray(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Array getArray(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getArray", "getArray");

        try {
            return this.rs.getArray(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.math.BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBigDecimal", "getBigDecimal");

        try {
            return this.rs.getBigDecimal(columnIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.math.BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBigDecimal", "getBigDecimal");

        try {
            return this.rs.getBigDecimal(columnIndex, scale);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.math.BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBigDecimal", "getBigDecimal");

        try {
            return this.rs.getBigDecimal(columnLabel);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.math.BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBigDecimal", "getBigDecimal");

        try {
            return this.rs.getBigDecimal(columnLabel, scale);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Blob getBlob(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBlob", "getBlob");

        try {
            return this.rs.getBlob(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Blob getBlob(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBlob", "getBlob");

        try {
            return this.rs.getBlob(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBlob(int parameterIndex, java.sql.Blob x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

        try {
            this.rs.updateBlob(parameterIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBlob(int parameterIndex, java.io.InputStream inputStream) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

        try {
            this.rs.updateBlob(parameterIndex, inputStream);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBlob(int parameterIndex, java.io.InputStream inputStream, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

        try {
            this.rs.updateBlob(parameterIndex, inputStream, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBlob(String parameterName, java.sql.Blob x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

        try {
            this.rs.updateBlob(parameterName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBlob(String parameterName, java.io.InputStream inputStream) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

        try {
            this.rs.updateBlob(parameterName, inputStream);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBlob(String parameterName, java.io.InputStream inputStream, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBlob", "updateBlob");

        try {
            this.rs.updateBlob(parameterName, inputStream, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean getBoolean(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBoolean", "getBoolean");

        try {
            return this.rs.getBoolean(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean getBoolean(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBoolean", "getBoolean");

        try {
            return this.rs.getBoolean(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Clob getClob(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getClob", "getClob");

        try {
            return this.rs.getClob(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Clob getClob(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getClob", "getClob");

        try {
            return this.rs.getClob(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateClob(int columnIndex, java.sql.Clob clob) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

        try {
            this.rs.updateClob(columnIndex, clob);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateClob(int columnIndex, java.io.Reader reader) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

        try {
            this.rs.updateClob(columnIndex, reader);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateClob(int columnIndex, java.io.Reader reader, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

        try {
            this.rs.updateClob(columnIndex, reader, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateClob(String columnLabel, java.sql.Clob clob) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

        try {
            this.rs.updateClob(columnLabel, clob);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateClob(String columnLabel, java.io.Reader reader) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

        try {
            this.rs.updateClob(columnLabel, reader);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateClob(String columnLabel, java.io.Reader reader, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateClob", "updateClob");

        try {
            this.rs.updateClob(columnLabel, reader, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Date getDate(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

        try {
            return this.rs.getDate(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Date getDate(int parameterIndex, java.util.Calendar cal) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

        try {
            return this.rs.getDate(parameterIndex, cal);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Date getDate(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

        try {
            return this.rs.getDate(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Date getDate(String parameterName, java.util.Calendar cal) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDate", "getDate");

        try {
            return this.rs.getDate(parameterName, cal);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public double getDouble(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDouble", "getDouble");

        try {
            return this.rs.getDouble(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public double getDouble(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getDouble", "getDouble");

        try {
            return this.rs.getDouble(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public float getFloat(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getFloat", "getFloat");

        try {
            return this.rs.getFloat(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public float getFloat(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getFloat", "getFloat");

        try {
            return this.rs.getFloat(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getInt(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getInt", "getInt");

        try {
            return this.rs.getInt(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getInt(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getInt", "getInt");

        try {
            return this.rs.getInt(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public long getLong(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getLong", "getLong");

        try {
            return this.rs.getLong(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public long getLong(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getLong", "getLong");

        try {
            return this.rs.getLong(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Ref getRef(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRef", "getRef");

        try {
            return this.rs.getRef(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Ref getRef(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRef", "getRef");

        try {
            return this.rs.getRef(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.RowId getRowId(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRowId", "getRowId");

        try {
            return this.rs.getRowId(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.RowId getRowId(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRowId", "getRowId");

        try {
            return this.rs.getRowId(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public short getShort(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getShort", "getShort");

        try {
            return this.rs.getShort(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public short getShort(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getShort", "getShort");

        try {
            return this.rs.getShort(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public String getString(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getString", "getString");

        try {
            return this.rs.getString(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public String getString(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getString", "getString");

        try {
            return this.rs.getString(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Time getTime(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

        try {
            return this.rs.getTime(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Time getTime(int parameterIndex, java.util.Calendar cal) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

        try {
            return this.rs.getTime(parameterIndex, cal);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Time getTime(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

        try {
            return this.rs.getTime(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Time getTime(String parameterName, java.util.Calendar cal) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTime", "getTime");

        try {
            return this.rs.getTime(parameterName, cal);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.net.URL getURL(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getURL", "getURL");

        try {
            return this.rs.getURL(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.net.URL getURL(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getURL", "getURL");

        try {
            return this.rs.getURL(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isClosed() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isClosed", "isClosed");

        try {
            return this.rs.isClosed();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isLast() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isLast", "isLast");

        try {
            return this.rs.isLast();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isAfterLast() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isAfterLast", "isAfterLast");

        try {
            return this.rs.isAfterLast();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isFirst() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isFirst", "isFirst");

        try {
            return this.rs.isFirst();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public String getCursorName() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getCursorName", "getCursorName");

        try {
            return this.rs.getCursorName();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public byte[] getBytes(int columnIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBytes", "getBytes");

        try {
            return this.rs.getBytes(columnIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public byte getByte(int columnIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getByte", "getByte");

        try {
            return this.rs.getByte(columnIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public byte getByte(String columnLabel) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getByte", "getByte");

        try {
            return this.rs.getByte(columnLabel);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public byte[] getBytes(String columnLabel) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBytes", "getBytes");

        try {
            return this.rs.getBytes(columnLabel);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.InputStream getBinaryStream(int columnIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBinaryStream", "getBinaryStream");

        try {
            return this.rs.getBinaryStream(columnIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.InputStream getBinaryStream(String columnLabel) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getBinaryStream", "getBinaryStream");

        try {
            return this.rs.getBinaryStream(columnLabel);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.InputStream getAsciiStream(int columnIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getAsciiStream", "getAsciiStream");

        try {
            return this.rs.getAsciiStream(columnIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.InputStream getAsciiStream(String columnLabel) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getAsciiStream", "getAsciiStream");

        try {
            return this.rs.getAsciiStream(columnLabel);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.InputStream getUnicodeStream(int columnIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getUnicodeStream", "getUnicodeBinaryStream");

        try {
            return this.rs.getUnicodeStream(columnIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.InputStream getUnicodeStream(String columnLabel) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getUnicodeStream", "getUnicodeBinaryStream");

        try {
            return this.rs.getUnicodeStream(columnLabel);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isBeforeFirst() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.isBeforeFirst", "isBeforeFirst");

        try {
            return this.rs.isBeforeFirst();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.setFetchDirection", "setFetchDirection");

        try {
            this.rs.setFetchDirection(direction);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.setFetchSize", "setFetchSize");

        try {
            this.rs.setFetchSize(rows);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return this.rs.isWrapperFor(iface);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return this.rs.unwrap(iface);
    }

    @Override
    public Object getObject(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

        try {
            return this.rs.getObject(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

        try {
            return this.rs.getObject(parameterIndex, type);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public Object getObject(int parameterIndex, java.util.Map<String, Class<?>> map) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

        try {
            return this.rs.getObject(parameterIndex, map);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public Object getObject(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

        try {
            return this.rs.getObject(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

        try {
            return this.rs.getObject(parameterName, type);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public Object getObject(String parameterName, java.util.Map<String, Class<?>> map) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getObject", "getObject");

        try {
            return this.rs.getObject(parameterName, map);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.SQLXML getSQLXML(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getSQLXML", "getSQLXML");

        try {
            return this.rs.getSQLXML(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.SQLXML getSQLXML(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getSQLXML", "getSQLXML");

        try {
            return this.rs.getSQLXML(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public String getNString(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNString", "getNString");

        try {
            return this.rs.getNString(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public String getNString(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNString", "getNString");

        try {
            return this.rs.getNString(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.Reader getNCharacterStream(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNCharacterStream", "getNCharacterStream");

        try {
            return this.rs.getNCharacterStream(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.Reader getNCharacterStream(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNCharacterStream", "getNCharacterStream");

        try {
            return this.rs.getNCharacterStream(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.Reader getCharacterStream(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getCharacterStream", "getCharacterStream");

        try {
            return this.rs.getCharacterStream(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.io.Reader getCharacterStream(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getCharacterStream", "getCharacterStream");

        try {
            return this.rs.getCharacterStream(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateCharacterStream(int parameterIndex, java.io.Reader x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

        try {
            this.rs.updateCharacterStream(parameterIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateCharacterStream(int parameterIndex, java.io.Reader x, int length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

        try {
            this.rs.updateCharacterStream(parameterIndex, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateCharacterStream(int parameterIndex, java.io.Reader x, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

        try {
            this.rs.updateCharacterStream(parameterIndex, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateCharacterStream(String parameterName, java.io.Reader x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

        try {
            this.rs.updateCharacterStream(parameterName, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateCharacterStream(String parameterName, java.io.Reader x, int length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

        try {
            this.rs.updateCharacterStream(parameterName, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateCharacterStream(String parameterName, java.io.Reader x, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateCharacterStream", "updateCharacterStream");

        try {
            this.rs.updateCharacterStream(parameterName, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBinaryStream(int columnIndex, java.io.InputStream x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

        try {
            this.rs.updateBinaryStream(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBinaryStream(int columnIndex, java.io.InputStream x, int length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

        try {
            this.rs.updateBinaryStream(columnIndex, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBinaryStream(int columnIndex, java.io.InputStream x, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

        try {
            this.rs.updateBinaryStream(columnIndex, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBinaryStream(String columnLabel, java.io.InputStream x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

        try {
            this.rs.updateBinaryStream(columnLabel, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBinaryStream(String columnLabel, java.io.InputStream x, int length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

        try {
            this.rs.updateBinaryStream(columnLabel, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateBinaryStream(String columnLabel, java.io.InputStream x, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateBinaryStream", "updateBinaryStream");

        try {
            this.rs.updateBinaryStream(columnLabel, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }
      
    @Override
    public void updateAsciiStream(int columnIndex, java.io.InputStream x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

        try {
            this.rs.updateAsciiStream(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateAsciiStream(int columnIndex, java.io.InputStream x, int length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

        try {
            this.rs.updateAsciiStream(columnIndex, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateAsciiStream(int columnIndex, java.io.InputStream x, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

        try {
            this.rs.updateAsciiStream(columnIndex, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateAsciiStream(String columnLabel, java.io.InputStream x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

        try {
            this.rs.updateAsciiStream(columnLabel, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateAsciiStream(String columnLabel, java.io.InputStream x, int length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

        try {
            this.rs.updateAsciiStream(columnLabel, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateAsciiStream(String columnLabel, java.io.InputStream x, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateAsciiStream", "updateAsciiStream");

        try {
            this.rs.updateAsciiStream(columnLabel, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNCharacterStream(int columnIndex, java.io.Reader x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

        try {
            this.rs.updateNCharacterStream(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNCharacterStream(int columnIndex, java.io.Reader x, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

        try {
            this.rs.updateNCharacterStream(columnIndex, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNCharacterStream(String columnLabel, java.io.Reader x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

        try {
            this.rs.updateNCharacterStream(columnLabel, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNCharacterStream(String columnLabel, java.io.Reader x, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNCharacterStream", "updateNCharacterStream");

        try {
            this.rs.updateNCharacterStream(columnLabel, x, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.NClob getNClob(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNClob", "getNClob");

        try {
            return this.rs.getNClob(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateSQLXML(int columnIndex, java.sql.SQLXML xmlObject) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateSQLXML", "updateSQLXML");

        try {
            this.rs.updateSQLXML(columnIndex, xmlObject);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateSQLXML(String columnName, java.sql.SQLXML xmlObject) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateSQLXML", "updateSQLXML");

        try {
            this.rs.updateSQLXML(columnName, xmlObject);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNString(String columnLabel, String nString) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNString", "updateNString");

        try {
            this.rs.updateNString(columnLabel, nString);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNString(int columnIndex, String nString) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNString", "updateNString");

        try {
            this.rs.updateNString(columnIndex, nString);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getHoldability() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getHoldability", "getHoldability");

        try {
            return this.rs.getHoldability();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateRow() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRow", "updateRow");

        try {
            this.rs.updateRow();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateRowId(int columnIndex, java.sql.RowId x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRowId", "updateRowId");

        try {
            this.rs.updateRowId(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateRowId(String columnLabel, java.sql.RowId x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRowId", "updateRowId");

        try {
            this.rs.updateRowId(columnLabel, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateArray(int columnIndex, java.sql.Array x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateArray", "updateArray");

        try {
            this.rs.updateArray(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateArray(String columnLabel, java.sql.Array x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateArray", "updateArray");

        try {
            this.rs.updateArray(columnLabel, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateRef(int columnIndex, java.sql.Ref x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRef", "updateRef");

        try {
            this.rs.updateRef(columnIndex, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateRef(String columnLabel, java.sql.Ref x) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateRef", "updateRef");

        try {
            this.rs.updateRef(columnLabel, x);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Timestamp getTimestamp(int parameterIndex) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTimestamp", "getTimestamp");

        try {
            return this.rs.getTimestamp(parameterIndex);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Timestamp getTimestamp(int parameterIndex, java.util.Calendar cal) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTimestamp", "getTimestamp");

        try {
            return this.rs.getTimestamp(parameterIndex, cal);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Timestamp getTimestamp(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTimestamp", "getTimestamp");

        try {
            return this.rs.getTimestamp(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Timestamp getTimestamp(String parameterName, java.util.Calendar cal) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getTimestamp", "getTimestamp");

        try {
            return this.rs.getTimestamp(parameterName, cal);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void moveToCurrentRow() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.moveToCurrentRow", "moveToCurrentRow");

        try {
            this.rs.moveToCurrentRow();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void moveToInsertRow() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.moveToInsertRow", "moveToInsertRow");

        try {
            this.rs.moveToInsertRow();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean last() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.last", "last");

        try {
            return this.rs.last();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void afterLast() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.afterLast", "afterLast");

        try {
            this.rs.afterLast();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void beforeFirst() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.beforeFirst", "beforeFirst");

        try {
            this.rs.beforeFirst();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean next() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.next", "next");

        try {
            return this.rs.next();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }


    @Override
    public boolean previous() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.previous", "previous");

        try {
            return this.rs.previous();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean absolute(int rows) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.absolute", "absolute");

        try {
            return this.rs.absolute(rows);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getRow() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getRow", "getRow");

        try {
            return this.rs.getRow();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }


    @Override
    public boolean relative(int rows) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.relative", "relative");

        try {
            return this.rs.relative(rows);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void cancelRowUpdates() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.cancelRowUpdates", "cancelRowUpdates");

        try {
            this.rs.cancelRowUpdates();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void refreshRow() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.refreshRow", "refreshRow");

        try {
            this.rs.refreshRow();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Statement getStatement() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getStatement", "getStatement");

        try {
            return this.rs.getStatement();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }
    @Override
    public java.sql.NClob getNClob(String parameterName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.getNClob", "getNClob");

        try {
            return this.rs.getNClob(parameterName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNClob(int columnIndex, java.sql.NClob nclob) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

        try {
            this.rs.updateNClob(columnIndex, nclob);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNClob(int columnIndex, java.io.Reader reader) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

        try {
            this.rs.updateNClob(columnIndex, reader);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNClob(int columnIndex, java.io.Reader reader, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

        try {
            this.rs.updateNClob(columnIndex, reader, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }
    @Override
    public void updateNClob(String columnLabel, java.sql.NClob nclob) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

        try {
            this.rs.updateNClob(columnLabel, nclob);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNClob(String columnLabel, java.io.Reader reader) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

        try {
            this.rs.updateNClob(columnLabel, reader);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void updateNClob(String columnLabel, java.io.Reader reader, long length) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.updateNClob", "updateNClob");

        try {
            this.rs.updateNClob(columnLabel, reader, length);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }


    @Override
    public boolean wasNull() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.ResultSet.wasNull", "wasNull");

        try {
            return this.rs.wasNull();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }
}
