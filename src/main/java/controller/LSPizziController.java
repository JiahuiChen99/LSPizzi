package controller;

import database.DBQueries;
import model.Customer;
import model.LSPizzi;
import model.delegation.Delegation;
import model.delegation.DelegationFactory;
import model.drink.Drink;
import model.pizza.Pizza;
import view.OrderForm;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<Pizza> customer_pizzas = new ArrayList<>();
        ArrayList<Drink> customer_drinks = new ArrayList<>();

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
            switch ( Integer.parseInt(this.orderForm.newOrder()) ) {
                case 1 -> selectPizza(customer_pizzas);
                case 2 -> selectDrink(customer_drinks);
                // Store order
                case 3 -> System.out.println("Storing data");
                // Exit program
                case 4 -> order_steps++;
                // Not valid option
                default -> System.out.println("Incorrect selection");
            }
        }
    }

    public void selectPizza(ArrayList<Pizza> customer_pizzas) {
        // Check if the client has already chosen 10 pizzas
        if ( customer_pizzas.size() >= 10 ) {
            System.out.println("You've already chosen 10 pizzas!");
            return;
        }

        // Choose pizza
        this.orderForm.pizzas(this.lsPizzi.getPizzas());

        // Choose dough type
        this.orderForm.doughs(this.lsPizzi.getDoughs());
    }

    public void selectDrink(ArrayList<Drink> customer_drinks) {
        if ( customer_drinks.size() >= 10 ) {
            System.out.println("You've already chosen 10 drinks!");
            return;
        }
        this.orderForm.drinks(this.lsPizzi.getDrinks());
    }
}
