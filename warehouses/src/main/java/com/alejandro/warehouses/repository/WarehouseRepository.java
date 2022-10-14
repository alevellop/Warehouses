package com.alejandro.warehouses.repository;

import com.alejandro.warehouses.model.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {

}
