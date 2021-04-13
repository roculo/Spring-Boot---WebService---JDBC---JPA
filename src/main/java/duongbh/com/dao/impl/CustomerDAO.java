package duongbh.com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import duongbh.com.converter.CustomerConverter;
import duongbh.com.dao.ICustomerDAO;
import duongbh.com.entity.CustomerEntity;
import duongbh.com.jdbc.ISQLQuery;
import duongbh.com.jdbc.mapper.CustomerMapper;

@Repository
public class CustomerDAO implements ICustomerDAO {
	@Autowired
	ISQLQuery<CustomerEntity> sqlQuery;

	@Autowired
	CustomerConverter customerConverter;

	public List<CustomerEntity> findAll(int page, int limit) {
		int offset=limit*page;
		String sql = "select * from customer limit " + limit + " offset " + offset;
		List<CustomerEntity> lst = sqlQuery.query(sql, new CustomerMapper());
		return lst;
	}
}
