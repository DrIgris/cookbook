package com.Thanatomisants.cookbook.ViewModel;

import com.Thanatomisants.cookbook.Model.Ingredient;
import com.Thanatomisants.cookbook.Model.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class RecipeFileDAO implements RecipeDAO{

    @Override
    public Recipe getRecipe(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecipe'");
    }

    @Override
    public Recipe[] searchRecipes(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchRecipes'");
    }

    @Override
    public Recipe[] getRecipeByIngredient(String ingredient) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecipeByIngredient'");
    }


    @Override
    public boolean updateRecipe(Recipe recipe) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRecipe'");
    }

    @Override
    public boolean deleteRecipe(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRecipe'");
    }
    
}
