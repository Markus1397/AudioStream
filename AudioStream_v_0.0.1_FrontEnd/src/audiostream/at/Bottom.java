/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream.at;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Eva
 */
public class Bottom {

    Slider slider;
    Label currentTime;
    Label finalDuration;

    public Slider getSlider() {
        return slider;
    }

    public void setMuiscImage(Image m) {
        if(m != null) {
                musicImageView.setImage(m);
                musicImageView.setFitHeight(60);
                musicImageView.setFitWidth(60);
                musicImageView.setPreserveRatio(true);
                musicImageView.setSmooth(true);
                musicImageView.setCache(true);
        }
        else
            musicImageView.setImage(musicImage);
        
    }

    public Label getCurrentTime() {
        return currentTime;
    }

    public Label getFinalDuration() {
        return finalDuration;
    }

    public Button getBack() {
        return back;
    }

    public Button getPlay() {
        return play;
    }

    public Button getForward() {
        return forward;
    }

    public void setMusicName(String text) {
        this.musicName.setText(text);
    }
    Button back;
    Button play;
    Button forward;
    Image musicImage;

    public Image getPauseImage() {
        return pauseImage;
    }
    Label musicName;
    HBox bottom;
    Image pauseImage;
    Image playImage;

    public Image getPlayImage() {
        return playImage;
    }

    public HBox getBottom() {
        return bottom;
    }
    ImageView musicImageView;

    public Bottom() {
        slider = new Slider();
        currentTime = new Label("0:00");
        finalDuration = new Label("0:00");
        Image backImage = new Image("file:zurueckspulen.png", 20, 20, false, false);
        musicImage = new Image("file:music-cover.jpg", 60, 60, false, false);
        playImage = new Image("file:play.png", 20, 20, false, false);
        Image forwardImage = new Image("file:vorspulen.png", 20, 20, false, false);
        pauseImage = new Image("file:pause.png", 20, 20, false, false);
        back = new Button("", new ImageView(backImage));
        play = new Button("", new ImageView(playImage));
        forward = new Button("", new ImageView(forwardImage));
        musicImageView = new ImageView(musicImage);
        bottom = new HBox();
        musicName = new Label("<Name>");
        musicName.setMaxWidth(100);
        musicName.setMinWidth(100);
        slider.setDisable(true);
        bottom.setSpacing(10);
        bottom.setAlignment(Pos.CENTER_LEFT);
        bottom.setStyle("-fx-border-color: grey;");
        bottom.getChildren().addAll(musicImageView, musicName, back, play, forward, currentTime, slider, finalDuration);
        bottom.setPadding(new Insets(10, 10, 10, 10));
        bottom.setPrefHeight(85);
    }
}
