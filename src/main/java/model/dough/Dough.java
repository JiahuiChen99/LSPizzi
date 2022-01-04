package model.dough;

public class Dough {
    private int ID;
    private String name;

    // Drink Constructors
    public Dough(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Dough(int ID) {
        this.ID = ID;
    }

    public Dough(String name) {
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
