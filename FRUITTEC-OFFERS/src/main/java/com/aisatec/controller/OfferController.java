package com.aisatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisatec.model.Offer;
import com.aisatec.service.OfferService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/Offer")
@Api (value = "Offers Microservice", description = "This API has a CRUD for offers")
public class OfferController {

	@Autowired
    private OfferService offerService;
	
	@GetMapping("/offers")
	@ApiOperation(value = "Find all offers", notes ="Returns all offers")
	public List getOffers() {
		return offerService.list();
	}

	@GetMapping("/offer/{id}")
	@ApiOperation(value = "Find a offer", notes ="Returns a offer by Id")
	public ResponseEntity getOffer(@PathVariable("id") Long id) {
		Offer offer = null;
		offer = offerService.get(id);
		if (offer == null) {
			return new ResponseEntity("No offer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(offer, HttpStatus.OK);
	}

	@PostMapping(value = "/offer")
	@ApiOperation(value = "Create an offer", notes ="Returns a new offer")
	public ResponseEntity createOffer(@RequestBody Offer offer) {
		offerService.save(offer);
		return new ResponseEntity(offer, HttpStatus.OK);
	}

	@DeleteMapping("/offer/{id}")
	@ApiOperation(value = "Delete an offer", notes ="Returns deleted offer id")
	public ResponseEntity deleteOffer(@PathVariable Long id) {
		offerService.delete(id);
		return new ResponseEntity(id, HttpStatus.OK);
	
	}

	@PutMapping("/offer/{id}")
	@ApiOperation(value = "Update an offer", notes ="Returns updated offer")
	public ResponseEntity updateOffer(@RequestBody Offer offer) {
		offerService.save(offer);
		return new ResponseEntity(offer, HttpStatus.OK);
	}

	@GetMapping("/offersFruitName/{fruitName}")
	@ApiOperation(value = "Find offers", notes ="Returns all offers by fruitName")
	public List getOffersByFruitName(String fruitName) {
		return offerService.findOffersByFruitName(fruitName);
	}
	
}