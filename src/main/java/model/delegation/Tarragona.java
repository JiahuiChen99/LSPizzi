package model.delegation;

public class Tarragona extends Delegation {

    public Tarragona(int ID, String name) {
        super(ID, name);
    }

    @Override
    public int getDelegationSpecialPizza() {
        return 20;  // "Tarragona" pizza
    }
}
