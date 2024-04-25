package com.SpringAPI.ApiIllustration.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringAPI.ApiIllustration.Service.ServiceInterface;

@RestController
@RequestMapping("/api")
public class Controller {
	
	private ServiceInterface theServiceInterface;
	
	@Autowired
	public Controller(ServiceInterface theServiceInterface)
	{
		this.theServiceInterface=theServiceInterface;
	}
	
	@GetMapping("/posts/{id}")
	public Map<String,Object> getPostById(@PathVariable int id)
	{
		return theServiceInterface.getPostById(id);
	}
	@GetMapping("/posts")
	public List<Map<String,Object>> getPosts()
	{
		return theServiceInterface.getPost();
	}
	@PostMapping("/posts")
	public Map<String,Object> postPost(@RequestBody Map<String,Object> payLoad)
	{
		 return theServiceInterface.insertPost(payLoad);
	}
	@PutMapping("/posts/{id}")
	public ResponseEntity<String> updatePostById(@PathVariable int id,@RequestBody Map<String,Object>payLoad)
	{
		theServiceInterface.updatePost(id, payLoad);
		return ResponseEntity.ok("updated");
	}
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<String> deletePostById(@PathVariable int id)
	{
		theServiceInterface.deletePost(id);
		return ResponseEntity.ok("Deleted");
	}
	
	

}
