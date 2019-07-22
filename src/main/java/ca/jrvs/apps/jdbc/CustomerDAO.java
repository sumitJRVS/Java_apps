package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataAccessObject;

import java.sql.*;
import java.util.List;

/** DataAccessObject interface  is extended by CutomerDAO class in here.
 *
 */

// DTO implements
//abstract DAO  class extends


public class CustomerDAO extends DataAccessObject<Customer> {


    private static final String INSERT = "Insert into customer (first_name,last_name, email,phone,address,city,state,zipcode) Values (?,?,?,?,?,?,?,?)";

    private static final String FIND_ONE = "SELECT customer_id, first_name, last_name, email,"+
            "phone, address, city, state, zipcode FROM customer WHERE customer_id=?";

    private static final String UPDATE = "UPDATE customer SET first_name=?, last_name=?, email=?, phone=?, address=?, city=?, state=?, zipcode=? WHERE customer_id = ?";

    private static final String DELETE = "DELETE FROM customer WHERE customer_id = ?";

    //constuctor
    public CustomerDAO(Connection connect) {
        super(connect);
    }

    // Extended Methods from thee original abstract class DAO
    @Override
    public Customer findByID(long id) {
        Customer customer = new Customer();

        try {
            PreparedStatement stat = this.cnt.prepareStatement(FIND_ONE);
            stat.setLong(1, id); // setLong ( placeholder, id), here i=1 is the one of the column to fill in for id.
            ResultSet rs = stat.executeQuery();
            //Benefit of making Resultset; is we can iterate using lop below;
            while (rs.next()) {
                customer.setId(rs.getLong("customer_id"));
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setZipcode(rs.getString("zipcode"));

            }
        } catch (SQLException err404) {
            err404.printStackTrace();
            throw new RuntimeException(err404);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer update(Customer dto) {

        Customer cust_upd = new Customer();
        try {
            PreparedStatement stat = this.cnt.prepareStatement(UPDATE);
            stat.setString(1, dto.getFirst_name());
            stat.setString(2, dto.getLast_name());
            stat.setString(3, dto.getEmail());
            stat.setString(4, dto.getPhone());
            stat.setString(5, dto.getAddress());
            stat.setString(6, dto.getCity());
            stat.setString(7, dto.getState());
            stat.setString(8, dto.getZipcode());
            stat.setLong(9, dto.getId());
            stat.execute();

            cust_upd = this.findByID(dto.getId());

        } catch (SQLException err404) {
            err404.printStackTrace();
            throw new RuntimeException();
        }
        return cust_upd;

    }

    @Override
    public void delete(long id) {
        try {
            PreparedStatement stat = cnt.prepareStatement(DELETE);
            stat.setLong(1, id);
            stat.execute();
        }
        catch(SQLException err){
            err.printStackTrace();
            throw  new RuntimeException("failed to delete!" + err);
        }

    }

    @Override
    public Customer create(Customer dto) throws SQLException {
        try {
            /**JDBC order>> Connection manager>> Connection>> Statement>> Resultset
             * Prepare statement, add data, verify-test last added data by returning last value-id
             */
            PreparedStatement stat = this.cnt
                    .prepareStatement(INSERT);
            stat.setString  (1, dto.getFirst_name());
            stat.setString  (2, dto.getLast_name());
            stat.setString  (3, dto.getEmail());
            stat.setString  (4, dto.getPhone());
            stat.setString  (5, dto.getAddress());
            stat.setString  (6, dto.getCity());
            stat.setString  (7, dto.getState());
            stat.setString  (8, dto.getZipcode());
            stat.execute();
            int last_id = this.getLastValue(CUSTOMER_SEQUENCE);
            return this.findByID(last_id);

        } catch (SQLException err404) {
            err404.printStackTrace();
            throw new RuntimeException(err404);
        }

    }
}
