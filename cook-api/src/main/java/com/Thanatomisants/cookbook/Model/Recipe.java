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
    private int id;
    private String title;
    private String intro;
    private int prepTime;
    private int cookTime;
    private int serving;
    private int calorie; 
}