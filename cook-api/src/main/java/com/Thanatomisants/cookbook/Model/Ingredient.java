package com.Thanatomisants.cookbook.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient implements Comparable<Ingredient>{
    private int id;
    private int recipeId;
    private int quantity;
    private String unit;
    private String item;
    private String notes;
    private int sort;

    @Override
    public int compareTo(Ingredient o) {
        return Integer.compare(this.sort, o.getSort());
    }
}
