package com.archneo.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.archneo.ecommerce.model.Tracking;
import com.archneo.ecommerce.repository.TrackingRepository;
import com.archneo.ecommerce.service.TrackingService;

@Service
public class TrackingServiceImpl implements TrackingService {
	
	private TrackingRepository trackingRepository;

	public TrackingServiceImpl(TrackingRepository trackingRepository) {
		super();
		this.trackingRepository = trackingRepository;
	}

	@Override
	public Tracking saveTracking(Tracking tracking) {
		System.out.println("tracking");
		return trackingRepository.save(tracking);
	}

	@Override
	public List<Tracking> getTrackings() {
		return trackingRepository.findAll();
	}

	
}
