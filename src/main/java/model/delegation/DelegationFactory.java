package model.delegation;

/**
 * Factory method that creates a new delegation
 * depending on the ID. All four delegations
 * { Barcelona, Lleida, Tarragona, Girona }
 * extends from the abstract class Delegation.
 * That class contains an abstract method to be
 * overriden by the specific delegation.
 */
public class DelegationFactory {
    public static Delegation getDelegation( int place ) throws ClassNotFoundException {
        Delegation delegation = null;
        switch ( place ) {
            case 1 -> delegation = new Barcelona(1, DelegationType.BARCELONA.name());
            case 2 -> delegation = new Lleida(2, DelegationType.LLEIDA.name());
            case 3 -> delegation = new Tarragona(3, DelegationType.TARRAGONA.name());
            case 4 -> delegation = new Girona(4, DelegationType.GIRONA.name());
            default->
                throw new ClassNotFoundException();
        }
        return delegation;
    }
}
