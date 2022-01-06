package model.pizza;

import model.dough.Dough;
import model.ingredient.Ingredient;

import java.util.List;

/**
 * Definition of the PizzaBuilder methods
 */
public interface PizzaInterface {
    void setPizzaID(int ID);
    void chooseDough(Dough dough);
    void addIngredient(List<Ingredient> ingredient);
    void addExtra(List<Ingredient> extras);
    Pizza build();
}
