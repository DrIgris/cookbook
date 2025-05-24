package com.Thanatomisants.cookbook.Repo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Thanatomisants.cookbook.Model.Direction;
import com.Thanatomisants.cookbook.Model.Ingredient;
import com.Thanatomisants.cookbook.Model.Recipe;
import com.Thanatomisants.cookbook.Mappers.DirectionRowMapper;
import com.Thanatomisants.cookbook.Mappers.IngredientRowMapper;
import com.Thanatomisants.cookbook.Mappers.RecipeRowMapper;

@Repository
public class CookbookRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // DIRECTIONS 
    public Direction[] getDirections(int recipeId) {
        String sql = "SELECT * FROM directions d WHERE d.recipe_id = ?";
        List<Direction> directions = jdbcTemplate.query(sql, new DirectionRowMapper(), recipeId);
        Collections.sort(directions);
        Direction[] results = directions.toArray(new Direction[0]);
        return results;
    }
    public Direction getDirection(int id) {
        String sql = "SELECT id, sort, recipe_id AS recipeId, direction FROM directions d WHERE d.id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Direction.class), id);
    }
    public boolean addDirection(Direction direction) {
        String sql = "INSERT INTO directions (id, sort, recipe_id, direction) VALUES (?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, direction.getId(), direction.getSort(), direction.getRecipeId(), direction.getDirection());
        return rows == 1;
    }
    public boolean deleteDirection(int id) {
        String sql = "DELETE FROM directions d WHERE d.id = ?";
        int rows = jdbcTemplate.update(sql, id);
        return rows == 1;
    }
    public boolean updateDirection(Direction direction) {
        String sql = "UPDATE directions d SET sort = ?, recipe_id = ?, direction = ? WHERE d.id = ?";
        int rows = jdbcTemplate.update(sql, direction.getSort(), direction.getRecipeId(), direction.getDirection(), direction.getId());
        return rows == 1;
    }
    // INGREDIENTS
    public Ingredient[] getIngredients(int recipeId) {
        String sql = "SELECT * FROM ingredients i WHERE i.recipe_id = ?";
        List<Ingredient> ingreds = jdbcTemplate.query(sql, new IngredientRowMapper(), recipeId);
        Collections.sort(ingreds);
        Ingredient[] results = ingreds.toArray(new Ingredient[0]);
        return results;
    }
    public Ingredient getIngredient(int id) {
        String sql = "SELECT id, quantity, recipe_id AS recipeId, unit, ingredient AS item, notes, sort FROM ingredients i WHERE i.id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Ingredient.class), id);
    }
    public boolean addIngredient(Ingredient ingredient) {
        String sql = "INSERT INTO ingredients (id, quantity, recipe_id, unit, ingredient, notes, sort) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, ingredient.getId(), ingredient.getQuantity(), ingredient.getRecipeId(), ingredient.getUnit(), ingredient.getItem(), ingredient.getNotes(), ingredient.getSort());
        return rows == 1;
    }
    public boolean deleteIngredient(int id) {
        String sql = "DELETE FROM ingredients i WHERE i.id = ?";
        int rows = jdbcTemplate.update(sql, id);
        return rows == 1;
    }
    public boolean updateIngredient(Ingredient ingredient) {
        String sql = "UPDATE ingredients i SET quantity = ?, recipe_id = ?, unit = ?, ingredient = ?, notes = ?, sort = ? WHERE i.id = ?";
        int rows = jdbcTemplate.update(sql, ingredient.getQuantity(), ingredient.getRecipeId(), ingredient.getUnit(), ingredient.getItem(), ingredient.getNotes(), ingredient.getSort(), ingredient.getId());
        return rows == 1;
    }
    // RECIPES
    public Recipe[] getRecipes(int offset, int limit) { //limit + 1
        String sql = "SELECT * FROM recipes LIMIT ? OFFSET ?";
        List<Recipe> recipes = jdbcTemplate.query(sql, new RecipeRowMapper(), limit + 1, offset);
        Recipe[] result = recipes.toArray(new Recipe[0]);
        return result;
    }
    public Recipe getRecipe(int id) {
        String sql = "SELECT * FROM recipes r WHERE r.id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Recipe.class), id);
    }
    public Recipe[] searchRecipes(String text) {
        String sql = "SELECT * FROM recipes r WHERE LOWER(r.title) LIKE LOWER(?)";
        String key = "%" + text + "%";
        List<Recipe> recipes = jdbcTemplate.query(sql, new RecipeRowMapper(), key);
        Recipe[] result = recipes.toArray(new Recipe[0]);
        return result;
    }
    public Recipe[] searchRecipesByIngredient(String ingredient) {
        String sql = "SELECT * FROM recipes r JOIN ingredients i ON r.id = i.recipe_id WHERE LOWER(i.ingredient) LIKE LOWER(?)";
        String key = "%" + ingredient + "%";
        List<Recipe> recipes = jdbcTemplate.query(sql, new RecipeRowMapper(), key);
        Recipe[] result = recipes.toArray(new Recipe[0]);
        return result;
    }
    public boolean addRecipe(Recipe recipe) {
        String sql = "INSERT INTO recipes (title, intro, prep_time, cook_time, serving, calorie) VALUES (?, ?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, recipe.getTitle(), recipe.getIntro(), recipe.getPrepTime(), recipe.getCookTime(), recipe.getServing(), recipe.getCalorie());
        return rows == 1;
    }
    public boolean updateRecipe(Recipe recipe) {
        String sql = "UPDATE recipes r SET title = ?, intro = ?, prep_time = ?, cook_time = ?, serving = ?, calorie = ? WHERE r.id = ?";
        int rows = jdbcTemplate.update(sql, recipe.getTitle(), recipe.getIntro(), recipe.getPrepTime(), recipe.getCookTime(), recipe.getServing(), recipe.getCalorie(), recipe.getId());
        return rows == 1;
    }
    public boolean deleteRecipe(int id) {
        String sql = "DELETE FROM recipes r WHERE r.id = ?";
        int rows = jdbcTemplate.update(sql, id);
        return rows == 1;
    }
}
