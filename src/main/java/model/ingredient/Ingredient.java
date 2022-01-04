package model.ingredient;

public class Ingredient {
    private int ID;
    private String name;

    public Ingredient(int ID, String name) {
        this.ID = ID;
        this.name = name;
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

}
