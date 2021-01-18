package interfaces;

import javafx.geometry.Insets;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.converter.DoubleStringConverter;

public class AddSalaryInterface extends Interface{

    public AddSalaryInterface(){
        super();
        super.setTitle("Miss Management | Add Salary to user");
    }


    public AnchorPane showGUI(){
        AnchorPane root = new AnchorPane();

        GridPane titlePane = getTitlePane("Miss Management | Add Salary to user");
        GridPane addSalaryNav = getAddSalaryNav();
        GridPane addSalaryPane = getAddSalaryPane();

        root.getChildren().add(titlePane);
        root.getChildren().add(addSalaryNav);
        root.getChildren().add(addSalaryPane);

        AnchorPane.setTopAnchor(titlePane,0.0);
        AnchorPane.setTopAnchor(addSalaryNav,120.0);
        AnchorPane.setTopAnchor(addSalaryPane,240.0);


        return root;
    }

    private GridPane getAddSalaryPane(){
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);


        GridPane.setConstraints(allUsersCB, 0, 0);
        grid.getChildren().add(allUsersCB);
        allUsersCB.getStyleClass().add("cb-lg");

        hourSalary.setPromptText("Enter hourly salary");
        hourSalary.setPrefColumnCount(10);

        hourSalary.setTextFormatter(new TextFormatter<>(new DoubleStringConverter()));

        GridPane.setConstraints(hourSalary, 0, 1);
        grid.getChildren().add(hourSalary);

        GridPane.setConstraints(addSalaryBtn, 0, 2);
        grid.getChildren().add(addSalaryBtn);

        debug.getStyleClass().add("debug");
        grid.getChildren().add(debug);
        GridPane.setConstraints(debug, 0, 3);


        grid.getStyleClass().add("grid");
        grid.getStyleClass().add("center");

        return grid;

    }
    private GridPane getAddSalaryNav(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(5);


        GridPane.setConstraints(backToManageProject, 0, 0);
        grid.getChildren().add(backToManageProject);

        return grid;
    }
}
