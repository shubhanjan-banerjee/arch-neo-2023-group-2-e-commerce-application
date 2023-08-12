package com.archneo.ecommerce.service;

import java.util.List;

import com.archneo.ecommerce.model.Tracking;

public interface TrackingService {
	Tracking saveTracking(Tracking tracking);
	List<Tracking> getTrackings();
}
