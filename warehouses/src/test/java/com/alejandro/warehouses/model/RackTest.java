package com.alejandro.warehouses.model;

import org.junit.Before;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RackTest{

   Rack rack;

   Warehouse warehouse;

   @Test
   public void test_getters_and_constructor(){
      int id = 1;
      String uuid = "12345";
      String type = "A";

      Warehouse warehouse = new Warehouse(1, uuid, "Client A", "EST", 20, new ArrayList<>());

      rack = new Rack(id, uuid, type, warehouse);

      assertEquals(rack.getId(), 1);
      assertEquals(rack.getUuid(), "12345");
      assertEquals(rack.getType(), "A");
      assertEquals(rack.getWarehouse(), warehouse);
   }

   @Test
   public void test_setters_and_constructor(){
      int id = 1;
      String uuid = "12345";
      String type = "A";

      Warehouse warehouse = new Warehouse(1, uuid, "Client A", "EST", 20, new ArrayList<>());

      rack = new Rack();
      rack.setId(id);
      rack.setUuid(uuid);
      rack.setType(type);
      rack.setWarehouse(warehouse);

      assertEquals(rack.getId(), 1);
      assertEquals(rack.getUuid(), "12345");
      assertEquals(rack.getType(), "A");
      assertEquals(rack.getWarehouse(), warehouse);
   }
}
