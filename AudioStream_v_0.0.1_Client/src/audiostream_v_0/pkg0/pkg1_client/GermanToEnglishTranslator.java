/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream_v_0.pkg0.pkg1_client;

/**
 *
 * @author Eva
 */
public class GermanToEnglishTranslator {

    MenuClient mclient;
    About about;
    Center center;
    LeftPart left;
    ServerProperties prop;
    Update update;

    public GermanToEnglishTranslator(MenuClient c, About a, Update u, Center ce, LeftPart l, ServerProperties s) {
        mclient = c;
        about = a;
        center = ce;
        left = l;
        prop = s;
        update = u;
    }

    public void start() {
        mclient.getFile().setText("File");
        mclient.getSettings().setText("Settings");
        mclient.getInfo().setText("Info");
        mclient.getQuit().setText("Quit");
        mclient.getColor().setText("Color");
        mclient.getLanguage().setText("Language");
        mclient.getAboutMenuItem().setText("About");
        mclient.getAboutMenuItem().setText("Update");
        mclient.getBlack().setText("Black");
        mclient.getGrey().setText("Grey");
        mclient.getGerman().setText("German");
        mclient.getEnglish().setText("English");
        mclient.getServer().setText("Server Properties");

        about.getAboutWindow().setTitle("About");
        about.getAbouttext().setText("Producers: Markus Kaufmann, Michael Dachs, Eva Pürmayr \nYear: 2015/16 \nVersion: a0.0.1");

        update.getUpdateWindow().setTitle("Updates");
        update.getUpdateText().setText("No updates available");

        center.getVolumeLabel().setText("Volume: ");

        left.getDisconnect().setText("Disconnect");
        left.getSettingsButton().setText("Settings");
        left.getServernameLabel().setText("Current");

        prop.getServerWindow().setTitle("Server Properties");
        prop.getIpLabel().setText("IP-Adress");
        prop.getDelayLabel().setText("Latency:");
        prop.getDisconnectServer().setText("Disconnect");
    }
}
