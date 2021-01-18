package interfaces;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class UserMeetingInterface extends Interface{
    public UserMeetingInterface() {
        super();
        super.setTitle("Miss Management | Meeting Menu");
    }


    public AnchorPane showGUI() {
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Meeting Menu");
        GridPane meetingPane = getMeetingPane();
        GridPane nav = getNav();

        root.getChildren().add(titlePane);
        root.getChildren().add(meetingPane);
        root.getChildren().add(nav);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(meetingPane,240.0);

        return root;
    }

    private GridPane getMeetingPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);


        GridPane.setConstraints(createNewMeetingBtn, 0,0);
        grid.getChildren().add(createNewMeetingBtn);


        GridPane.setConstraints(meetingScheduleBtn, 0,1);
        grid.getChildren().add(meetingScheduleBtn);


        GridPane.setConstraints(pastMeetingsBtn, 0,2);
        grid.getChildren().add(pastMeetingsBtn);

        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;

    }

    private GridPane getNav(){
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));


        GridPane.setConstraints(backToManageProject, 0, 0);
        grid.getChildren().add(backToManageProject);

        return grid;
    }



}
