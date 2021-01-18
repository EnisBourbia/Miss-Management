package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class PastProjectsInterface extends Interface {
    public PastProjectsInterface(){
        super();
        super.setTitle("Miss Management | Past Projects");
    }

    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Past projects");
        GridPane nav = getNav();
        GridPane projectsPane = getProjectsPane();

        root.getChildren().add(titlePane);
        root.getChildren().add(nav);
        root.getChildren().add(projectsPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(projectsPane,200.0);

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

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;
    }




}
