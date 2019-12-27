package com.aisatec.communication;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.aisatec.model.Fruit;

public class Producer {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	Fruit getFruit(String fruitname) {
		Fruit fruit = new Fruit(0L, fruitname);
		
		URI url = null;
		try {
			url = new URI("http://localhost:8092/FruitController/fruitName/" + fruitname);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		ResponseEntity<Fruit> fruitResponse = restTemplate.postForEntity(url, fruit, Fruit.class);
		if (HttpStatus.OK.equals(fruitResponse.getStatusCode())) {
			fruit = fruitResponse.getBody();
		} else {
			fruit = null;
		}
		return fruit;
		
	}
}
