/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream.at;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Eva
 */
public class MenuClient {

    MenuBar header = new MenuBar();
    MenuItem addMusic;
    MenuItem quit;
    MenuItem clients;
    MenuItem preferences;
    Menu color;

    public MenuItem getAddMusic() {
        return addMusic;
    }

    public MenuItem getQuit() {
        return quit;
    }

    public MenuItem getClients() {
        return clients;
    }

    public MenuItem getPreferences() {
        return preferences;
    }

    public Menu getColor() {
        return color;
    }

    public Menu getLanguage() {
        return language;
    }

    public MenuItem getAbout() {
        return about;
    }

    public MenuItem getUpdate() {
        return update;
    }


    public MenuItem getGrey() {
        return grey;
    }

    public MenuItem getEnglisch() {
        return english;
    }

    public MenuItem getDeutsch() {
        return german;
    }
    Menu language;
    MenuItem about;
    MenuItem update;
    MenuItem black;
    MenuItem grey;
    MenuItem english;
    MenuItem german;
    Menu file;
    Menu settings;

    public MenuItem getBlack() {
        return black;
    }

    public Menu getSettings() {
        return settings;
    }

    public Menu getInfo() {
        return info;
    }
    Menu info;
    

    public Menu getFile() {
        return file;
    }

    public MenuClient() {
        file = new Menu("File");
        settings = new Menu("Settings");
        info = new Menu("Info");
        addMusic = new MenuItem("Add Music");
        quit = new MenuItem("Quit");
        preferences = new MenuItem("Preferences");
        preferences.setDisable(true);
        clients = new MenuItem("Clients");
        color = new Menu("Color");
        language = new Menu("Language");
        about = new MenuItem("About");
        update = new MenuItem("Update");
        black = new MenuItem("Black");
        grey = new MenuItem("Grey");
        english = new MenuItem("English");
        german = new MenuItem("German");
        header.backgroundProperty();
        color.getItems().addAll(grey, black);
        language.getItems().addAll(english, german);
        header.getMenus().addAll(file, settings, info);
        file.getItems().addAll(addMusic, preferences, quit);
        settings.getItems().addAll(clients, color, language);
        info.getItems().addAll(about, update);
    }

    public MenuBar getHeader() {
        return header;
    }
}
