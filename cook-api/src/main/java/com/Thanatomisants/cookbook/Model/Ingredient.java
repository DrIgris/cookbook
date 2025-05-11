package com.Thanatomisants.cookbook.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ingredient {
    int amount;
    String unit;
    String item;
    String notes;

    public Ingredient(int amount, String unit, String item) {
        this.amount = amount;
        this.unit = unit;
        this.item = item;
        notes = "";
    }

    public Ingredient(int amount, String unit, String item, String notes) {
        this.amount = amount;
        this.unit = unit;
        this.item = item;
        this.notes = notes;
    }
}
