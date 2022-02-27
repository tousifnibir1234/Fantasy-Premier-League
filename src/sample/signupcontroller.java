package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signupcontroller {
    private Main main;
    public static String string;

    Image image;

    {
        try {
            image = new Image(new FileInputStream("G:\\JavaFXLogin\\src\\sample\\stadium.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private ImageView imageView = new ImageView(image);


    @FXML
    private TextField username;

    @FXML
    private TextField emailtext;

    @FXML
    private TextField favourite_team_name;

    @FXML
    private TextField fantasy_team_name;

    @FXML
    private PasswordField password_text;

    @FXML
    private Button signbutton;
    @FXML
    void get_sign_up (ActionEvent event) throws Exception {
        String name = username.getText();
        String email = emailtext.getText();
        String favourite = favourite_team_name.getText();
        String teamName = fantasy_team_name.getText();
        string  = teamName ;
        String password = password_text.getText();
        String sql = "insert into profile values('" + name + "','" + teamName + "','" + favourite + "','" + email + "','" + password + "')";
        System.out.println(sql);
        Adapter adapter = new Adapter();
        adapter.connect();
        try {
            adapter.stmt=adapter.conn.createStatement();
            adapter.stmt.executeUpdate(sql);

        }catch (SQLException e)
        {e.printStackTrace();}
        adapter.disconnect();
        main.showPickTeamPage();


////            String sql = "insert into users values('" + name + "'," + Integer.toString(58) + "," + "'" + password + "','" + email + "','" + teamName + "')";
////            // String sql ="select *from users";
////            adapter.stmt = adapter.conn.prepareStatement(sql);
////            ((PreparedStatement) adapter.stmt).execute();
//            //            System.out.println("connection is established");
//            adapter.stmt= adapter.conn.prepareStatement("SELECT * FROM fantasy_league");
//            adapter.rs= ((PreparedStatement) adapter.stmt).executeQuery();
//            while(adapter.rs.next())
//            {
//                System.out.println(adapter.rs.getInt(1)+adapter.rs.getString(2));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        adapter.disconnect();
    }

    void setMain(Main main) {
        this.main = main;
    }

}
