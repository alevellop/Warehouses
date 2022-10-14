package com.alejandro.warehouses.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WarehouseTest {

   Rack rack;

   Warehouse warehouse;

   @Test
   public void test_getters_and_constructor(){
      Warehouse warehouse = new Warehouse(1, "12345", "Client A", "EST", 20, new ArrayList<>());

      assertEquals(warehouse.getId(), 1);
      assertEquals(warehouse.getUuid(), "12345");
      assertEquals(warehouse.getFamily(), "EST");
      assertEquals(warehouse.getClient(), "Client A");
      assertEquals(warehouse.getSize(), 20);
      assertEquals(warehouse.getRacks().getClass(), ArrayList.class);
   }

   @Test
   public void test_setters_and_constructor(){
      Warehouse warehouse = new Warehouse();

      warehouse.setRacks(new ArrayList<>());
      warehouse.setId(1);
      warehouse.setFamily("EST");
      warehouse.setUuid("12345");
      warehouse.setClient("Client A");
      warehouse.setSize(20);

      assertEquals(warehouse.getId(), 1);
      assertEquals(warehouse.getUuid(), "12345");
      assertEquals(warehouse.getFamily(), "EST");
      assertEquals(warehouse.getSize(), 20);
      assertEquals(warehouse.getRacks().getClass(), ArrayList.class);
   }
}
