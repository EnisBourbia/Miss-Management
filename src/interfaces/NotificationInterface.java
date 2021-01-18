package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class NotificationInterface extends Interface {

    public NotificationInterface(){
        super();
        setTitle("Miss Management | Notifications");
    }

    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Notifications");
        GridPane notificationNav = getNotificationNav();
        GridPane notificationPane = getNotificationPane();


        root.getChildren().add(titlePane);
        root.getChildren().add(notificationNav);
        root.getChildren().add(notificationPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(notificationNav,120.0);
        AnchorPane.setTopAnchor(notificationPane,200.0);

        return root;
    }

    private GridPane getNotificationNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(backToUserMenu, 0, 0);
        grid.getChildren().add(backToUserMenu);

        return grid;
    }




    private GridPane getNotificationPane(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);


        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;
    }
}
