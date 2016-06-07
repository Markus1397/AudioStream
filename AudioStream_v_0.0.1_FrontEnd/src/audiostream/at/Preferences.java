/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream.at;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Eva
 */
public class Preferences {

    Stage preferencesWindow = new Stage();
    Label preferencesTitleLabel;
    Label artistLabel;
    Label albumLabel;
    Label genreLabel;

    public Label getTitleLabel() {
        return preferencesTitleLabel;
    }

    public Label getArtistLabel() {
        return artistLabel;
    }

    public Label getAlbumLabel() {
        return albumLabel;
    }

    public Label getGenreLabel() {
        return genreLabel;
    }

    public Label getDurationLabel() {
        return preferencesDurationLabel;
    }

    public Scene getScene() {
        return preferencesScene;
    }

    public Stage getPreferencesWindow() {
        return preferencesWindow;
    }

    public Text getPreferencesText() {
        return preferencesText;
    }

    public Label getPreferenceTitle() {
        return preferenceTitle;
    }
    Label preferencesDurationLabel;
    GridPane preferncesPane = new GridPane();
    Scene preferencesScene = new Scene(preferncesPane);
    Text preferencesText;
    Label preferenceTitle;
    Label preferencesDuration;

    public Label getPreferencesDuration() {
        return preferencesDuration;
    }

    public Preferences() {
        preferencesWindow.setTitle("Preferences");
        preferencesWindow.setWidth(250);
        preferencesWindow.setHeight(250);
        preferencesText = new Text("Music Preferences");
        preferencesText.setId("preferencestext");
        preferncesPane.setAlignment(Pos.CENTER);
        preferncesPane.setHgap(10);
        preferncesPane.setVgap(10);
        preferncesPane.setPadding(new Insets(25, 25, 25, 25));
        preferncesPane.add(preferencesText, 0, 0, 2, 1);
        preferenceTitle = new Label("Title: ");
        preferncesPane.add(preferenceTitle, 0, 1);
        Label artist = new Label("Artist: ");
        preferncesPane.add(artist, 0, 2);
        Label album = new Label("Album: ");
        preferncesPane.add(album, 0, 3);
        Label genre = new Label("Genre: ");
        preferncesPane.add(genre, 0, 4);
        preferencesDuration = new Label("Duration: ");
        preferncesPane.add(preferencesDuration, 0, 5);
        preferencesTitleLabel = new Label("-");
        preferncesPane.add(preferencesTitleLabel, 1, 1);
        artistLabel = new Label("-");
        preferncesPane.add(artistLabel, 1, 2);
        albumLabel = new Label("-");
        preferncesPane.add(albumLabel, 1, 3);
        genreLabel = new Label("-");
        preferncesPane.add(genreLabel, 1, 4);
        preferencesDurationLabel = new Label("-");
        preferncesPane.add(preferencesDurationLabel, 1, 5);
        preferencesWindow.setScene(preferencesScene);
    }
    public void show() {
        preferencesWindow.show();
    }
}
