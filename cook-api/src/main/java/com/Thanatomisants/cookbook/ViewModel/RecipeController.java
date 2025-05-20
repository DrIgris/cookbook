package com.Thanatomisants.cookbook.ViewModel;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thanatomisants.cookbook.Model.Recipe;
import com.Thanatomisants.cookbook.Repo.CookbookRepo;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cook")
public class RecipeController {
    @Autowired
    private CookbookRepo cookRepo;

    @PostMapping
    public ResponseEntity<Void> addRecipe(@RequestBody Recipe recipe) {
        boolean result = cookRepo.addRecipe(recipe);
        return result ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
