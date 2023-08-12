package com.archneo.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archneo.ecommerce.model.Tracking;
import com.archneo.ecommerce.service.TrackingService;

@RestController
@RequestMapping("/api/trackings")
public class TrackingController {
	
	private TrackingService trackingService;
	
	public TrackingController(TrackingService trackingService) {
		super();
		this.trackingService = trackingService;
	}

	// create product REST API
	@PostMapping()
	public ResponseEntity<Tracking> saveProduct(@RequestBody Tracking tracking){
		return new ResponseEntity<Tracking>(trackingService.saveTracking(tracking), HttpStatus.CREATED);
	}

	// get all products REST API
	@GetMapping
	public List<Tracking> getAllProducts(){
		return trackingService.getTrackings();
	}

}
