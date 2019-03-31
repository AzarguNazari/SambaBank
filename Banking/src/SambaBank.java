
import DOA.Customer;
import DOA.CustomerDAOImpl;
import DOA.DataHelper;
import java.sql.SQLException;
import java.util.Scanner;
import utility.Checker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hazar Gul Nazari
 */
public class SambaBank {

    /**
     * @param args the command line arguments
     */
    private static final Scanner input = new Scanner(System.in);

    // CustomerDAO for dealing customer related option
    private static final CustomerDAOImpl customerDao = new CustomerDAOImpl();

    public static void main(String[] args) {

        System.out.println("\n----- Welcome to Samba Bank ------\n");

        Exit:
        while (true) {

            int mainOption = mainPageOption();

            switch (mainOption) {
                case 1:
                    
                    System.out.println("Enter 1: Admin");
                    System.out.println("Enter 2: Customer");
                    int userType = input.nextInt();
                    
                    if(userType == 1){
                        adminSignIn();
                    }
                    else if(userType == 2){
                        customerSignIn();
                    }
                    else{
                        System.out.println("You should enter 1 or 2");
                    }
                    
                    
                    
                    
                    break;

                case 2:
                    signup();
                    break;

                case 3:

                    break;
            }

        }

    }

    public static int mainPageOption() {
        int option;
        while (true) {
            System.out.println("Enter 1: For Signin");
            System.out.println("Enter 2: For Signup");
            System.out.println("Enter 3: for exit");
            System.out.print("Enter your option: ");
            option = input.nextInt();

            if (option == 1 || option == 2 || option == 3) {
                return option;
            } else {
                System.out.println("Please Enter a correct option (1 or 2)");
            }
        }

    }
    
    public static void adminSignIn(){
        
    }

    public static void customerSignIn() {

        System.out.println("\n\nYour Email: ");
        String email = input.next();
        System.out.print("Your Password: ");
        String password = input.next();

        Customer tempCustomer = new Customer();
        tempCustomer.setEmail(email);
        tempCustomer.setPassword(password);

        if (customerDao.loginCustomer(tempCustomer)) {
            // customer exists
            customerPanel(email, password);
        } else {
            // customer doesnt exist
            System.err.println("Sorry, Customer with " + email + " email doent exist");
        }
    }

    public static void signup() {

        System.out.println("\nEnter FullName");
        String fullName = input.nextLine();

        while (fullName.length() == 0) {
            System.out.println("\nEnter FullName");
            fullName = input.nextLine();
        }

        System.out.println("Enter Email: ");
        String email = input.next();

        while (!customerDao.isEmailUnique(email)) {
            System.out.println("Sorry, this email is already used (Enter a new Email)");
            System.out.println("Enter Email: ");
            email = input.next();
        }

        System.out.println("Enter Password: ");
        String password = input.next();

        while (!Checker.isPasswordCorrect.test(password)) {
            System.out.println("Password should be more than 8 Character");
            System.out.println("Enter Password: ");
            password = input.next();
        }

        Customer newCustomer = new Customer(fullName, email, password);
        
        if(customerDao.addCustomer(newCustomer)){
            System.out.println("Welcome " + fullName + " into Samba Bank");
            customerPanel(email, password);
        }
        else{
            System.out.println("Sorry, the customer is not added");
        }
    }

    public static void customerPanel(String email, String password) {

        Customer customer = customerDao.getCustomer(email);

    }

    public static int customerPanelOptions() {
        System.out.println();
        System.out.println("Enter 1: Deposit Money");
        System.out.println("Enter 2: Withdraw Money");
        System.out.println("Enter 3: Transfer Money");
        System.out.println("Enter 4: Check Profile");
        System.out.println("Enter 5: Print Balance");
        System.out.println("Enter 6: Print Transactions Statement");
        System.out.println("Enter 7: Print Inbox Message");
    }

}
