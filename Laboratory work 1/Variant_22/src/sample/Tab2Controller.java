package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class Tab2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<User> people;

    @FXML
    private TableColumn<User, String> namecolumn;

    @FXML
    private TableColumn<User, Integer> agecolumn;

    @FXML
    private Button read_users_button;

    @FXML
    private Button sort_button;

    @FXML
    private TextArea steps;

    ObservableList<User> list = FXCollections.observableArrayList();
    ArrayList<User> men = new ArrayList<User>();

    public void initialize() {
        namecolumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        agecolumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        read_users_button.setOnAction(actionEvent -> {
            try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
                String s;
                while((s = br.readLine())!=null){
                    String[] arr;
                    arr = s.split(" ");
                    addUser(new User(arr[0], Integer.parseInt(arr[1])));
                }
                people.setItems(GetUser());
            }
            catch(Exception ex){

                System.out.println(ex.getMessage());
            }
        });
        sort_button.setOnAction(actionEvent -> {
            bubble_sort();
            list = FXCollections.observableArrayList(men);
            people.setItems(GetUser());
        });
    }

    public void bubble_sort(){
        int count = 0, kol = 0;
        long startTime = System.nanoTime();
        StringBuilder text = new StringBuilder("");
        for(int i = 0; i < men.size(); i++){
            for(int j = 1; j < (men.size() - i); j++){
                if(men.get(j - 1).getName().compareTo(men.get(j).getName()) > 0){
                    count++;
                    text.append(count).append(") ").append(men.get(j - 1).getName()).append(" <-> ").append(men.get(j).getName()).append("\n");
                    User temp = men.get(j - 1);
                    men.set(j - 1, men.get(j));
                    men.set(j, temp);
                }
            }
            kol++;
        }
        long estimatedTime = System.nanoTime() - startTime;
        text.append("Количество шагов = ").append(count);
        text.append("\nКоличество проходов = ").append(kol);
        text.append("\nВремя выполнения = ").append(estimatedTime);
        steps.setText(text.toString());
    }

    public void addUser(User user){
        list.add(user);
        men.add(user);
    }

    public ObservableList<User> GetUser(){ return list; }
}
