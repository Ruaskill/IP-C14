package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateAccountController {
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField userName;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Button createAccountButton;

    @FXML
    public ComboBox<String> comboBox;

    @FXML
    private Text outputText;

    ObservableList<String> accountType = FXCollections.observableArrayList("Student", "Teacher");

    //check if any field is empty
    public boolean verifyFields() {
        String fname = firstName.getText();
        String lname = lastName.getText();
        String username = userName.getText();
        String emailString = email.getText();
        String passwordString = String.valueOf(password.getText());
        String confirmPasswordString = String.valueOf(confirmPassword.getText());

        if(fname.trim().equals("") || lname.trim().equals("") || username.trim().equals("") || emailString.trim().equals("") || passwordString.trim().equals("")) {
            outputText.setStyle("-fx-text-fill: #d33232");
            outputText.setText("Fill in the Required Fields");
            return false;
        }

        //check if confirm password equals password
        else if(passwordString.equals(confirmPasswordString)) {
            outputText.setStyle("-fx-text-fill: #D33232");
            outputText.setText("Password does not Match Confirm Password");
            return false;
        }

        // if everything is fine
        else {
            return true;
        }
    }

    //



    public void createAccountButtonClicked(ActionEvent event) throws SQLException {

        connectivity.ConnectionClass connectionClass=new connectivity.ConnectionClass();
        Connection connection=connectionClass.getConnection();


        try {
            String sql="INSERT INTO user(first_name, last_name, user_name, email, password) VALUES(?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, firstName.getText());
            pst.setString(2, lastName.getText());
            pst.setString(3, userName.getText());
            pst.setString(4, email.getText());
            pst.setString(5, password.getText());

            pst.execute();

            outputText.setText("Account Created!");




        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}

