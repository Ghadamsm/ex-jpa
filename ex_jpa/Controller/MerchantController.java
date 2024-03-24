package com.example.ex_jpa.Controller;


import com.example.ex_jpa.Model.Merchant;
import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService ;


    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        return ResponseEntity.status(200).body(merchantService.getMerchant());
    }



    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("added");

    }




    @PutMapping("/update/{Id}")
    public ResponseEntity updateMerchant(@PathVariable int Id , @RequestBody @Valid Merchant merchant , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = merchantService.updateMerchant(Id , merchant);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("Invalid Id");
    }




    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteMerchant(@PathVariable int Id ){


        if (merchantService.deleteMerchant(Id) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }

        return ResponseEntity.status(200).body("deleted");

    }

}
