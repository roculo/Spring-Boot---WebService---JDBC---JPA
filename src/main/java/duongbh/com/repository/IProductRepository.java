package duongbh.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import duongbh.com.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity,Long>{

}
