package com.Thanatomisants.cookbook.ViewModel;

public interface DirectionDAO {
    String[] getDirections(int recipeId);
    String getDirection(int recipeId, int sort);
    void addDirection(int recipeId, int sort, String direction);
    void deleteDirection(int recipeId, int sort);
    void updateDirection(int recipeId, int sort, String direction);
} 
