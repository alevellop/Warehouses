package com.alejandro.warehouses.repository;

import com.alejandro.warehouses.model.Rack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RackRepository extends CrudRepository<Rack, Integer> {

   List<Rack> findByWarehouseId(Integer warehouseId);
}
