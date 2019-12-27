package com.aisatec.service;

import java.util.List;

import com.aisatec.model.Offer;

public interface OfferService {
	List<Offer> list();
	Offer get(Long id);
	void save(Offer message);
	void delete(Long id);	
	List<Offer> findOffersByFruitName(String fruitName);
}
