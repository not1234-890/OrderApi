package com.naceAPI.repository;
import com.naceAPI.model.Nace;
import com.naceAPI.model.Orders;
//repository that extends CrudRepository
public interface NaceRepository extends CrudRepository<Nace, Integer>
{

	Iterable<Nace> findAll();
	
}
