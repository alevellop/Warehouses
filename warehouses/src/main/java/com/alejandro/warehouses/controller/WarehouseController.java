package com.alejandro.warehouses.controller;

import com.alejandro.warehouses.model.Warehouse;
import com.alejandro.warehouses.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/warehouses")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class WarehouseController {

   @Autowired
   private WarehouseService warehouseService;

   @GetMapping()
   public ResponseEntity<List<Warehouse>> getAllWarehouses(){
      return this.warehouseService.getAllWarehouses();
   }

   @GetMapping(path = "/{id}")
   public ResponseEntity<Warehouse> getWarehouse(@PathVariable("id") Integer id){
      return this.warehouseService.getWarehouse(id);
   }

   @PutMapping(path="/{id}")
   public ResponseEntity<Warehouse> editWarehouse(@PathVariable("id") Integer id, @RequestBody Warehouse warehouse){
      return this.warehouseService.updateWarehouse(id, warehouse);
   }

   @DeleteMapping(path = "/{id}")
   public ResponseEntity<String> deleteWarehouse(@PathVariable("id") Integer id){
      return this.warehouseService.deleteWarehouse(id);
   }

   @PostMapping()
   public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse){
      return this.warehouseService.createWarehouse(warehouse);
   }

}
