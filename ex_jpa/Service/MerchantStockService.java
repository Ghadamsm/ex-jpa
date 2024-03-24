package com.example.ex_jpa.Service;

import com.example.ex_jpa.Model.MerchantStock;
import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Repository.MerchantStockRepository;
import com.example.ex_jpa.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {


    private final MerchantStockRepository merchantStockRepository;
    private final ProductRepository productRepository ;

    public List<MerchantStock> getMerchantStock(){
        return merchantStockRepository.findAll();
    }


    public void addMerchantStock(MerchantStock merchantStock){
        merchantStockRepository.save(merchantStock);
    }

    public Boolean updateMerchantStock(Integer Id , MerchantStock merchantStock){

        MerchantStock m = merchantStockRepository.getById(Id);

        if (m == null){
            return false;
        }

        m.setMerchantID(merchantStock.getMerchantID());
        m.setStock(merchantStock.getStock());
        m.setProductID(merchantStock.getProductID());

        merchantStockRepository.save(m);
        return true ;
    }



    public Boolean deleteMerchantStock(Integer Id){

        MerchantStock m = merchantStockRepository.getById(Id);

        if (m == null){
            return false;
        }

        merchantStockRepository.delete(m);
        return true ;
    }



    public Boolean reStock(Integer IdP , Integer IdM , Integer newStock){

       Product p = productRepository.getById(IdP);
       MerchantStock m = merchantStockRepository.getById(IdM);

        if (p == null && m == null){
            return false ;
        }

        m.setStock(m.getStock() + newStock);

       return true ;
    }



    public MerchantStock getMById(Integer IdM){
        MerchantStock m = merchantStockRepository.getById(IdM);
        return m ;
    }








}
