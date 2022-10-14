package com.alejandro.warehouses.service;

import com.alejandro.warehouses.model.Permutation;
import com.alejandro.warehouses.model.RacksType;
import com.alejandro.warehouses.repository.PermutationRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PermutationServiceTest {

   @Mock
   RacksTypeService racksTypeService;

   @Mock
   PermutationRepository thisRepository;

   @InjectMocks
   PermutationService thisService;

   @Before
   public void setup(){
      MockitoAnnotations.openMocks(this);
   }

   @Test
   public void test_permutations(){
      racksTypeService.createRacksType(new RacksType(1, "EST", "A"));
      racksTypeService.createRacksType(new RacksType(2, "EST", "B"));
      racksTypeService.createRacksType(new RacksType(3, "EST", "C"));

      System.out.println("------------------------");
      System.out.println(racksTypeService.getAllRacksType().getBody());

      Permutation permutation = new Permutation("EST", new ArrayList<>(Arrays.asList("ABC")));
      ResponseEntity<List<Permutation>> actual =
          new ResponseEntity<>(new ArrayList<>(Arrays.asList(permutation)), HttpStatus.OK);

      when(thisService.permutations()).thenReturn(actual);

      ResponseEntity<List<Permutation>> expected = thisRepository.permutations();

      assertEquals(expected, actual);
   }
}
