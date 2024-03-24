package com.example.ex_jpa.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MerchantStock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;


    @NotNull(message = "product ID must be not empty")
    @Column(columnDefinition = "int not null")
    private Integer productID ;

    @NotNull(message = "merchant ID must be not empty")
    @Column(columnDefinition = "int not null")
    private Integer merchantID ;

    @NotNull(message = "stock must be not empty")
    @Min(value = 10 , message = "stock must be more than 10 at start")
    @Column(columnDefinition = "int not null ")
    private Integer stock ;



}
