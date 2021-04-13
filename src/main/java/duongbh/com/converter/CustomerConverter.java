package duongbh.com.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import duongbh.com.dto.CustomerDTO;
import duongbh.com.entity.CustomerEntity;
import duongbh.com.service.ICustomerService;

@Component
public class CustomerConverter {

	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	ICustomerService customerService;
	public CustomerDTO toDTO (CustomerEntity customerEntity)
	{
		
		CustomerDTO result = modelMapper.map(customerEntity, CustomerDTO.class);
		return result;
	}
	public CustomerEntity toEntity (CustomerDTO customerDTO)
	{
		CustomerEntity result = modelMapper.map(customerDTO,CustomerEntity.class);
		return result;
	}
}
