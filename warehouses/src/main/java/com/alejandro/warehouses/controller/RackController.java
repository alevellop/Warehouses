package com.alejandro.warehouses.controller;

import com.alejandro.warehouses.model.Rack;
import com.alejandro.warehouses.service.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class RackController {

   @Autowired
   private RackService rackService;

   @GetMapping("/{warehouse_id}/racks")
   public ResponseEntity<List<Rack>> getAllRacksByWarehouseId(@PathVariable(value="warehouse_id") Integer warehouseId){
      return this.rackService.getAllRacksByWarehouse(warehouseId);
   }

   @GetMapping("/racks/{id}")
   public ResponseEntity<Rack> getRack(@PathVariable(value = "id") Integer id){
      return this.rackService.getRack(id);
   }

   @PostMapping("/{warehouse_id}/racks")
   public ResponseEntity<Rack> createRackByWarehouse(
       @PathVariable(value = "warehouse_id") Integer warehouseId,
       @RequestBody Rack rack)
   {
      return this.rackService.createRackByWarehouse(warehouseId, rack);
   }

   @DeleteMapping("/racks/{id}")
   public ResponseEntity<String> deleteRack(@PathVariable(value = "id") Integer id){
      return this.rackService.deleteRack(id);
   }
}
