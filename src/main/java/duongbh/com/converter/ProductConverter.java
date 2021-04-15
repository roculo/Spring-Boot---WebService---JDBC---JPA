package duongbh.com.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import duongbh.com.dto.ProductDTO;
import duongbh.com.entity.ProductEntity;
import duongbh.com.service.IProductService;

@Component
public class ProductConverter {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	IProductService productService;

	public ProductDTO toDTO(ProductEntity productEntity) {
		ProductDTO result = new ProductDTO();
		result.setContent(productEntity.getContent());
		result.setShortContent(productEntity.getShortContent());
		result.setCreateOn(productEntity.getCreateOn());
		result.setId(productEntity.getId());
		result.setIsSold(productEntity.getIsSold());
		result.setName(productEntity.getName());
		result.setPrice(productEntity.getPrice());
		result.setThumbNail(productEntity.getThumbNail());
		return result;
	}

	public ProductEntity toEntity(ProductDTO productDTO) {
		ProductEntity result = modelMapper.map(productDTO, ProductEntity.class);
		return result;
	}
}
