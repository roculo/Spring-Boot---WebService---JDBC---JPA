package duongbh.com.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duongbh.com.converter.ProductConverter;
import duongbh.com.dto.ProductDTO;
import duongbh.com.entity.ProductEntity;
import duongbh.com.repository.ICategoryRepository;
import duongbh.com.repository.IProductRepository;
import duongbh.com.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;

	@Autowired
	ICategoryRepository categoryRepository;

	@Autowired
	ProductConverter productConverter;

	public List<ProductDTO> findAll(String categoryName) {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		Long id = categoryRepository.findByName(categoryName).getId();
		List<ProductEntity> lst = categoryRepository.findOne(Long.valueOf(id)).getProducts();
		for (ProductEntity productEntity : lst) {
			result.add(productConverter.toDTO(productEntity));
		}
		return result;
	}

	public ProductDTO findOne(Long id) {
		ProductEntity newone = productRepository.findOne(id);
		return productConverter.toDTO(newone);
	}

	public ProductDTO add(ProductDTO p) {
		ProductEntity newone = new ProductEntity();
		newone = productConverter.toEntity(p);
		return productConverter.toDTO(productRepository.save(newone));
	}

	public ProductDTO update(ProductDTO p) {
		ProductEntity newone = new ProductEntity();
		newone = productConverter.toEntity(p);
		return productConverter.toDTO(productRepository.save(newone));
	}

	public void delete(Long[] ids) {
		for (Long id : ids) {
			productRepository.delete(id);
		}

	}

}
