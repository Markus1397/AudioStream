/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream_v_0.pkg0.pkg1_client;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Eva
 */
public class LeftPart {

    Button settingsButton = new Button("Settings");
    Label serverName = new Label("<Name>");
    Button disconnect = new Button("Disconnect");

    public Button getSettingsButton() {
        return settingsButton;
    }

    public Label getServerName() {
        return serverName;
    }

    public void setServerName(Label serverName) {
        this.serverName = serverName;
    }

    public Label getServernameLabel() {
        return servernameLabel;
    }

    public Button getDisconnect() {
        return disconnect;
    }
    Label servernameLabel;
    public LeftPart(BorderPane root) {
        VBox left = new VBox();
        servernameLabel = new Label("Current");
        Label servernameLabel2 = new Label("Server: ");
        Label nothing = new Label();
        left.getChildren().addAll(servernameLabel, servernameLabel2, serverName, settingsButton, nothing, disconnect);
        root.setLeft(left);
        left.setAlignment(Pos.TOP_CENTER);
        left.setPadding(new Insets(10, 10, 10, 10));
        left.setPrefWidth(130);
        left.setMaxWidth(150);
        left.setId("left");
        servernameLabel.setId("servernamelabel");
        serverName.setId("servername");
        servernameLabel2.setId("servernamelabel2");
        settingsButton.setId("settingsbutton");
        disconnect.setId("disconnect");
        servernameLabel.setPadding(new Insets(20, 20, 0, 20));
        servernameLabel2.setPadding(new Insets(0, 20, 30, 20));
        serverName.setPadding(new Insets(0, 20, 100, 20));
        nothing.setPadding(new Insets(10, 0, 5, 0));
    }
}
