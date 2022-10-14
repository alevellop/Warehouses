package com.alejandro.warehouses.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PermutationTest {

   Permutation permutation;

   @Test
   public void test_getters_setters_and_constructor(){
      permutation = new Permutation();
      List<String> combinations = new ArrayList<>();
      combinations.add("ABC");

      permutation.setFamily("EST");
      permutation.setCombinations(combinations);

      assertEquals(permutation.getFamily(), "EST");
      assertEquals(permutation.getCombinations().get(0), "ABC");
   }
}
