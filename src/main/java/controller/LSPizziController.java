package controller;

import database.DBQueries;
import model.Customer;
import model.LSPizzi;
import model.delegation.Delegation;
import model.delegation.DelegationFactory;
import model.dough.Dough;
import model.drink.Drink;
import model.ingredient.Ingredient;
import model.pizza.Pizza;
import model.pizza.PizzaBuilder;
import view.OrderForm;

import java.util.*;

public class LSPizziController {
    private LSPizzi lsPizzi;
    private OrderForm orderForm;
    private DBQueries dbQueries;
    private Set<Integer> special_pizzas_ID = new HashSet<Integer>(Arrays.asList(18,19,20,21));

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
            if ( choice >= 1 && choice <= 4) order_steps++;
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
                case 1 -> selectPizza(customer_pizzas, delegation);
                case 2 -> selectDrink(customer_drinks);
                // Store order
                case 3 -> saveOrder(delegation, customer, customer_pizzas, customer_drinks);
                // Exit program
                case 4 -> order_steps++;
                // Not valid option
                default -> System.out.println("Incorrect selection");
            }
        }
    }

    public void selectPizza(ArrayList<Pizza> customer_pizzas, Delegation delegation) {
        // Check if the client has already chosen 10 pizzas
        if ( customer_pizzas.size() >= 10 ) {
            System.out.println("You've already chosen 10 pizzas!");
            return;
        }

        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        int choice = -1;
        // Choose pizza
        while ( choice <= 0 || choice >= 25 ){
            // Delete other delegation's pizzas;
            ArrayList<Pizza> availabe_pizzas = (ArrayList<Pizza>) this.lsPizzi.getPizzas();

            Iterator<Pizza> it = availabe_pizzas.iterator();
            int this_delegation_pizza = delegation.getDelegationSpecialPizza();

            // Remove by ID and maintain the delegation pizza
            while (it.hasNext()) {
                int pizza_id = it.next().getID();
                if ( special_pizzas_ID.contains(pizza_id)
                        && pizza_id != this_delegation_pizza ) {
                    it.remove();
                }
            }

            choice = Integer.parseInt(this.orderForm.pizzas(availabe_pizzas));
            if ( special_pizzas_ID.contains(choice) && choice != this_delegation_pizza ) {
                this.orderForm.error("Not an available pizza in your delegation");
                choice = -1;
            } else if ( choice <= 0 || choice >= 25 ) {
                this.orderForm.error("Choose from the available ones");
            } else {
                 pizzaBuilder.setPizzaID(choice);
            }
        }

        choice = -1;
        // Choose dough type
        while (choice <= 0 || choice >= 4) {
            choice = Integer.parseInt(this.orderForm.doughs(this.lsPizzi.getDoughs()));
        }
        pizzaBuilder.chooseDough(new Dough(choice));

        HashMap<Integer, Integer> chosen_extras = new HashMap<>();

        choice = -1;
        // Ask for Extras
        while (choice <= 0 || choice >= 3) {
            choice = Integer.parseInt(this.orderForm.wantExtra());
            if ( choice == 1) {
                int choice2 = -1;
                while (choice2 <= 0 || choice2 >= 34) {
                     choice2 = Integer.parseInt(this.orderForm.extras(this.lsPizzi.getIngredients()));
                }

                // Search if the customer has chosen before
                Integer quantity = chosen_extras.get(choice2);
                if (quantity == null) quantity = 0;
                if ( quantity == 10 ) {
                    this.orderForm.error("Reached maximum of 10 elements for this ingredient");
                } else {
                    // Choose quantity
                    int q = -1;
                    while ( q <= 0 || q >= (10 - quantity) + 1) {
                        this.orderForm.showMessage("Available quantity [1 - " + (10 - quantity) + "]");
                        q = Integer.parseInt(this.orderForm.customerChoice());
                    }

                    // Add element
                    chosen_extras.put(choice2, q + quantity);
                }
                // Let the customer add another ingredient if she/he wants
                choice = -1;
            }
        }

        // Save the extras to the pizza
        ArrayList<Ingredient> list_extras = new ArrayList<>();
        chosen_extras.forEach((extra, quantity) -> {
            list_extras.add(new Ingredient(extra, quantity));
        });
        pizzaBuilder.addExtra(list_extras);

        // Add pizza to order
        customer_pizzas.add(pizzaBuilder.build());
    }

    public void selectDrink(ArrayList<Drink> customer_drinks) {
        if ( customer_drinks.size() >= 10 ) {
            System.out.println("You've already chosen 10 drinks!");
            return;
        }
        int drink = -1;
        // Check legal age for alcoholic drinks
        int age = Integer.parseInt(this.orderForm.legalAge());
        while (drink <= 0 || drink >= 4 || (age <= 17 && drink == 3) ) {
            drink = Integer.parseInt(this.orderForm.drinks(this.lsPizzi.getDrinks()));
            if ((age <= 17 && drink == 3)) {
                System.out.println("You're underage, choose a non-alcoholic drink!");
            }
        }

        customer_drinks.add(new Drink(drink));
    }

    private void saveOrder(Delegation delegation, Customer customer, ArrayList<Pizza> customer_pizzas,ArrayList<Drink> customer_drinks) {
        // Save customer data
        this.dbQueries.setClient(customer);
        // Save customer order
        this.dbQueries.setOrder(delegation, customer, customer_pizzas, customer_drinks);
    }
}
