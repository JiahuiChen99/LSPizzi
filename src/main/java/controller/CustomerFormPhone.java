package controller;

public class CustomerFormPhone extends CustomerFormState{
    public CustomerFormPhone(CustomerForm customerForm) {
        super(customerForm);
    }

    /**
     * Get user telephone number
     * This method could check if the phone
     * is a valid one or not using some regex
     * and keep asking if it doesn't match
     *
     * For the simplicity of the program the
     * method doesn't check if it's valid.
     */
    @Override
    public void getInformation() {
        this.customerForm.getOrderForm().showMessage("Enter telephone number:");
        String phone_number = this.customerForm.getOrderForm().customerChoice();

        // Store the customer data
        this.customerForm.getCustomerData().setPhone(phone_number);

        // Change state and ask next question
        this.customerForm.nextQuestion(
                new CustomerFormName(this.customerForm)
        );
    }
}
