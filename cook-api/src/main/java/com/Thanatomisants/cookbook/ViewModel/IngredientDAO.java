package com.Thanatomisants.cookbook.ViewModel;

public interface IngredientDAO {
    String[] getIngredients(int recipeId);
    String getIngredient(int recipeId, int sort);
    void addIngredient(int recipeId, int sort, String ingredient);
    void deleteIngredient(int recipeId, int sort);
    void updateIngredient(int recipeId, int sort, String ingredient);
    
}   
