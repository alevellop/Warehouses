package com.alejandro.warehouses.service;

import com.alejandro.warehouses.model.Permutation;
import com.alejandro.warehouses.repository.PermutationRepository;
import org.paukov.combinatorics3.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PermutationService implements PermutationRepository {

   @Autowired
   private RacksTypeService racksTypeService;

   @Override
   public ResponseEntity<List<Permutation>> permutations() {

      List<String> families = racksTypeService.getAllFamilies().getBody();
      List<Permutation> output = new ArrayList<>();

      families.forEach((family) -> {
                 List<String> typesList = racksTypeService.getRacksTypeByFamily(family).getBody();
                 List<String> permutationslist = new ArrayList<>();
                 Permutation permutation = new Permutation();

                 //library to get permutations
                 Generator
                     .permutation(typesList)
                     .withRepetitions(typesList.size())
                     .forEach((row) -> {
                        String combination = row.toString().replaceAll("[^a-zA-Z0-9]", " ");
                        permutationslist.add(combination);
                     });

               permutation.setFamily(family);
               permutation.setCombinations(permutationslist);
               output.add(permutation);
              });

      return ResponseEntity.ok(output);
   }
}
