package interfaces;

import javafx.scene.layout.AnchorPane;
import javafx.geometry.Insets;

import javafx.scene.layout.GridPane;

public class CreateProjectInterface extends Interface {

    public CreateProjectInterface(){
            super();
            super.setTitle("Miss Management | Create a project");
        }


    private GridPane getCreateProjectPane(){
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        projectName.setPromptText("Enter project name");
        projectName.setPrefColumnCount(10);
        GridPane.setConstraints(projectName, 0, 0);
        grid.getChildren().add(projectName);

        projectDescription.setPromptText("Enter project description");
        projectDescription.setPrefColumnCount(10);
        GridPane.setConstraints(projectDescription, 0, 1);
        grid.getChildren().add(projectDescription);

        GridPane.setConstraints(createProjectBtn, 0, 2);
        grid.getChildren().add(createProjectBtn);
        debug.getStyleClass().add("debug");
        grid.getChildren().add(debug);
        GridPane.setConstraints(debug, 0, 3);

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;

    }

    private GridPane getNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));

        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(backToUserMenu, 0, 0);
        grid.getChildren().add(backToUserMenu);

        return grid;
    }



    public AnchorPane showGUI() {
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Create a project");
        GridPane createProjectPane = getCreateProjectPane();
        GridPane nav = getNav();

        root.getChildren().add(titlePane);
        root.getChildren().add(createProjectPane);
        root.getChildren().add(nav);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(createProjectPane,240.0);

        return root;

        }

}
