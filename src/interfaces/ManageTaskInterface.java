package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ManageTaskInterface extends Interface{
    public ManageTaskInterface(){
        super();
        super.setTitle("Miss Management | Manage Task");

    }

    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();
        GridPane titlePane = getTitlePane("Miss Management | Manage Task");
        GridPane manageTaskNav = getManageTaskNav();
        GridPane manageTaskMenu = getManageTaskMenu();

        root.getChildren().add(titlePane);
        root.getChildren().add(manageTaskNav);
        root.getChildren().add(manageTaskMenu);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(manageTaskNav,120.0);
        AnchorPane.setTopAnchor(manageTaskMenu,240.0);



        return root;

    }



    public GridPane getManageTaskNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(backToCurrentTasks, 0, 0);
        grid.getChildren().add(backToCurrentTasks);

        GridPane.setConstraints(taskNameLabel, 0, 1);
        grid.getChildren().add(taskNameLabel);

        GridPane.setConstraints(taskDescLabel, 0, 2);
        grid.getChildren().add(taskDescLabel);

        GridPane.setConstraints(taskProgressLabel, 0, 3);
        grid.getChildren().add(taskProgressLabel);


        return grid;
    }

    public GridPane getManageTaskMenu(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        grid.getStyleClass().add("grid");

        return grid;
    }




}
