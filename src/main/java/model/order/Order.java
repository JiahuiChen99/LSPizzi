package model.order;

public class Order {
    private String ID;
    private String date_time;
    private String customer_ID;
    private String delegation_ID;

    public Order(String ID, String date_time, String customer_ID, String delegation_ID) {
        this.ID = ID;
        this.date_time = date_time;
        this.customer_ID = customer_ID;
        this.delegation_ID = delegation_ID;
    }

    // Getters & Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getDelegation_ID() {
        return delegation_ID;
    }

    public void setDelegation_ID(String delegation_ID) {
        this.delegation_ID = delegation_ID;
    }
}
