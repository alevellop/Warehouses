package com.alejandro.warehouses.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RacksTypeTest {

   RacksType racksType;

   @Test
   public void test_getters_setters_and_constructor(){
      racksType = new RacksType();

      racksType.setId(1);
      racksType.setFamily("EST");
      racksType.setType("A");

      assertEquals(racksType.getId(), 1);
      assertEquals(racksType.getFamily(), "EST");
      assertEquals(racksType.getType(), "A");
   }
}
