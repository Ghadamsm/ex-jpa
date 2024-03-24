package com.example.ex_jpa.Service;

import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

   private final ProductRepository products ;


    public List<Product> getProducts(){
        return products.findAll();
    }


    public void addProduct(Product product){

        products.save(product);

    }

    public Boolean updateProduct(Integer Id , Product product){

        Product p = products.getById(Id);

        if (p == null ){
            return false ;
        }

        p.setName(product.getName());
        p.setCategoryID(product.getCategoryID());
        p.setPrice(product.getPrice());

        products.save(p);

        return true ;
    }



    public Boolean deleteProduct(Integer Id){

        Product p = products.getById(Id);

        if (p == null){
            return false;
        }

        products.delete(p);
        return true ;
    }





    public Boolean discounts(Integer IdP , Integer des) {

        Product p = products.getById(IdP);

        if (p == null){
            return false ;
        }

        p.setPrice(p.getPrice() - (p.getPrice() * des / 100));
        return true;
    }





    public Boolean giftCard(String giftCard , Integer Id){

        Product p = products.getById(Id);

        if (p == null){
            return false ;
        }

        if (giftCard.equalsIgnoreCase("gift")){
            p.setPrice(p.getPrice() - 100);
            return true;
        }

        return false ;
    }


    public Product getByID (Integer IdP){
        Product p = products.getById(IdP);

        if (p == null){
            return null ;
        }

        return p ;
    }


}
