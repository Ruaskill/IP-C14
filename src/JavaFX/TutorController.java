package JavaFX;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TutorController implements Initializable {
    private LoginController loginController;

    @FXML
    private Button logOutButton;

    @FXML
    private Button timeTable;

    @FXML
    private Button viewStudentRequests;

    @FXML
    private Button changeStatus;

    @FXML
    private TextField enterStudentUsername;

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

    @FXML
    private Text userNameText;

    @FXML
    private Text fullNameText;

    @FXML
    private Text emailText;

    @FXML
    private Text studentIDText;

    @FXML
    public ComboBox<String> comboBox;

    ObservableList<String> selectCourse = FXCollections.observableArrayList("Beginner", "On-Going", "Completed", "Not Complete");


    @FXML
    void logOutButtonClicked(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene homeScene = new Scene(homeParent, 600, 500);

        //gets stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home");
        window.setScene(homeScene);
        window.show();
    }

    //make connection to database
    connectivity.ConnectionClass connectionClass = new connectivity.ConnectionClass();
    Connection connection = connectionClass.getConnection();

    @FXML
    void changeStatusClicked(ActionEvent event) throws IOException, SQLException {

    }

    @FXML
    void timeTableClicked(ActionEvent event) throws IOException {
        Parent timetableParent = FXMLLoader.load(getClass().getResource("TutorTimetable.fxml"));
        Scene timetableScene = new Scene(timetableParent, 600, 500);

        //gets stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Tutor Timetable");
        window.setScene(timetableScene);
        window.show();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(selectCourse);
        comboBox.setValue("Select Status");
        changeStatus.setVisible(false);

        //set up Computer Systems description
        csDescriptionLabel.setWrapText(true);
        csDescriptionLabel.setMaxWidth(750);
        csDescriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        csDescriptionLabel.setVisible(false);

        //set up Software Engineering description
        seDescriptionLabel.setWrapText(true);
        seDescriptionLabel.setMaxWidth(750);
        seDescriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        seDescriptionLabel.setVisible(false);

        //set up Programming description
        pDescriptionLabel.setWrapText(true);
        pDescriptionLabel.setMaxWidth(750);
        pDescriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        pDescriptionLabel.setVisible(false);

        //set up Web Security description
        wsDescriptionLabel.setWrapText(true);
        wsDescriptionLabel.setMaxWidth(750);
        wsDescriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        wsDescriptionLabel.setVisible(false);

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

        //action event when mouse enters/exits log out button
        logOutButton.setOnMouseEntered(e -> logOutButton.setStyle("-fx-background-color: #4E4E4E;"));
        logOutButton.setOnMouseExited(e -> logOutButton.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits timetable button
        timeTable.setOnMouseEntered(e -> timeTable.setStyle("-fx-background-color: #4E4E4E;"));
        timeTable.setOnMouseExited(e -> timeTable.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits view student requests button
        viewStudentRequests.setOnMouseEntered(e -> viewStudentRequests.setStyle("-fx-background-color: #4E4E4E;"));
        viewStudentRequests.setOnMouseExited(e -> viewStudentRequests.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits select course combo box
        comboBox.setOnMouseEntered(e -> comboBox.setStyle("-fx-background-color: #4E4E4E;"));
        comboBox.setOnMouseExited(e -> comboBox.setStyle("-fx-background-color:  #2B2828;"));

        //action event when mouse enters/exits book course button
        changeStatus.setOnMouseEntered(e -> changeStatus.setStyle("-fx-background-color: #4E4E4E;"));
        changeStatus.setOnMouseExited(e -> changeStatus.setStyle("-fx-background-color:  #2B2828;"));

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
        enterCourses.setOnMouseClicked(e -> {
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
        exitCourses.setOnMouseClicked(e -> {
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
    public void comboChanged(ActionEvent event) {
        if (comboBox.getValue().equals("Beginner") || comboBox.getValue().equals("On-Going") || comboBox.getValue().equals("Completed") || comboBox.getValue().equals("Not Complete")) {
            changeStatus.setVisible(true);
        }
    }
}