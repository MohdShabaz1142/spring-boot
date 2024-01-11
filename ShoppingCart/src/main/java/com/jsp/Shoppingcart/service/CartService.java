package com.jsp.Shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Shoppingcart.Response;
import com.jsp.Shoppingcart.CustomException.CartNotFoundException;
import com.jsp.Shoppingcart.CustomException.CartNotFoundWithName;
import com.jsp.Shoppingcart.entity.Cart;
import com.jsp.Shoppingcart.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cr;


	public ResponseEntity<Response<Cart>> insert(Cart c) {
		Cart c1 = cr.save(c);
		Response<Cart> rc = new Response<>();

		if (c1 != null) {
			

			rc.setStatusCode(HttpStatus.CREATED.value());
			rc.setMessage("Data Saved Successfully");
			rc.setData(c1);

			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.CREATED);
		} else {
			rc.setStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
			rc.setMessage("Data Cannot Be Empty");
			rc.setData(null);

			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}

	}

	public ResponseEntity<Response<Cart>> saveAll(List<Cart> list) {
		List<Cart> li = (List<Cart>) cr.saveAll(list);
		Response<Cart> rc = new Response<>();
		if (!li.isEmpty()) {
			rc.setStatusCode(HttpStatus.ACCEPTED.value());
			rc.setMessage("Saved All The Data");
			rc.setList(li);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.ACCEPTED);

		} else {
			rc.setStatusCode(HttpStatus.BAD_REQUEST.value());
			rc.setMessage("Saved All The Data");
			rc.setList(null);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Response<Cart>> findById(int id) {
		Optional<Cart> ob = cr.findById(id);
		 Response<Cart> rc = new Response<>();
		if (ob.isPresent()) {
			rc.setStatusCode(HttpStatus.FOUND.value());
			rc.setMessage("Data Found");
			rc.setExceptionData(null);
			rc.setData(ob.get());
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.FOUND);
		} else {
			throw new CartNotFoundException("Cart not Found");
		}
	}

	public ResponseEntity<Response<Cart>> findAllObj() {
		List<Cart> li = (List<Cart>) cr.findAll();
		Response<Cart> rc = new Response<>();
		if (!li.isEmpty()) {
			rc.setStatusCode(HttpStatus.FOUND.value());
			rc.setMessage("List Of Data Found Successfully");
			rc.setList(li);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.FOUND);
		} else {
			rc.setStatusCode(HttpStatus.NO_CONTENT.value());
			rc.setMessage("No Data Found In The DataBase");
			rc.setList(null);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.NO_CONTENT);
		}

	}

	public ResponseEntity<Response<Cart>> findByName(String name) {

		List<Cart> cart = cr.findByCname(name);
		Response<Cart> rc = new Response<>();

		if (!cart.isEmpty()) {
			rc.setStatusCode(HttpStatus.FOUND.value());
			rc.setList(cart);
			rc.setMessage("Data Found");
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.FOUND);
		} else {
			throw new CartNotFoundWithName("Cart Not Found");
		}

	}

	public ResponseEntity<Response<Cart>> updateAllObj(int items) {

		int rows = cr.update(items);
		Response<Cart> rc = new Response<>();

		if (rows >= 1) {
			rc.setStatusCode(HttpStatus.OK.value());
			rc.setMessage("All data Updated Successfully");
			rc.setList(null);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.OK);
		} else {
			rc.setStatusCode(HttpStatus.NOT_IMPLEMENTED.value());
			rc.setMessage("Data Cannot be Updated");
			rc.setList(null);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.NOT_IMPLEMENTED);
		}
	}

	public ResponseEntity<Response<Cart>> updateById(int id, String name) {
		int rows = cr.updateById(id, name);
		Response<Cart> rc = new Response<>();

		if (rows == 1) {
			rc.setStatusCode(HttpStatus.ACCEPTED.value());
			rc.setMessage("Updated");
			rc.setData(null);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.ACCEPTED);
		} else {
			rc.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			rc.setMessage("Cannot be Updated");
			rc.setData(null);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	public ResponseEntity<Response<Cart>> updateByName(String name, int items) {

		int rows = cr.upbyName(name, items);
		Response<Cart> rc = new Response<>();

		if (rows >= 1) {
			rc.setStatusCode(HttpStatus.OK.value());
			rc.setMessage("Updated rows :" + rows);
			rc.setList(null);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.OK);
		} else {
			rc.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			rc.setMessage("Not Updated");
			rc.setList(null);
			return new ResponseEntity<Response<Cart>>(rc, HttpStatus.NOT_ACCEPTABLE);
		}

	}

	public ResponseEntity<Response<Cart>> deleteAll() {
		cr.deleteAll();
		Response<Cart> rc = new Response<>();

		rc.setMessage("Deleted All records Succesfully");
		rc.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<Response<Cart>>(rc, HttpStatus.OK);
	}

	public ResponseEntity<Response<Cart>> deleteById(int id) {
		cr.deleteById(id);
		Response<Cart> rc = new Response<>();

		rc.setStatusCode(HttpStatus.OK.value());
		rc.setMessage("Object Successfully Deleted");
		return new ResponseEntity<Response<Cart>>(rc, HttpStatus.OK);
	}

	public ResponseEntity<Response<Cart>> deleteByName(String name) {

		cr.deleteBycName(name);
		Response<Cart> rc = new Response<>();

		rc.setStatusCode(HttpStatus.OK.value());
		rc.setMessage("Deleted SuccessFully");

		return new ResponseEntity<Response<Cart>>(rc, HttpStatus.OK);
	}

}
