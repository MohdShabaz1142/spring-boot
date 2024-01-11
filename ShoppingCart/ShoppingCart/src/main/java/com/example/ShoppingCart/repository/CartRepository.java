package com.example.ShoppingCart.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ShoppingCart.entity.Cart;

import jakarta.transaction.Transactional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> 
{
	
	@Query("select c from Cart c where c.cname Like %?1%")
	public List<Cart> fetchByCartCname(String cname);

	
	
	@Transactional
	@Modifying
	@Query("update Cart c set c.cname =:cname")
	public int UpdateAllCartcitems(@Param("cname") String cname);
	
	
	@Transactional
	@Modifying
	@Query("Update Cart c set c.cname=:cname where c.cid=:cid")
	public int updateCartByid(@Param("cid")int cid ,@Param("cname")String cname);
	
	
	@Transactional
	@Modifying
	@Query("Update Cart c set c.citems=:citems where c.cname=:cname")
	public int updateCartByname(@Param("cname")String cname ,@Param("citems")int citems);
	
	@Transactional
	@Modifying
	public void deleteCartBycname(String cname);
}
