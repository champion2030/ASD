package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private Tab tab3;

    @FXML
    private Tab tab4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane pane1 = FXMLLoader.load(getClass().getResource("Tab1.fxml"));
            tab1.setContent(pane1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("Tab2.fxml"));
            tab2.setContent(pane2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            AnchorPane pane3 = FXMLLoader.load(getClass().getResource("Tab3.fxml"));
            tab3.setContent(pane3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            AnchorPane pane4 = FXMLLoader.load(getClass().getResource("Tab4.fxml"));
            tab4.setContent(pane4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
