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

    public MenuClient() {
        Menu settings = new Menu("Settings");
        Menu info = new Menu("Info");
        Menu file = new Menu("File");
        Menu color = new Menu("Color");
        Menu language = new Menu("Language");
        MenuItem grey = new MenuItem("Grey");
        MenuItem pink = new MenuItem("Pink");
        MenuItem german = new MenuItem("German");
        MenuItem english = new MenuItem("English");
        menu.getMenus().addAll(file, settings, info);
        color.getItems().addAll(grey, pink);
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
