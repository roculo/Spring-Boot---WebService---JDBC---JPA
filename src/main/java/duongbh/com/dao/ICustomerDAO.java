package duongbh.com.dao;

import java.util.List;

import duongbh.com.entity.CustomerEntity;

public interface ICustomerDAO {
	List<CustomerEntity> findAll(int page,int limit);
}
