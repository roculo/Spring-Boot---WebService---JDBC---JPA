package duongbh.com.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import duongbh.com.jdbc.ISQLQuery;
import duongbh.com.jdbc.MySQLConnector;
import duongbh.com.jdbc.mapper.IRowMapper;

@Component
public class SQLQuery<T> implements ISQLQuery<T> {

	@Autowired
	MySQLConnector mySQLConnector;

	public List<T> query(String sql, IRowMapper<T> rowMapper, Object... objects) {
		List<T> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = MySQLConnector.getConnection();
			statement = connection.prepareStatement(sql);
			// Set params prepare statement
			setParams(statement, objects);
			ResultSet rs = statement.executeQuery();
			// Get result set
			while (rs.next()) {
				result.add(rowMapper.mapRow(rs));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection(statement, connection);
		}
		return result;
	}

	public Long insert(String sql, Object... objects) {
		Connection connection = null;
		PreparedStatement statement = null;
		Long result = null;
		ResultSet rs = null;
		try {
			connection = MySQLConnector.getConnection();
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// Set params prepare statement
			setParams(statement, objects);
			statement.executeUpdate();
			connection.commit();
			// Get result set
			rs = statement.getGeneratedKeys();
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection(statement, connection);
		}
		return result;
	}

	public boolean update(String sql, Object... objects) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean result = false;
		try {
			connection = MySQLConnector.getConnection();
			statement = connection.prepareStatement(sql);
			// Set params prepare statement
			setParams(statement, objects);
			statement.executeUpdate();
			result = true;
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection(statement, connection);
		}
		return result;
	}

	public boolean delete(String sql, Object... objects) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean result = false;
		try {
			connection = MySQLConnector.getConnection();
			statement = connection.prepareStatement(sql);
			// Set params prepare statement
			setParams(statement, objects);
			statement.executeUpdate();
			result = true;
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection(statement, connection);
		}
		return result;
	}

	@Override
	public int count(String sql, Object... objects) {
		int result = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = MySQLConnector.getConnection();
			statement = connection.prepareStatement(sql);
			// Set params prepare statement
			setParams(statement, objects);
			ResultSet rs = statement.executeQuery();
			// Get result set
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection(statement, connection);
		}
		return result;
	}

	public void setParams(PreparedStatement statement, Object... objects) {
		try {
			for (int i = 0; i < objects.length; i++) {
				if (objects[i] instanceof String) {
					statement.setString(i + 1, (String) objects[i]);
				} else if (objects[i] instanceof Integer) {
					statement.setInt(i + 1, (Integer) objects[i]);
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}

	public void closeConnection(PreparedStatement statement, Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
