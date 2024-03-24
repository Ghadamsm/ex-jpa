package com.example.ex_jpa.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;


    @NotEmpty(message = "username must be not empty")
    @Size(min = 5 , message = "username must be more then 5 length long")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username ;


    @NotEmpty(message = "password must be not empty")
    @Size(min = 6 , message = "password must be more then 6 length long" )
//    @Pattern(regexp = "^[A-Za-z0-9]$" , message = "password must have characters and digits")
    @Column(columnDefinition = "varchar(15) not null ")
    private String password ;

    @NotEmpty(message = "email must be not empty")
    @Email(message = "must be valid email")
    @Column(columnDefinition = "varchar(35) not null unique")
    private String email ;

    @NotEmpty(message = "role must be not empty")
    @Pattern(regexp = "^(Admin|Customer)$" , message = "role have to be in Admin, Customer")
    @Column(columnDefinition = "varchar(9) not null check(role = 'Admin' or role = 'Customer')")
    private String role ;

    @NotNull(message = "balance must be not empty")
    @Positive(message = "balance must be positive number")
    @Column(columnDefinition = "int not null")
    private Integer balance ;



}
