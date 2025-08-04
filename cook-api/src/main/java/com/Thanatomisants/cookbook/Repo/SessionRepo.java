package com.Thanatomisants.cookbook.Repo;

import org.springframework.stereotype.Repository;

import com.Thanatomisants.cookbook.Model.Session;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SessionRepo extends JpaRepository<Session, String>{
    
}
