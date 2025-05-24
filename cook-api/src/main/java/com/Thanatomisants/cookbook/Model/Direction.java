package com.Thanatomisants.cookbook.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Direction implements Comparable<Direction>{
    private int id;
    private int recipeId;
    private int sort;
    private String direction;

    @Override
    public int compareTo(Direction o) {
        return Integer.compare(this.sort, o.getSort());
    }
}
