package duongbh.com.converter;

import org.springframework.stereotype.Component;

import duongbh.com.dto.CategoryDTO;
import duongbh.com.entity.CategoryEntity;

@Component
public class CatogeryConverter {

	public CategoryDTO toDTO(CategoryEntity c) {
		CategoryDTO r = new CategoryDTO();
		r.setDescs(c.getDescs());
		r.setId(c.getId());
		r.setName(c.getName());
		r.setThumbNail(c.getThumbNail());
		r.setProducts(c.getProducts());
		return r;

	}

}
