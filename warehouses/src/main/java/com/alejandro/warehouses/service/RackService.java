package com.alejandro.warehouses.service;

import com.alejandro.warehouses.exception.ResourceNotFoundException;
import com.alejandro.warehouses.model.Rack;
import com.alejandro.warehouses.repository.RackRepository;
import com.alejandro.warehouses.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class RackService {

   @Autowired
   private RackRepository rackRepository;

   @Autowired
   private WarehouseRepository warehouseRepository;

   public ResponseEntity<List<Rack>> getAllRacksByWarehouse(Integer warehouseId){
      if(!warehouseRepository.existsById(warehouseId)){
         throw new ResourceNotFoundException("Not found warehouse with id = " + warehouseId);
      }

      List<Rack> _rackList = rackRepository.findByWarehouseId(warehouseId);

      return ResponseEntity.ok(_rackList);
   }

   public ResponseEntity<Rack> getRack(Integer id){
      Rack _rack = rackRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Not found rack with id = " + id));

      return ResponseEntity.ok(_rack);
   }

   public ResponseEntity<Rack> createRackByWarehouse(Integer warehouseId, Rack rack) {
      Rack _rack = warehouseRepository.findById(warehouseId).map(warehouse -> {
         rack.setWarehouse(warehouse);
         return rackRepository.save(rack);
      }).orElseThrow(() -> new ResourceNotFoundException("Not found warehouse with id = " + warehouseId));

      return new ResponseEntity<>(_rack, HttpStatus.CREATED);
   }

   public ResponseEntity<String> deleteRack(Integer id){

      if(!rackRepository.existsById(id)){
         throw new ResourceNotFoundException("Not found rack with id = " + id);
      }

      rackRepository.deleteById(id);
      return ResponseEntity.ok(null);
   }
}
