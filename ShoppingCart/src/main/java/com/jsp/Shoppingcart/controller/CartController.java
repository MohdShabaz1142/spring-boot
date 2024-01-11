package com.jsp.Shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Shoppingcart.Response;
import com.jsp.Shoppingcart.entity.Cart;
import com.jsp.Shoppingcart.service.CartService;

@RestController
public class CartController
{
	@Autowired
	private CartService cs;

	@PostMapping("/savedata")
	public ResponseEntity<Response<Cart>> insert(@RequestBody Cart c){
		return cs.insert(c);
	}
	@PostMapping("/saveall")
	public ResponseEntity<Response<Cart>> insertAll(@RequestBody List<Cart> list){
		return cs.saveAll(list);	
	}

	@GetMapping("/findid/{id}")
	public ResponseEntity<Response<Cart>> find(@PathVariable int id){
		return cs.findById(id);
	}
	@GetMapping("/findall")
	public ResponseEntity<Response<Cart>> findall(){
		return cs.findAllObj();
	}
	@GetMapping("/findname/{name}")
	public ResponseEntity<Response<Cart>> find(@PathVariable String name){
		return cs.findByName(name);
	}
	@PutMapping("/updateall/{items}")
	public ResponseEntity<Response<Cart>> updateAll(@PathVariable int items){
		return cs.updateAllObj(items);
	}

	@PutMapping("/updatebyid/{id}/{name}")
	public  ResponseEntity<Response<Cart>> updateById(@PathVariable int id,@PathVariable String name){
		return cs.findById(id);
	}

	@PutMapping("/updatebyname/{name}/{items}")
	public ResponseEntity<Response<Cart>> updateByName(@PathVariable String name,@PathVariable int items){
		return cs.updateByName(name,items);
	}

	@DeleteMapping("/deleteall")
	public  ResponseEntity<Response<Cart>> deleteAll(){
		return cs.deleteAll();
	}
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Response<Cart>> deletebyId(@PathVariable int id){
		return cs.deleteById(id);
	}
	@DeleteMapping("/deletebyname/{name}")
	public ResponseEntity<Response<Cart>> deletebyName(@PathVariable String name){
		return cs.deleteByName(name);
	}



}



























































