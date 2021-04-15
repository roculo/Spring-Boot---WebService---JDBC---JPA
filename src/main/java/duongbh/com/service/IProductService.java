package duongbh.com.service;

import java.util.List;

import duongbh.com.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> findAll(String categoryName);

	ProductDTO add(ProductDTO productDTO);

	ProductDTO update(ProductDTO productDTO);

	void delete(Long[] ids);
}
