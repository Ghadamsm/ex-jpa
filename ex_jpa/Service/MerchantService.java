package com.example.ex_jpa.Service;


import com.example.ex_jpa.Model.Merchant;
import com.example.ex_jpa.Model.MerchantStock;
import com.example.ex_jpa.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository ;
    public List<Merchant> getMerchant(){
        return merchantRepository.findAll();
    }


    public void addMerchant(Merchant merchant){

        merchantRepository.save(merchant);

    }

    public Boolean updateMerchant(Integer Id , Merchant merchant){

        Merchant m = merchantRepository.getById(Id);

        if (m == null){
            return false;
        }

        m.setName(merchant.getName());

        merchantRepository.save(m);
        return true ;

    }



    public Boolean deleteMerchant(Integer Id){

        Merchant m = merchantRepository.getById(Id);

        if (m == null){
            return false;
        }

        merchantRepository.delete(m);
        return true ;
    }




}
