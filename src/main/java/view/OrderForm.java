package view;

import java.util.Scanner;

public class OrderForm {
    private Scanner customerIput;

    public OrderForm() {
        // Create a new input scanner
        this.customerIput = new Scanner(System.in);
    }

    private String customerChoice() {
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

    public String newOrder() {
        System.out.println("###############################################");
        System.out.println("Create a new order");
        System.out.println("###############################################");
        System.out.println("First choose where you want to place the order (Delegation)");
        System.out.println("\t[1]. Barcelona");
        System.out.println("\t[1]. Lleida");
        System.out.println("\t[1]. Tarragona");
        System.out.println("\t[1]. Girona");
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
}
