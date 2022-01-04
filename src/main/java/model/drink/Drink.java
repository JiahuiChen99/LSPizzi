package model.drink;

public class Drink {
    private int ID;
    private String name;

    // Drink Constructors
    public Drink(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Drink(int ID) {
        this.ID = ID;
    }

    public Drink(String name) {
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
