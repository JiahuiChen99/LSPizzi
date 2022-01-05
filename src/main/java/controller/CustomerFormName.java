package controller;

public class CustomerFormName extends CustomerFormState{
    public CustomerFormName(CustomerForm customerForm) {
        super(customerForm);
    }

    /**
     * Get user's Name, Surname1, Surname2
     * This method could check if the data
     * is a valid one or not using some regex
     * and keep asking if it doesn't match
     *
     * For the simplicity of the program the
     * method doesn't check if it's valid.
     */
    @Override
    public void getInformation() {
        this.customerForm.getOrderForm().showMessage("Enter name:");
        String customer_name = this.customerForm.getOrderForm().customerChoice();

        this.customerForm.getOrderForm().showMessage("Enter surname 1:");
        String customer_surname1 = this.customerForm.getOrderForm().customerChoice();

        this.customerForm.getOrderForm().showMessage("Enter surname 2:");
        String customer_surname2 = this.customerForm.getOrderForm().customerChoice();

        // Store the customer data
        this.customerForm.getCustomerData().setName(customer_name);
        this.customerForm.getCustomerData().setSurname_1(customer_name);
        this.customerForm.getCustomerData().setSurname_2(customer_name);

        // Change state and ask next question
        this.customerForm.nextQuestion(
                new CustomerFormAddress(this.customerForm)
        );
    }
}
