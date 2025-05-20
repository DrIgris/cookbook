package com.Thanatomisants.cookbook.ViewModel;

import com.Thanatomisants.cookbook.Model.Recipe;

public interface RecipeDAO {
    Recipe[] getRecipes(int offset, int limit); //Make sure to limit the limit + 1 to check for pagination
    Recipe getRecipe(int id);
    Recipe[] searchRecipes(String text);
    Recipe[] getRecipeByIngredient(String ingredient);
    void addRecipe(Recipe recipe);
    void updateRecipe(Recipe recipe);
    void deleteRecipe(int id);
}
