package model.pizza;

import model.ingredient.Ingredient;

/**
 * Definition of the PizzaBuilder methods
 */
public interface PizzaInterface {
    void setPizza();
    void chooseDough();
    void addIngredient(Ingredient ingredient);
    void addExtra(Ingredient ingredient);
    Pizza build();
}
