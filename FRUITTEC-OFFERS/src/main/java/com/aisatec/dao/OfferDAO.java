package com.aisatec.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aisatec.model.Offer;

@Repository
public interface OfferDAO extends CrudRepository<Offer, Long> {

	List<Offer> findByFruitname(String fruitName);
	
}
