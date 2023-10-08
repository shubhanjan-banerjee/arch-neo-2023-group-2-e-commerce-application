package com.archneo.ecommerce.service.impl;

import com.archneo.ecommerce.model.WishList;
import com.archneo.ecommerce.model.WishListId;
import com.archneo.ecommerce.repository.WishListRepository;
import com.archneo.ecommerce.service.WishListService;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WishListServiceImpl implements WishListService {

	
    private final WishListRepository wishListRepository;

    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }
    
    @Override
	public List<WishList> getAllWishList(Integer customerId, Pageable pageable) {
        return wishListRepository.findByCustomerId(customerId, pageable);
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
        wishListRepository.deleteAllByCustomerId(customerId);
	}
}
