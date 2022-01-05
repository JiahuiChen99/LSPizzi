package controller;

import model.Customer;
import view.OrderForm;

public class CustomerForm {
    private CustomerFormState state;
    private OrderForm orderForm;
    private Customer customer_data = new Customer();

    public CustomerForm(OrderForm orderForm) {
        this.orderForm = orderForm;
        this.state = new CustomerFormPhone(this);
        // Ask first question
        this.state.getInformation();
    }

    /**
     * Changes the state and ask the next question
     * of the user information form
     */
    public void nextQuestion(CustomerFormState next_state) {
        this.state = next_state;
        // Ask next question
        this.state.getInformation();
    }

    public OrderForm getOrderForm() {
        return orderForm;
    }

    public Customer getCustomerData() {
        return customer_data;
    }
}
