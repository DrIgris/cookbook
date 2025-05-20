package com.Thanatomisants.cookbook.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Thanatomisants.cookbook.Model.Recipe;

@Repository
@SuppressWarnings("unused")
public class TestRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void insertTest(Recipe recipe) {
        // String sql = "INSERT INTO recipes (title, intro, prep_time, cook_time, serving, calorie) VALUES (?, ?, ?, ?, ?, ?)";
        // int rows = jdbcTemplate.update(sql, recipe.getName(), recipe.getIntro(), recipe.getPrepTime(), recipe.getCookTime(), recipe.getServing(), recipe.getCalorie());
        // System.out.println(rows == 1 ? "User added successfully" : "Failed to add user");
        // jdbcTemplate.update("DELETE FROM recipes WHERE id = ?", 1);
    }
    
}
