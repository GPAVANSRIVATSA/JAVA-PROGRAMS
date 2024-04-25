package com.SpringAPI.ApiIllustration.Service;

import java.lang.reflect.ParameterizedType;
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
	
	String url="http://localhost:8181/api/employees";
	
	@Override
	public Map<String, Object> getPostById(int id) {
		String urlNew=url+"/"+Integer.toString(id);
		Map<String,Object> thePost=theRestTemplate.getForObject(urlNew,Map.class);
		return thePost;
	}

	@Override
	public List<Map<String, Object>> getPost() {
		/*HttpHeaders headers1=new HttpHeaders();
		headers1.setAccept(Arrays.asList(MediaType.ALL));
		HttpEntity<Void>theHttpEntity=new HttpEntity<>(headers1);
		ResponseEntity<Object> response = theRestTemplate.exchange(urlNew,HttpMethod.GET,theHttpEntity,Object.class);
		Object o = response.getBody();
		return null;*/
		HttpHeaders headers1=new HttpHeaders();
		headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Void>theHttpEntity=new HttpEntity<>(headers1);
		ResponseEntity<List<Map<String,Object>>>response=theRestTemplate.exchange(url,HttpMethod.GET,theHttpEntity,new ParameterizedTypeReference<List<Map<String, Object>>>() {});
		return response.getBody();
	}

	@Override
	public Map<String,Object> insertPost(Map<String, Object> payLoad) {
		return theRestTemplate.postForObject(url,payLoad,Map.class);
	}

	@Override
	public void deletePost(int id) {
		String urlNew=url+"/"+Integer.toString(id);
		theRestTemplate.delete(urlNew);
	}

	@Override
	public Map<String,Object> updatePost(int id, Map<String, Object> payLoad) {
		String urlNew=url+"/"+Integer.toString(id);
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<String,Object>>theHttpEntity=new HttpEntity<>(payLoad,headers);
		ResponseEntity<Map<String,Object>>response=theRestTemplate.exchange(urlNew,HttpMethod.PUT,theHttpEntity,new ParameterizedTypeReference<Map<String, Object>>() {});
		return response.getBody();
	}

}
