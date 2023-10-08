package com.archneo.ecommerce.service.impl;

import com.archneo.ecommerce.model.WishList;
import com.archneo.ecommerce.model.WishListId;
import com.archneo.ecommerce.repository.WishListRepository;
import com.archneo.ecommerce.service.WishListService;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class WishListServiceImpl implements WishListService {

	
    private final WishListRepository wishListRepository;

    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }
    
    @Override
	public Page<WishList> getAllWishList(MultiValueMap<String, String> params, Pageable pageable) {
        String customerId = params.getFirst("customerId");
        
        Specification<WishList> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            
            if (customerId != null) {
                predicates.add(criteriaBuilder.equal(root.get("customer").get("customerId"), customerId));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return wishListRepository.findAll(specification, pageable);
	}
    
	@Override
	public WishList createWishList(WishList wishList) {
		return wishListRepository.save(wishList);
	}

	@Override
	public void deleteWishList(int customerId, int productId) {
		wishListRepository.deleteById(new WishListId(customerId, productId));
	}

	
	@Override
	public void deleteAllWishList(int customerId) {
		// TODO Auto-generated method stub
        wishListRepository.deleteAllByCustomerId(customerId);
		
	}
}
