package com.example.APISpringDemonstration.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.APISpringDemonstration.postService.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService thePostService;
	
	@GetMapping("/getPosts")
	List<Map<String, Object>> getAllPosts()
	{
		return thePostService.getPosts();
	}
	@GetMapping("/getPostById/{id}")
	Map<String,Object> getPostById(@PathVariable int id)
	{
		return thePostService.getPostById(id);
	}
	@PostMapping("/insertPosts")
	Map<String,Object> insertPosts(@RequestBody Map<String,Object>payLoad)
	{
		return thePostService.insertPost(payLoad);
	}
	@PutMapping("/updatePosts/{id}")
	Map<String,Object> updatePosts(@RequestBody Map<String,Object>payLoad,@PathVariable int id)
	{
		return thePostService.updatePost(payLoad,id);
	}
	@DeleteMapping("/deletePosts/{id}")
	Map<String,Object> deletePosts(@PathVariable int id)
	{
		return thePostService.delete(id);
	}
	
	

}
