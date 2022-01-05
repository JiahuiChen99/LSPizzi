package model.pizza;

import model.dough.Dough;
import model.ingredient.Ingredient;
import java.util.List;

public class Pizza {
    private int ID;
    private String name;
    private Dough dough;
    private List<Ingredient> ingredients;
    private List<Ingredient> extras;

    public Pizza(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Pizza(int ID, String name, Dough dough, List<Ingredient> ingredients, List<Ingredient> extras) {
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getExtras() {
        return extras;
    }

    public void setExtras(List<Ingredient> extras) {
        this.extras = extras;
    }
}
