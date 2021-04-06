package JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button homeButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text outputText;

    @FXML
    private Label createAccountLabel;

    @FXML
    void homeButtonClicked(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene homeScene = new Scene(homeParent);

        //gets stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home Page");
        window.setScene(homeScene);
        window.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //action event when mouse enters/exits enterCourses button
        createAccountLabel.setOnMouseEntered(e -> createAccountLabel.setStyle("-fx-text-fill: #6BB2E8;"));
        createAccountLabel.setOnMouseExited(e -> createAccountLabel.setStyle("-fx-text-fill:  #2B2828;"));

        //action event when mouse enters/exits home button
        homeButton.setOnMouseEntered( e -> homeButton.setStyle("-fx-background-color: #4E4E4E;"));
        homeButton.setOnMouseExited( e -> homeButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits home button
        loginButton.setOnMouseEntered( e -> loginButton.setStyle("-fx-background-color: #4E4E4E;"));
        loginButton.setOnMouseExited( e -> loginButton.setStyle("-fx-background-color:  #2B2828;"));

        //click action event for create account label
        createAccountLabel.setOnMouseClicked( event ->  {
            Parent createAccountParent = null;
            try {
                createAccountParent = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene createAccountScene = new Scene(createAccountParent);

            //gets stage information
            Stage createAccountWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            createAccountWindow.setTitle("Create Account");
            createAccountWindow.setScene(createAccountScene);
            createAccountWindow.show();
        });


    }

    //make connection to database
    connectivity.ConnectionClass connectionClass = new connectivity.ConnectionClass();
    Connection connection = connectionClass.getConnection();

    //action event for login button
    public void loginButtonClicked(ActionEvent event) {
        String usernameString = userName.getText();
        String passwordString = String.valueOf(passwordField.getText());

        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM user WHERE user_name = ? AND password = ?";

        try {
            st = connection.prepareStatement(query);
            st.setString(1, usernameString);
            st.setString(2, passwordString);

            rs = st.executeQuery();

            while(rs.next()) {
                if (rs.getString("account_type").equals("Student")) {
                    Parent studentParent = FXMLLoader.load(getClass().getResource("Student.fxml"));
                    Scene studentScene = new Scene(studentParent);

                    //gets stage information
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Student Page");
                    window.setScene(studentScene);
                    window.show();
                }
                else if(rs.getString("account_type").equals("Tutor")) {
                    Parent tutorParent = FXMLLoader.load(getClass().getResource("Tutor.fxml"));
                    Scene tutorScene = new Scene(tutorParent);

                    //gets stage information
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Tutor Page");
                    window.setScene(tutorScene);
                    window.show();
                }
                else {
                    outputText.setText("Username or Password Incorrect");
                }
            }

        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}