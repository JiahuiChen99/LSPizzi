package model.delegation;

public class Girona extends Delegation {

    public Girona(int ID, String name) {
        super(ID, name);
    }

    @Override
    public int getDelegationSpecialPizza() {
        return 19;  // "Girona" pizza
    }
}
