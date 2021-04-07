package JavaFX;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Button homeButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private Button csButton;

    @FXML
    private Button seButton;

    @FXML
    private Button pButton;

    @FXML
    private Button wsButton;

    @FXML
    private AnchorPane slider;

    @FXML
    private Label enterCourses;

    @FXML
    private Label exitCourses;

    @FXML
    private Label csDescriptionLabel;

    @FXML
    private Label seDescriptionLabel;

    @FXML
    private Label pDescriptionLabel;

    @FXML
    private Label wsDescriptionLabel;


    /**
     * action event when home button clicked. Takes you to home scene i.e. the same scene
     * @param event
     * @throws IOException
     */
    @FXML
    void homeButtonClicked(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene homeScene = new Scene(homeParent, 600, 500);

        //gets stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home");
        window.setScene(homeScene);
        window.show();
    }

    /**
     * action event when create account clicked. Takes you to create account scene
     * @param event
     * @throws IOException
     */
    @FXML
    void createAccountClicked(ActionEvent event) throws IOException {
        Parent createAccountParent = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Scene createAccountScene = new Scene(createAccountParent);

        //gets stage information
        Stage createAccountWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        createAccountWindow.setTitle("Create Account");
        createAccountWindow.setScene(createAccountScene);
        createAccountWindow.show();

    }

    /**
     * action event when login button clicked. Takes you to login scene.
     * @param event
     * @throws IOException
     */
    @FXML
    void loginButtonClicked(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene createAccountScene = new Scene(loginParent);

        //gets stage information
        Stage loginWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginWindow.setTitle("Login");
        loginWindow.setScene(createAccountScene);
        loginWindow.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set up Computer Systems description
        csDescriptionLabel.setWrapText(true);
        csDescriptionLabel.setMaxWidth(1580);
        csDescriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        csDescriptionLabel.setVisible(false);

        //set up Software Engineering description
        seDescriptionLabel.setWrapText(true);
        seDescriptionLabel.setMaxWidth(1580);
        seDescriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        seDescriptionLabel.setVisible(false);

        //set up Programming description
        pDescriptionLabel.setWrapText(true);
        pDescriptionLabel.setMaxWidth(1580);
        pDescriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        pDescriptionLabel.setVisible(false);

        //set up Web Security description
        wsDescriptionLabel.setWrapText(true);
        wsDescriptionLabel.setMaxWidth(1580);
        wsDescriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        wsDescriptionLabel.setVisible(false);

        //action event when mouse enters/exits create account button
        createAccountButton.setOnMouseEntered( e -> createAccountButton.setStyle("-fx-background-color: #4E4E4E;"));
        createAccountButton.setOnMouseExited( e -> createAccountButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits login button
        loginButton.setOnMouseEntered( e -> loginButton.setStyle("-fx-background-color: #4E4E4E;"));
        loginButton.setOnMouseExited( e -> loginButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits home button
        homeButton.setOnMouseEntered( e -> homeButton.setStyle("-fx-background-color: #4E4E4E;"));
        homeButton.setOnMouseExited( e -> homeButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits enterCourses button
        enterCourses.setOnMouseEntered(e -> enterCourses.setStyle("-fx-background-color: #4E4E4E;"));
        enterCourses.setOnMouseExited(e -> enterCourses.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits exitCourses button
        exitCourses.setOnMouseEntered(e -> exitCourses.setStyle("-fx-background-color: #4E4E4E;"));
        exitCourses.setOnMouseExited(e -> exitCourses.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits cs button
        csButton.setOnMouseEntered(e -> csButton.setStyle("-fx-background-color: #4E4E4E;"));
        csButton.setOnMouseExited(e -> csButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits se button
        seButton.setOnMouseEntered(e -> seButton.setStyle("-fx-background-color: #4E4E4E;"));
        seButton.setOnMouseExited(e -> seButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits p button
        pButton.setOnMouseEntered(e -> pButton.setStyle("-fx-background-color: #4E4E4E;"));
        pButton.setOnMouseExited(e -> pButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits ws button
        wsButton.setOnMouseEntered(e -> wsButton.setStyle("-fx-background-color: #4E4E4E;"));
        wsButton.setOnMouseExited(e -> wsButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when cs button clicked
        csButton.setOnMouseClicked(e -> {
            csDescriptionLabel.setVisible(true);
            seDescriptionLabel.setVisible(false);
            pDescriptionLabel.setVisible(false);
            wsDescriptionLabel.setVisible(false);
        });

        //action event when se button clicked
        seButton.setOnMouseClicked(e -> {
            csDescriptionLabel.setVisible(false);
            seDescriptionLabel.setVisible(true);
            pDescriptionLabel.setVisible(false);
            wsDescriptionLabel.setVisible(false);
        });

        //action event when p button clicked
        pButton.setOnMouseClicked(e -> {
            csDescriptionLabel.setVisible(false);
            seDescriptionLabel.setVisible(false);
            pDescriptionLabel.setVisible(true);
            wsDescriptionLabel.setVisible(false);
        });

        //action event when ws button clicked
        wsButton.setOnMouseClicked(e -> {
            csDescriptionLabel.setVisible(false);
            seDescriptionLabel.setVisible(false);
            pDescriptionLabel.setVisible(false);
            wsDescriptionLabel.setVisible(true);
        });

        slider.setTranslateX(-200);
        //action event when enterCourses is clicked
        enterCourses.setOnMouseClicked( e -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-200);

            slide.setOnFinished((ActionEvent event) -> {
                enterCourses.setVisible(false);
                exitCourses.setVisible(true);
            });
        });
        //action event when exitCourses is clicked
        exitCourses.setOnMouseClicked( e -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-200);
            slide.play();

            csDescriptionLabel.setVisible(false);
            seDescriptionLabel.setVisible(false);
            pDescriptionLabel.setVisible(false);
            wsDescriptionLabel.setVisible(false);

            slider.setTranslateX(0);

            slide.setOnFinished(event -> {
                enterCourses.setVisible(true);
                exitCourses.setVisible(false);
            });

        });
    }
}

