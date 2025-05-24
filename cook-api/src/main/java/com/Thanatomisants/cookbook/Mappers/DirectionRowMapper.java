package com.Thanatomisants.cookbook.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Thanatomisants.cookbook.Model.Direction;

public class DirectionRowMapper implements RowMapper<Direction>{

    @Override
    public Direction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Direction direction = new Direction();
        direction.setId(rs.getInt("id"));
        direction.setRecipeId(rs.getInt("recipe_id"));
        direction.setSort(rs.getInt("sort"));
        direction.setDirection(rs.getString("direction"));
        return direction;
    }
    
}
