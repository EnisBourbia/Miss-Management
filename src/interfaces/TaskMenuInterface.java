package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class TaskMenuInterface extends Interface {

    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Task Menu");
        GridPane taskMenuPane = getTaskMenuPane();
        GridPane nav = getNav();

        root.getChildren().add(titlePane);
        root.getChildren().add(nav);
        root.getChildren().add(taskMenuPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(taskMenuPane,240.0);


        return root;
    }

    private GridPane getNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(backToManageProject, 0, 0);
        grid.getChildren().add(backToManageProject);

        return grid;
    }

    private GridPane getTaskMenuPane(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(createTaskBtn, 0, 1);
        grid.getChildren().add(createTaskBtn);

        GridPane.setConstraints(currentTasksBtn, 0, 2);
        grid.getChildren().add(currentTasksBtn);


        GridPane.setConstraints(logHoursBtn, 0, 3);
        grid.getChildren().add(logHoursBtn);

        GridPane.setConstraints(allTasksBtn, 0, 4);
        grid.getChildren().add(allTasksBtn);

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;
    }

}
