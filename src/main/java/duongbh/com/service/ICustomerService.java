package duongbh.com.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import duongbh.com.dto.CustomerDTO;

public interface ICustomerService {
	//JPA
	public List<CustomerDTO> findAll(Pageable pageable);
	//JDBC
	public List<CustomerDTO> findAll(int offset,int limit);
	public CustomerDTO save(CustomerDTO customer);
	public void remove(Long[] ids);
	public int count();
}
