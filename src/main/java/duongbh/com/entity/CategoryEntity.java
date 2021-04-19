package duongbh.com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "descs")
	private String descs;
	@Column(name = "thumbNail")
	private String thumbNail;

	@OneToMany(mappedBy = "category")
	@JsonManagedReference
	private List<ProductEntity> products;

	public CategoryEntity() {
		super();
	}


	public CategoryEntity(long id, String name, String descs, String thumbNail, List<ProductEntity> products) {
		super();
		this.id = id;
		this.name = name;
		this.descs = descs;
		this.thumbNail = thumbNail;
		this.products = products;
	}


	public String getThumbNail() {
		return thumbNail;
	}


	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}


	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
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

	public String getDesc() {
		return descs;
	}

	public void setDesc(String desc) {
		this.descs = desc;
	}

}
