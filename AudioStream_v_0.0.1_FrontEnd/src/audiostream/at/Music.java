/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream.at;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

/**
 *
 * @author Eva
 */
public class Music {
    private String name;
    private String interpret;
    private String duration;
    private String album;
    private String genre;
    private Image image;
    public Music(String n, String i, String d, String a, String g, Image im) {
        name = n;
        interpret = i;
        duration = d;
        album = a;
        genre = g;
        image = im;
    }
    
    public String getName() {
        return name;
    }

    public Image getImage() {
        
        return image;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public String getInterpret() {
        return interpret;
    }

    public String getDuration() {
        return duration;
    }

}
