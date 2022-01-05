package controller;

import database.DBQueries;
import model.Customer;
import model.LSPizzi;
import model.delegation.Delegation;
import model.delegation.DelegationFactory;
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
        int order_steps = 1;
        Delegation delegation = null;
        Customer customer = null;

        // Choose delegation to place an order
        while ( order_steps == 1 ) {
            int choice = Integer.parseInt(this.orderForm.delegations());
            if ( choice >= 1 && choice <= 3) order_steps++;
            // Get the delegation
            try {
                delegation = DelegationFactory.getDelegation(choice);
            } catch (ClassNotFoundException e) {
                this.orderForm.error("Incorrect delegation");
            }
        }

        // Fill customer information form
        while ( order_steps == 2) {
            this.orderForm.customerForm();
            CustomerForm customerForm = new CustomerForm(orderForm);
            customer = customerForm.getCustomerData();
            order_steps++;
        }

        // New order
        while ( order_steps == 3 ) {
            // Exit program
            if ( Integer.parseInt(this.orderForm.newOrder()) == 4) break;

            // Store order

        }
    }
}
