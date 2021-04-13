package duongbh.com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import duongbh.com.dto.CustomerDTO;
import duongbh.com.page.CustomerPage;
import duongbh.com.service.ICustomerService;

@CrossOrigin
@RestController
@RequestMapping(value = "/customer")
public class CustomerAPI {

	@Autowired
	ICustomerService customerService;

	@GetMapping(value = "/api")
	public CustomerPage getAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		CustomerPage customerPage = new CustomerPage();
		// JPA
//		customerPage.setPage(page);
//		int total = customerService.count();
//		int t = (int) Math.ceil((double) total / limit);
//		customerPage.setTotalPage(t);
//		PageRequest pageable = new PageRequest(page - 1, limit);
//		customerPage.setResult(customerService.findAll(pageable));
		// JDBC
		customerPage.setPage(page);
		int total = customerService.count();
		int t = (int) Math.ceil((double) total / limit);
		customerPage.setTotalPage(t);
		customerPage.setResult(customerService.findAll(page-1, limit));
		return customerPage;
	}

	@PostMapping(value = "/api")
	public CustomerDTO addCustomer(@RequestBody CustomerDTO customer) {
		return customerService.save(customer);
	}

	@PutMapping(value = "/api/{id}")
	public Long updateCustomer(@RequestBody CustomerDTO customer, @PathVariable(required = true) Long id) {
//		System.out.println(id);
		customer.setId(id);
		return customerService.save(customer).getId();
	}

	@DeleteMapping(value = "/api")
	public void deleteCustomer(@RequestBody Long[] ids) {
		customerService.remove(ids);
	}
}
