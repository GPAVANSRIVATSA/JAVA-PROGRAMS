package com.SpringAPI.ApiIllustrationWebClient.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceImpl implements ServiceInterface{

	private WebClient.Builder theWebClientBuilder;
	
	@Autowired
	public ServiceImpl(WebClient.Builder theWebClientBuilder)
	{
		this.theWebClientBuilder=theWebClientBuilder;
	}
	String url="http://localhost:8181/api/employees";
	@Override
	public Map<String, Object> getPostById(int id) {
		String urlNew=url+"/"+Integer.toString(id);
		Map<String,Object> thePost=theWebClientBuilder.build().get().uri(urlNew).retrieve().bodyToMono(Map.class).block();
		return thePost;
	}

	@Override
	public List<Map<String, Object>> getPost() {
	    Flux<Map<String, Object>> postsFlux = theWebClientBuilder.build().get().uri(url).retrieve().bodyToFlux(new ParameterizedTypeReference<Map<String, Object>>() {});

	    List<Map<String, Object>> postList = postsFlux.collectList().block();
	    return postList;
	}

	@Override
	public void insertPost(Map<String, Object> payLoad) {
		// TODO Auto-generated method stub
		Mono<Void> result = theWebClientBuilder.build()
	            .post()
	            .uri(url)
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(BodyInserters.fromValue(payLoad))
	            .retrieve()
	            .bodyToMono(Void.class);
	        
	        result.block(); 
	    }

	@Override
	public void updatePost(int id, Map<String, Object> payLoad) {
		String urlNew=url+"/"+Integer.toString(id);
		 Mono<Void> result = theWebClientBuilder.build()
		            .put()
		            .uri(urlNew)
		            .contentType(MediaType.APPLICATION_JSON)
		            .body(BodyInserters.fromValue(payLoad))
		            .retrieve()
		            .bodyToMono(Void.class);
		        
		    result.block();
	}

	@Override
	public void deletePost(int id) {
		String urlNew=url+"/"+Integer.toString(id);
		Mono<Void> result = theWebClientBuilder.build()
	            .delete()
	            .uri(urlNew)
	            .retrieve()
	            .bodyToMono(Void.class);
	        
	    result.block();
	}
	
	

}
