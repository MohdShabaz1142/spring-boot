package com.jsp.Shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.Shoppingcart.entity.Cart;

import jakarta.transaction.Transactional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>
{
	@Query("select c from Cart c where c.cName=:cName")
	public List<Cart> findByCname(@Param("cName") String name);
	
	@Transactional
	@Modifying
	@Query("update Cart c set c.cItems=:cItems")
	public int update(@Param("cItems") int cItems);
	
	@Transactional
	@Modifying
	@Query("update Cart c set c.cName=:name where c.cId=:id")
	public int updateById(@Param("id") int id,@Param("name") String name); 
	
	@Transactional
	@Modifying
	@Query("update Cart C set C.cItems=:cItems where C.cName=:cName")
	public int upbyName(@Param("cName") String name,@Param("cItems") int items);
	
	@Transactional
	@Modifying
	public void deleteBycName(String name);
}





