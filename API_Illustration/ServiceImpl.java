package com.SpringAPI.ApiIllustration.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ServiceImpl implements ServiceInterface{

	@Autowired
	private RestTemplate theRestTemplate;
	
	String url="https://dummyjson.com";
	StringBuilder builder=new StringBuilder(url);
	

	@Override
	public Map<String, Object> getPostById(int id) {
		String urlNew=builder.append("/products/").append(id).toString();
		Map<String,Object> thePost=theRestTemplate.getForObject(urlNew,Map.class);
		return thePost;
	}

	@Override
	public List<Map<String, Object>> getPost() {
		String urlNew=builder.append("/products").toString();
		HttpHeaders headers1=new HttpHeaders();
		headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Void>theHttpEntity=new HttpEntity<>(headers1);
		ResponseEntity<List<Map<String, Object>>> response = theRestTemplate.exchange(urlNew,HttpMethod.GET,theHttpEntity,new ParameterizedTypeReference<List<Map<String, Object>>>() {});
		return response.getBody();
	}

	@Override
	public Map<String, Object> insertPost(Map<String, Object> payLoad) {
		String urlNew=builder.append("/posts").toString();
		HttpHeaders headers2=new HttpHeaders();
		headers2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers2.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> httpEntity2 = new HttpEntity<>(payLoad,headers2);
		ResponseEntity<Map<String, Object>> response = theRestTemplate.exchange(urlNew,HttpMethod.POST,httpEntity2,new ParameterizedTypeReference<Map<String, Object>>() {});
		return response.getBody();
	}

	@Override
	public Map<String, Object> deletePost(int id) {
		String urlNew=builder.append("/posts").append(id).toString();
		HttpHeaders headers1=new HttpHeaders();
		headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Void>theHttpEntity=new HttpEntity<>(headers1);
		ResponseEntity<Map<String, Object>> response = theRestTemplate.exchange(urlNew,HttpMethod.DELETE,theHttpEntity,new ParameterizedTypeReference<Map<String, Object>>() {});
		return response.getBody();
	}

	@Override
	public Map<String, Object> updatePost(int id, Map<String, Object> payLoad) {
		String urlNew=builder.append("/posts").append(id).toString();
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String,Object>>httpEntity=new HttpEntity<>(payLoad,header);
		ResponseEntity<Map<String, Object>> response = theRestTemplate.exchange(urlNew,HttpMethod.DELETE,httpEntity,new ParameterizedTypeReference<Map<String, Object>>() {});
		return response.getBody();
	}

}
