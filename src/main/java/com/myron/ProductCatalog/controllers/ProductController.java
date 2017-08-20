package com.myron.ProductCatalog.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.myron.ProductCatalog.models.Product;
import com.myron.ProductCatalog.services.ProductService;

@Controller
public class ProductController {
private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/")
	public String getProducts(Model model, @ModelAttribute("product") Product product1, BindingResult result) {
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		return "index.jsp";
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String postProducts(@ModelAttribute("product") Product product1, BindingResult result) {
		productService.addProduct(product1);
		System.out.println("MADE PRODUCT");
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("/products")
	public List<Product> allProducts(){
		return productService.allProducts();
	}
	
	@GetMapping("/products/{id}")
	public String oneProduct(@PathVariable("id") Long id, Model model) throws JsonProcessingException{
		Product product = productService.findOne(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		String jsonProduct = mapper.writeValueAsString(product);
		model.addAttribute("theproduct", jsonProduct);
		model.addAttribute("product", product);
		return "oneProduct.jsp";
	}
	
	@RequestMapping(path="/products/{id}", method=RequestMethod.POST)
	public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product, BindingResult result) {
		System.out.println("UPDATING");
		Product theProduct = product;
		productService.updateProduct(theProduct);
		return "redirect:/products/" + id;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}
}
