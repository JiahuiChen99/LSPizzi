package model;

import model.dough.Dough;
import model.drink.Drink;
import model.ingredient.Ingredient;
import model.pizza.Pizza;

import java.util.List;

/**
 * A class that includes all the LSPizzi information
 *
 */
public class LSPizzi {
    private List<Pizza> pizzas;
    private List<Ingredient> ingredients;
    private List<Dough> doughs;
    private List<Drink> drinks;

    public LSPizzi(List<Pizza> pizzas, List<Ingredient> ingredients, List<Dough> doughs, List<Drink> drinks) {
        this.pizzas = pizzas;
        this.ingredients = ingredients;
        this.doughs = doughs;
        this.drinks = drinks;
    }

    // Getters & Setters
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Dough> getDoughs() {
        return doughs;
    }

    public void setDoughs(List<Dough> doughs) {
        this.doughs = doughs;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
}
