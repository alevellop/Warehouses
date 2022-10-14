package com.alejandro.warehouses.controller;

import com.alejandro.warehouses.model.Permutation;
import com.alejandro.warehouses.service.PermutationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/permutations")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
public class PermutationController {

   @Autowired
   private PermutationService permutationService;

   @GetMapping()
   public ResponseEntity<List<Permutation>> getPermutations(){

      return this.permutationService.permutations();
   }
}
