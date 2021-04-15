package duongbh.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import duongbh.com.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findByName(String name);
}
