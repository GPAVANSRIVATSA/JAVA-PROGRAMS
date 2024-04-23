package com.SpringAPI.ApiIllustration.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringAPI.ApiIllustration.Service.ServiceInterface;

@RestController
@RequestMapping("/api")
public class Controller {
	
	private ServiceInterface theServiceInterface;
	
	public Controller(ServiceInterface theServiceInterface)
	{
		this.theServiceInterface=theServiceInterface;
	}
	
	@GetMapping("/products/{id}")
	public Map<String,Object> getProductById(@PathVariable int id)
	{
		return theServiceInterface.getPostById(id);
	}
	@GetMapping("/products")
	public List<Map<String,Object>> getProducts()
	{
		return theServiceInterface.getPost();
	}
	@PostMapping("/products")
	public Map<String,Object> postProduct(@RequestBody Map<String,Object> payLoad)
	{
		return theServiceInterface.insertPost(payLoad);
	}
	@DeleteMapping("/products/{id}")
	public Map<String,Object> deleteProductById(@PathVariable int id)
	{
		return theServiceInterface.deletePost(id);
	}
	
	

}
