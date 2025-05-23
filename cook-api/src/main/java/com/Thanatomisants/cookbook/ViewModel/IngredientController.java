package com.Thanatomisants.cookbook.ViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.Thanatomisants.cookbook.Model.Ingredient;
import com.Thanatomisants.cookbook.Repo.CookbookRepo;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    private CookbookRepo cookRepo;

    @GetMapping("/{recipeId}")
    public ResponseEntity<Ingredient[]> getIngredients(@PathVariable int recipeId) {
        Ingredient[] results = cookRepo.getIngredients(recipeId);
        return results != null ? new ResponseEntity<Ingredient[]>(results, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id) {
        Ingredient result = cookRepo.getIngredient(id);
        return result != null ? new ResponseEntity<Ingredient>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Void> addIngredient(@RequestBody Ingredient ingredient) {
        boolean result = cookRepo.addIngredient(ingredient);
        return result ? new ResponseEntity<Void>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        boolean result = cookRepo.deleteIngredient(id);
        return result ? new ResponseEntity<Void>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping()
    public ResponseEntity<Void> updateIngredient(@RequestBody Ingredient ingredient) {
        boolean result = cookRepo.updateIngredient(ingredient);
        return result ? new ResponseEntity<Void>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
