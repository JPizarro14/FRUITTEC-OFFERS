package com.aisatec.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aisatec.dao.OfferDAO;
import com.aisatec.model.Offer;
import com.aisatec.service.OfferService;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferDAO offerDAO;

	@Transactional(readOnly = true)
	public List<Offer> list() {
		Iterable<Offer> iterable = null;
		iterable = offerDAO.findAll();
		return (iterable != null ? StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList()) : null);
	}

	@Transactional(readOnly = true)
	public Offer get(Long id) {
		Offer offer = null;
		offer = offerDAO.findById(id).get();
		return offer;
	}

	@Transactional
	public void save(Offer offer) {
		offerDAO.save(offer);
	}

	@Transactional
	public void delete(Long id) {
		offerDAO.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Offer> findOffersByFruitName(String fruitName) {
		Iterable<Offer> iterable = null;
		iterable = offerDAO.findByFruitname(fruitName);
		return (iterable != null ? StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList()) : null);
	}

}
