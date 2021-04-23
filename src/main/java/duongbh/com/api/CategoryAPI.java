package duongbh.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duongbh.com.dto.CategoryDTO;
import duongbh.com.service.ICategoryService;
@CrossOrigin
@RestController
@RequestMapping(value = "/category")
public class CategoryAPI {
	@Autowired
	ICategoryService categoryService;

	@GetMapping(value = "/api")
	public List<CategoryDTO> getAll() {
		return categoryService.findAll();
	}
}
