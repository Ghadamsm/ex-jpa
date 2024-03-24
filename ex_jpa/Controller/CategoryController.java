package com.example.ex_jpa.Controller;


import com.example.ex_jpa.Model.Category;
import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService ;


    @GetMapping("/get")
    public ResponseEntity getCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategory());
    }



    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("added");

    }




    @PutMapping("/update/{Id}")
    public ResponseEntity updateCategory(@PathVariable int Id , @RequestBody @Valid Category category , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = categoryService.updateCategory(Id , category);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("Invalid Id");
    }




    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteCategory(@PathVariable int Id ){


        if (categoryService.deleteCategory(Id) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }

        return ResponseEntity.status(200).body("deleted");

    }

}
