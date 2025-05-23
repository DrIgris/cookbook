package com.Thanatomisants.cookbook.ViewModel;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Thanatomisants.cookbook.Model.Recipe;
import com.Thanatomisants.cookbook.Repo.CookbookRepo;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cook")
public class RecipeController {
    @Autowired
    private CookbookRepo cookRepo;

    @PostMapping("/recipe")
    public ResponseEntity<Void> addRecipe(@RequestBody Recipe recipe) {
        boolean result = cookRepo.addRecipe(recipe);
        return result ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/recipe") //Remember repo will return limit + 1 items
    public ResponseEntity<Recipe[]> getRecipes(@RequestParam int offset, @RequestParam int limit) {
        Recipe[] results = cookRepo.getRecipes(offset, limit);
        return results != null ? new ResponseEntity<Recipe[]>(results, HttpStatus.OK) : new ResponseEntity<Recipe[]>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/recipe/{id}") //Remember repo will return limit + 1 items
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Recipe result = cookRepo.getRecipe(id);
        return result != null ? new ResponseEntity<Recipe>(result, HttpStatus.OK) : new ResponseEntity<Recipe>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/recipe/search") //call url looks like http://localhost:8080/cook/recipe/search?text=chicken
    public ResponseEntity<Recipe[]> searchRecipes(@RequestParam String text) {
       Recipe[] results = cookRepo.searchRecipes(text);
       return results != null ? new ResponseEntity<Recipe[]>(results, HttpStatus.OK) : new ResponseEntity<Recipe[]>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/recipe/ingredient")
    public ResponseEntity<Recipe[]> searchRecipesIngredient(@RequestParam String text) {
        Recipe[] results = cookRepo.getRecipeByIngredient(text);
        return results != null ? new ResponseEntity<Recipe[]>(results, HttpStatus.OK) : new ResponseEntity<Recipe[]>(HttpStatus.NOT_FOUND);
    }
}
