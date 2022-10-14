package com.alejandro.warehouses.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroDetails {

   private String message;

   public ErroDetails(String message) {
      super();

      this.message = message;
   }
}
