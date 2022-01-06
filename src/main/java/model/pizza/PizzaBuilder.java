package model.pizza;

import model.dough.Dough;
import model.ingredient.Ingredient;

import java.util.List;

/**
 * Helper class to generate instances of the Pizza class
 * in an abstract way, following the Builder software design pattern
 */
public class PizzaBuilder implements PizzaInterface{
    private Pizza pizza = new Pizza();

    @Override
    public void setPizzaID(int ID) {
        pizza.setID(ID);
    }

    @Override
    public void chooseDough(Dough dough) {
        pizza.setDough(dough);
    }

    @Override
    public void addIngredient(List<Ingredient> ingredients) {
        pizza.setIngredients(ingredients);
    }

    @Override
    public void addExtra(List<Ingredient> extras) {
        pizza.setExtras(extras);
    }

    @Override
    public Pizza build() {
        return pizza;
    }
}
