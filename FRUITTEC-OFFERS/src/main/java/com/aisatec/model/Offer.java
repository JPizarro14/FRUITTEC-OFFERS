package com.aisatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "OFFER")
public class Offer {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Offer Id", required = true)
	@NotNull
	private long offerId;
	
	@Column(name = "NAME", nullable = false, unique = true)
	@ApiModelProperty(notes = "Fruit Name", required = true)
	@NotNull
	private String fruitname;
	
	@Column(name = "OFFER", nullable = false, unique = true)
	@ApiModelProperty(notes = "Offer amount", required = true)
	@NotNull
	private String offer;
	
	public Offer() {
		super();
	}
	
	public Offer(Long offerId, String fruitName, String offer) {
		this.offerId = offerId;
		this.fruitname = fruitName;
		this.offer = offer;
	}

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	public String getFruitname() {
		return fruitname;
	}

	public void setFruitname(String fruitname) {
		this.fruitname = fruitname;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	
	
}
