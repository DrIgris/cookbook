package com.Thanatomisants.cookbook.ViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thanatomisants.cookbook.Repo.SessionRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    SessionRepo sessionRepo;
    
}
