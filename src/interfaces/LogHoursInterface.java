package interfaces;

import javafx.geometry.Insets;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.converter.IntegerStringConverter;

public class LogHoursInterface extends Interface{

    public LogHoursInterface(){
        super();
        super.setTitle("Miss Management | Log hours");
    }


    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Log hours");
        GridPane nav = getNav();
        GridPane logHoursPane = getLogHoursPane();

        root.getChildren().add(titlePane);
        root.getChildren().add(nav);
        root.getChildren().add(logHoursPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(nav,120.0);
        AnchorPane.setTopAnchor(logHoursPane,240.0);

        return root;
    }

    private GridPane getNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        GridPane.setConstraints(backToTaskMenu, 0, 0);
        grid.getChildren().add(backToTaskMenu);

        return grid;
    }




    private GridPane getLogHoursPane(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);

        hoursInput.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
        GridPane.setConstraints(hoursInput, 0, 0);
        grid.getChildren().add(hoursInput);


        GridPane.setConstraints(addHoursBtn, 0, 1);
        grid.getChildren().add(addHoursBtn);

        GridPane.setConstraints(debug, 0, 2);
        grid.getChildren().add(debug);
        debug.getStyleClass().add("debug");



        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");
        return grid;
    }





}
