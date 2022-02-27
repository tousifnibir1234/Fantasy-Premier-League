package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LoginController {

    Image image;

    {
        try {
            image = new Image(new FileInputStream("G:\\JavaFXLogin\\src\\sample\\fantasy.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Main main;
    @FXML
    private ImageView fantasyview = new ImageView(image);

    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText ;

    @FXML
    private Button resetButton;
    boolean b = false ;
    @FXML
    private Button loginButton;
    @FXML
    void loginAction(ActionEvent event) throws SQLException {
        String name = userText.getText();
        String password = passwordText.getText();
        Adapter adapter = new Adapter();
        adapter.connect();
        try {
            adapter.stmt= adapter.conn.prepareStatement("SELECT * FROM profile;");
            adapter.rs= ((PreparedStatement) adapter.stmt).executeQuery();
            while(adapter.rs.next())
            {
                String s1 = adapter.rs.getString(1);
                String s2 = adapter.rs.getString(5);
                if(s1.equals(name) && s2.equals(password)) {b = true ; break;}
            }
        }catch (SQLException e)
        {e.printStackTrace();}
        adapter.disconnect();
        //adapter.disconnect();
        //main.showPickTeamPage();
        /*
        String validUserName = "admin";
        String validPassword = "123";
        String userName = userText.getText();
        String password = passwordText.getText();
        */
        if (b){
            // successful login
            try {
                main.showPickTeamPage();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // failed login
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }

    }

    @FXML
    void resetAction(ActionEvent event) throws Exception {
       main.showSignUpPage();
    }

    void setMain(Main main) {
        this.main = main;
    }

}
