package ca.jrvs.apps.jdbc;


import ca.jrvs.apps.jdbc.util.DataTransferObject;

import java.util.Date;

public class Order implements DataTransferObject {


    private String cust_first_name;
    private String cust_last_name;
    private String cust_email;
    private long orderID;
    private Date ord_creation_date;
    private Integer ord_total_due;
    private String ord_status;
    private String sale_first_name;


    private String sale_last_name;
    private String sale_email;
    private Integer ord_qty;
    private String prod_code;
    private String prod_name;

    private String prod_variety;
    private Integer prod_size;
    private Integer prod_price;
    private long id;


    @Override
    public String toString() {
        return "Order{" +
                "cust_first_name='" + cust_first_name + '\'' +
                ", cust_last_name='" + cust_last_name + '\'' +
                ", cust_email='" + cust_email + '\'' +
                ", orderID=" + orderID +
                ", ord_creation_date=" + ord_creation_date +
                ", ord_total_due=" + ord_total_due +
                ", ord_status='" + ord_status + '\'' +
                ", sale_first_name='" + sale_first_name + '\'' +
                ", sale_last_name='" + sale_last_name + '\'' +
                ", sale_email='" + sale_email + '\'' +
                ", ord_qty=" + ord_qty +
                ", prod_code='" + prod_code + '\'' +
                ", prod_name='" + prod_name + '\'' +
                ", prod_variety='" + prod_variety + '\'' +
                ", prod_size=" + prod_size +
                ", prod_price=" + prod_price +
                ", id=" + id +
                '}';
    }

    @Override
    public long getId() {
        return 0;
    }

    public String getCust_first_name() {
        return cust_first_name;
    }

    public void setCust_first_name(String cust_first_name) {
        this.cust_first_name = cust_first_name;
    }

    public String getCust_last_name() {
        return cust_last_name;
    }

    public void setCust_last_name(String cust_last_name) {
        this.cust_last_name = cust_last_name;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public Date getOrd_creation_date() {
        return ord_creation_date;
    }

    public void setOrd_creation_date(Date ord_creation_date) {
        this.ord_creation_date = ord_creation_date;
    }

    public Integer getOrd_total_due() {
        return ord_total_due;
    }

    public void setOrd_total_due(Integer ord_total_due) {
        this.ord_total_due = ord_total_due;
    }

    public String getOrd_status() {
        return ord_status;
    }

    public void setOrd_status(String ord_status) {
        this.ord_status = ord_status;
    }

    public String getSale_first_name() {
        return sale_first_name;
    }

    public void setSale_first_name(String sale_first_name) {
        this.sale_first_name = sale_first_name;
    }

    public String getSale_last_name() {
        return sale_last_name;
    }

    public void setSale_last_name(String sale_last_name) {
        this.sale_last_name = sale_last_name;
    }

    public String getSale_email() {
        return sale_email;
    }

    public void setSale_email(String sale_email) {
        this.sale_email = sale_email;
    }

    public Integer getOrd_qty() {
        return ord_qty;
    }

    public void setOrd_qty(Integer ord_qty) {
        this.ord_qty = ord_qty;
    }

    public String getProd_code() {
        return prod_code;
    }

    public void setProd_code(String prod_code) {
        this.prod_code = prod_code;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_variety() {
        return prod_variety;
    }

    public void setProd_variety(String prod_variety) {
        this.prod_variety = prod_variety;
    }

    public Integer getProd_size() {
        return prod_size;
    }

    public void setProd_size(Integer prod_size) {
        this.prod_size = prod_size;
    }

    public Integer getProd_price() {
        return prod_price;
    }

    public void setProd_price(Integer prod_price) {
        this.prod_price = prod_price;
    }

    public void setId(long id) {
        this.id = id;
    }
}