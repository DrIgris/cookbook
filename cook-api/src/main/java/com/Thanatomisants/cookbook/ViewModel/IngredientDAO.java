package com.Thanatomisants.cookbook.ViewModel;

public interface IngredientDAO {
    String[] getIngredients(int recipeId);
    String getIngredient(int recipeId, int sort);
    boolean addIngredient(int recipeId, int sort, String ingredient);
    boolean deleteIngredient(int recipeId, int sort);
    boolean updateIngredient(int recipeId, int sort, String ingredient);
    
}   
