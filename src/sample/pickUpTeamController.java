package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.ComboBox;
import javafx.util.Pair;

import java.net.URL;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.StringTokenizer;


public class pickUpTeamController implements Initializable {


   @FXML public ComboBox<String>  comboBox  = new ComboBox<String>();
   @FXML public ComboBox<String>  comboBox1  = new ComboBox<String>();
    public ObservableList<String> list = FXCollections.observableArrayList("Deffender", "Midfielder","Forward","Goalkeeper");
    public ObservableList<String> dlist = FXCollections.observableArrayList("4-4-2", "4-3-3","5-3-2","5-4-1");
    public ObservableList<dummyClass> list1 =FXCollections.observableArrayList();
    public ObservableList<dummyClass> list2 =FXCollections.observableArrayList();
    String selected;
    boolean done  = false;
    int max_def  =4, def =  0, max_mf = 3, mf = 0, fwd = 0,  max_fwd = 3, gk = 0;
    int array[] = new int[1000],cap = 0, v_cap =0;
    @FXML
    void genCom(ActionEvent event)
    {
        comboBox.setDisable(false);
        String s  = comboBox1.getValue();
        String []st = s.split("-");
        max_def = Integer.parseInt(st[0]);
        max_mf = Integer.parseInt(st[1]);
        max_fwd = Integer.parseInt(st[2]);
    }
    @FXML
    void generateCombo(ActionEvent event)
    {
        selected = comboBox.getValue();
        System.out.println(selected);
        Adapter adapter = new Adapter();
        adapter.connect();

        try {
           // String sql = "SELECT * FROM player where position="+selected+";";

           // System.out.println(sql);
            list1.clear();
            adapter.stmt= adapter.conn.prepareStatement("SELECT * FROM player where position= '"+selected+"';");
            adapter.rs= ((PreparedStatement) adapter.stmt).executeQuery();

            while(adapter.rs.next())
           {
               int i=adapter.rs.getInt(1);
               String s1 = adapter.rs.getString(2);
               String  s2 =adapter.rs.getString(3);
               String s3=adapter.rs.getString(4);
               double d1= adapter.rs.getDouble(5);
               double d2 =adapter.rs.getDouble(6);
               boolean b1=adapter.rs.getBoolean(7);
               String s4 =adapter.rs.getString(8);
               String s5 =adapter.rs.getString(9);
              // dummyClass dum = new dummyClass(adapter.rs.getInt(1),adapter.rs.getString(2),adapter.rs.getString(3),adapter.rs.getString(4),adapter.rs.getDouble(5),adapter.rs.getDouble(6),adapter.rs.getBoolean(7),adapter.rs.getString(8),adapter.rs.getString(5));
              // dummyClass dum =new dummyClass(adapter.rs.getInt(1),adapter.rs.getString(2),adapter.rs.getString(3), adapter.rs.getString(4),adapter.rs.getDouble(5),adapter.rs.getDouble(6), adapter.rs.getBoolean(7),adapter.rs.getString(8),adapter.rs.getString(9));
//                System.out.println(rs.getString(1)+rs.getInt(2));
               dummyClass dum=  new dummyClass();
               dum.setId(i);
               dum.setFirstName(s1);
               dum.setLastName(s2);
               dum.setClub(s3);
               dum.setRating(d1);
               dum.setPrice(d2);
               dum.setInjuryStatus(b1);
               dum.setCountry(s4);
               dum.setPosition(s5);
               list1.add(dum);

           }
           table.setItems(list1);
           // System.out.println(list1);
            //System.out.println(table.getItems());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private Main main;
   @FXML private TableView<dummyClass> table = new TableView<dummyClass>();
   @FXML private TableView<dummyClass> table1 = new TableView<dummyClass>();
   @FXML private Button showButton;
   //@FXML private Button addButton;
   @FXML private Button capt;
   @FXML private Button vice_capt;




    void setMain(Main main)
    {
        this.main= main;
    }
   @FXML TableColumn< dummyClass,Integer>  playerId,playerId1  ;
   @FXML TableColumn< dummyClass,String> firstName ,firstName1   ;
   @FXML TableColumn< dummyClass,String> lastName,lastName1  ;
   @FXML TableColumn< dummyClass,String> club ,club1  ;
   @FXML TableColumn< dummyClass,Double> rating ,rating1    ;
   @FXML TableColumn< dummyClass,Double>  price,price1  ;
   @FXML TableColumn< dummyClass,Boolean> injury ,injury1   ;
   @FXML TableColumn< dummyClass,String> country,country1    ;
   @FXML TableColumn< dummyClass,String> position ,position1  ;

   @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //System.out.println("came here");
       // System.out.println(list);
        comboBox.setItems(list);
        comboBox1.setItems(dlist);
        comboBox.setDisable(true);
        //System.out.println( comboBox.getItems());
        playerId.setCellValueFactory(new PropertyValueFactory<dummyClass,Integer>("Id"));
        firstName.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("LastName"));
        club.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("Club"));
        rating.setCellValueFactory(new PropertyValueFactory<dummyClass,Double>("Rating"));
        price.setCellValueFactory(new PropertyValueFactory<dummyClass,Double>("Price"));
        injury.setCellValueFactory(new PropertyValueFactory<dummyClass,Boolean>("InjuryStatus"));
        country.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("Country"));
        position.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("Position"));

        playerId1.setCellValueFactory(new PropertyValueFactory<dummyClass,Integer>("Id"));
        firstName1.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("firstName"));
        lastName1.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("LastName"));
        club1.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("Club"));
        rating1.setCellValueFactory(new PropertyValueFactory<dummyClass,Double>("Rating"));
        price1.setCellValueFactory(new PropertyValueFactory<dummyClass,Double>("Price"));
        injury1.setCellValueFactory(new PropertyValueFactory<dummyClass,Boolean>("InjuryStatus"));
        country1.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("Country"));
        position1.setCellValueFactory(new PropertyValueFactory<dummyClass,String>("Position"));


        table.setItems(list1);
        table1.setItems(list2);
    }

   @FXML public void showItem(ActionEvent event)
   {
       boolean bool = false;
       dummyClass item = table.getSelectionModel().getSelectedItem();
       if(item.position.equals("Deffender") && def<max_def && array[item.id]==0){def++;bool = true;}
       else if(item.position.equals("Midfielder") && mf<max_mf && array[item.id]==0){mf++;bool = true;}
       else if(item.position.equals("Forward") && fwd<max_fwd && array[item.id]==0){fwd++;bool = true;}
       else if (item.position.equals("Goalkeeper") && gk<1){gk++;bool = true;}
       if(bool  == true)
       {
           list2.add(item);
           array[item.id]=1;
           Adapter adapter = new Adapter();
           adapter.connect();
           String sql = "insert into fantasy_team(team_name,league_id,total_point,captain,vice_captain) values ('"+signupcontroller.string+"','"+1+"','" +0+"' ,'"+cap+"','"+v_cap+"')";
           try {
               if(done!=true && cap!=0 && v_cap!=0) {
                   System.out.println(cap);
                   System.out.println(v_cap);
                   adapter.stmt = adapter.conn.createStatement();
                   adapter.stmt.executeUpdate(sql);
                   done = true;
               }

           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }

   @FXML public void captain(ActionEvent event)
   {
       if(cap!=0) return;
       dummyClass item = table1.getSelectionModel().getSelectedItem();
       if(item.id==v_cap)return;
       cap = item.id;
       Adapter adapter = new Adapter();
       adapter.connect();
       String sql = "insert into fantasy_team(team_name,league_id,total_point,captain,vice_captain) values ('"+signupcontroller.string+"','"+1+"','" +0+"' ,'"+cap+"','"+v_cap+"')";
       try {
           if(done!=true && cap!=0 && v_cap!=0) {
               System.out.println(cap);
               System.out.println(v_cap);
               adapter.stmt = adapter.conn.createStatement();
               adapter.stmt.executeUpdate(sql);
               done = true;
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    @FXML public void vice_captain(ActionEvent event)
    {
        if(v_cap!=0) return;
        dummyClass item = table1.getSelectionModel().getSelectedItem();
        if(item.id==cap)return;
        v_cap = item.id;
        Adapter adapter = new Adapter();
        adapter.connect();
        String sql = "insert into fantasy_team(team_name,league_id,total_point,captain,vice_captain) values ('"+signupcontroller.string+"','"+1+"','" +0+"' ,'"+cap+"','"+v_cap+"')";
        try {
            if(done!=true && cap!=0 && v_cap!=0) {
                System.out.println(cap);
                System.out.println(v_cap);
                adapter.stmt = adapter.conn.createStatement();
                adapter.stmt.executeUpdate(sql);
                done = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
