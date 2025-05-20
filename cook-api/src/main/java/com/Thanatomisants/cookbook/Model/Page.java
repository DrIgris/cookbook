package com.Thanatomisants.cookbook.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Page {
    private Recipe recipe;
    private Ingredient[] ingredients;
    private Direction[] directions;
}
