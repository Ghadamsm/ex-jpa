package com.example.ex_jpa.Service;


import com.example.ex_jpa.Model.MerchantStock;
import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Model.User;
import com.example.ex_jpa.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository ;
    private final ProductService productService ;
    private final MerchantStockService merchantStockService ;

    public List<User> getUser(){
        return userRepository.findAll();
    }


    public void addUser(User user){

       userRepository.save(user);

    }

    public Boolean updateUser(Integer Id , User user){

        User u = userRepository.getById(Id);

        if (u == null){
            return false ;
        }

        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setBalance(user.getBalance());
        u.setRole(user.getRole());

        userRepository.save(u);

        return true ;
    }



    public Boolean deleteUser(Integer Id){

        User u = userRepository.getById(Id);

        if (u == null){
            return false;
        }

        userRepository.delete(u);

        return true ;
    }






    public String buyProduct(Integer IdU , Integer IdP , Integer IdMS){

        User u = userRepository.getById(IdU);
        if (u == null ){
            return "Invalid user id ";
        }

        Product p = productService.getByID(IdP);

        if (p == null){
            return "Invalid product";
        }

        MerchantStock m = merchantStockService.getMById(IdMS) ;

        if (m == null){
            return "Invalid ";
        } else if (m.getStock() <= 1) {
            return "out of stuck";
        }

        if (u.getBalance() <= p.getPrice()){
            return "check your balance";
        }

        u.setBalance(u.getBalance() - p.getPrice());

        int i2 = m.getStock() - 1;
        m.setStock(i2);
        return "thank you" ;

    }





    public String giftCard(int IdU ){
        User u = userRepository.getById(IdU);
        if (u == null){
            return null ;
        }else if (u.getBalance() >= 100 ){
                    u.setBalance(u.getBalance() - 100);
                    return "your gift card : gift ";
        }

        return "Invalid Id";
    }






    public Boolean deposit(Integer Id , Integer dep){
        User u = userRepository.getById(Id);

        if (u == null){
            return false ;
        }
        u.setBalance(u.getBalance() + dep);
        return true ;
    }

}
