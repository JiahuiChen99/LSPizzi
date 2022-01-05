package controller;

public abstract class CustomerFormState {
    CustomerForm customerForm;

    public CustomerFormState(CustomerForm customerForm) {
        this.customerForm = customerForm;
    }

    /**
     * This abstract method will be overridden
     * to get the information according to the
     * customer form state
     * 1. Get Customer Telephone
     * 2. Get Customer Name
     * 3. Get Customer Address
     * 4. Get Customer City
     */
    public abstract void getInformation();
}
