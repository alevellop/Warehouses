package com.alejandro.warehouses.service;

import com.alejandro.warehouses.exception.ResourceNotFoundException;
import com.alejandro.warehouses.model.Rack;
import com.alejandro.warehouses.model.RacksType;
import com.alejandro.warehouses.model.Warehouse;
import com.alejandro.warehouses.repository.RacksTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class RacksTypeService {

   @Autowired
   private RacksTypeRepository racksTypeRepository;

   public ResponseEntity<List<RacksType>> getAllRacksType(){
      List<RacksType> _racksType = (List<RacksType>) racksTypeRepository.findAll();

      if(_racksType.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } else{
         return ResponseEntity.ok(_racksType);
      }
   }

   public ResponseEntity<List<String>> getRacksTypeByFamily(String family){

      if(!racksTypeRepository.existByFamily(family)){
         throw new ResourceNotFoundException("Not found warehouse's family with name = " + family);
      }

      List<String> _racksType = racksTypeRepository.findByFamily(family);

      return ResponseEntity.ok(_racksType);
   }

   public ResponseEntity<RacksType> createRacksType(RacksType racksType) {
      RacksType racksTypeToCreate = new RacksType();
      racksTypeToCreate.setType(racksType.getType());
      racksTypeToCreate.setFamily(racksType.getFamily());

      RacksType _racksType = racksTypeRepository.save(racksTypeToCreate);

      return new ResponseEntity<>(_racksType, HttpStatus.CREATED);
   }

   public ResponseEntity<String> deleteRacksType(Integer id){

      if(!racksTypeRepository.existsById(id)){
         throw new ResourceNotFoundException("Not found racksType with id = " + id);
      }

      racksTypeRepository.deleteById(id);
      return ResponseEntity.ok(null);
   }

   public ResponseEntity<List<String>> getAllFamilies(){
      List<String> _families = racksTypeRepository.getAllFamilies();

      return ResponseEntity.ok(_families);
   }
}
