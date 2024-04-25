package com.SpringAPI.ApiIllustrationWebClient.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
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
	@GetMapping("/posts")
	public List<Map<String,Object>> getProducts()
	{
		return theServiceInterface.getPost();
	}
	@PostMapping("/posts")
	public ResponseEntity<String> postProduct(@RequestBody Map<String,Object> payLoad)
	{
		 theServiceInterface.insertPost(payLoad);
		 return ResponseEntity.ok("Posted");
	}
	@PutMapping("/posts/{id}")
	public ResponseEntity<String> updatePostById(@PathVariable int id,@RequestBody Map<String,Object>payLoad)
	{
		theServiceInterface.updatePost(id,payLoad);
		 return ResponseEntity.ok("Updated");
	}
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id)
	{
		 theServiceInterface.deletePost(id);
		 return ResponseEntity.ok("Deleted");
	}
	
	

}
