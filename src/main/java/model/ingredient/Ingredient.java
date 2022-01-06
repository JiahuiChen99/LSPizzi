package model.ingredient;

public class Ingredient {
    private int ID;
    private String name;
    private int quantity;

    public Ingredient(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Ingredient(int ID, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
