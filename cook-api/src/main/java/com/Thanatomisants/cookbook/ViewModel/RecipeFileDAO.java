package com.Thanatomisants.cookbook.ViewModel;

import com.Thanatomisants.cookbook.Model.Recipe;

public class RecipeFileDAO implements RecipeDAO{

    @Override
    public Recipe[] getRecipes(int offset, int limit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecipes'");
    }

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
    public void addRecipe(Recipe recipe) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRecipe'");
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRecipe'");
    }

    @Override
    public void deleteRecipe(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRecipe'");
    }

    @Override
    public void addDirection(int recipeId, int sort, String direction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDirection'");
    }

    @Override
    public void deleteDirection(int recipeId, int sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDirection'");
    }

    @Override
    public void updateDirection(int recipeId, int sort, String direction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDirection'");
    }
    
}
