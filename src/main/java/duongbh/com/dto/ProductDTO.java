package duongbh.com.dto;

import java.sql.Date;

import duongbh.com.entity.CategoryEntity;

public class ProductDTO {
	private long id;
	private String name;
	private String content;
	private String shortContent;
	private int price;
	private int isSold;
	private Date createOn;
	private String thumbNail;
	private CategoryEntity category;

	public ProductDTO() {
		super();
	}

	public ProductDTO(long id, String name, String content, String shortContent, int price, int isSold, Date createOn,
			String thumbNail, CategoryEntity category) {
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

}
