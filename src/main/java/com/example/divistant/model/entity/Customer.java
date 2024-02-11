package com.example.divistant.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(nullable = false, unique = true, length = 16)
    private String Nik;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private Integer Income;

    public Customer(Integer id, String nik, String name, Integer income) {
        Id = id;
        Nik = nik;
        Name = name;
        Income = income;
    }
}
