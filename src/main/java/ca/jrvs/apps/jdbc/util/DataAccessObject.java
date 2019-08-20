package ca.jrvs.apps.jdbc.util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DataAccessObject<T extends DataTransferObject> {

    //final variable defined.
    protected final Connection cnt;
    protected final String LAST_VAL = "SELECT last_value FROM ";
    protected final String CUSTOMER_SEQUENCE = "hp_customer_seq";

    //abstract class must have constructor
    public DataAccessObject(Connection connect) {
        super(); //this means super.cnt is accessible from this child class, super gives access to parent class
        this.cnt = connect;

    }

    //abstract methods of DAO
    public abstract T findByID(long id);

    public abstract List<T> findAll();

    public abstract T update(T dto);

    public abstract void delete(long id);

    public abstract T create(T dto) throws SQLException;


    // concrete method of DAO
    protected int getLastValue(String sequence) {
        int count = 0;
        try (Statement statement = cnt.createStatement()) {
            String sqlQuery = LAST_VAL + sequence;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException err404) {
            err404.printStackTrace();
            throw new RuntimeException(err404);
        }

    }
}
