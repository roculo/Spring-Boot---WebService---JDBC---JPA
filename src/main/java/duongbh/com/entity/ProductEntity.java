package duongbh.com.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	@Column(name = "shortContent", columnDefinition = "TEXT")
	private String shortContent;
	@Column(name = "price")
	private int price;
	@Column(name = "isSold")
	private int isSold;
	@Column(name = "createOn")
	private Date createOn;
	@Column(name = "thumbNail", columnDefinition = "TEXT")
	private String thumbNail;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity category;

	public ProductEntity() {
		super();
	}

	public ProductEntity(long id, String name, String content, String shortContent, int price, int isSold,
			Date createOn, String thumbNail, CategoryEntity category) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.shortContent = shortContent;
		this.price = price;
		this.isSold = isSold;
		this.createOn = createOn;
		this.thumbNail = thumbNail;
		this.category = category;
	}

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getIsSold() {
		return isSold;
	}

	public void setIsSold(int isSold) {
		this.isSold = isSold;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

//	public TypeEntity getTypeEntity() {
//		return type;
//	}
//
//	public void setTypeEntity(TypeEntity typeEntity) {
//		this.type = typeEntity;
//	}

}
