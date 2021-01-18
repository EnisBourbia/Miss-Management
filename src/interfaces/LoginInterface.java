package interfaces;

import javafx.scene.layout.AnchorPane;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class LoginInterface extends Interface {

    public LoginInterface(){
        super();
        super.setTitle("Miss Management | Login");
    }




    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Login");
        GridPane loginPane = getLoginPane();
        GridPane nav = getTopNav();

        root.getChildren().add(titlePane);
        root.getChildren().add(nav);

        root.getChildren().add(loginPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);

        AnchorPane.setTopAnchor(loginPane,240.0);

        return root;
    }


    private GridPane getTopNav(){
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));

        GridPane.setConstraints(mainMenuLink, 0, 0);
        grid.getChildren().add(mainMenuLink);


        return grid;
    }




    private GridPane getLoginPane(){
        GridPane grid = new GridPane();

        Label loginLabel = new Label("Login");

        grid.setPadding(new Insets(20, 0, 20, 0));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(loginLabel, 0, 0);
        grid.getChildren().add(loginLabel);

        userEmail.setPromptText("Enter email");
        GridPane.setConstraints(userEmail, 0, 1);

        grid.getChildren().add(userEmail);

        userPassword.setPromptText("Enter password");
        GridPane.setConstraints(userPassword, 0, 2);
        grid.getChildren().add(userPassword);

        GridPane.setConstraints(submitLoginBtn, 0, 3);
        grid.getChildren().add(submitLoginBtn);


        grid.getChildren().add(debug);
        GridPane.setConstraints(debug, 0, 4);
        debug.getStyleClass().add("debug");


        GridPane.setConstraints(registerLink, 0, 6);
        grid.getChildren().add(registerLink);
        GridPane.setHalignment(registerLink, HPos.RIGHT);

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;
    }




}

