package model.pizza;

import model.dough.Dough;
import model.ingredient.Ingredient;
import model.ingredient.IngredientType;

import java.util.HashMap;

public class Pizza {
    private int ID;
    private String name;
    private Dough dough;
    private HashMap<Enum<IngredientType>, Ingredient> ingredients;
    private HashMap<Enum<IngredientType>, Ingredient> extras;

    public Pizza(int ID, String name, Dough dough, HashMap<Enum<IngredientType>, Ingredient> ingredients, HashMap<Enum<IngredientType>, Ingredient> extras) {
        this.ID = ID;
        this.name = name;
        this.dough = dough;
        this.ingredients = ingredients;
        this.extras = extras;
    }

    // Getters & Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public HashMap<Enum<IngredientType>, Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Enum<IngredientType>, Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public HashMap<Enum<IngredientType>, Ingredient> getExtras() {
        return extras;
    }

    public void setExtras(HashMap<Enum<IngredientType>, Ingredient> extras) {
        this.extras = extras;
    }
}
