package duongbh.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duongbh.com.dto.ProductDTO;
import duongbh.com.service.IProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductAPI {

	@Autowired
	IProductService productService;

	@GetMapping(value = "/api/{categoryName}")
	public List<ProductDTO> getAllProductByCategory(@PathVariable(value = "categoryName") String categoryName) {
		return productService.findAll(categoryName);
	}

	@GetMapping(value = "/api/detail/{productId}")
	public ProductDTO getProduct(@PathVariable(value = "productId") Long productId) {
		return productService.findOne(productId);
	}

	@PostMapping(value = "/api")
	public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
		return productService.add(productDTO);
	}

	@PutMapping(value = "/api/{id}")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
		productDTO.setId(id);
		return productService.update(productDTO);
	}

	@DeleteMapping(value = "/api")
	public void deleteProduct(@RequestBody Long[] ids) {
		productService.delete(ids);
	}

}
