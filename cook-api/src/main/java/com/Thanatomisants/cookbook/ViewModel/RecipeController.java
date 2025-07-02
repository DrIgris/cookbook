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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Thanatomisants.cookbook.Model.Direction;
import com.Thanatomisants.cookbook.Model.Ingredient;
import com.Thanatomisants.cookbook.Model.Page;
import com.Thanatomisants.cookbook.Model.Recipe;
import com.Thanatomisants.cookbook.Repo.CookbookRepo;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private CookbookRepo cookRepo;

    @GetMapping() //Remember repo will return limit + 1 items
    public ResponseEntity<Recipe[]> getRecipes(@RequestParam int offset, @RequestParam int limit) {
        Recipe[] results = cookRepo.getRecipes(offset, limit);
        return results != null ? new ResponseEntity<Recipe[]>(results, HttpStatus.OK) : new ResponseEntity<Recipe[]>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}") //Remember repo will return limit + 1 items
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Recipe result = cookRepo.getRecipe(id);
        return result != null ? new ResponseEntity<Recipe>(result, HttpStatus.OK) : new ResponseEntity<Recipe>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search") //call url looks like http://localhost:8080/cook/recipe/search?text=chicken  Also should have pageination!!
    public ResponseEntity<Recipe[]> searchRecipes(@RequestParam String text) {
       Recipe[] results = cookRepo.searchRecipes(text);
       return results != null ? new ResponseEntity<Recipe[]>(results, HttpStatus.OK) : new ResponseEntity<Recipe[]>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ingredient") //Also should have pageination!!
    public ResponseEntity<Recipe[]> searchRecipesIngredient(@RequestParam String text) {
        Recipe[] results = cookRepo.searchRecipesByIngredient(text);
        return results != null ? new ResponseEntity<Recipe[]>(results, HttpStatus.OK) : new ResponseEntity<Recipe[]>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Void> addRecipe(@RequestBody Recipe recipe) {
        boolean result = cookRepo.addRecipe(recipe);
        return result ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping()
    public ResponseEntity<Void> updateRecipe(@RequestBody Recipe recipe) {
        boolean result = cookRepo.updateRecipe(recipe);
        return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        boolean result = cookRepo.deleteRecipe(id);
        return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //PAGE
    @GetMapping("/page/{id}")
    public ResponseEntity<Page> getPage(@PathVariable int id) {
        Page p = new Page();
        Recipe r = cookRepo.getRecipe(id);
        Ingredient[] i = cookRepo.getIngredients(id);
        Direction[] d = cookRepo.getDirections(id);
        if(r != null && i != null && d != null) {
            p.setRecipe(r);
            p.setIngredients(i);
            p.setDirections(d);
            return new ResponseEntity<Page>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
