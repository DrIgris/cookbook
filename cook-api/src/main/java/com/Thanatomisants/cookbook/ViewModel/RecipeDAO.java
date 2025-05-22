package com.Thanatomisants.cookbook.ViewModel;

import com.Thanatomisants.cookbook.Model.Recipe;

public interface RecipeDAO {
    Recipe getRecipe(int id);
    Recipe[] searchRecipes(String text);
    Recipe[] getRecipeByIngredient(String ingredient);
    boolean updateRecipe(Recipe recipe);
    boolean deleteRecipe(int id);
}
