package com.archneo.ecommerce.service;

import com.archneo.ecommerce.model.WishList;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WishListService {
    List<WishList> getAllWishList(Integer customerId, Pageable pageable);
    WishList createWishList(WishList wishList);
    void deleteWishList(int customerId, int productId);
    void deleteAllWishList(int customerId);
}
