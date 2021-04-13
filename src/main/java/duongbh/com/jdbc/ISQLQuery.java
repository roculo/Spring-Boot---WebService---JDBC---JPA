package duongbh.com.jdbc;

import java.util.List;

import duongbh.com.jdbc.mapper.IRowMapper;

public interface ISQLQuery<T> {
	List<T> query(String sql, IRowMapper<T> rowmapper, Object... objects);

	Long insert(String sql, Object... objects);

	boolean update(String sql, Object... objects);

	boolean delete(String sql, Object... objects);
	
	int count(String sql, Object... objects);
}
