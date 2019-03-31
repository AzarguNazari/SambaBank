/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import static DOA.DataHelper.handleSQLExceptions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hazar Gul Nazari
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List<Customer> getAllCustomers() {
        try {

            //1: Create a preparated statement
            List<Customer> customers = new ArrayList();
            String checkstmt = "SELECT * FROM customer";
            PreparedStatement stmt = DatabaseHandler.getInstance().getConnection().prepareStatement(checkstmt);

            //2: Return a list of customers
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
//                customers.add(new Customer(rs.getString("username"), rs.getString("email"), rs.getString("name"), rs.getString("password")));
            }

            return customers;
        } catch (SQLException ex) {
            handleSQLExceptions(ex);
        }
        return null;
    }

    @Override
    public Customer getCustomer(String email) {
        try {

            //1: Create a preparated statement
            Customer customer = null;
            String checkstmt = "SELECT * FROM CUSTOMER WHERE email=?";
            PreparedStatement stmt = DatabaseHandler.getInstance().getConnection().prepareStatement(checkstmt);

            //2: Assign values
            stmt.setString(1, email);

            //3: Return the customer
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                customer = new Customer();
            }

            return customer;
        } catch (SQLException ex) {
            handleSQLExceptions(ex);
        }
        return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try {

            //1: Create a preparated statement
            String update = "UPDATE CUSTOMER SET EMAIL=?, NAME=?, PASSWORD=? WHERE CID=?";
            PreparedStatement stmt = DatabaseHandler.getInstance().getConnection().prepareStatement(update);

            //2: Assign values to the ? in SQL statement
            stmt.setString(1, customer.getEmail());
            stmt.setString(2, customer.getUserName());
            stmt.setString(3, customer.getPassword());
//            stmt.setString(4, customer.getUserID());

            //3: Check if the update worked
            int res = stmt.executeUpdate();
            return (res > 0);
        } catch (SQLException ex) {
            handleSQLExceptions(ex);
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String email) {
        try {

            //1: Create a preparated statement
            PreparedStatement stmt = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "DELETE FROM PLAYER WHERE USERNAME = ?");

            //2: Assign values to the ? in SQL statement
            stmt.setString(1, email);

            //3: Check if the deletion worked
            int res = stmt.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException ex) {
            handleSQLExceptions(ex);
        }
        return false;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try {

            //1: Create a preparated statement
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO PLAYER(Username,Email,Name,Password) VALUES(?,?,?,?)");

            //2: Assign values
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getName());
            statement.setString(4, customer.getPassword());

            //3: Check if at least one record has been affected
            return statement.executeUpdate() > 0;

        } catch (SQLException ex) {
            handleSQLExceptions(ex);
        }

        return false;
    }

    @Override
    public boolean doesCustomerExists(String email) {
        try {

            //1: Create a preparated statement
            String checkstmt = "SELECT COUNT(*) FROM PLAYER WHERE username=?";
            PreparedStatement stmt = DatabaseHandler.getInstance().getConnection().prepareStatement(checkstmt);

            //2: Assign values
            stmt.setString(1, email);

            //3: Check if the customer exists
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return (count > 0);
            }

        } catch (SQLException ex) {
            handleSQLExceptions(ex);
        }
        return false;
    }

    @Override
    public boolean loginCustomer(Customer customer) {
        try {

            //1: Create a preparated statement
            String checkstmt = "SELECT COUNT(*) FROM CUSTOMER WHERE EMAIL=? AND PASSWORD=?";
            PreparedStatement stmt = DatabaseHandler.getInstance().getConnection().prepareStatement(checkstmt);

            //2: Assign values
            stmt.setString(1, customer.getEmail());
            stmt.setString(2, customer.getPassword());

            //3: Return the customer
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return (count > 0);
            }

        } catch (SQLException ex) {
            handleSQLExceptions(ex);
        }
        return false;
    }

    @Override
    public boolean isEmailUnique(String email) {
        try {

            //1: Create a preparated statement
            String checkstmt = "SELECT COUNT(*) FROM PLAYER WHERE EMAIL=?";
            PreparedStatement stmt = DatabaseHandler.getInstance().getConnection().prepareStatement(checkstmt);

            //2: Assign values
            stmt.setString(1, email);

            //3: Return the customer
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return (count== 0);
            }

        } catch (SQLException ex) {
            handleSQLExceptions(ex);
        }
        return false;
    }

    @Override
    public Customer getCustomer(int id) {
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public boolean deleteCustomer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean doesCustomerExists(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Inbox> getCustomerInbox(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deposite(Customer customer, double balance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean withdraw(Customer customer, double balance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Transaction> getTransactions(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printCustomer(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
