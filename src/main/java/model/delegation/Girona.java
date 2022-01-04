package model.delegation;

public class Girona extends Delegation {

    public Girona(int ID, String name) {
        super(ID, name);
    }

    @Override
    public String getDelegationSpecialPizza() {
        return "Girona";
    }
}
