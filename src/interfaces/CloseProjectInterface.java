package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CloseProjectInterface extends Interface {

    public CloseProjectInterface(){
        super();
        super.setTitle("Miss Management | Close a project");
    }

    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Close a project");
        GridPane nav = getNav();
        GridPane projectsPane = getProjectsPane();

        root.getChildren().add(titlePane);
        root.getChildren().add(nav);
        root.getChildren().add(projectsPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(projectsPane,240.0);

        return root;
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




    private GridPane getProjectsPane(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(projectsCb, 0, 0);
        grid.getChildren().add(projectsCb);
        projectsCb.getStyleClass().add("cb-lg");

        GridPane.setConstraints(closeProjectBtn, 0, 1);
        grid.getChildren().add(closeProjectBtn);

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");
        return grid;
    }




}
