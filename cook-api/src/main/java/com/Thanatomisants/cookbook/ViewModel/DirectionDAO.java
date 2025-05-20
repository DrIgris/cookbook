package com.Thanatomisants.cookbook.ViewModel;

public interface DirectionDAO {
    String[] getDirections(int recipeId);
    String getDirection(int recipeId, int sort);
    boolean addDirection(int recipeId, int sort, String direction);
    boolean deleteDirection(int recipeId, int sort);
    boolean updateDirection(int recipeId, int sort, String direction);
} 
