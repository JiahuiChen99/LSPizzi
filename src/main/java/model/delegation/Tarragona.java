package model.delegation;

public class Tarragona extends Delegation {

    public Tarragona(int ID, String name) {
        super(ID, name);
    }

    @Override
    public String getDelegationSpecialPizza() {
        return "Tarragona";
    }
}
