package com.alejandro.warehouses.repository;

import com.alejandro.warehouses.model.RacksType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacksTypeRepository extends CrudRepository<RacksType, Integer> {

   @Query("SELECT case WHEN (count(*) > 0)  THEN true ELSE false END FROM RacksType WHERE family = :family")
   Boolean existByFamily(String family);
   @Query("SELECT type FROM RacksType WHERE family = :family")
   List<String> findByFamily(String family);

   @Query("SELECT DISTINCT family FROM RacksType")
   List<String> getAllFamilies();
}
