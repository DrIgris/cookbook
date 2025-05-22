package com.Thanatomisants.cookbook.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Thanatomisants.cookbook.Model.Recipe;

public class RecipeRowMapper implements RowMapper<Recipe>{

    @Override
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setId(rs.getInt("id"));
        recipe.setTitle(rs.getString("title"));
        recipe.setIntro(rs.getString("intro"));
        recipe.setPrepTime(rs.getInt("prep_time"));
        recipe.setCookTime(rs.getInt("cook_time"));
        recipe.setServing(rs.getInt("serving"));
        recipe.setCalorie(rs.getInt("calorie"));
        return recipe;
    }
    
}
