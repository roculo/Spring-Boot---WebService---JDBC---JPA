package duongbh.com.page;

import java.util.List;

import duongbh.com.dto.CustomerDTO;

public class CustomerPage {
	int page;
	int totalPage;
	List<CustomerDTO> result;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<CustomerDTO> getResult() {
		return result;
	}
	public void setResult(List<CustomerDTO> result) {
		this.result = result;
	}
	
}
