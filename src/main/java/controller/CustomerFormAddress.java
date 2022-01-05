package controller;

public class CustomerFormAddress extends CustomerFormState{
    public CustomerFormAddress(CustomerForm customerForm) {
        super(customerForm);
    }

    /**
     * Get user's Address
     * This method could check if the address
     * is a valid one or not
     *
     * For the simplicity of the program the
     * method doesn't check if it's valid.
     */
    @Override
    public void getInformation() {
        this.customerForm.getOrderForm().showMessage("Enter address:");
        String customer_address = this.customerForm.getOrderForm().customerChoice();

        // Store the customer data
        this.customerForm.getCustomerData().setAddress(customer_address);

        // Change state and ask next question
        this.customerForm.nextQuestion(
                new CustomerFormCity(this.customerForm)
        );
    }
}
