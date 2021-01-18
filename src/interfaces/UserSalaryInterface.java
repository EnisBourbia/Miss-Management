package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class UserSalaryInterface extends Interface{

    public UserSalaryInterface(){
        super();
        super.setTitle("Miss Management | Costs");
    }


    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Costs");
        GridPane userSalaryNav = getUserSalaryNav();
        GridPane userSalaryPane = getUserSalaryPane();

        root.getChildren().add(titlePane);
        root.getChildren().add(userSalaryNav);
        root.getChildren().add(userSalaryPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(userSalaryNav,120.0);
        AnchorPane.setTopAnchor(userSalaryPane,240.0);

        return root;
    }

    private GridPane getUserSalaryNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(backToManageProject, 0, 0);
        grid.getChildren().add(backToManageProject);

        return grid;
    }




    private GridPane getUserSalaryPane(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);


        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");
        return grid;
    }






}


