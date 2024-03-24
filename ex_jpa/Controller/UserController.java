package com.example.ex_jpa.Controller;


import com.example.ex_jpa.Model.MerchantStock;
import com.example.ex_jpa.Model.User;
import com.example.ex_jpa.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService ;


    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }



    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body("added");

    }




    @PutMapping("/update/{Id}")
    public ResponseEntity updateUser(@PathVariable Integer Id , @RequestBody @Valid User user , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = userService.updateUser(Id , user);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("Invalid Id");
    }




    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteUser(@PathVariable Integer Id ){


        if (userService.deleteUser(Id) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }

        return ResponseEntity.status(200).body("deleted");

    }




    @GetMapping("/deposit/{Id}/{dep}")
    public ResponseEntity deposit(@PathVariable Integer Id , @PathVariable Integer dep){

        if(userService.deposit(Id, dep) == false){
            return ResponseEntity.status(400).body("Invalid ID");
        }
        return ResponseEntity.status(200).body("Done");
    }


    @GetMapping("/buy/{IdU}/{IdP}/{IdMS}")
    public ResponseEntity buyProduct(@PathVariable Integer IdU ,@PathVariable Integer IdP ,@PathVariable Integer IdMS) {

       if (userService.buyProduct(IdU, IdP, IdMS) == "Invalid user id "){

           return ResponseEntity.status(400).body("Invalid user id ");

       } else if (userService.buyProduct(IdU, IdP, IdMS) == "out of stuck") {

            return ResponseEntity.status(400).body("out of stuck");
       }

        return ResponseEntity.status(200).body("thank you for your purchase!");
    }


    @GetMapping("/gift/{IdU}")
    public ResponseEntity giftCard(@PathVariable Integer IdU){
        String x = userService.giftCard(IdU);
        if (x.equalsIgnoreCase("Invalid")) {
            return ResponseEntity.status(400).body("Invalid");
        } else if (x.equalsIgnoreCase("check your balance")) {
            return ResponseEntity.status(400).body("check your balance");
        }

        return ResponseEntity.status(200).body("your gift card : gift ");
    }




}
