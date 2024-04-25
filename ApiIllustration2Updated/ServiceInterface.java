package com.SpringAPI.ApiIllustrationWebClient.Service;

import java.util.List;
import java.util.Map;


public interface ServiceInterface {
	public Map<String,Object> getPostById(int id);
	public List<Map<String,Object>> getPost();
	public void insertPost(Map<String,Object>payLoad);
	public void updatePost(int id,Map<String,Object>payLoad);
	public void deletePost(int id);
}
