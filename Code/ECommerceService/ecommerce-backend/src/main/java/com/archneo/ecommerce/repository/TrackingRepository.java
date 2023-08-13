package com.archneo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archneo.ecommerce.model.Tracking;

public interface TrackingRepository extends JpaRepository<Tracking, Integer> {
    // Define custom query methods if needed
}
