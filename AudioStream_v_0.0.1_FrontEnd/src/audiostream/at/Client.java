/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream.at;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Eva
 */
public class Client {

    Stage clientsWindow = new Stage();
    BorderPane clientPane = new BorderPane();

    public Scene getScene() {
        return clientScene;
    }
    Scene clientScene = new Scene(clientPane);
    TableView clientTable = new TableView();

    public Client() {
        clientsWindow.setTitle("Clients");
        clientsWindow.setWidth(300);
        clientsWindow.setHeight(400);
        Label clientText = new Label("Clients");
        clientText.setId("clienttext");
        clientsWindow.setScene(clientScene);
        HBox clientBox = new HBox();
        clientBox.setPadding(new Insets(10, 10, 10, 10));
        clientBox.setId("clientbox");
        clientBox.getChildren().add(clientText);
        TableColumn ip = new TableColumn("IP-Adresse");
        TableColumn name = new TableColumn("Name");
        TableColumn verzoegerung = new TableColumn("Verzögerung");
        TableColumn check = new TableColumn("");
        clientTable.getColumns().addAll(ip, name, verzoegerung, check);
        clientPane.setCenter(clientTable);
        clientPane.setTop(clientBox);
        Button kick = new Button("Kick");
        HBox clientBottom = new HBox();
        clientBottom.setPadding(new Insets(10, 10, 10, 10));
        clientBottom.getChildren().add(kick);
        clientBottom.setId("clientbottom");
        clientPane.setBottom(clientBottom);
    }

    public void setClientTable(TableView clientTable) {
        this.clientTable = clientTable;
    }
    public void show() {
        clientsWindow.show();
    }
}
