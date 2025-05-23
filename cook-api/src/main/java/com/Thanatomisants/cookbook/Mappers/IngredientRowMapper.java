package com.Thanatomisants.cookbook.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Thanatomisants.cookbook.Model.Ingredient;

public class IngredientRowMapper implements RowMapper<Ingredient>{

    @Override
    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(rs.getInt("id"));
        ingredient.setRecipeId(rs.getInt("recipe_id"));
        ingredient.setQuantity(rs.getInt("quantity"));
        ingredient.setUnit(rs.getString("unit"));
        ingredient.setItem(rs.getString("ingredient"));
        ingredient.setNotes(rs.getString("notes"));
        ingredient.setSort(rs.getInt("sort"));
        return ingredient;
    }
    
}
