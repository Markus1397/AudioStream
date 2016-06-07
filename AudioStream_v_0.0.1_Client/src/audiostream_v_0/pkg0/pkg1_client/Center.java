/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream_v_0.pkg0.pkg1_client;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Eva
 */
public class Center {
    Image cover_image;
    Label songName;
    Label songTimeEnd;
    Label volumeValue;
    Slider volumeSlider;
    Label songTime;
    Slider songSlider;

    public void setSongSlider(Slider songSlider) {
        this.songSlider = songSlider;
    }

    public void setSongTime(Label songTime) {
        this.songTime = songTime;
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

    public void setCover_image(Image cover_image) {
        this.cover_image = cover_image;
    }

    public void setSongName(Label songName) {
        this.songName = songName;
    }

    public void setSongTimeEnd(Label songTimeEnd) {
        this.songTimeEnd = songTimeEnd;
    }

    public Label getVolumeValue() {
        return volumeValue;
    }
    Label volumeLabel;
    public Center(BorderPane root) {
        VBox center = new VBox();
        cover_image = new Image("file:music-cover.jpg", 150,150, false,false);
        GridPane centerPane = new GridPane();
        ImageView cover = new ImageView(cover_image);
        center.setAlignment(Pos.CENTER);
        center.setSpacing(20);
        centerPane.setHgap(20);
        centerPane.setVgap(10);
        HBox song = new HBox();
        HBox volume = new HBox();
        song.setSpacing(10);
        volume.setSpacing(10);
        centerPane.setPadding(new Insets(20,0,0,20));
        song.setAlignment(Pos.CENTER);
        volume.setAlignment(Pos.CENTER);
        songName = new Label("<Songname>: ");
       volumeLabel = new Label("Volume: ");
        songTime  = new Label("0:00");
        songTimeEnd = new Label("3:24");
        volumeValue = new Label();
        Label volumeEnd = new Label("100");
        songSlider = new Slider(0,4,0);
        songSlider.setDisable(true);
        volumeSlider = new Slider(0,100,50);
        volumeValue.setText(Integer.toString((int) volumeSlider.getValue()));
        song.getChildren().addAll( songTime, songSlider, songTimeEnd);
        volume.getChildren().addAll(volumeValue, volumeSlider, volumeEnd);
        centerPane.add(songName, 0,0);
        centerPane.add(volumeLabel, 0, 1);
        centerPane.add(song, 1, 0);
        centerPane.add(volume, 1, 1);
        center.getChildren().addAll(cover, centerPane);
        root.setCenter(center);
    }

    public Label getVolumeLabel() {
        return volumeLabel;
    }
}
