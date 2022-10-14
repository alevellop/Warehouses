package com.alejandro.warehouses.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="racks_type")
public class RacksType {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @NonNull
   @Column(length = 3)
   private String family;

   @NonNull
   @Column(length = 1)
   private String type;
}
