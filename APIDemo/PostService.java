package com.example.APISpringDemonstration.postService;

import java.util.List;
import java.util.Map;

public interface PostService {
	
	List<Map<String,Object>> getPosts();
	Map<String,Object> getPostById(int id);
	Map<String,Object> insertPost(Map<String,Object> payLoad);
	Map<String,Object> updatePost(Map<String,Object>payLoad,int id);
	Map<String,Object> delete(int id);

}
