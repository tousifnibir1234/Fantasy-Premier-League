package sample;

import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        //showPickTeamPage();
        showLoginPage();
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 620, 400));
        stage.show();
    }
    public void showPickTeamPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("pickteam.fxml"));
        Parent root = loader.load();

        // Loading the controller
        pickUpTeamController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Pick Your Team");
        stage.setScene(new Scene(root, 900, 570));
        stage.show();
    }

    public void showSignUpPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("SignUp1.fxml"));

        Parent root = loader.load();

        // Loading the controller
        signupcontroller controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 550, 341));
        stage.show();
    }

    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);
    }
}
