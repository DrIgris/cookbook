package com.Thanatomisants.cookbook.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ingredient {
    private int id;
    private int recipeId;
    private int quantity;
    private String unit;
    private String item;
    private String notes;

    public Ingredient(int quantity, String unit, String item) {
        this.quantity = quantity;
        this.unit = unit;
        this.item = item;
        notes = "";
    }

    public Ingredient(int quantity, String unit, String item, String notes) {
        this.quantity = quantity;
        this.unit = unit;
        this.item = item;
        this.notes = notes;
    }
}
