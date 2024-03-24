package com.example.ex_jpa.Controller;


import com.example.ex_jpa.Model.Merchant;
import com.example.ex_jpa.Model.MerchantStock;
import com.example.ex_jpa.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class MerchantStockController {


    private final MerchantStockService merchantStockService ;


    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStock());
    }



    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("added");

    }




    @PutMapping("/update/{Id}")
    public ResponseEntity updateMerchantStock(@PathVariable Integer Id , @RequestBody @Valid MerchantStock merchantStock , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = merchantStockService.updateMerchantStock(Id , merchantStock);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("Invalid Id");
    }




    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer Id ){


        if (merchantStockService.deleteMerchantStock(Id) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }

        return ResponseEntity.status(200).body("deleted");

    }



    @GetMapping("/restock/{IdP}/{IdM}/{newStock}")
    public ResponseEntity reStock(@PathVariable Integer IdP , @PathVariable Integer IdM , @PathVariable Integer newStock){
        if (merchantStockService.reStock(IdP, IdM, newStock) == false){
            return ResponseEntity.status(400).body("Invalid ID");
        }

        return ResponseEntity.status(200).body("done");
    }


}
