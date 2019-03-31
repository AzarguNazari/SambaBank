package pages;

import DOA.Customer;
import DOA.CustomerDAOImpl;
import DOA.DatabaseHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Hazar Gul Nazari
 */
public class LogIn implements Initializable {

    @FXML
    private Label errorMessage;
    @FXML
    private Button loginButton;
    @FXML
    private RadioButton English, Farsi;
    @FXML
    private ToggleGroup loginType;
    @FXML
    private AnchorPane mainBody;

    @FXML
    Hyperlink RegisterAnAccount;

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    @FXML
    private void changeLanguage() {

        if (English.isSelected()) {
            //DatabaseHandler.getInstance().setEnglish();
        } else {
            //DatabaseHandler.getInstance().setArabic();
        }

        English.setText(DatabaseHandler.getInstance().getMessages().getString("English"));
        Arabic.setText(DatabaseHandler.getInstance().getMessages().getString("Arabic"));

        RegisterAnAccount.setText(DatabaseHandler.getInstance().getMessages().getString("RegisterAnAccount"));

        email.setPromptText(DatabaseHandler.getInstance().getMessages().getString("Username"));
        password.setPromptText(DatabaseHandler.getInstance().getMessages().getString("Password"));

        loginButton.setText(DatabaseHandler.getInstance().getMessages().getString("SignIn"));

    }
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        
        //1: Declare/Define variables
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        
        Customer customer;
        String emailAddress = email.getText().trim();
        String password = this.password.getText().trim();

        //2: Check if the username or password fields are empty
        if (areFieldsEmpty(emailAddress, password)) {
            return;
        }

        //3: Check if the player has an account
        if (customerDAO.doesCustomerExists(emailAddress)) {
            customer = new Customer(emailAddress, password);

            //Log player if the password is correct
            if (customerDAO.loginCustomer(customer)) {
                DatabaseHandler.setCurrentUsername(emailAddress);
                loginCustomer(event);
            } else {
                errorHappened("wrongPassword");
            }

        } else {
            errorHappened("notExist");
        }

    }

    @FXML
    private void RegisterAnAccount(ActionEvent event) throws IOException {
        Scene tableViewScene = new Scene(FXMLLoader.load(getClass().getResource("RegisterPage.fxml")));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    private boolean areFieldsEmpty(String userName, String pass) {

        if (userName.length() == 0) {
            errorHappened("username");
            email.setStyle("-fx-border-width: 2;");
            return true;
        } else {
            errorMessage.setVisible(false);
            email.setStyle("-fx-border-width: 0;");
        }

        if (pass.length() == 0) {
            errorHappened("password");
            password.setStyle("-fx-border-width: 2;");
            return true;
        } else {
            errorMessage.setVisible(false);
            password.setStyle("-fx-border-width: 0;");
        }

        return false;

    }

    private void loginCustomer(ActionEvent event) throws IOException {

        errorMessage.setVisible(false);
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../MainPage/MainPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    

    private void errorHappened(String errorText) {
        switch (errorText) {
            case "username":
                errorMessage.setText(DatabaseHandler.getInstance().getMessages().getString("UsernameError"));
                break;
            case "password":
                errorMessage.setText(DatabaseHandler.getInstance().getMessages().getString("PasswordError"));
                break;

            case "wrongPassword":
                errorMessage.setText(DatabaseHandler.getInstance().getMessages().getString("wrongPassword"));
                break;
            case "notExist":
                errorMessage.setText(DatabaseHandler.getInstance().getMessages().getString("notExist"));
                break;
            case "databaseError":
                errorMessage.setText(DatabaseHandler.getInstance().getMessages().getString("databaseError"));
                break;
        }
        errorMessage.setVisible(true);
        Utilities.Utilities.FadeInTransition(errorMessage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMessage.setVisible(false);
        Utilities.Utilities.FadeInTransition(mainBody);

        if (DatabaseHandler.getInstance().getCurrentLocale().getLanguage().equals("en")) {
            English.setSelected(true);

        } else {
            Arabic.setSelected(true);
        }

        changeLanguage();

    }
}
