package com.orderAPI.repository;
import com.orderAPI.model.Orders;
//repository that extends CrudRepository
public interface OrderRepository extends CrudRepository<Orders, Integer>
{

	Iterable<Orders> findAll();
}
