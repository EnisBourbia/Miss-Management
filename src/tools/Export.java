package tools;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Export {

    public static void createUserDataExport(String userData) {

        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            File export = new File("export.txt");
            if (export.createNewFile()) {
                alert.titleProperty().set("Export");
                alert.headerTextProperty().set("Export created: " + export.getName());
                alert.showAndWait();
            } else {
                alert.titleProperty().set("Export");
                alert.headerTextProperty().set("Export already exists. Updating export...");
                alert.showAndWait();
            }
            writeToFile(userData);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.titleProperty().set("Export");
            alert.headerTextProperty().set("Something went wrong. Try to create export again.");
            alert.showAndWait();
        }
    }


    public static void writeToFile(String userData){
        try {
            FileWriter writer = new FileWriter("export.txt");
            writer.write(userData);
            writer.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.titleProperty().set("Export");
            alert.headerTextProperty().set("Error in writing to file. Try to create export again.");
            alert.showAndWait();
        }
    }


}
