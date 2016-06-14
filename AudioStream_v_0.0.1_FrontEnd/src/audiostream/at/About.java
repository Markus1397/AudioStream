/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream.at;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Eva
 */
public class About {

    Stage aboutWindow = new Stage();
    BorderPane aboutpane = new BorderPane();
    Scene aboutscene = new Scene(aboutpane);
    Label aboutLabel;
    Label abouttext;

    public Stage getAboutWindow() {
        return aboutWindow;
    }

    public BorderPane getAboutpane() {
        return aboutpane;
    }

    public Scene getAboutscene() {
        return aboutscene;
    }

    public Label getAboutLabel() {
        return aboutLabel;
    }

    public Label getAbouttext() {
        return abouttext;
    }

    public About() {
        aboutWindow.setTitle("About");
        aboutWindow.setWidth(500);
        aboutWindow.setHeight(300);
        aboutpane.setId("aboutpane");
        aboutLabel = new Label("Audio Stream");
        aboutLabel.setId("aboutlabel");
        abouttext = new Label("Producer: Markus Kaufmann, Michael Dachs, Eva Pürmayr \nYear: 2015/16 \nVersion: a0.0.1");
        aboutpane.setCenter(abouttext);
        aboutWindow.setScene(aboutscene);
        HBox aboutheader = new HBox();
        aboutheader.setId("aboutheader");
        aboutpane.setTop(aboutheader);
        aboutheader.getChildren().add(aboutLabel);
    }

    public Scene getScene() {
        return aboutscene;
    }

    public void show() {
        aboutWindow.show();
    }
}
