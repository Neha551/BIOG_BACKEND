package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ConfiguredPc;

public interface IConfiguredPCsRepository extends JpaRepository<ConfiguredPc, Integer> {

	//list all pc with price in the range of begin and end
		List<ConfiguredPc> findByPriceBetween(double begin,double end);
		
//		@Query("select p from ConfiguredPc p  = ?1")
	     List<ConfiguredPc> findByOrderByPriceAsc();
		 
		// @Query("select p from ConfiguredPc p where p.type = ?1") //aisa kaha use krte the jpql mein
		 List<ConfiguredPc> findByType(String type);

		// String jpql="select p from configured_pc p join fetch p.ram_memory ";  then?//yeh hhh
				 
		 
}
