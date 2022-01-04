package model.delegation;

public class Delegation {
    private int ID;
    private String name;

    public Delegation(int ID, String name) {
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
