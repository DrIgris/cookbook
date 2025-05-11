package com.Thanatomisants.cookbook.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Recipe {
    String[] directions;
    Ingredient[] ingredients;
    String name;
    String intro;
    int prep;
    int cook;
    int serving;
    int calorie; 
}