package interfaces;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MainMenuInterface extends Interface {


    public MainMenuInterface(){
        super();
        super.setTitle("Miss Management | Main Menu");
    }


    public AnchorPane showGUI() {
        AnchorPane root = new AnchorPane();

        GridPane mainTitlePane = getMainTitlePane();
        GridPane menuOptionsPane = getMenuOptions();
        root.getChildren().add(mainTitlePane);
        root.getChildren().add(menuOptionsPane);

        AnchorPane.setTopAnchor(mainTitlePane,0.0);
        AnchorPane.setTopAnchor(menuOptionsPane,240.0);

        return root;
    }

    private GridPane getMainTitlePane(){
        GridPane grid = new GridPane();

        Label title = new Label("Miss Management");
        Label description = new Label("the program where project management isn't mismanaged");

        GridPane.setConstraints(title, 0, 0);
        grid.getChildren().add(title);
        GridPane.setConstraints(description, 0, 1);
        grid.getChildren().add(description);

        title.getStyleClass().add("title");
        description.getStyleClass().add("subtitle");
        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("bg");

        return grid;
    }

    private GridPane getMenuOptions(){
        GridPane grid = new GridPane();

        grid.setVgap(20);
        grid.setHgap(5);

        GridPane.setConstraints(loginBtn, 0, 0);
        grid.getChildren().add(loginBtn);
        loginBtn.getStyleClass().add("btn");

        GridPane.setConstraints(registerBtn, 0, 1);
        grid.getChildren().add(registerBtn);
        getRegisterBtn().getStyleClass().add("btn");

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;
    }



}
