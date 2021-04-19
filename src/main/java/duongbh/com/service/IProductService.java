package duongbh.com.service;

import java.util.List;

import duongbh.com.dto.ProductDTO;

public interface IProductService  {
	List<ProductDTO> findAll(String categoryName);

	ProductDTO findOne(Long id);

	ProductDTO add(ProductDTO productDTO);

	ProductDTO update(ProductDTO productDTO);

	void delete(Long[] ids);
}
