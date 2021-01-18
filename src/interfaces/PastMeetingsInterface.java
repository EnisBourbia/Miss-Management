package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class PastMeetingsInterface extends Interface {
    public PastMeetingsInterface(){
        super();
        super.setTitle("Miss Management | Past Meetings");
    }

    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Past Meetings");
        GridPane nav = getNav();
        GridPane meetingsPane = getMeetingsPane();

        root.getChildren().add(titlePane);
        root.getChildren().add(nav);
        root.getChildren().add(meetingsPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(meetingsPane,200.0);

        return root;
    }

    private GridPane getNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(backToMeetingMenu, 0, 0);
        grid.getChildren().add(backToMeetingMenu);

        return grid;
    }




    private GridPane getMeetingsPane(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;
    }




}
