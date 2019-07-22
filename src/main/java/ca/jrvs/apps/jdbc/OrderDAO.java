package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataAccessObject;
import ca.jrvs.apps.jdbc.util.DataTransferObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class OrderDAO extends DataAccessObject {

    //constructor
    public OrderDAO(Connection conn){
        super(conn);
    }

    public static final String givenSQLstat = "SELECT c.first_name, c.last_name, c.email, o.order_id, o.creation_date, o.total_due, o.status, s.first_name, s.last_name, s.email, ol.quantity, p.code, p.name, p.size, p.variety, p.price FROM orders o JOIN customer c on o.customer_id = c.customer_id JOIN salesperson s on o.salesperson_id = s.salesperson_id JOIN order_item ol on ol.order_id = o.order_id JOIN product p on ol.product_id = p.product_id where o.order_id = ?";

/**

    public static final String givenSQLstat = " SELECT cust_first_name, cust_last_name, cust_email, ord_id, ord_creation_date, ord_total_due, ord_status, sale_first_name, sale_last_name, sale_email, ord_qty, prod_code, prod_name , prod_size, prod_variety, prod_price"
            + " FROM orders o " +
            "JOIN customer c on o.customer_id = c.customer_id " +
            "JOIN salesperson s on o.salesperson_id = s.salesperson_id " +
            "JOIN order_item ol on ol.order_id = o.order_id " +
            "JOIN product p on ol.product_id = p.product_id where o.order_id = ?";
    */

    @Override
    public DataTransferObject findByID(long id) {
        Order order = new Order();

        try{
            PreparedStatement stat = this.cnt.prepareStatement(givenSQLstat);
            stat.setLong(1,id);
            ResultSet resultSet = stat.executeQuery();

            while (resultSet.next()) {
                order.setCust_first_name(resultSet.getString(1));
                order.setCust_last_name(resultSet.getString(2));
                order.setCust_email(resultSet.getString(3));
                order.setId(resultSet.getLong(4));
                order.setOrd_creation_date(new Date(resultSet.getDate(5).getTime()));
                order.setOrd_total_due(resultSet.getInt(6));
                order.setOrd_status(resultSet.getString(7));
                order.setSale_first_name(resultSet.getString(8));
                order.setSale_last_name(resultSet.getString(9));
                order.setSale_email(resultSet.getString(10));
                order.setOrd_qty(resultSet.getInt(11));
                order.setProd_code(resultSet.getString(12));
                order.setProd_name(resultSet.getString(13));
                order.setProd_variety(resultSet.getString(14));
                order.setProd_size(resultSet.getInt(15));
                order.setProd_price(resultSet.getInt(16));
                order.setId(id);


            }
        }

        catch(SQLException er){
            er.printStackTrace();
            throw new RuntimeException(er);
        }
        return order;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public DataTransferObject update(DataTransferObject dto) {
        return null;
    }

    @Override
    public void delete(long id) {
    }

    @Override
    public DataTransferObject create(DataTransferObject dto)  {
        return null;
    }


}