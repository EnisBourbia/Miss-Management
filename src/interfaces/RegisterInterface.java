package interfaces;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;

public class RegisterInterface extends Interface {


    public RegisterInterface(){
        super();
        super.setTitle("Miss Management | Register");
    }


    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Register");
        GridPane registerPane = createRegisterPane();
        GridPane topNav = getTopNav();


        root.getChildren().add(titlePane);
        root.getChildren().add(topNav);
        root.getChildren().add(registerPane);


        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(topNav,120.0);
        AnchorPane.setTopAnchor(registerPane,200.0);


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



    public GridPane createRegisterPane(){
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(5);

        Label createAccLabel = new Label("Create an account");
        GridPane.setConstraints(createAccLabel,0,0);
        grid.getChildren().add(createAccLabel);


        userFirstName.setPromptText("Enter first name");
        userLastName.setPromptText("Enter last name");
        userEmail.setPromptText("Enter email");
        userPassword.setPromptText("Enter password (8 letters or more)");
        userPasswordConfirm.setPromptText("Confirm password");
        debug.getStyleClass().add("debug");



        GridPane.setConstraints(userFirstName, 0, 1);
        grid.getChildren().add(userFirstName);
        GridPane.setConstraints(userLastName, 0, 2);
        grid.getChildren().add(userLastName);
        GridPane.setConstraints(userEmail, 0, 3);
        grid.getChildren().add(userEmail);
        GridPane.setConstraints(userPassword, 0, 4);
        grid.getChildren().add(userPassword);
        GridPane.setConstraints(userPasswordConfirm, 0, 5);
        grid.getChildren().add(userPasswordConfirm);
        GridPane.setConstraints(createAccBtn, 0, 6);
        grid.getChildren().add(createAccBtn);
        grid.getChildren().add(debug);
        GridPane.setConstraints(debug, 0, 7);

        grid.getChildren().add(loginLink);
        GridPane.setConstraints(loginLink, 0, 9);
        GridPane.setHalignment(loginLink, HPos.RIGHT);

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");


        return grid;

    }





}
