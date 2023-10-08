package com.archneo.ecommerce.service;

import com.archneo.ecommerce.model.WishList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

public interface WishListService {
    Page<WishList> getAllWishList(MultiValueMap<String, String> params, Pageable pageable);
    WishList createWishList(WishList wishList);
    void deleteWishList(int customerId, int productId);
    void deleteAllWishList(int customerId);
}
