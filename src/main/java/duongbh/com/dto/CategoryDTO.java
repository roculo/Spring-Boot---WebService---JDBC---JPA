package duongbh.com.dto;

import java.util.List;

import duongbh.com.entity.ProductEntity;

public class CategoryDTO {
	private long id;
	private String name;
	private String descs;
	private String thumbNail;
	private List<ProductEntity> products;
	
	
	public CategoryDTO() {
		super();
	}


	public CategoryDTO(long id, String name, String descs, String thumbNail, List<ProductEntity> products) {
		super();
		this.id = id;
		this.name = name;
		this.descs = descs;
		this.thumbNail = thumbNail;
		this.products = products;
	}


	public long getCount() {
		return products.size();
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescs() {
		return descs;
	}


	public void setDescs(String descs) {
		this.descs = descs;
	}


	public String getThumbNail() {
		return thumbNail;
	}


	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}


	public List<ProductEntity> getProducts() {
		return products;
	}


	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}


}
