package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CreateTaskInterface extends Interface{

    public CreateTaskInterface() {
        super();
        super.setTitle("Miss Management | Create a task");
    }

    public AnchorPane showGUI() {
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Create a task");
        GridPane taskMenu = getCreateATask();
        root.getChildren().add(titlePane);
        GridPane nav = getNav();
        root.getChildren().add(taskMenu);
        root.getChildren().add(nav);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(taskMenu,240.0);

        return root;
    }

    private GridPane getCreateATask(){
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);


        taskName.setPromptText("Enter task name");
        taskName.setPrefColumnCount(10);
        GridPane.setConstraints(taskName, 0, 0);
        grid.getChildren().add(taskName);

        taskDesc.setPromptText("Enter task description");
        taskDesc.setPrefColumnCount(10);
        GridPane.setConstraints(taskDesc, 0, 1);
        grid.getChildren().add(taskDesc);

        GridPane.setConstraints(createATaskBtn, 0, 2);
        grid.getChildren().add(createATaskBtn);

        debug.getStyleClass().add("debug");
        grid.getChildren().add(debug);
        GridPane.setConstraints(debug, 0, 3);

        grid.getChildren().add(assignUserCB);
        GridPane.setConstraints(assignUserCB, 1, 0);


        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;

    }

    private GridPane getNav(){
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));


        GridPane.setConstraints(backToTaskMenu, 0, 0);
        grid.getChildren().add(backToTaskMenu);

        return grid;
    }




}
