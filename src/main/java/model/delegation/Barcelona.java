package model.delegation;

public class Barcelona extends Delegation{
    public Barcelona(int ID, String name) {
        super(ID, name);
    }

    @Override
    public String getDelegationSpecialPizza() {
        return "Barcelona";
    }
}
