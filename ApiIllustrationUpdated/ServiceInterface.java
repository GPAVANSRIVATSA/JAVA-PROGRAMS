package com.SpringAPI.ApiIllustration.Service;

import java.util.List;
import java.util.Map;

public interface ServiceInterface {
	public Map<String,Object> getPostById(int id);
	public List<Map<String,Object>> getPost();
	public Map<String,Object> insertPost(Map<String,Object>payLoad);
	public Map<String,Object> updatePost(int id,Map<String,Object>payLoad);
	public void deletePost(int id);
}
