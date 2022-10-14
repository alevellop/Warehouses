package com.alejandro.warehouses.service;

import com.alejandro.warehouses.exception.ResourceNotFoundException;
import com.alejandro.warehouses.model.Warehouse;
import com.alejandro.warehouses.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseService {

   @Autowired
   private WarehouseRepository warehouseRepository;


   public ResponseEntity<List<Warehouse>> getAllWarehouses(){
      List<Warehouse> _warehouseList = (List<Warehouse>) warehouseRepository.findAll();

      if(_warehouseList.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } else{
         return ResponseEntity.ok(_warehouseList);
      }
   }

   public ResponseEntity<Warehouse> getWarehouse(Integer id){
      Warehouse _warehouse = warehouseRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Not found warehouse with id = " + id));

      return ResponseEntity.ok(_warehouse);
   }

   public ResponseEntity<String> deleteWarehouse(Integer id){
      if(!warehouseRepository.existsById(id)){
         throw new ResourceNotFoundException("Not found warehouse with id = " + id);
      }

      warehouseRepository.deleteById(id);
      return ResponseEntity.ok(null);
   }

   public ResponseEntity<Warehouse> updateWarehouse(Integer id, Warehouse warehouse){
      Warehouse warehouseToUpdate = warehouseRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Not found warehouse with id = " + id));

      warehouseToUpdate.setUuid(warehouse.getUuid());
      warehouseToUpdate.setSize(warehouse.getSize());
      warehouseToUpdate.setFamily(warehouse.getFamily());
      warehouseToUpdate.setClient(warehouse.getClient());
      warehouseToUpdate.setRacks(warehouse.getRacks());

      Warehouse _warehouse = warehouseRepository.save(warehouseToUpdate);

      return ResponseEntity.ok(warehouseToUpdate);
   }

   public ResponseEntity<Warehouse> createWarehouse(Warehouse warehouse){
      Warehouse warehouseToCreate =  new Warehouse();
      warehouseToCreate.setClient(warehouse.getClient());
      warehouseToCreate.setUuid(warehouse.getUuid());
      warehouseToCreate.setSize(warehouse.getSize());
      warehouseToCreate.setFamily(warehouse.getFamily());
      warehouseToCreate.setRacks(new ArrayList<>());

      Warehouse _warehouse = warehouseRepository.save(warehouseToCreate);

      return new ResponseEntity<>(_warehouse, HttpStatus.CREATED);
   }
}
