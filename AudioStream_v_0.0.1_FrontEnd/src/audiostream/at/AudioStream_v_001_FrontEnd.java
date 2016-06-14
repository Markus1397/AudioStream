/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream.at;

import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.setUserAgentStylesheet;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Eva
 */
public class AudioStream_v_001_FrontEnd extends Application {

    final ObservableList<Music> data = FXCollections.observableArrayList();
    public boolean playCheck = false;

    @Override
    public void start(Stage primaryStage) {
        //declarations
        FileChooser fileChooser = new FileChooser();
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 500);
        MusicTable musicTable = new MusicTable(data);
        MenuClient menu = new MenuClient();
        Client client = new Client();
        Update update = new Update();
        About about = new About();
        Preferences preferences = new Preferences();
        Bottom bottom = new Bottom();

        root.setCenter(musicTable.getTable());
        root.setTop(menu.getHeader());
        root.setBottom(bottom.getBottom());

        //actions
        menu.getAddMusic().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("MP3", "*.mp3"));
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    Media media = new Media(file.toURI().toString());

                    MediaPlayer mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.setOnReady(new Runnable() {

                        public void run() {
                            String artist = "";
                            String genre = "";
                            String album = "";
                            String name;
                            ObservableMap<String, Object> map = media.getMetadata();
                            if (map.get("artist") != null) {
                                artist = map.get("artist").toString();
                            }
                            if (map.get("genre") != null) {
                                genre = map.get("genre").toString();
                            }
                            if (map.get("album") != null) {
                                album = map.get("album").toString();
                            }
                            if (map.get("title") != null) {
                                name = map.get("title").toString();
                            } else {
                                name = file.getName();
                            }
                            Image image = (Image) map.get("image");

                            Integer mins = (int) media.getDuration().toMinutes();
                            Integer seconds = (int) media.getDuration().toSeconds() - (mins * 60);
                            String sec = seconds.toString();
                            if (seconds.toString().length() == 1) {
                                sec = "0" + seconds.toString();
                            }
                            String durationTemp = mins.toString() + ":" + sec;
                            addMusic(file.getPath(), name, artist, durationTemp, album, genre, image);
                        }
                    });
                }
            }
        });
        musicTable.getTable().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Music musicTemp = (Music) musicTable.getTable().getSelectionModel().getSelectedItem();
                if (musicTemp != null) {
                    bottom.setMusicName(musicTemp.getName());
                    bottom.getFinalDuration().setText(musicTemp.getDuration());
                    bottom.setMuiscImage(musicTemp.getImage());
                }
            }

        });
        menu.getClients().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client.show();
            }
        });
        menu.getAbout().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                about.show();
            }
        });
        menu.getUpdate().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                update.show();
            }
        });
        menu.getQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        menu.getBlack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setUserAgentStylesheet(STYLESHEET_CASPIAN);
            }
        });
        menu.getGrey().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setUserAgentStylesheet(STYLESHEET_MODENA);
            }
        });
        menu.getPreferences().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                preferences.show();
            }
        });
        bottom.getPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (playCheck == false) {
                    Music m = (Music) musicTable.getTable().getSelectionModel().getSelectedItem();
                    if (m != null) {
                        System.out.println(m.getPath());
                        RTPServer.main("ip", m.getPath(), 00000);
                        bottom.getPlay().setGraphic(new ImageView(bottom.getPauseImage()));
                        playCheck = true;
                    }
                } else {
                    bottom.getPlay().setGraphic(new ImageView(bottom.getPlayImage()));
                    playCheck = false;
                }
            }
        });
        menu.getFile().setOnShown(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Music m;
                m = (Music) musicTable.getTable().getSelectionModel().getSelectedItem();
                if (m != null) { //check if somehinng is marked, continue
                    menu.getPreferences().setDisable(false);
                    preferences.getTitleLabel().setText(m.getName());
                    preferences.getAlbumLabel().setText(m.getAlbum());
                    preferences.getGenreLabel().setText(m.getGenre());
                    preferences.getArtistLabel().setText(m.getInterpret());
                    preferences.getDurationLabel().setText(m.getDuration());
                } else {
                    menu.getPreferences().setDisable(true);
                }
            }
        });
        menu.getDeutsch().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                EnglishToGermanTranslator tran = new EnglishToGermanTranslator(menu, about, client, musicTable, preferences, update);
                tran.start();
            }

        });
        menu.getEnglisch().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GermanToEnglishTranslator tran = new GermanToEnglishTranslator(menu, about, client, musicTable, preferences, update);
                tran.start();
            }
        });

        //css
        primaryStage.setTitle("AudioStreamer - Server");
        primaryStage.setScene(scene);
        about.getScene().getStylesheets().add(AudioStream_v_001_FrontEnd.class.getResource("server.css").toExternalForm());
        update.getScene().getStylesheets().add(AudioStream_v_001_FrontEnd.class.getResource("server.css").toExternalForm());
        client.getScene().getStylesheets().add(AudioStream_v_001_FrontEnd.class.getResource("server.css").toExternalForm());
        preferences.getScene().getStylesheets().add(AudioStream_v_001_FrontEnd.class.getResource("server.css").toExternalForm());
        primaryStage.show();

    }

    public void addMusic(String path, String musicName, String interpret, String duration, String album, String genre, Image image) {
        Music m = new Music(path, musicName, interpret, duration, album, genre, image);
        data.add(m);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
