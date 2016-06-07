/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream_v_0.pkg0.pkg1_client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Eva
 */
public class AudioStream_v_001_Client extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Declarations
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 400);
        MenuClient menuclient = new MenuClient();
        ServerProperties serverproperties = new ServerProperties();
        LeftPart left = new LeftPart(root);
        Center center = new Center(root);
        About about = new About();
        Update update = new Update();
        root.setTop(menuclient.getMenu());

        ChangeListener listener = new ChangeListener<Double>() {
            @Override
            public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                center.getVolumeValue().setText(Integer.toString(newValue.intValue()));
            }
        };
        center.getVolumeSlider().valueProperty().addListener(listener);

        //actions
        left.getSettingsButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                serverproperties.show();
            }
        });
        menuclient.getAboutMenuItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                about.show();
            }
        });
        menuclient.getUpdateMenuItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                update.show();
            }
        });
        menuclient.getServer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                serverproperties.show();
            }
        });
        menuclient.getQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        menuclient.getBlack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setUserAgentStylesheet(STYLESHEET_CASPIAN);
            }
        });
        menuclient.getGrey().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setUserAgentStylesheet(STYLESHEET_MODENA);
            }
        });
        menuclient.getGerman().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                EnglishToGermanTranslator tran = new EnglishToGermanTranslator(menuclient, about, update, center, left, serverproperties);
                tran.start();
            }
        });
        menuclient.getEnglish().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GermanToEnglishTranslator tran = new GermanToEnglishTranslator(menuclient, about, update, center, left, serverproperties);
                tran.start();
            }
        });
        //css
        about.getScene().getStylesheets().add(AudioStream_v_001_Client.class.getResource("Client.css").toExternalForm());
        update.getScene().getStylesheets().add(AudioStream_v_001_Client.class.getResource("Client.css").toExternalForm());
        serverproperties.getScene().getStylesheets().add(AudioStream_v_001_Client.class.getResource("Client.css").toExternalForm());
        scene.getStylesheets().add(AudioStream_v_001_Client.class.getResource("Client.css").toExternalForm());
        primaryStage.setTitle("Audio Stream - Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
