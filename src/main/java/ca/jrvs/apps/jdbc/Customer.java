package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataTransferObject;

// Customer class or Customer.java help implementing DTO interface
public class Customer implements DataTransferObject {

    final StringBuilder cust_str = new StringBuilder();
    private long customer_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;

    // 1 compulsory by default implementation here;
    @Override
    public long getId() {
        return this.customer_id;
    }

    ///more getter setter implementation can be added now;
    public void setId(long ip_customer_id) {
        this.customer_id = ip_customer_id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String ip_first_name) {
        this.first_name = ip_first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String ip_last_name) {
        this.last_name = ip_last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String ip_email) {
        this.email = ip_email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String ip_phone) {
        this.phone = ip_phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String ip_address) {
        this.address = ip_address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String ip_city) {
        this.city = ip_city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String ip_state) {
        this.state = ip_state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String ip_zipcode) {
        this.zipcode = ip_zipcode;
    }

    @Override
    public String toString() {


        this.cust_str.append("customer{");
        this.cust_str.append("id=");
        this.cust_str.append(customer_id);
        this.cust_str.append(", first_name" + first_name + '\'');
        this.cust_str.append(", last_name" + last_name + '\'');
        this.cust_str.append(", email" + email + '\'');
        this.cust_str.append(", phone" + phone + '\'');
        this.cust_str.append(", address" + address + '\'');
        this.cust_str.append(", city" + city + '\'');
        this.cust_str.append(", state" + state + '\'');
        this.cust_str.append(", zipcode" + zipcode + '\'');
        this.cust_str.append('}');

        return this.cust_str.toString();
    }

}

