package duongbh.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import duongbh.com.entity.CustomerEntity;


public interface ICustomerRepository extends JpaRepository<CustomerEntity,Long> {
	


}
