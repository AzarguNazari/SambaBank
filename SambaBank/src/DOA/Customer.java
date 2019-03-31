package DOA;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Hazar Gul Nazari
 */
public class Customer {

    private int userID;
    private String userName;
    private String email;
    private String password;
    private double balance;
    private ArrayList<String> indexBox;

    public Customer(int userID, String userName, String email, String password, double balance) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    
    public Customer(String userName, String email, String password){
        this(0, userName, email, password, 0);
    }
    
    public Customer(String email, String password){
        this("", email, password);
    }

    public Customer(){}

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getIndexBox() {
        return indexBox;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setIndexBox(ArrayList<String> indexBox) {
        this.indexBox = indexBox;
    }

    @Override
    public String toString() {
        return "Player{" + "userID=" + userID + ", userName=" + userName + ", email=" + email + ", password=" + password + ", balance=" + balance + ", indexBox=" + indexBox + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.userID);
        hash = 47 * hash + Objects.hashCode(this.userName);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.password);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    

}
