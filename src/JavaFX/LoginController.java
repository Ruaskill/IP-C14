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


    /**
     * This method has not been implemented properly. Intended purpose was to store the user ID from the database to be used in Student or Tutor scenes
     * @param userNameText
     */
//    public Text getUserID() {
//        String usernameString = userName.getText();
//
//
//        PreparedStatement st;
//        ResultSet rs;
//        String query = "SELECT * FROM user WHERE user_name = ?";
//
//        try {
//            st = connection.prepareStatement(query);
//            st.setString(1, usernameString);
//
//            rs = st.executeQuery();
//            rs.next();
//            userID.setText(rs.getString("user_id"));
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return userID;
//    }

    public void setUserNameText(Text userNameText) {
        this.userNameText = userNameText;
        userNameText.setText("username");
    }

    private Text userNameText;


    /**
     * action event when home button is clicked. Takes you to home screen
     * @param event
     * @throws IOException
     */
    @FXML
    void homeButtonClicked(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene homeScene = new Scene(homeParent, 1800, 700);

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
            Scene createAccountScene = new Scene(createAccountParent, 1000, 900);

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

    /**
     * action event when login button is clicked. Takes you to either Student or Tutor scene depending on account type in database
     * @param event
     */
    public void loginButtonClicked(ActionEvent event) {
        String usernameString = userName.getText();
        String passwordString = String.valueOf(passwordField.getText());


        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM user WHERE user_name = ? AND password = ? ";

        try {
            st = connection.prepareStatement(query);
            st.setString(1, usernameString);
            st.setString(2, passwordString);


            rs = st.executeQuery();

            while(rs.next()) {
                if (rs.getString("account_type").equals("Student")) {
                    Parent studentParent = FXMLLoader.load(getClass().getResource("Student.fxml"));
                    Scene studentScene = new Scene(studentParent, 1800, 1200);




                    //gets stage information
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Student Page");
                    window.setScene(studentScene);
                    window.show();
                }
                else if(rs.getString("account_type").equals("Tutor")) {
                    Parent tutorParent = FXMLLoader.load(getClass().getResource("Tutor.fxml"));
                    Scene tutorScene = new Scene(tutorParent, 1800, 1500);

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