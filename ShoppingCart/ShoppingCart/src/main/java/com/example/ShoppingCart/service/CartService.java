
package com.example.ShoppingCart.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ShoppingCart.Response.Response;
import com.example.ShoppingCart.entity.Cart;
import com.example.ShoppingCart.exceptionhandling.CartNotFoundException;
import com.example.ShoppingCart.repository.CartRepository;

@Service
public class CartService 
{
	@Autowired
	CartRepository repo;

	
	
	public ResponseEntity<Response<Cart>> insert(Cart c) 
	{
		Response<Cart>rs =new Response<>();
		Cart c1 = repo.save(c);

		if(c1!=null)
		{
			rs.setStatuscode(HttpStatus.CREATED.value());
			rs.setMessage("data saved succesfully");
			rs.setData(c1);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.CREATED);		
		}
		else
		{
			rs.setStatuscode(HttpStatus.CREATED.value());
			rs.setMessage("data cannot be saved");
			rs.setData(null);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
	}

	public ResponseEntity<Response<Cart>> insertall(List<Cart> clist) 
	{
		Response<Cart>rs =new Response<>();
		List<Cart> list =(List<Cart>) repo.saveAll(clist);

		if(list!=null)
		{
			rs.setStatuscode(HttpStatus.CREATED.value());
			rs.setMessage("data saved succesfully");
			rs.setList(list);

			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.CREATED);		
		}
		else
		{
			rs.setStatuscode(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
			rs.setMessage("data cannot be saved");
			rs.setList(null);

			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
	}

	public ResponseEntity<Response<Cart>> fetchall()
	{
		Response<Cart>rs =new Response<>();
		List<Cart> clist = (List<Cart>)repo.findAll();
		if(!clist.isEmpty())
		{
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setMessage("all data fetched");
			rs.setList(clist);

			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.FOUND);
		}
		else
		{
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMessage("could not fetch  data ");
			rs.setList(null);

			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Response<Cart>> fetchbyid(int cid)
	{
		Response<Cart>rs =new Response<>();
		Optional<Cart> findById =repo.findById(cid);
		if(findById.isPresent())
		{
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setMessage("object found with this id");
			rs.setData(findById.get());
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.FOUND);
		}
		else
		{
			throw new CartNotFoundException("student not found");
		}
	}

	public ResponseEntity<Response<Cart>>fetchbyname(String  cname)
	{
		Response<Cart>rs =new Response<>();
		List<Cart> fetchByCartCname = repo.fetchByCartCname(cname);

		if(!fetchByCartCname.isEmpty())
		{
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setMessage("data found");
			rs.setList(fetchByCartCname);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NOT_FOUND);
		}
		else
		{
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMessage("data not found with the name");
			rs.setList(null);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<Response<Cart>> updateall(String cname)
	{
		Response<Cart>rs =new Response<>();
		int updateAllCartcitems = repo.UpdateAllCartcitems(cname);

		if(updateAllCartcitems>0)
		{
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMessage("data updated for all these "+updateAllCartcitems );
			rs.setData(null);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.OK);
		}
		else
		{
			rs.setStatuscode(HttpStatus.NOT_MODIFIED.value());
			rs.setMessage("data is  not updated ");
			rs.setList(null);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NOT_MODIFIED);
		}

	}
	public ResponseEntity<Response<Cart>> updatebyid(int cid,String cname)
	{
		Response<Cart>rs =new Response<>();
		int updateCartByid = repo.updateCartByid(cid, cname);

		if(updateCartByid==1)
		{
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMessage("Cart updated with the id:"+cid);
			rs.setData(null);
			return new  ResponseEntity<Response<Cart>>(rs,HttpStatus.OK);
		}
		else
		{
			rs.setStatuscode(HttpStatus.NOT_MODIFIED.value());
			rs.setMessage("data not updated");
			rs.setData(null);

			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NOT_MODIFIED);
		}
	}

	public ResponseEntity<Response<Cart>>updatebyname(String cname,int citems)
	{
		Response<Cart>rs =new Response<>();
		int updateCartByname = repo.updateCartByname(cname, citems);
		if(updateCartByname==1)
		{
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMessage(cname+ "updated to "+citems);
			rs.setData(null);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.OK);
		}
		else
		{
			rs.setStatuscode(HttpStatus.NOT_MODIFIED.value());
			rs.setMessage("data could not be modified");
			rs.setData(null);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NOT_MODIFIED);
		}
	}
	
	public ResponseEntity<Response<Cart>>deleteall()
	{
		Response<Cart>rs =new Response<>();
		List<Cart> clist =(List<Cart>)repo.findAll();
		if(!clist.isEmpty())
		{
			repo.deleteAll();
			rs.setStatuscode(HttpStatus.GONE.value());
			rs.setMessage("data deleted succesfully");
			rs.setData(null);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.GONE);
		}
		else
		{
			rs.setStatuscode(HttpStatus.NO_CONTENT.value());
			rs.setMessage("could not delete data");
			rs.setData(null);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NO_CONTENT);
		}

	}
	public ResponseEntity<Response<Cart>>deletebyid(int cid)
	{
		Response<Cart>rs =new Response<>();
		List<Cart> clist =(List<Cart>) repo.findAll();
		if(!clist.isEmpty())
		{
			repo.deleteById(cid);
			rs.setStatuscode(HttpStatus.GONE.value());
			rs.setMessage("item deleted with id:"+cid);

			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.GONE);
		}
		else
		{
			rs.setStatuscode(HttpStatus.NO_CONTENT.value());
			rs.setMessage("no data to delete");

			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NO_CONTENT);
		}
	}
	public ResponseEntity<Response<Cart>>deletebyname(String cname)
	{
		Response<Cart>rs =new Response<>();
		List<Cart> clist =(List<Cart>) repo.findAll();
		if(!clist.isEmpty())
		{
			repo.deleteCartBycname(cname);
			rs.setStatuscode(HttpStatus.GONE.value());
			rs.setMessage("item deleted with name:"+cname);
			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.GONE);
		}
		else
		{
			rs.setStatuscode(HttpStatus.NO_CONTENT.value());
			rs.setMessage("no data to delete");

			return new ResponseEntity<Response<Cart>>(rs,HttpStatus.NO_CONTENT);
		}
	}
}
