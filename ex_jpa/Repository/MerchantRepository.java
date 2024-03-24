package com.example.ex_jpa.Repository;

import com.example.ex_jpa.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
}
