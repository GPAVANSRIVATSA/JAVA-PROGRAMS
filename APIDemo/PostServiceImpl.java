package com.example.APISpringDemonstration.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.APISpringDemonstration.postService.PostService;

import lombok.val;

@Service
public class PostServiceImpl implements PostService {
	
	String baseUrl="https://jsonplaceholder.typicode.com";
	StringBuilder theStringBuilder=new StringBuilder(baseUrl);
	String POST="/posts";
	String POSTBYID="/posts/";
	@Autowired
	private RestTemplate theRestTemplate;
	@Override
	public List<Map<String, Object>> getPosts() {
		HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
		String url=theStringBuilder.append(POST).toString();
		return theRestTemplate.exchange(url,HttpMethod.GET,httpEntity,List.class).getBody();
	}

		
		private HttpHeaders gethttpHeaders() {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			return headers;
		}


		
		@Override
		public Map<String, Object> getPostById(int id) {
			HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
			String url=theStringBuilder.append(POSTBYID).append(id).toString();
			return theRestTemplate.exchange(url,HttpMethod.GET,httpEntity,Map.class).getBody();
		}

		@Override
		public Map<String, Object> insertPost(Map<String, Object> payLoad) {
			HttpEntity<Map> httpEntity = new HttpEntity<>(payLoad,gethttpHeaders());
			String url=theStringBuilder.append(POST).toString();
			var response=theRestTemplate.exchange(url,HttpMethod.POST,httpEntity,Map.class);
			return response.getBody();
		}


		@Override
		public Map<String, Object> updatePost(Map<String, Object> payLoad, int id) {
			HttpEntity<Map> httpEntity = new HttpEntity<>(payLoad,gethttpHeaders());
			String url=theStringBuilder.append(POSTBYID).append(id).toString();
			var response=theRestTemplate.exchange(url,HttpMethod.PUT,httpEntity,Map.class);
			return response.getBody();
		}


		@Override
		public Map<String,Object> delete(int id) {
			HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
			String url=theStringBuilder.append(POSTBYID).append(id).toString();
			var response=theRestTemplate.exchange(url,HttpMethod.DELETE,httpEntity,Map.class);
			return response.getBody();
			
		}
}
