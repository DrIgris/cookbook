package com.Thanatomisants.cookbook.Repo;




import org.springframework.stereotype.Repository;

import com.Thanatomisants.cookbook.Model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
}
