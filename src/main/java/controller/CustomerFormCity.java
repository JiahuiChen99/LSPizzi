package controller;

public class CustomerFormCity extends CustomerFormState{
    public CustomerFormCity(CustomerForm customerForm) {
        super(customerForm);
    }

    /**
     * Get user's city
     * This method could check if it's an
     * actual city in the world
     *
     * For the simplicity of the program the
     * method doesn't check if it's valid.
     */
    @Override
    public void getInformation() {
        this.customerForm.getOrderForm().showMessage("Enter city:");
        String customer_city = this.customerForm.getOrderForm().customerChoice();

        // Store the customer data
        this.customerForm.getCustomerData().setCity(customer_city);

        // No more questions
    }
}
