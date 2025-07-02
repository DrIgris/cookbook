package com.Thanatomisants.cookbook.ViewModel;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Thanatomisants.cookbook.Model.User;

import com.Thanatomisants.cookbook.Model.LoginRequest;
import com.Thanatomisants.cookbook.Model.Session;
import com.Thanatomisants.cookbook.Repo.SessionRepo;
import com.Thanatomisants.cookbook.Repo.UserRepo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;    
    @Autowired
    SessionRepo sessionRepo;

    Instant expirationTime = Instant.now().plus(24, ChronoUnit.HOURS);

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        Optional<User> optUser = userRepo.findByUsername(loginRequest.getUsername());
        if (optUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = optUser.get();

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String sessionToken = UUID.randomUUID().toString();
        sessionRepo.save(new Session(sessionToken, user.getId(), expirationTime.toEpochMilli()));

        Cookie cookie = new Cookie("SESSIONID", sessionToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60); // 1 day
        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody LoginRequest loginRequest) {
        if((userRepo.findByUsername(loginRequest.getUsername()).isPresent())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        String pass = passwordEncoder.encode(loginRequest.getPassword());
        User user = new User(loginRequest.getUsername(), pass);
        User resultUser = userRepo.save(user);
        return resultUser == null ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) : new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
