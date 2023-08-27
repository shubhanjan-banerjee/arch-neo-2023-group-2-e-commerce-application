package com.archneo.ecommerce.controller;

import com.archneo.ecommerce.model.Cart;
import com.archneo.ecommerce.service.CartService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Page<Cart> getAllCarts(@RequestParam MultiValueMap<String, String> params) {
        int pageNumber = params.containsKey("page") ? Integer.parseInt(params.getFirst("page")) : 0;
        int pageSize = params.containsKey("size") ? Integer.parseInt(params.getFirst("size")) : 10;
        String sortField = params.containsKey("sort") ? params.getFirst("sort") : "cartId";
        Sort.Direction sortDirection = params.containsKey("order") && params.getFirst("order").equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField));

        return cartService.getAllCarts(params, pageable);
    }

    @GetMapping("/{cartId}")
    public Cart getCartById(@PathVariable int cartId) {
        return cartService.getCartById(cartId);
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @PutMapping("/{cartId}")
    public Cart updateCart(@PathVariable int cartId, @RequestBody Cart cart) {
        return cartService.updateCart(cartId, cart);
    }

    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable int cartId) {
        cartService.deleteCart(cartId);
    }
}
