package model;

public class Customer {
    private int ID;
    private String name;
    private String surname_1;
    private String surname_2;
    private String phone;
    private String address;
    private String city;
    private boolean vip;   // For customers who have ordered more than one time

    public Customer() {
    }

    public Customer(int ID, String name, String surname_1, String surname_2, String phone, String address, String city, boolean vip) {
        this.ID = ID;
        this.name = name;
        this.surname_1 = surname_1;
        this.surname_2 = surname_2;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.vip = vip;
    }

    // Getters & Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname_1() {
        return surname_1;
    }

    public void setSurname_1(String surname_1) {
        this.surname_1 = surname_1;
    }

    public String getSurname_2() {
        return surname_2;
    }

    public void setSurname_2(String surname_2) {
        this.surname_2 = surname_2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
