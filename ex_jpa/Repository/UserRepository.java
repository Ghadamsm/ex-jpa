package com.example.ex_jpa.Repository;

import com.example.ex_jpa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
