package com.archneo.ecommerce.controller;

import com.archneo.ecommerce.model.WishList;
import com.archneo.ecommerce.service.impl.WishListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/wishlists")
public class WishlistController {

    @Autowired
    private final WishListServiceImpl wishlistService;

    public WishlistController(WishListServiceImpl wishlistService) {
        this.wishlistService = wishlistService;
    }

    // create add wishlist REST API
    @PostMapping("/saveWishlist")
    public ResponseEntity<WishList> saveWishlist(@RequestBody WishList wishlist){
        return new ResponseEntity<WishList>(wishlistService.createWishList(wishlist), HttpStatus.CREATED);
    }

    // get all wishlists REST API
    @GetMapping("/getAllWishlists")
        public ResponseEntity<List<WishList>> getAllWishlists(@RequestParam(name = "customerId", required = true) Integer customerId){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("productId").descending());
        return new ResponseEntity<>(wishlistService.getAllWishList(customerId,pageable), HttpStatus.OK);
    }


    // delete wishlist REST API
    @DeleteMapping("/deleteWishlist")
    public ResponseEntity<String> deleteWishlist(@RequestParam int customerId, @RequestParam int productId){
        // delete wishlist from DB
        wishlistService.deleteWishList(customerId, productId);
        return new ResponseEntity<String>("Wishlist deleted successfully!", HttpStatus.OK);
    }
}
