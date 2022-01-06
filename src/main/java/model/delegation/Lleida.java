package model.delegation;

public class Lleida extends Delegation {

    public Lleida(int ID, String name) {
        super(ID, name);
    }

    @Override
    public int getDelegationSpecialPizza() {
        return 21;  // "Lleida" pizza
    }
}
