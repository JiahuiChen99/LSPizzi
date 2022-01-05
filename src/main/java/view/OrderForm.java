package view;

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

    public void doughs() {
        System.out.println("###############################################");
        System.out.println("Available doughs");
        System.out.println("###############################################");

        // TODO: Print doughs
    }

    public void drinks() {
        System.out.println("###############################################");
        System.out.println("Available drinks");
        System.out.println("###############################################");

        // TODO: Print drinks
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
