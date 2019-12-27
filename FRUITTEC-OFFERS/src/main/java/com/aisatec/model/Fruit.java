package com.aisatec.model;

public class Fruit {

	private long fruitId;
	
	private String fruitname;
	
	public Fruit() {
		super();
	}
	
	public Fruit(Long fruitId, String fruitName) {
		this.fruitId = fruitId;
		this.fruitname = fruitName;
	}

	public Long getId() {
		return fruitId;
	}

	public void setId(Long fruitId) {
		this.fruitId = fruitId;
	}

	public String getFruitName() {
		return fruitname;
	}

	public void setFruitName(String fruitName) {
		this.fruitname = fruitName;
	}
	
	
	
}
