/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream_v_0.pkg0.pkg1_client;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Eva
 */
public class ServerProperties {
    Stage serverWindow = new Stage();
    GridPane serverPane = new GridPane();
    Scene serverScene = new Scene(serverPane);
    Label ip;

    public void setIp(Label ip) {
        this.ip = ip;
    }

    public void setHostname(Label hostname) {
        this.hostname = hostname;
    }

    public Stage getServerWindow() {
        return serverWindow;
    }

    public GridPane getServerPane() {
        return serverPane;
    }

    public Scene getServerScene() {
        return serverScene;
    }

    public Label getIp() {
        return ip;
    }

    public Label getHostname() {
        return hostname;
    }

    public Label getDelay() {
        return delay;
    }

    public Label getIpLabel() {
        return ipLabel;
    }

    public Label getHostnameLabel() {
        return hostnameLabel;
    }

    public Label getDelayLabel() {
        return delayLabel;
    }

    public Button getDisconnectServer() {
        return disconnectServer;
    }

    public void setDelay(Label delay) {
        this.delay = delay;
    }
    Label hostname;
    Label delay;
    Label ipLabel;
    Label hostnameLabel;
    Label delayLabel;
    Button disconnectServer;
    public ServerProperties() {
        serverWindow.setTitle("Server Properties");
        serverWindow.setWidth(250);
        serverWindow.setHeight(250);
        Text serverLabel = new Text("Server");
        serverLabel.setId("serverlabel");
        serverPane.setAlignment(Pos.CENTER);
        serverPane.setHgap(10);
        serverPane.setVgap(10);
        serverPane.setPadding(new Insets(25, 25, 25, 25));
        serverPane.add(serverLabel, 0, 0, 2, 1);
        ipLabel = new Label("IP-Adress:");
        serverPane.add(ipLabel, 0, 1);
        ip = new Label("-");
        serverPane.add(ip, 1, 1);
        hostnameLabel = new Label("Hostname:");
        serverPane.add(hostnameLabel, 0, 2);
        hostname = new Label("-");
        serverPane.add(hostname, 1, 2);
        delayLabel = new Label("Delay:");
        serverPane.add(delayLabel, 0, 3);
        delay = new Label("-");
        serverPane.add(delay, 1, 3);
        disconnectServer = new Button("Disconnect");
        HBox hbdisconnect = new HBox(10);
        hbdisconnect.setAlignment(Pos.BOTTOM_RIGHT);
        hbdisconnect.getChildren().add(disconnectServer);
        serverPane.add(hbdisconnect, 1, 4);
        serverWindow.setScene(serverScene);
    }
    public void show(){
        serverWindow.show();
    }
    public Scene getScene() {
        return this.serverScene;
    }
}
