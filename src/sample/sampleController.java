package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class sampleController {
    private Main main;

    @FXML
    private Button login;

    @FXML
    private TextField user_name;

    @FXML
    private TextField password_field;

    @FXML
    private Button sign_up;

    public sampleController(Main main) {
        this.main = main;
    }

    @FXML
    void get_log_in(ActionEvent event) {

        System.out.println("just print");

    }

    @FXML
    void get_sign_up(ActionEvent event) {
        System.out.println("just print");

    }
    void setMain(Main main) {
        this.main = main;
    }

}
