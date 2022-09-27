package com.chainsys.GroceryShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.GroceryShop.dao.GroceryDao;
import com.chainsys.GroceryShop.model.Grocery;
import com.chainsys.GroceryShop.validation.GroceryValidation;
import com.chainsys.GroceryShop.validation.UserValidation;

@Controller
@RequestMapping("/grocery")
public class GroceryController {
	
	@Autowired
	GroceryDao groceryDao;
	@Autowired
	GroceryValidation groceryValidation;
	@Autowired
	UserValidation userValidation;
	
	@GetMapping("/addProduct")
	public String add() {
		return "/add-product.jsp";
	}

	@GetMapping("add")
	public String insertProduct(@RequestParam("productId")int productId,@RequestParam("productName")String productName ,@RequestParam("quantity")int quantity,@RequestParam("price")int price,@RequestParam("userId")int userId,Model model) {
		if(groceryValidation.checkProductId(productId)) {
			if(groceryValidation.checkProductname(productName)) {
			if(groceryValidation.checkQuantity(quantity)) {
			if(groceryValidation.checkPrice(price)) {
			if(userValidation.checkUserId(userId)) {	
			Grocery grocery = new Grocery();
			grocery.setProductId(productId);
			grocery.setProductName(productName);
			grocery.setQuantity(quantity);
			grocery.setPrice(price);
			grocery.setUserId(userId);
		
			int addgrocery =  groceryDao.addProduct(grocery);
			List<Grocery> groceryList = groceryDao.groceryList();
			model.addAttribute("groceryList", groceryList);
			return "/grocery-list.jsp";
			
			}else {
				String addUserId="please enter valid id";
				model.addAttribute("check", addUserId);
				return "/add-product.jsp";
			}
			
			}else {
				String addprice="please enter valid number";
				model.addAttribute("check", addprice);
				return "/add-product.jsp";
			}
			}else {
				String addquantity="please enter valid number";
				model.addAttribute("check", addquantity);
				return "/add-product.jsp";
				}
			
			}else {
				String addName = "Please enter Alphabets only";
				model.addAttribute("check", addName);
				return "/add-product.jsp";
			}
		
		}
		else {
			String additems = "Please enter valid id";
			model.addAttribute("check", additems);
			return "/add-product.jsp";
		}
	}
	
	@GetMapping("/updateproduct")
	public String update() {
		return "/update-product.jsp";
	}
@GetMapping("update")
   public String updateProduct(@RequestParam("productId")int productId,@RequestParam("productName")String productName ,@RequestParam("quantity")int quantity,@RequestParam("price")int price,@RequestParam("userId")int userId,Model model) {
	 Grocery grocery = new Grocery();
	 
	 grocery.setProductName(productName);
	 grocery.setQuantity(quantity);
	 grocery.setPrice(price);
	 grocery.setUserId(userId);
	 grocery.setProductId(productId);
	
	 
	 int updateGrocery = groceryDao.updateProduct(grocery);
	 List<Grocery> groceryList = groceryDao.groceryList();
		model.addAttribute("groceryList", groceryList);
		return "/grocery-list.jsp";
	 
}
	@GetMapping("/deleteproduct")
	public String delete() {
		return "/delete-product.jsp";
	}
  @GetMapping("delete")
   public String deleteProduct(@RequestParam("productId")int productId,Model model) {
        int deleteGrocery = groceryDao.deleteProduct(productId);
         List<Grocery> groceryList = groceryDao.groceryList();
         model.addAttribute("groceryList", groceryList);
           return "/grocery-list.jsp";
  }
    
       @GetMapping("/findbyproductid")
       public String findById() {
    	   return "/findby-productid.jsp";
       }
       
      @GetMapping("findbyid") 
      public String findIdProduct(@RequestParam("productId")int productId,Model model) {
    	  Grocery findIdByProduct = groceryDao.findByProductId(productId);
    	  List<Grocery> groceryList = new ArrayList<>();
    	  groceryList.add(findIdByProduct);
    	  model.addAttribute("groceryList", groceryList);
    	  return "/grocery-list.jsp";
    	  
      }
}
