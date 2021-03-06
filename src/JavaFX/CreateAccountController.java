package JavaFX;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CreateAccountController implements Initializable {
    @FXML
    private Button homeButton;

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
    private Text outputText;

    @FXML
    public ComboBox<String> comboBox;

    ObservableList<String> accountType = FXCollections.observableArrayList("Student", "Tutor");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(accountType);
        comboBox.setValue("Account Type");

        //action event when mouse enters/exits create account button
        comboBox.setOnMouseEntered(e -> comboBox.setStyle("-fx-background-color: #4E4E4E;"));
        comboBox.setOnMouseExited(e -> comboBox.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits create account button
        createAccountButton.setOnMouseEntered(e -> createAccountButton.setStyle("-fx-background-color: #4E4E4E;"));
        createAccountButton.setOnMouseExited(e -> createAccountButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits home button
        homeButton.setOnMouseEntered(e -> homeButton.setStyle("-fx-background-color: #4E4E4E;"));
        homeButton.setOnMouseExited(e -> homeButton.setStyle("-fx-background-color:  #2B2828;"));

    }


    //home button action event
    public void homeButtonClicked(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene homeScene = new Scene(homeParent, 1800, 700);

        //gets stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(homeScene);
        window.show();
    }

    //make connection to database
    connectivity.ConnectionClass connectionClass = new connectivity.ConnectionClass();
    Connection connection = connectionClass.getConnection();


    /**
     * check if any field is empty
     *
     * @return
     */
    public boolean verifyFields() {
        String fname = firstName.getText();
        String lname = lastName.getText();
        String username = userName.getText();
        String emailString = email.getText();
        String passwordString = String.valueOf(password.getText());
        String confirmPasswordString = String.valueOf(confirmPassword.getText());


        if (fname.trim().equals("") || lname.trim().equals("") || username.trim().equals("") || emailString.trim().equals("") || passwordString.trim().equals("")) {

            outputText.setStyle("-fx-text-fill: #d33232");
            outputText.setText("Fill in the Required Fields");

            return false;
        }

        //check if confirm password equals password
        else if (!passwordString.equals(confirmPasswordString)) {
            outputText.setStyle("-fx-text-fill: #D33232");
            outputText.setText("Password does not match Confirm Password");
            return false;
        }

        // if everything is fine
        else {
            return true;
        }
    }


    /**
     * function to check if username already exists in database
     *
     * @param userName
     * @return
     */
    public boolean checkUserName(TextField userName) {
        String userNameSQL = "SELECT * FROM user WHERE user_name = ? ";
        ResultSet rsUser;
        boolean username_exists = false;


        try {

            PreparedStatement userPST = connection.prepareStatement(userNameSQL);
            userPST.setString(1, userName.getText());
            rsUser = userPST.executeQuery();

            if (rsUser.next()) {
                username_exists = true;
                outputText.setStyle("-fx-text-fill: #d33232");
                outputText.setText("Username Already Exists");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return username_exists;

    }


    /**
     * function to check if username already exists in database
     *
     * @param email
     * @return
     */
    public boolean checkEmail(TextField email) {
        String emailSQL = "SELECT * FROM user WHERE email = ?";
        ResultSet rsEmail;
        boolean email_exists = false;


        try {

            PreparedStatement emailPST = connection.prepareStatement(emailSQL);
            emailPST.setString(1, email.getText());
            rsEmail = emailPST.executeQuery();

            if (rsEmail.next()) {
                email_exists = true;
                outputText.setStyle("-fx-text-fill: #d33232");
                outputText.setText("Email Already Used");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return email_exists;

    }


    /**
     * action event when create account button is clicked. Changes scene to either Student scene or Tutor scene depending on account type selected
     *
     * @param event
     */
    public void createAccountButtonClicked(ActionEvent event) {

        if (verifyFields()) {
            if (!checkUserName(userName)) {
                if (!checkEmail(email)) {
                    if (comboBox.getValue().equals("Student")) {
                        try {
                            Parent studentParent = FXMLLoader.load(getClass().getResource("Student.fxml"));
                            Scene studentScene = new Scene(studentParent, 1800, 1200);

                            //gets stage information
                            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            window.setTitle("Student Page");
                            window.setScene(studentScene);
                            window.show();

                            String sql = "INSERT INTO user(first_name, last_name, user_name, email, password, account_type) VALUES(?,?,?,?,?,?)";
                            PreparedStatement pst = connection.prepareStatement(sql);
                            pst.setString(1, firstName.getText());
                            pst.setString(2, lastName.getText());
                            pst.setString(3, userName.getText());
                            pst.setString(4, email.getText());
                            pst.setString(5, password.getText());
                            pst.setString(6, comboBox.getValue());

                            pst.execute();

                            outputText.setText("Account Created!");


                        } catch (SQLException | IOException e) {
                            e.printStackTrace();
                        }
                    } else if (comboBox.getValue().equals("Tutor")) {
                        try {
                            Parent tutorParent = FXMLLoader.load(getClass().getResource("Tutor.fxml"));
                            Scene tutorScene = new Scene(tutorParent, 1800, 1500);

                            //gets stage information
                            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            window.setTitle("Tutor Page");
                            window.setScene(tutorScene);
                            window.show();

                            String sql = "INSERT INTO user(first_name, last_name, user_name, email, password, account_type) VALUES(?,?,?,?,?,?)";
                            PreparedStatement pst = connection.prepareStatement(sql);
                            pst.setString(1, firstName.getText());
                            pst.setString(2, lastName.getText());
                            pst.setString(3, userName.getText());
                            pst.setString(4, email.getText());
                            pst.setString(5, password.getText());
                            pst.setString(6, comboBox.getValue());

                            pst.execute();

                            outputText.setText("Account Created!");


                        } catch (SQLException | IOException e) {
                            e.printStackTrace();
                        }
                    } else if (comboBox.getValue().equals("Account Type")) {
                        outputText.setText("Select Account Type");
                    }
                }
            }
        }


    }


}

