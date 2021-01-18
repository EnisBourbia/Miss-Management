package tools;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import users.User;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class GridTools {

    public static Button getButtonAtRow(int row, GridPane gridPane){
        Button btn = new Button();
        for(int i = 0; i < gridPane.getChildren().size(); i++){
            Node child = gridPane.getChildren().get(i);
            if(GridPane.getColumnIndex(child) == 0 && GridPane.getRowIndex(child) == row){
                btn = (Button) child;
            }
        }
        return btn;
    }

    public static VBox getVBoxAtRow(int row, GridPane gridPane){
        VBox box = new VBox();
        for(int i = 0; i < gridPane.getChildren().size(); i++){
            Node child = gridPane.getChildren().get(i);
            if(GridPane.getColumnIndex(child) == 0 && GridPane.getRowIndex(child) == row){
                box = (VBox) child;
            }
        }
        return box;
    }

    public static ChoiceBox<String> getCBAtRow(int row, GridPane gridPane){
        ChoiceBox<String> cb = new ChoiceBox<String>();
        for(int i = 0; i < gridPane.getChildren().size(); i++){
            Node child = gridPane.getChildren().get(i);
            if(GridPane.getColumnIndex(child) == 1 && GridPane.getRowIndex(child) == row){
                cb = (ChoiceBox<String>) child;
            }
        }
        return cb;
    }


    public static void addLabelIfNoItems(int arrSize, GridPane gridPane, String labelText) {
        Label label = new Label(labelText);
        if(arrSize == 0){
            if(!gridPane.getChildren().contains(label)){
                GridPane.setConstraints(label, 0, 0);
                gridPane.getChildren().add(label);
            }
        }  else{
            gridPane.getChildren().remove(label);
        }
    }
}
