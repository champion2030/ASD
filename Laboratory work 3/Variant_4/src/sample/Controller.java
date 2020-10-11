package sample;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class Controller {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea file_result;

    @FXML
    private Button take_from_file_button;

    @FXML
    private TextArea hands_results;

    @FXML
    private Button file_button;

    @FXML
    private TextField hands_enter;

    @FXML
    private Button hands_button;

    @FXML
    private TextField file_enter;

    public String Path;
    public String[] number;


    public void take_hands_elements(){
        String text = hands_enter.getText();
        String[] words = text.split(" ");
        binary_tree the_tree = new binary_tree();
        boolean k = false;
        for(String i: words){
            if(i.matches("[-+]?\\d+"))
                the_tree.addNode(Integer.parseInt(i));
            else{
                k = true;
                break;
            }
        }
        if(!k){
            hands_results.setText(the_tree.preorderTraverseTree(the_tree.root) + "Высота дерева = " + the_tree.Height(the_tree.root) + "\nСумма дерева = " + the_tree.sumTree(the_tree.root, 0));
        }
    }

    public void put_file_information(){
        try(BufferedReader br = new BufferedReader(new FileReader(Path))) {
            String s;
            s = br.readLine();
            if (s != null){
                file_enter.setText(s);
                number = s.split(" ");
            }
        }

        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public void take_elements_file(){
        binary_tree the_tree = new binary_tree();
        boolean k = false;
        if(number != null){
            for(String i: number){
                if(i.matches("[-+]?\\d+"))
                    the_tree.addNode(Integer.parseInt(i));
                else{
                    k = true;
                    break;
                }
            }
            if(!k){
                file_result.setText(the_tree.preorderTraverseTree(the_tree.root) + "Высота дерева = " + the_tree.Height(the_tree.root) + "\nСумма дерева = " + the_tree.sumTree(the_tree.root, 0));
            }
        }
    }

    @FXML
    void initialize() {
        hands_button.setOnAction(actionEvent -> {
            take_hands_elements();
        });
        take_from_file_button.setOnAction(actionEvent -> {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("D:\\Второй курс\\АСД"));
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT files", "*.txt"));
            File selectedFile = fc.showOpenDialog(null);
            if(selectedFile != null){
                Path = selectedFile.getAbsolutePath();
                put_file_information();
            }
            else {
                System.out.println("LOL");
            }
        });
        file_button.setOnAction(actionEvent -> {
            take_elements_file();
        });
    }

    static class binary_tree {

        Node root;
        String temp = "";
        public void addNode(int key){
            Node newNode = new Node(key);

            if (root == null){
                root = newNode;
            }
            else {
                Node focusNode = root;
                Node parent;
                while (true){
                    parent = focusNode;
                    if(key < focusNode.key){
                        focusNode = focusNode.leftChild;
                        if(focusNode == null){
                            parent.leftChild = newNode;
                            return;
                        }
                    }else {
                        focusNode = focusNode.rightChild;
                        if (focusNode == null){
                            parent.rightChild = newNode;
                            return;
                        }
                    }
                }
            }
        }

        public String preorderTraverseTree(Node focusNode){
            if(focusNode != null){
                temp += focusNode + "\n";
                System.out.println(focusNode);
                preorderTraverseTree(focusNode.leftChild);
                preorderTraverseTree(focusNode.rightChild);
            }
            return temp;
        }

        public int Height(Node root){
            if(root==null) {
                temp += "";
                return 0;
            }

            else{
                int l=Height(root.leftChild);
                int r=Height(root.rightChild);
                return (Math.max(l,r))+1;
            }
        }

        public int sumTree(Node r, int result)
        {
            if (r==null) return 0;
            else{
                result =  sumTree(r.leftChild, 0)+r.key+sumTree(r.rightChild, 0);
            }
            return result;
        }
    }


    static class Node{
        int key;

        Node leftChild;
        Node rightChild;

        Node(int key){
            this.key = key;
        }

        public String toString(){
            return ""+key;
        }
    }
}

