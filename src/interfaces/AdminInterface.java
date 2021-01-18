package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class AdminInterface extends Interface {
    public AdminInterface(){
        super();
        super.setTitle("Miss Management | Admin");
    }

    public AnchorPane showGUI() {
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Admin");
        GridPane adminMenu = getAdminOptions();
        GridPane bottomNav = getBottomNav();

        root.getChildren().add(titlePane);
        root.getChildren().add(adminMenu);
        root.getChildren().add(bottomNav);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(adminMenu,200.0);
        AnchorPane.setBottomAnchor(bottomNav,0.0);

        return root;
    }

    private GridPane getAdminOptions(){
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);


        GridPane.setConstraints(userExportBtn, 0, 0);
        grid.getChildren().add(userExportBtn);
        userExportBtn.getStyleClass().add("btn");



        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");


        return grid;

    }


    private GridPane getBottomNav(){
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));

        grid.getChildren().add(logoutLink);
        GridPane.setConstraints(logoutLink, 0, 2);
        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("right-align");


        return grid;
    }



}
