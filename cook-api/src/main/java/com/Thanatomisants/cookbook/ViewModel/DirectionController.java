package com.Thanatomisants.cookbook.ViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.Thanatomisants.cookbook.Repo.CookbookRepo;
import com.Thanatomisants.cookbook.Model.Direction;
import com.Thanatomisants.cookbook.Model.Ingredient;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/direction")
public class DirectionController {
    @Autowired
    private CookbookRepo cookRepo;

    @GetMapping("/{recipeId}")
    public ResponseEntity<Direction[]> getDirections(@PathVariable int recipeId) {
        Direction[] results = cookRepo.getDirections(recipeId);
        return results != null ? new ResponseEntity<Direction[]>(results, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Direction> getDirection(@PathVariable int id) {
        Direction result = cookRepo.getDirection(id);
        return result != null ? new ResponseEntity<Direction>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping()
    public ResponseEntity<Void> addDirection(@RequestBody Direction direction) {
        boolean result = cookRepo.addDirection(direction);
        return result ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirection(@PathVariable int id) {
        boolean result = cookRepo.deleteDirection(id);
        return result ? new ResponseEntity<Void>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping()
    public ResponseEntity<Void> updateDirection(@RequestBody Direction direction) {
        boolean result = cookRepo.updateDirection(direction);
        return result ? new ResponseEntity<Void>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
