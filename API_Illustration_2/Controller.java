package com.SpringAPI.ApiIllustrationWebClient.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringAPI.ApiIllustrationWebClient.Service.ServiceInterface;

import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api")
public class Controller {
	
	private ServiceInterface theServiceInterface;
	
	public Controller(ServiceInterface theServiceInterface)
	{
		this.theServiceInterface=theServiceInterface;
	}
	
	@GetMapping("/posts/{id}")
	public Map<String,Object> getProductById(@PathVariable int id)
	{
		return theServiceInterface.getPostById(id);
	}
	/*@GetMapping("/products")
	public Flux<Map> getProducts()
	{
		return theServiceInterface.getPost();
	}*/
	@PostMapping("/posts")
	public void postProduct(@RequestBody Map<String,Object> payLoad)
	{
		 theServiceInterface.insertPost(payLoad);
	}
	@PutMapping("/posts/{id}")
	public void updatePostById(@PathVariable int id,@RequestBody Map<String,Object>payLoad)
	{
		theServiceInterface.updatePost(id,payLoad);
	}
	@DeleteMapping("/posts/{id}")
	public void deleteProductById(@PathVariable int id)
	{
		 theServiceInterface.deletePost(id);
	}
	
	

}
