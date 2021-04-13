package duongbh.com.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import duongbh.com.entity.CustomerEntity;

public class CustomerMapper implements IRowMapper<CustomerEntity>{
   
	@Override
	public CustomerEntity mapRow(ResultSet rs) {
		try {
			Long id = rs.getLong("id");
			String name = rs.getString("name");
			return new CustomerEntity(id,name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

}
