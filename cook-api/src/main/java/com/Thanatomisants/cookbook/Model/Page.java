package com.Thanatomisants.cookbook.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    private Recipe recipe;
    private Ingredient[] ingredients;
    private Direction[] directions;
}
