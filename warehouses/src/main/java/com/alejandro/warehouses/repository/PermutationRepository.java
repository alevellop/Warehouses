package com.alejandro.warehouses.repository;

import com.alejandro.warehouses.model.Permutation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PermutationRepository {

   ResponseEntity<List<Permutation>> permutations();
}
