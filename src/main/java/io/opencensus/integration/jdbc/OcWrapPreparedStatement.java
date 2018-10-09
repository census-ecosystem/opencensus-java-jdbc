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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.EnumSet;

/**
 * Wraps and instruments a {@link PreparedStatement} instance with tracing and metrics using
 * OpenCensus.
 */
public class OcWrapPreparedStatement implements PreparedStatement {
  private final PreparedStatement preparedStatement;
  private final boolean shouldAnnotateSpansWithSQL;

  public OcWrapPreparedStatement(PreparedStatement pstmt, EnumSet<TraceOption> opts) {
    this.preparedStatement = pstmt;
    this.shouldAnnotateSpansWithSQL = Observability.shouldAnnotateSpansWithSQL(opts);
  }

  public OcWrapPreparedStatement(PreparedStatement pstmt, boolean shouldAnnotateSpansWithSQL) {
    this.preparedStatement = pstmt;
    this.shouldAnnotateSpansWithSQL = shouldAnnotateSpansWithSQL;
  }

  @Override
  public void addBatch() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.addBatch");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.addBatch();
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void addBatch(String SQL) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#addBatch--
    this.preparedStatement.addBatch(SQL);
  }

  @Override
  public void cancel() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.cancel");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.cancel();
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void clearBatch() throws SQLException {
    // This method may go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#clearBatch--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.createBatch");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.clearBatch();
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void clearWarnings() throws SQLException {
    // This method may go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#clearWarnings--
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.clearWarnings");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.clearWarnings();
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void clearParameters() throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#clearParameters--
    this.preparedStatement.clearParameters();
  }

  @Override
  public void close() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.close");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.close();
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void closeOnCompletion() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#closeOnCompletion--
    this.preparedStatement.closeOnCompletion();
  }

  @Override
  public boolean execute() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.execute");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute();
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute(SQL);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL, String[] columnNames) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute(SQL, columnNames);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL, int[] columnIndices) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute(SQL, columnIndices);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public boolean execute(String SQL, int autoGeneratedKeys) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.execute", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.execute(SQL, autoGeneratedKeys);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int[] executeBatch() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.executeBatch");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeBatch();
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSet executeQuery(String SQL) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeQuery", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.ResultSet rs = this.preparedStatement.executeQuery(SQL);
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate(SQL);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL, int autoGeneratedKeys) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate(SQL, autoGeneratedKeys);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL, int[] columnIndices) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate", this.shouldAnnotateSpansWithSQL, SQL);
    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate(SQL, columnIndices);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate(String SQL, String[] columnNames) throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan(
            "java.sql.PreparedStatement.executeUpdate", this.shouldAnnotateSpansWithSQL, SQL);

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate(SQL, columnNames);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public java.sql.ResultSet executeQuery() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.executeQuery");

    try (Scope ws = trackingOperation.withSpan()) {
      java.sql.ResultSet rs = this.preparedStatement.executeQuery();
      return new OcWrapResultSet(rs);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int executeUpdate() throws SQLException {
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.executeUpdate");

    try (Scope ws = trackingOperation.withSpan()) {
      return this.preparedStatement.executeUpdate();
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public int getFetchDirection() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getFetchDirection--
    return this.preparedStatement.getFetchDirection();
  }

  @Override
  public int getFetchSize() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getFetchSize--
    return this.preparedStatement.getFetchSize();
  }

  @Override
  public java.sql.ResultSet getGeneratedKeys() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getGeneratedKeys--
    java.sql.ResultSet rs = this.preparedStatement.getGeneratedKeys();
    return new OcWrapResultSet(rs);
  }

  @Override
  public int getMaxFieldSize() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getMaxFieldSize--
    return this.preparedStatement.getMaxFieldSize();
  }

  @Override
  public int getMaxRows() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getMaxRows--
    return this.preparedStatement.getMaxRows();
  }

  @Override
  public java.sql.ResultSetMetaData getMetaData() throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#getMetaData--
    return this.preparedStatement.getMetaData();
  }

  @Override
  public boolean getMoreResults(int current) throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getMoreResults--
    return this.preparedStatement.getMoreResults(current);
  }

  @Override
  public boolean getMoreResults() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getMoreResults-int-
    return this.preparedStatement.getMoreResults();
  }

  @Override
  public java.sql.ResultSet getResultSet() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getResultSet--
    java.sql.ResultSet rs = this.preparedStatement.getResultSet();
    return new OcWrapResultSet(rs);
  }

  @Override
  public int getResultSetConcurrency() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getResultSetConcurrency--
    return this.preparedStatement.getResultSetConcurrency();
  }

  @Override
  public int getQueryTimeout() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getQueryTimeout--
    return this.preparedStatement.getQueryTimeout();
  }

  @Override
  public java.sql.Connection getConnection() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getConnection--
    return this.preparedStatement.getConnection();
  }

  @Override
  public java.sql.ParameterMetaData getParameterMetaData() throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#getParameterMetaData--
    return this.preparedStatement.getParameterMetaData();
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    // This method doesn't get over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getResultSetHoldability--
    return this.preparedStatement.getResultSetHoldability();
  }

  @Override
  public int getResultSetType() throws SQLException {
    // This method doesn't get over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getResultSetType--
    return this.preparedStatement.getResultSetType();
  }

  @Override
  public int getUpdateCount() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getUpdateCount--
    return this.preparedStatement.getUpdateCount();
  }

  @Override
  public java.sql.SQLWarning getWarnings() throws SQLException {
    // This method doesn't go over the network:
    // Inherited from:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html#getWarnings--
    return this.preparedStatement.getWarnings();
  }

  @Override
  public void setArray(int parameterIndex, java.sql.Array x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setArray-int-java.sql.Array-
    this.preparedStatement.setArray(parameterIndex, x);
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setAsciiStream-int-java.io.InputStream-
    this.preparedStatement.setAsciiStream(parameterIndex, stream);
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream, int length)
      throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setAsciiStream-int-java.io.InputStream-int-
    this.preparedStatement.setAsciiStream(parameterIndex, stream, length);
  }

  @Override
  public void setAsciiStream(int parameterIndex, java.io.InputStream stream, long length)
      throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setAsciiStream-int-java.io.InputStream-long-
    this.preparedStatement.setAsciiStream(parameterIndex, stream, length);
  }

  @Override
  public void setBigDecimal(int parameterIndex, java.math.BigDecimal x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBigDecimal-int-java.math.BigDecimal-
    this.preparedStatement.setBigDecimal(parameterIndex, x);
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBinaryStream-int-java.io.InputStream-
    this.preparedStatement.setBinaryStream(parameterIndex, stream);
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream, int length)
      throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBinaryStream-int-java.io.InputStream-int-
    this.preparedStatement.setBinaryStream(parameterIndex, stream, length);
  }

  @Override
  public void setBinaryStream(int parameterIndex, java.io.InputStream stream, long length)
      throws SQLException {
    // This method doesn't go oer the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBinaryStream-int-java.io.InputStream-long-
    this.preparedStatement.setBinaryStream(parameterIndex, stream, length);
  }

  @Override
  public void setBlob(int parameterIndex, java.sql.Blob x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBlob-int-java.sql.Blob-
    this.preparedStatement.setBlob(parameterIndex, x);
  }

  @Override
  public void setBlob(int parameterIndex, java.io.InputStream x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBlob-int-java.io.InputStream-
    this.preparedStatement.setBlob(parameterIndex, x);
  }

  @Override
  public void setBlob(int parameterIndex, java.io.InputStream inputStream, long length)
      throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBlob-int-java.io.InputStream-long-
    this.preparedStatement.setBlob(parameterIndex, inputStream, length);
  }

  @Override
  public void setBoolean(int parameterIndex, boolean x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBoolean-int-boolean-
    this.preparedStatement.setBoolean(parameterIndex, x);
  }

  @Override
  public void setByte(int parameterIndex, byte x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setByte-int-byte-
    this.preparedStatement.setByte(parameterIndex, x);
  }

  @Override
  public void setBytes(int parameterIndex, byte[] x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setBytes-int-byte:A-
    this.preparedStatement.setBytes(parameterIndex, x);
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setCharacterStream-int-java.io.Reader-
    this.preparedStatement.setCharacterStream(parameterIndex, reader);
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader, int length)
      throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setCharacterStream-int-java.io.Reader-int-
    this.preparedStatement.setCharacterStream(parameterIndex, reader, length);
  }

  @Override
  public void setCharacterStream(int parameterIndex, java.io.Reader reader, long length)
      throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setCharacterStream-int-java.io.Reader-long-
    this.preparedStatement.setCharacterStream(parameterIndex, reader, length);
  }

  @Override
  public void setClob(int parameterIndex, java.sql.Clob x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setClob-int-java.sql.Clob-
    this.preparedStatement.setClob(parameterIndex, x);
  }

  @Override
  public void setClob(int parameterIndex, java.io.Reader reader) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setClob-int-java.io.Reader-
    this.preparedStatement.setClob(parameterIndex, reader);
  }

  @Override
  public void setClob(int parameterIndex, java.io.Reader reader, long length) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setClob-int-java.io.Reader-long-
    this.preparedStatement.setClob(parameterIndex, reader, length);
  }

  @Override
  public void setDate(int parameterIndex, java.sql.Date x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setDate-int-java.sql.Date-
    this.preparedStatement.setDate(parameterIndex, x);
  }

  @Override
  public void setDate(int parameterIndex, java.sql.Date x, java.util.Calendar cal)
      throws SQLException {
    // This method goes over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setDate-int-java.sql.Date-java.util.Calendar-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setDate");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setDate(parameterIndex, x, cal);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setDouble(int parameterIndex, double x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setDouble-int-double-
    this.preparedStatement.setDouble(parameterIndex, x);
  }

  @Override
  public void setFloat(int parameterIndex, float x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setFloat-int-float-
    this.preparedStatement.setFloat(parameterIndex, x);
  }

  @Override
  public void setInt(int parameterIndex, int x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setInt-int-int-
    this.preparedStatement.setFloat(parameterIndex, x);
  }

  @Override
  public void setLong(int parameterIndex, long x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setLong-int-long-
    this.preparedStatement.setLong(parameterIndex, x);
  }

  @Override
  public void setNCharacterStream(int parameterIndex, java.io.Reader value) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNCharacterStream-int-java.io.Reader-
    this.preparedStatement.setNCharacterStream(parameterIndex, value);
  }

  @Override
  public void setNCharacterStream(int parameterIndex, java.io.Reader value, long length)
      throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNCharacterStream-int-java.io.Reader-long-
    this.preparedStatement.setNCharacterStream(parameterIndex, value, length);
  }

  @Override
  public void setNClob(int parameterIndex, java.sql.NClob value) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNClob-int-java.sql.NClob-
    this.preparedStatement.setNClob(parameterIndex, value);
  }

  @Override
  public void setNClob(int parameterIndex, java.io.Reader reader) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNClob-int-java.io.Reader-
    this.preparedStatement.setNClob(parameterIndex, reader);
  }

  @Override
  public void setNClob(int parameterIndex, java.io.Reader reader, long length) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNClob-int-java.io.Reader-long-
    this.preparedStatement.setNClob(parameterIndex, reader, length);
  }

  @Override
  public void setNString(int parameterIndex, String value) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNString-int-java.lang.String-
    this.preparedStatement.setNString(parameterIndex, value);
  }

  @Override
  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNull-int-int-
    this.preparedStatement.setNull(parameterIndex, sqlType);
  }

  @Override
  public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setNull-int-int-java.lang.String-
    this.preparedStatement.setNull(parameterIndex, sqlType, typeName);
  }

  @Override
  public void setObject(int parameterIndex, Object x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setObject-int-java.lang.Object-
    this.preparedStatement.setObject(parameterIndex, x);
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setObject-int-java.lang.Object-java.sql.SQLType-
    this.preparedStatement.setObject(parameterIndex, x, targetSqlType);
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength)
      throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setObject-int-java.lang.Object-java.sql.SQLType-int-
    this.preparedStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
  }

  @Override
  public void setRef(int parameterIndex, java.sql.Ref x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setRef-int-java.sql.Ref-
    this.preparedStatement.setRef(parameterIndex, x);
  }

  @Override
  public void setRowId(int parameterIndex, java.sql.RowId x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setRowId-int-java.sql.RowId-
    this.preparedStatement.setRowId(parameterIndex, x);
  }

  @Override
  public void setShort(int parameterIndex, short x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setShort-int-short-
    this.preparedStatement.setShort(parameterIndex, x);
  }

  @Override
  public void setSQLXML(int parameterIndex, java.sql.SQLXML xmlObject) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setSQLXML-int-java.sql.SQLXML-
    this.preparedStatement.setSQLXML(parameterIndex, xmlObject);
  }

  @Override
  public void setString(int parameterIndex, String x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setString-int-java.lang.String-
    this.preparedStatement.setString(parameterIndex, x);
  }

  @Override
  public void setTime(int parameterIndex, java.sql.Time x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setTime-int-java.sql.Time-
    this.preparedStatement.setTime(parameterIndex, x);
  }

  @Override
  public void setTime(int parameterIndex, java.sql.Time x, java.util.Calendar cal)
      throws SQLException {
    // This method goes over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setTime-int-java.sql.Time-java.util.Calendar-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setTime");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setTime(parameterIndex, x, cal);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @Override
  public void setTimestamp(int parameterIndex, java.sql.Timestamp x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setTimestamp-int-java.sql.Timestamp-
    this.preparedStatement.setTimestamp(parameterIndex, x);
  }

  @Override
  public void setTimestamp(int parameterIndex, java.sql.Timestamp x, java.util.Calendar cal)
      throws SQLException {
    // This method goes over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setTimestamp-int-java.sql.Timestamp-java.util.Calendar-
    TrackingOperation trackingOperation =
        Observability.createRoundtripTrackingSpan("java.sql.PreparedStatement.setTimestamp");

    try (Scope ws = trackingOperation.withSpan()) {
      this.preparedStatement.setTimestamp(parameterIndex, x, cal);
    } catch (Exception e) {
      trackingOperation.recordException(e);
      throw e;
    } finally {
      trackingOperation.end();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public void setUnicodeStream(int parameterIndex, java.io.InputStream x, int length)
      throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setUnicodeStream-int-java.io.InputStream-int-
    this.preparedStatement.setUnicodeStream(parameterIndex, x, length);
  }

  @Override
  public void setURL(int parameterIndex, java.net.URL x) throws SQLException {
    // This method doesn't go over the network:
    // https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#setURL-int-java.net.URL-
    this.preparedStatement.setURL(parameterIndex, x);
  }

  @Override
  public boolean isClosed() throws SQLException {
    return this.preparedStatement.isClosed();
  }

  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    return this.preparedStatement.isCloseOnCompletion();
  }

  @Override
  public boolean isPoolable() throws SQLException {
    return this.preparedStatement.isPoolable();
  }

  @Override
  public void setCursorName(String cursorName) throws SQLException {
    this.preparedStatement.setCursorName(cursorName);
  }

  @Override
  public void setEscapeProcessing(boolean enable) throws SQLException {
    this.preparedStatement.setEscapeProcessing(enable);
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    this.preparedStatement.setFetchDirection(direction);
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    this.preparedStatement.setFetchSize(rows);
  }

  @Override
  public void setMaxFieldSize(int max) throws SQLException {
    this.preparedStatement.setMaxFieldSize(max);
  }

  @Override
  public void setMaxRows(int max) throws SQLException {
    this.preparedStatement.setMaxRows(max);
  }

  @Override
  public void setPoolable(boolean poolable) throws SQLException {
    this.preparedStatement.setPoolable(poolable);
  }

  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    this.preparedStatement.setQueryTimeout(seconds);
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
