package com.alejandro.warehouses.service;

import com.alejandro.warehouses.model.RacksType;
import com.alejandro.warehouses.repository.RacksTypeRepository;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RacksTypeServiceTest {

   @Autowired
   RacksTypeService thisService;

   @Autowired
   RacksTypeRepository thisRepository;

   @Test
   public void test_CreateRacksType(){
      int actualSize = ((Collection<?>) thisRepository.findAll()).size();

      RacksType racksType = new RacksType(1, "EST", "A");
      RacksType actual = thisRepository.save(racksType);
      ResponseEntity<RacksType> actualList =
          new ResponseEntity<>(actual, HttpStatus.OK);

      RacksTypeService mockService = mock(RacksTypeService.class);
      when(mockService.createRacksType(racksType)).thenReturn(actualList);

      RacksType racksType2 = new RacksType(2, "EST", "A");
      ResponseEntity<RacksType> expected = thisService.createRacksType(racksType2);
      int expectedSize = ((Collection<?>) thisRepository.findAll()).size();

      assertTrue(expectedSize > actualSize);
      assertTrue(expected.getBody() instanceof RacksType);
   }

   @Test
   public void test_getAllRacksType(){
      Collection<?> actual = (Collection<?>) thisRepository.findAll();

      RacksTypeService mockService = mock(RacksTypeService.class);
      when(mockService.getAllRacksType()).thenReturn( (ResponseEntity<List<RacksType>>) actual);

      ResponseEntity<List<RacksType>> expected = thisService.getAllRacksType();

      assertEquals(expected.getBody(), ((ResponseEntity<?>) actual).getBody());


   }

   @Test
   public void test_getRacksTypeByFamily(){
      RacksType racksType = new RacksType(1, "EST", "A");
      thisRepository.save(racksType);
      ResponseEntity<List<String>> actual =
          new ResponseEntity<>(new ArrayList<>(Arrays.asList("EST")), HttpStatus.OK);

      RacksTypeService mockService = mock(RacksTypeService.class);

      when(mockService.getRacksTypeByFamily("EST")).thenReturn(actual);

      ResponseEntity<List<String>> expected = thisService.getRacksTypeByFamily("EST");

      assertEquals(expected.getBody().size(), actual.getBody().size());
      assertEquals(expected.getBody().get(0), actual.getBody().get(0));
   }

}
