package interfaces;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MeetingScheduleInterface extends Interface {
    public MeetingScheduleInterface(){
        super();
        super.setTitle("Miss Management | Upcoming Meetings");
    }

    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Upcoming Meetings");
        GridPane nav = getNav();
        GridPane meetingPane = getMeetingPane();

        root.getChildren().add(titlePane);
        root.getChildren().add(nav);
        root.getChildren().add(meetingPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(meetingPane,200.0);

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




    private GridPane getMeetingPane(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");
        return grid;
    }




}
