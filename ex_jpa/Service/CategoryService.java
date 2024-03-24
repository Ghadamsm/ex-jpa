package com.example.ex_jpa.Service;

import com.example.ex_jpa.Model.Category;
import com.example.ex_jpa.Model.Merchant;
import com.example.ex_jpa.Model.User;
import com.example.ex_jpa.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository ;


    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }


    public void addCategory(Category category){

        categoryRepository.save(category);

    }

    public Boolean updateCategory(Integer Id , Category category){

        Category c = categoryRepository.getById(Id);

        if (c == null){
            return false;
        }

        c.setName(category.getName());

        categoryRepository.save(c);
        return true ;
    }



    public Boolean deleteCategory(Integer Id){

        Category c = categoryRepository.getById(Id);

        if (c == null){
            return false;
        }


        categoryRepository.delete(c);
        return true ;
    }

}
