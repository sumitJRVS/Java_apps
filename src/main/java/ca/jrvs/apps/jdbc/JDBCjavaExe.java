package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCjavaExe {

    public static void main(String[] args) {


        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");

        Customer cust = new Customer();

        try {
            Connection connect = dcm.getConnect();
            CustomerDAO cusDAO = new CustomerDAO(connect);


            switch (args[0]) {


                case "create":
                    //Argument: create "Bill" "Gates" "bill@gate.com" "123-123-4567" "38ElmStreet" "Toronto" "Ontario" "M55555"
                    cust.setFirst_name(args[1]);
                    cust.setLast_name(args[2]);
                    cust.setEmail(args[3]);
                    cust.setPhone(args[4]);
                    cust.setAddress(args[5]);
                    cust.setCity(args[6]);
                    cust.setState(args[7]);
                    cust.setZipcode(args[8]);
                    System.out.println("Added 1 record into Customer table...");
                    System.out.println(cusDAO.create(cust));
                    break;

                case "update":
                    cust.setId(Long.getLong(args[1]));
                    cust.setFirst_name(args[2]);
                    cust.setLast_name(args[3]);
                    cust.setEmail(args[4]);
                    cust.setPhone(args[5]);
                    cust.setAddress(args[6]);
                    cust.setCity(args[7]);
                    cust.setState(args[8]);
                    cust.setZipcode(args[9]);
                    System.out.println("Updated 1 record into Customer table...");
                    System.out.println(cusDAO.update(cust));
                    break;

                case "read":
                    System.out.println(cusDAO.findByID(Integer.valueOf(args[1])));
                    break;

                case "order":
                    OrderDAO ordDAO = new OrderDAO(connect);
                    System.out.println(ordDAO.findByID(Integer.valueOf(args[1])));
                    break;


                case "delete":
                    cusDAO.delete(Integer.valueOf(args[1]));
                    System.out.println(args[1] + "Deleted record from Customer table...");
                    break;

                default:
                    System.out.println("Usage: create|update|read|update|delete");

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

}
