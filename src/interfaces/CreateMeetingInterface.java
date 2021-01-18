package interfaces;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class CreateMeetingInterface extends Interface {
    public CreateMeetingInterface() {
        super();
        super.setTitle("Miss Management | Create Team Meeting");
    }


    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Create Team Meeting");
        GridPane meetingPane = getCreateAMeeting();
        GridPane nav = getNav();
        root.getChildren().add(titlePane);
        root.getChildren().add(meetingPane);
        root.getChildren().add(nav);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(meetingPane,240.0);

        return root;
    }

    private GridPane getCreateAMeeting() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));


        GridPane.setConstraints(meetingLocation, 0, 1);
        grid.getChildren().add(meetingLocation);
        meetingLocation.setPromptText("Meeting location (e.g. Zoom-meeting link)");

        GridPane.setConstraints(meetingDate, 0,2);
        grid.getChildren().add(meetingDate);
        meetingDate.setPromptText("Pick date for meeting");


        GridPane.setConstraints(createNewMeetingInviteBtn, 0,3);
        grid.getChildren().add(createNewMeetingInviteBtn);

        grid.getChildren().add(debug);
        GridPane.setConstraints(debug, 0, 4);
        debug.getStyleClass().add("debug");

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;

    }

    private GridPane getNav(){
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));


        GridPane.setConstraints(backToMeetingMenu, 0, 0);
        grid.getChildren().add(backToMeetingMenu);

        return grid;
    }





}