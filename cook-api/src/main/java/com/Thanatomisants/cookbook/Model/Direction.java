package com.Thanatomisants.cookbook.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Direction {
    private int id;
    private int recipeId;
    private int sort;
    private String direction;
}
