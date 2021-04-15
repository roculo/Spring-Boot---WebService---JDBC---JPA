package duongbh.com.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAPI {
	@GetMapping(value = "/test")
	public String getAllProductByCategory() {
		return "Success!";
	}
}
