
package DOA;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Hazar Gul Nazari
 */

public interface CustomerDAO {

    public List<Customer> getAllCustomers();

    public Customer getCustomer(int id);
    
    public Customer getCustomer(String email);

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomer(int id);
    
    public boolean deleteCustomer(String email);
    
    //Registers a new player
    public boolean addCustomer(Customer customer);

    public boolean doesCustomerExists(int id);
    
    public boolean doesCustomerExists(String email);
    
    public boolean isEmailUnique(String email);
    
    public boolean deposite(Customer customer, double balance);

    public boolean withdraw(Customer customer, double balance);
    
    public void printCustomer(String email);
    
    public ArrayList<Transaction> getTransactions(Customer customer);
    
    //Logs in an existing player 
    public boolean loginCustomer(Customer customer);
    
    public ArrayList<Inbox> getCustomerInbox(int id);

}
