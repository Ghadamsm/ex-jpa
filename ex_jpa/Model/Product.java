package com.example.ex_jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;


    @NotEmpty(message = "name must be not empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    @Size(min = 3 , message = "name must be more than 3 char")
    private String name ;


    @NotNull(message = "price must be not empty")
    @Positive(message = "price must be positive number")
    @Column(columnDefinition = "int not null")
    private Integer price ;


    @NotNull(message = "category ID must be not empty")
    @Column(columnDefinition = "int")
    private Integer categoryID ;


}
