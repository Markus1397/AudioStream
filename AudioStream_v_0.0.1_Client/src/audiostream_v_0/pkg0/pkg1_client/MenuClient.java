/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream_v_0.pkg0.pkg1_client;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Eva
 */
public class MenuClient {

    MenuBar menu = new MenuBar();
    MenuItem server = new MenuItem("Server Properties");
    MenuItem aboutMenuItem = new MenuItem("About");
    MenuItem updateMenuItem = new MenuItem("Update");
    MenuItem quit = new MenuItem("Quit");
    Menu settings;
    Menu info;
    Menu file;
    Menu color;
    Menu language;

    public Menu getSettings() {
        return settings;
    }

    public Menu getInfo() {
        return info;
    }

    public Menu getFile() {
        return file;
    }

    public Menu getColor() {
        return color;
    }

    public Menu getLanguage() {
        return language;
    }

    public MenuItem getGrey() {
        return grey;
    }

    public MenuItem getBlack() {
        return black;
    }

    public MenuItem getGerman() {
        return german;
    }

    public MenuItem getEnglish() {
        return english;
    }
    MenuItem grey;
    MenuItem black;
    MenuItem german;
    MenuItem english;

    public MenuClient() {
        settings = new Menu("Settings");
         info = new Menu("Info");
         file = new Menu("File");
         color = new Menu("Color");
         language = new Menu("Language");
         grey = new MenuItem("Grey");
         black = new MenuItem("Black");
         german = new MenuItem("German");
         english = new MenuItem("English");
        menu.getMenus().addAll(file, settings, info);
        color.getItems().addAll(grey, black);
        language.getItems().addAll(german, english);
        file.getItems().addAll(server, quit);
        settings.getItems().addAll(color, language);
        info.getItems().addAll(aboutMenuItem, updateMenuItem);
    }

    public MenuItem getServer() {
        return server;
    }

    public MenuItem getQuit() {
        return quit;
    }

    public MenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public MenuItem getUpdateMenuItem() {
        return updateMenuItem;
    }

    public MenuBar getMenu() {
        return menu;
    }
}
