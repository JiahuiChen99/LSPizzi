package model.delegation;

public class Barcelona extends Delegation{
    public Barcelona(int ID, String name) {
        super(ID, name);
    }

    @Override
    public int getDelegationSpecialPizza() {
        return 18;  // "Barcelona" pizza
    }
}
