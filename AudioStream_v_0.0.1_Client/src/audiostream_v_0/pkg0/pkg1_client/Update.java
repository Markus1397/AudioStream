/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream_v_0.pkg0.pkg1_client;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Eva
 */
public class Update {

    Stage updateWindow = new Stage();
    BorderPane updatePane = new BorderPane();
    Scene updateScene = new Scene(updatePane);

    public Stage getUpdateWindow() {
        return updateWindow;
    }

    public Label getUpdateText() {
        return updateText;
    }
    Label updateText;

    public Update() {

        updateWindow.setTitle("Update");
        updateWindow.setWidth(500);
        updateWindow.setHeight(300);
        updateText = new Label("No updates available");
        updateText.setId("updatetext");
        updateWindow.setScene(updateScene);
        HBox updateBox = new HBox();
        updateBox.setId("updatebox");
        updatePane.setCenter(updateBox);
        updateBox.getChildren().add(updateText);
    }

    public void show() {
        updateWindow.show();
    }

    public Scene getScene() {
        return this.updateScene;
    }
}
