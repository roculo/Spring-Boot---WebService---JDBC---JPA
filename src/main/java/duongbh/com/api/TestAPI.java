package duongbh.com.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import duongbh.com.entity.CategoryEntity;

@RestController
public class TestAPI {
	@GetMapping(value = "/test")
	public String getAllProductByCategory() {
		return "Success!";
	}
	public static void main(String[] args) {
		CategoryEntity category = new CategoryEntity(1,"22", "s", "sds", null);
		System.out.println(category.toString());
	}
}
