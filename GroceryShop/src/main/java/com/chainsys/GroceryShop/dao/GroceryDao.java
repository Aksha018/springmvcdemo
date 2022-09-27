package com.chainsys.GroceryShop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.GroceryShop.Exception.UserException;
import com.chainsys.GroceryShop.mapper.GroceryMapper;
import com.chainsys.GroceryShop.model.Grocery;
import com.chainsys.GroceryShop.validation.GroceryValidation;

@Repository
public class GroceryDao {
  @Autowired
  JdbcTemplate jdbcTemplate;
  @Autowired
  GroceryValidation groceryValidation;
  
 //Insert 
  
   public int addProduct(Grocery grocery) {
	   String q = "insert into PRODUCTS(PRODUCT_ID,PRODUCT_NAME,QUNATITY,PRICE,USER_ID)values(?,?,?,?,?)";
	    int product = 0;
	    Object[] productDetails = {grocery.getProductId(),grocery.getProductName(),grocery.getQuantity(),grocery.getPrice(),grocery.getUserId()};
	    product = jdbcTemplate.update(q,productDetails);
	    return product;
   }
 // View product list
   
   public List<Grocery> groceryList(){
	   
	   String q = "select PRODUCT_ID,PRODUCT_NAME,QUNATITY,PRICE,USER_ID from PRODUCTS";
	   List<Grocery> groceryList = null;
	   groceryList = jdbcTemplate.query(q, new GroceryMapper());
	   return groceryList;
	   
	   
   }
 //Update 
    public int updateProduct(Grocery grocery) {
    	String q = "update PRODUCTS set PRODUCT_NAME=?,QUNATITY=?,PRICE=?,USER_ID=? where PRODUCT_ID=?";
    	int product =0;
    	Object[] productDetails = {grocery.getProductName(),grocery.getQuantity(),grocery.getPrice(),grocery.getUserId(),grocery.getProductId()};
    	product = jdbcTemplate.update(q,productDetails);
    	return product;
    }
  //Delete 
    public int deleteProduct(int productId) {
    	String q = "delete from PRODUCTS where PRODUCT_ID=?";
    	int product  = 0;
    	product = jdbcTemplate.update(q,productId);
    	return product;
    }
 //FindByProductId
    public Grocery findByProductId(int productId) {
    	try {
    	if(groceryValidation.checkProductId(productId)) {
  		  throw new UserException("Invalid Id");
  	  }
    	String q = "select PRODUCT_ID,PRODUCT_NAME,QUNATITY,PRICE,USER_ID from PRODUCTS where PRODUCT_ID=?";
    	Grocery findByProductId = null;
    	findByProductId = jdbcTemplate.queryForObject(q, new GroceryMapper(),productId);
    	return findByProductId;
    	}
    	catch(UserException e) {
    		return null;
    	}
    	
    }
    
    

}
