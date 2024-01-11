
package com.example.ShoppingCart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShoppingCart.Response.Response;
import com.example.ShoppingCart.entity.Cart;
import com.example.ShoppingCart.exceptionhandling.CartNotFoundException;
import com.example.ShoppingCart.service.CartService;

@RestController
public class CartContoller
{
	@Autowired
	CartService cserv;
	

	
	@PostMapping("/save")
	public ResponseEntity<Response<Cart>> insert(@RequestBody Cart c )
	{

		ResponseEntity<Response<Cart>> insert = cserv.insert(c);
		return insert;
	}

	@PostMapping("/saveall")
	public ResponseEntity<Response<Cart>> insertall(@RequestBody List<Cart>list)
	{
		ResponseEntity<Response<Cart>> insertall = cserv.insertall(list);
		return insertall;
	}

	@GetMapping("/fetchall")
	public ResponseEntity<Response<Cart>>fetchall()
	{
		ResponseEntity<Response<Cart>> fetchall = cserv. fetchall();
		return fetchall;
	}

	@GetMapping("/fetchbyid/{cid}")
	public ResponseEntity<Response<Cart>> fetchbyid(@PathVariable int cid)
	{
		ResponseEntity<Response<Cart>> fetchbyid = cserv.fetchbyid(cid);
		return fetchbyid;
	}

	@GetMapping("/fetchbyname/{cname}")
	public ResponseEntity<Response<Cart>> fetchbyname(@PathVariable String cname)
	{
		ResponseEntity<Response<Cart>> fetchbyname = cserv.fetchbyname(cname);
		return fetchbyname;
	}

	@PutMapping("/updateall/{cname}")
	public ResponseEntity<Response<Cart>>updateall(@PathVariable String cname)
	{
		ResponseEntity<Response<Cart>> updateall = cserv.updateall(cname);
		return updateall;
	}
	@PutMapping("/updatebyid/{cid}/{cname}")
	public ResponseEntity<Response<Cart>> updatebyid(@PathVariable int cid,@PathVariable String cname)
	{
		ResponseEntity<Response<Cart>> updatebyid = cserv.updatebyid(cid, cname);
		return  updatebyid;
	}

	@PutMapping("/updatebyname/{cname}/{citems}")
	public ResponseEntity<Response<Cart>>updatebyname(@PathVariable String cname,@PathVariable int citems)
	{
		ResponseEntity<Response<Cart>> updatebyname = cserv.updatebyname(cname, citems);
		return updatebyname;
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<Response<Cart>>deleteall()
	{
		ResponseEntity<Response<Cart>> deleteall = cserv.deleteall();
		return deleteall;
	}
	
	@DeleteMapping("/deletebyid/{cid}")
	public ResponseEntity<Response<Cart>>deletebyid(@PathVariable int cid)
	{
		ResponseEntity<Response<Cart>> deletebyid = cserv.deletebyid(cid);
		return deletebyid;
	}
	
	@DeleteMapping("/deletbyname/{cname}")
	public ResponseEntity<Response<Cart>>deleteByname(@PathVariable String cname)
	{
		ResponseEntity<Response<Cart>> deletebyname = cserv.deletebyname(cname);
		return deletebyname;
	}
}
