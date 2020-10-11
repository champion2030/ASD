package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {
    private SimpleStringProperty name;
    private SimpleIntegerProperty age;

    User(String name, int age){
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
    }
    User(){};

    public String getName(){ return name.get();}
    public void setName(String value){ name.set(value);}

    public int getAge(){ return age.get();}
    public void setAge(int value){ age.set(value);}
}
