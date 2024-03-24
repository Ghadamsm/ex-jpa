package com.example.ex_jpa.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Merchant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;

    @NotEmpty(message = "name must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 3 , message = "name must be more then 3 char")
    private String name ;

}
