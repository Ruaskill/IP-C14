package JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TutorTimetableController implements Initializable {
    @FXML
    private Button returnButton;

    @FXML
    void returnButtonClicked(ActionEvent event) throws IOException {
        Parent tutorParent = FXMLLoader.load(getClass().getResource("Tutor.fxml"));
        Scene tutorScene = new Scene(tutorParent, 1800, 1500);

        //gets stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Tutor Page");
        window.setScene(tutorScene);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //action event when mouse enters/exits enterCourses button
        returnButton.setOnMouseEntered(e -> returnButton.setStyle("-fx-background-color: #4E4E4E;"));
        returnButton.setOnMouseExited(e -> returnButton.setStyle("-fx-background-color:  #2B2828;"));
    }
}