package com.chainsys.GroceryShop.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.GroceryShop.model.Grocery;

public class GroceryMapper implements RowMapper<Grocery> {
	@Override
	public Grocery mapRow(ResultSet rs, int rowNum)throws SQLException {
	   int productId = rs.getInt(1);
	   String productName = rs.getString(2);
	   int quantity = rs.getInt(3);
	   int price = rs.getInt(4);
	   int userId = rs.getInt(5);
	   
	   Grocery grocery = new Grocery();
	   
	   grocery.setProductId(productId);
	   grocery.setProductName(productName);
	   grocery.setQuantity(quantity);
	   grocery.setPrice(price);
	   grocery.setUserId(userId);
	   
	   return grocery;
	
	
	}

}
