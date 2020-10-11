package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Tab1Controller {
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
    private Button add_user_button;

    @FXML
    private Button sort_button;

    @FXML
    private TextField name_field;

    @FXML
    private TextField age_field;

    @FXML
    private TextArea steps;

    ObservableList<User> list = FXCollections.observableArrayList();
    ArrayList<User> men = new ArrayList<User>();

    public void initialize() {
        namecolumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        agecolumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        add_user_button.setOnAction(actionEvent -> {
            addUser(new User(name_field.getText(), Integer.parseInt(age_field.getText())));
            people.setItems(GetUser());
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
