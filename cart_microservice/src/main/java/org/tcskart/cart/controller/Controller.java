package org.tcskart.cart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tcskart.cart.bean.Cart;
import org.tcskart.cart.bean.CartDTO;
import org.tcskart.cart.bean.CartItem;
import org.tcskart.cart.bean.CartWishlist;
import org.tcskart.cart.service.CartService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/carts")
public class Controller {
	
	@Autowired
	CartService service;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/{userid}/viewcart") //To view cart
	public Optional<Cart> getUserCart(@PathVariable long userid){
		return service.getUserCart(userid);
	}
	
	@GetMapping("/{userid}/wishlist")
	public List<CartWishlist> getWishlist(@PathVariable long userid ) {
		return service.findWishlistByUserId(userid);
	}
	
	@PostMapping("/{userid}/placeorder")
	public List<CartDTO> placeOrder(@PathVariable long userid){
		return service.placeOrder(userid);		  
	}
	
//	@GetMapping("/{userid}/viewcart/viewitems") //To show only the added cart items 
//	public List<CartItem> getCartItems(@PathVariable long userid){
//		return service.getCartItems(userid);
//	}
	
	@PostMapping("/{userid}/additems") //Add item to cart
	public String addToCart(@PathVariable Long userid,@RequestBody CartItem item) {   //notworking
		return service.addToCart(userid,item); 
	}
	
	@PostMapping("/{userid}/wishlist/additems")
	public String addToWishlist(@PathVariable Long userid,@RequestBody CartDTO item ) {
		service.addToWishlist(userid, item);
		return "Item Added to the wishlist";
	}
	@DeleteMapping("/{userid}/wishlist/clearitems")
	public String deleteWishlist(@PathVariable Long userid) {
		service.clearWishList(userid);
		return "Wishlist cleared";
	}
	
	@DeleteMapping("/{userid}/deleteitems/{productid}") //delete an entire item from cart
	public String deleteFromCart(@PathVariable Long userid,@PathVariable Long productid) {
		return service.deleteItem(userid,productid);
	}
	
	@PutMapping("/{userid}/reduceitems/{productid}") // - reduce button implementation
	public String reduceItemsFromCart(@PathVariable Long userid,@PathVariable Long productid) {
		return service.deleteItemButton(userid, productid);
	}
	@PutMapping("/{userid}/increaseitems/{productid}") // + reduce button implementation
	public String increaseItemsFromCart(@PathVariable Long userid,@PathVariable Long productid) {
		return service.addItemButton(userid, productid);
	}
	
	
}
