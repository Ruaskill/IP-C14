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

public class StudentTimetableController implements Initializable {
    @FXML
    private Button sReturnButton;

    @FXML
    void sReturnButtonClicked(ActionEvent event) throws IOException {
        Parent studentParent = FXMLLoader.load(getClass().getResource("Student.fxml"));
        Scene studentScene = new Scene(studentParent, 1800, 1200);

        //gets stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Student Page");
        window.setScene(studentScene);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //action event when mouse enters/exits enterCourses button
        sReturnButton.setOnMouseEntered(e -> sReturnButton.setStyle("-fx-background-color: #4E4E4E;"));
        sReturnButton.setOnMouseExited(e -> sReturnButton.setStyle("-fx-background-color:  #2B2828;"));
    }
}

