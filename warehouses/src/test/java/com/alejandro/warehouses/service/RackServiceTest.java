package com.alejandro.warehouses.service;

import com.alejandro.warehouses.model.Rack;
import com.alejandro.warehouses.model.Warehouse;
import com.alejandro.warehouses.repository.RackRepository;
import com.alejandro.warehouses.repository.WarehouseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class RackServiceTest {

   @Mock
   WarehouseService warehouseService;

   @Mock
   RackRepository thisRepository;

   @InjectMocks
   RackService thisService;

   @Test
   public void test_getAllRacks(){

   }
}
