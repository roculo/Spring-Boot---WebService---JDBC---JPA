package duongbh.com.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duongbh.com.converter.CatogeryConverter;
import duongbh.com.dto.CategoryDTO;
import duongbh.com.entity.CategoryEntity;
import duongbh.com.repository.ICategoryRepository;
import duongbh.com.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepository categoryRepository;
	@Autowired
	CatogeryConverter categoryConverter;

	public List<CategoryDTO> findAll() {
		List<CategoryDTO> result = new ArrayList<CategoryDTO>();
		List<CategoryEntity> lst = categoryRepository.findAll();
		for (CategoryEntity categoryEntity : lst) {
			result.add(categoryConverter.toDTO(categoryEntity));
		}
		return result;
	}
}
