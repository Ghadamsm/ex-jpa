package com.example.ex_jpa.Controller;


import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Service.ProductService;
import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService ;


    @GetMapping("/get")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(productService.getProducts());
    }



    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        productService.addProduct(product);
        return ResponseEntity.status(200).body("added");

    }




    @PutMapping("/update/{Id}")
    public ResponseEntity updateProduct(@PathVariable Integer Id , @RequestBody @Valid Product product , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = productService.updateProduct(Id , product);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("Invalid Id");
    }




    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteProduct(@PathVariable Integer Id ){


        if (productService.deleteProduct(Id) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }

        return ResponseEntity.status(200).body("deleted");

    }



    @GetMapping("/discounts/{IdP}/{des}")
    public ResponseEntity discounts(@PathVariable Integer IdP , @PathVariable Integer des){

        if (productService.discounts(IdP , des) == false){
            return ResponseEntity.status(400).body("invalid");
        }

        return ResponseEntity.status(200).body("Done");
    }


    @GetMapping("/gift/{giftCard}/{Id}")
    public ResponseEntity giftCard(@PathVariable String giftCard , @PathVariable Integer Id){
        if (productService.giftCard(giftCard , Id) == false){
            return ResponseEntity.status(400).body("Invalid code");
        }

        return ResponseEntity.status(200).body("your gift card added");
    }


}
