package com.SpringAPI.ApiIllustrationWebClient.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	String url="https://jsonplaceholder.typicode.com";
	StringBuilder theStringBuilder=new StringBuilder(url);
	@Override
	public Map<String, Object> getPostById(int id) {
		String urlNew=theStringBuilder.append("/posts/").append(id).toString();
		Map<String,Object> thePost=theWebClientBuilder.build().get().uri(urlNew).retrieve().bodyToMono(Map.class).block();
		return thePost;
	}

	@Override
	public List<Map> getPost() {
		String urlNew=theStringBuilder.append("/posts").toString();
		Flux<Map> postsFlux = theWebClientBuilder.build().get().uri(urlNew).retrieve().bodyToFlux(Map.class);

		List<Map> postList = postsFlux.collectList().block();
		return postList;
    }

	@Override
	public void insertPost(Map<String, Object> payLoad) {
		// TODO Auto-generated method stub
		String urlNew=theStringBuilder.append("/posts").toString();
		Mono<Void> result = theWebClientBuilder.build()
	            .post()
	            .uri(urlNew)
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(BodyInserters.fromValue(payLoad))
	            .retrieve()
	            .bodyToMono(Void.class);
	        
	        result.block(); 
	    }

	@Override
	public void updatePost(int id, Map<String, Object> payLoad) {
		String urlNew=theStringBuilder.append("/posts/").append(id).toString();
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
		String urlNew=theStringBuilder.append("/posts/").append(id).toString();
		Mono<Void> result = theWebClientBuilder.build()
	            .delete()
	            .uri(urlNew)
	            .retrieve()
	            .bodyToMono(Void.class);
	        
	    result.block();
	}
	
	

}
