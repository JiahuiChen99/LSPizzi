package view;

import model.dough.Dough;
import model.drink.Drink;
import model.ingredient.Ingredient;
import model.pizza.Pizza;
import java.util.List;
import java.util.Scanner;

public class OrderForm {
    private Scanner customerIput;

    public OrderForm() {
        // Create a new input scanner
        this.customerIput = new Scanner(System.in);
    }

    public String customerChoice() {
        return this.customerIput.nextLine();
    }

    public String welcome() {
        System.out.println("###############################################");
        System.out.println("Welcome to LSPizzi");
        System.out.println("###############################################");
        System.out.println("\t[1]- Place an order");
        System.out.println("\t[2]- Exit");
        System.out.println("Select an option:");
        return customerChoice();
    }

    public String delegations() {
        System.out.println("###############################################");
        System.out.println("Which restaurant");
        System.out.println("###############################################");
        System.out.println("First choose where you want to place the order (Delegation)");
        System.out.println("\t[1]- Barcelona");
        System.out.println("\t[2]- Lleida");
        System.out.println("\t[3]- Tarragona");
        System.out.println("\t[4]- Girona");
        return customerChoice();
    }

    public String newOrder() {
        System.out.println("###############################################");
        System.out.println("Create a new order");
        System.out.println("###############################################");
        System.out.println("Select a product");
        System.out.println("\t[1]- Add Pizza");
        System.out.println("\t[2]- Add Soft Drink");
        System.out.println("\t[3]- Place order");
        System.out.println("\t[4]- Exit");
        return customerChoice();
    }

    public String pizzas(List<Pizza> pizzas) {
        System.out.println("> Available pizzas");
        pizzas.forEach( pizza -> {
            System.out.println("\t[" + pizza.getID() + "]- " + pizza.getName() + " " + pizza.getFormattedIngredients());
        });
        return customerChoice();
    }

    public String doughs(List<Dough> doughs) {
        System.out.println("> Available doughs");
        doughs.forEach( dough -> {
            System.out.println("\t[" + dough.getID() + "]- " + dough.getName());
        });
        return customerChoice();
    }

    public String legalAge() {
        System.out.println("> What's your age:");
        return customerChoice();
    }

    public String drinks(List<Drink> drinks) {
        System.out.println("> Available drinks");
        drinks.forEach( drink -> {
            System.out.println("\t[" + drink.getID() + "]- " + drink.getName());
        });
        return customerChoice();
    }

    public String extras(List<Ingredient> extras) {
        System.out.println("> Available extras");
        extras.forEach( extra -> {
            System.out.println("\t[" + extra.getID() + "]- " + extra.getName());
        });
        return customerChoice();
    }

    public String wantExtra() {
        System.out.println("> Want extra ingredient?");
        System.out.println("\t[1]- Yes");
        System.out.println("\t[2]- No");
        return customerChoice();
    }

    public void customerForm() {
        System.out.println("###############################################");
        System.out.println("Fill Customer Information Form");
        System.out.println("###############################################");
    }

    // Ask questions to user
    public void showMessage(String question) {
        System.out.println(question);
    }

    public void error(String error_message) {
        System.out.println(error_message);
    }
}
