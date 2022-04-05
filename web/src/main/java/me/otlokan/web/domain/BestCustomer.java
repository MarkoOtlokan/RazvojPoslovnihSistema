package me.otlokan.web.domain;

public class BestCustomer {
    private long Customerid;
    private String firstName;
    private String lastName;
    private long spend;

    public BestCustomer(long id, String firstName, String lastName, long spend) {
        this.Customerid = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.spend = spend;
    }

    public BestCustomer() {
    }

    public long getCustomerid() {
        return Customerid;
    }

    public void setCustomerid(long customerid) {
        Customerid = customerid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getSpend() {
        return spend;
    }

    public void setSpend(long spend) {
        this.spend = spend;
    }

    @Override
    public String toString() {
        return "BestCustomer{" +
                "Customerid=" + Customerid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", spend=" + spend +
                '}';
    }


}
