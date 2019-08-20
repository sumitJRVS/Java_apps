package ca.jrvs.apps.jdbc;

/**
 * This JDBCjavaExecutor class has main method that can perform functions like:
 * 1) Established JDBC connection manager
 * 2) Generate JDBC connection
 * 3) Execute statement,
 * 4) Get resultset
 * 5) Operation on created data.
 */

public class JDBCjavaExe_deprecatedV0 {

    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");

        /**
         *  Connection connect = dcm.getConnect();
         */


        /** Statement-object is created to build some query.
         * Statement stm = connect.createStatement();
         * /

         /** Resultset-object is created and stored the output of query.
         *  Resultset is multidimensional array that returns a db statement. Iterating on Resultset is possible e.g. while (resultSet.next());
         *  ResultSet rset = stm.executeQuery("SELECT COUNT (*) FROM CUSTOMER");
         *
         * while (rset.next()) {
         *   System.out.println(rset.getInt(1));
         *   }
         *
         */
            /*
            This works for insert statement main method
            Connection connect = dcm.getConnect();

            CustomerDAO customerDAO = new CustomerDAO(connect);
            Customer cust_obj_instnc =  new Customer();

            customerDAO.create(cust_obj_instnc);


            cust_obj_instnc.setFirst_name("Sumit");
            cust_obj_instnc.setLast_name("Mistry");
            cust_obj_instnc.setEmail("sumit@live.com");
            cust_obj_instnc.setPhone("647-123-1234");
            cust_obj_instnc.setAddress("108_Steven");
            cust_obj_instnc.setCity("Toronto");
            cust_obj_instnc.setState("Ontario");
            cust_obj_instnc.setZipcode("M5A1A1");
            System.out.println("Added 1 record into Customer table...");
            */
        /**
         * This is findbyID method main run
         * Connection con = dcm.getConnect();
         * CustomerDAO custoDAO = new CustomerDAO(con);
         * Customer cust = custoDAO.findByID(10018 );
         * System.out.println(cust.getFirst_name());
         *
         */

        /**
         * This is Update method's main run
         *
         * Connection con = dcm.getConnect();
         * CustomerDAO cDao = new CustomerDAO(con);
         * Customer customer = cDao.findByID(10001);
         * System.out.println(customer.getFirst_name()+ customer.getLast_name());
         *
         * customer.setFirst_name("GgGIZI");
         * customer.setLast_name("Zhnanag");
         *
         * customer = cDao.update(customer);
         * System.out.println(customer.getFirst_name() + customer.getLast_name());
         */

        /**
         * This is DELETE method in the main run
         *
         * Connection cm = dcm.getConnect();
         * CustomerDAO cusDAO = new CustomerDAO(cm);
         * Customer cust = new Customer();
         * cusDAO.delete(1000);
         */


    }

}

