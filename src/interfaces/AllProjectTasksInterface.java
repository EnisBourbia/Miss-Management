package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class AllProjectTasksInterface extends Interface {
    public AllProjectTasksInterface(){
        super();
        super.setTitle("Miss Management | All project tasks");
    }

    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();
        GridPane titlePane = getTitlePane("Miss Management | All project tasks");
        GridPane topNav = getTopNav();
        GridPane allProjectTasks = getAllProjectTasks();


        root.getChildren().add(titlePane);
        root.getChildren().add(topNav);
        root.getChildren().add(allProjectTasks);


        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(topNav,120.0);
        AnchorPane.setTopAnchor(allProjectTasks,200.0);


        return root;

    }

    public GridPane getTopNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(backToTaskMenu, 0, 0);
        grid.getChildren().add(backToTaskMenu);


        return grid;
    }

    public GridPane getAllProjectTasks(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;
    }

}
