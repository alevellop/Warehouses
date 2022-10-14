package com.alejandro.warehouses.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="Warehouses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(length = 36)
    private String uuid;

    @NonNull
    @Column(length = 50)
    private String client;

    @NonNull
    @Column(length = 3)
    private String family;

    @NonNull
    @Column(length = 2)
    private Integer size;

    @OneToMany(
        mappedBy = "warehouse",
        cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Rack> racks = new ArrayList<>();
}
