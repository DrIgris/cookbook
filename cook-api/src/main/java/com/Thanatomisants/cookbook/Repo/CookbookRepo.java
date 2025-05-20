package com.Thanatomisants.cookbook.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Thanatomisants.cookbook.Model.Recipe;

@Repository
public class CookbookRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // DIRECTIONS 
    public String[] getDirections(int recipeId) {
        throw new UnsupportedOperationException("Unimplemented method 'getDirections'");
    }
    public String getDirection(int recipeId, int sort) {
        throw new UnsupportedOperationException("Unimplemented method 'getDirection'");
    }
    public boolean addDirection(int recipeId, int sort, String direction) {
        throw new UnsupportedOperationException("Unimplemented method 'addDirection'");
    }
    public boolean deleteDirection(int recipeId, int sort) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteDirection'");
    }
    public boolean updateDirection(int recipeId, int sort, String direction) {
        throw new UnsupportedOperationException("Unimplemented method 'updateDirection'");
    }
    // INGREDIENTS
    public String[] getIngredients(int recipeId) {
        throw new UnsupportedOperationException("Unimplemented method 'getIngredients'");
    }
    public String getIngredient(int recipeId, int sort) {
        throw new UnsupportedOperationException("Unimplemented method 'getIngredient'");
    }
    public boolean addIngredient(int recipeId, int sort, String ingredient) {
        throw new UnsupportedOperationException("Unimplemented method 'addIngredient'");
    }
    public boolean deleteIngredient(int recipeId, int sort) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteIngredient'");
    }
    public boolean updateIngredient(int recipeId, int sort, String ingredient) {
        throw new UnsupportedOperationException("Unimplemented method 'updateIngredient'");
    }
    // RECIPES
    public Recipe[] getRecipes(int offset, int limit) {
        throw new UnsupportedOperationException("Unimplemented method 'getRecipes'");
    }
    public Recipe getRecipe(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'getRecipe'");
    }
    public Recipe[] searchRecipes(String text) {
        throw new UnsupportedOperationException("Unimplemented method 'searchRecipes'");
    }
    public Recipe[] getRecipeByIngredient(String ingredient) {
        throw new UnsupportedOperationException("Unimplemented method 'getRecipeByIngredient'");
    }
    public boolean addRecipe(Recipe recipe) {
        String sql = "INSERT INTO recipes (title, intro, prep_time, cook_time, serving, calorie) VALUES (?, ?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, recipe.getTitle(), recipe.getIntro(), recipe.getPrepTime(), recipe.getCookTime(), recipe.getServing(), recipe.getCalorie());
        return rows == 1;
    }
    public boolean updateRecipe(Recipe recipe) {
        throw new UnsupportedOperationException("Unimplemented method 'updateRecipe'");
    }
    public boolean deleteRecipe(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteRecipe'");
    }
}
