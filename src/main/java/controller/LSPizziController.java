package controller;

import database.DBClient;
import database.DBQueries;
import model.LSPizzi;
import model.delegation.Delegation;
import view.OrderForm;

public class LSPizziController {
    private LSPizzi lsPizzi;
    private OrderForm orderForm;
    private DBQueries dbQueries;

    public LSPizziController(LSPizzi lsPizzi, OrderForm orderForm, DBQueries dbQueries) {
        this.lsPizzi = lsPizzi;
        this.orderForm = orderForm;
        this.dbQueries = dbQueries;
    }

    public void runPizzi(){
        boolean leave = false;
        while ( !leave ) {
            // Greet the user and let her/him place
            // an order or leave the restaurant
            String choice = this.orderForm.welcome();
            switch ( Integer.parseInt(choice) ) {
                case 1 -> placeOrder();
                case 2 -> leave = true;
            }
        }
    }

    private void placeOrder() {
        Delegation delegation = null;

        String choice = this.orderForm.newOrder();

    }
}
