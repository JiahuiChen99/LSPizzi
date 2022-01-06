package model.delegation;

public abstract class Delegation {
    private int ID;
    private String name;

    public Delegation(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    /**
     * Abstract method that acts like an interface
     * so that different delegations can have their
     * own specialty pizza
     * @return local pizza name
     */
    public abstract int getDelegationSpecialPizza();

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
