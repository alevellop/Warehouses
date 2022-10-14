package com.alejandro.warehouses.controller;

import com.alejandro.warehouses.model.Rack;
import com.alejandro.warehouses.model.RacksType;
import com.alejandro.warehouses.service.RackService;
import com.alejandro.warehouses.service.RacksTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/racks-type")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class RacksTypeController {

   @Autowired
   private RacksTypeService racksTypeService;

   @GetMapping()
   public ResponseEntity<List<RacksType>> getAllRacksType(){
      return this.racksTypeService.getAllRacksType();
   }

   @GetMapping("/{family}")
   public ResponseEntity<List<String>> getRacksTypeByFamily(@PathVariable(name = "family") String family){
      return this.racksTypeService.getRacksTypeByFamily(family);
   }

   @GetMapping("/families")
   public ResponseEntity<List<String>> getAllFamilies(){
      return this.racksTypeService.getAllFamilies();
   }

   @PostMapping()
   public ResponseEntity<RacksType> createRacksType(@RequestBody RacksType racksType)
   {
      return this.racksTypeService.createRacksType(racksType);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteRacksType(@PathVariable(value = "id") Integer id){
      return this.racksTypeService.deleteRacksType(id);
   }
}
