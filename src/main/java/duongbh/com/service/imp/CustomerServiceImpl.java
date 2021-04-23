package duongbh.com.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import duongbh.com.converter.CustomerConverter;
import duongbh.com.dao.ICustomerDAO;
import duongbh.com.dto.CustomerDTO;
import duongbh.com.entity.CustomerEntity;
import duongbh.com.jdbc.ISQLQuery;
import duongbh.com.repository.ICustomerRepository;
import duongbh.com.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	// For JPA
	@Autowired
	ICustomerRepository customerRespository;
	// For JDBC
	@Autowired
	ICustomerDAO customerDAO;
	@Autowired
	ISQLQuery<CustomerEntity> sqlQuery;

	@Autowired
	CustomerConverter customerConverter;

	@Override
	public List<CustomerDTO> findAll(Pageable pageable) {
		List<CustomerDTO> result = new ArrayList<CustomerDTO>();
		List<CustomerEntity> lst = customerRespository.findAll(pageable).getContent();
		for (CustomerEntity customerEntity : lst) {
			result.add(customerConverter.toDTO(customerEntity));
		}
		return result;
	}

	public List<CustomerDTO> findAll(int page, int limit) {
		List<CustomerDTO> result = new ArrayList<CustomerDTO>();
		List<CustomerEntity> lst = customerDAO.findAll(page, limit);
		for (CustomerEntity customerEntity : lst) {
			result.add(customerConverter.toDTO(customerEntity));
		}
		return result;
	}

	@Override
	public void remove(Long[] ids) {
		// JPA mode
		for (Long id : ids) {
			customerRespository.delete(id);
		}
		// JBDC mode

	}

	@Override
	public int count() {
		return (int) customerRespository.count();
	}

	@Override
	public CustomerDTO save(CustomerDTO customer) {
		// add
		if (customer.getId() == null) {
			CustomerEntity entity = customerConverter.toEntity(customer);
			customerRespository.save(entity);
			entity = customerRespository.save(entity);
			return customerConverter.toDTO(entity);
		}
		// update
		else {
			CustomerEntity entity = customerRespository.findOne(customer.getId());
			entity.setName(customer.getName());
			return customerConverter.toDTO(entity);
		}
	}

}
