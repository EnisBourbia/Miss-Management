package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class AddUserInterface extends Interface {

    public AddUserInterface(){
        super();
        super.setTitle("Miss Management | Add user to project");
    }


    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Add user to project");
        GridPane addUserNav = getAddUserNav();
        GridPane addUserPane = getAddUserPane();

        root.getChildren().add(titlePane);
        root.getChildren().add(addUserNav);
        root.getChildren().add(addUserPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(addUserNav,120.0);
        AnchorPane.setTopAnchor(addUserPane,240.0);


        return root;
    }

    private GridPane getAddUserNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);


        GridPane.setConstraints(backToManageProject, 0, 0);
        grid.getChildren().add(backToManageProject);

        return grid;
    }

    private GridPane getAddUserPane(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(userEmail, 0, 0);
        grid.getChildren().add(userEmail);
        userEmail.setPromptText("Enter user's email");

        GridPane.setConstraints(userRolesCb, 1, 0);
        grid.getChildren().add(userRolesCb);
        userRolesCb.getItems().addAll( "Scrum Master", "Product Owner", "Developer");
        userRolesCb.setValue("Scrum Master");

        GridPane.setConstraints(addUserConfirmBtn, 0, 1);
        grid.getChildren().add(addUserConfirmBtn);

        GridPane.setConstraints(debug,0, 2);
        grid.getChildren().add(debug);
        debug.getStyleClass().add("debug");


        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;
    }
}
