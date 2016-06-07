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
public class EnglishToGermanTranslator {
    MenuClient mclient;
    About about;
    Center center;
    LeftPart left;
    ServerProperties prop;
    Update update;
    
    public EnglishToGermanTranslator(MenuClient c, About a, Update u, Center ce, LeftPart l, ServerProperties s)
    {
        mclient = c;
        about = a;
        center = ce;
        left = l;
        prop = s;
        update = u;
    }
    public void start() {
        mclient.getFile().setText("Datei");
        mclient.getSettings().setText("Einstellungen");
        mclient.getInfo().setText("Information");
        mclient.getQuit().setText("Beenden");
        mclient.getColor().setText("Farbe");
        mclient.getLanguage().setText("Sprache");
        mclient.getAboutMenuItem().setText("Über");
        mclient.getUpdateMenuItem().setText("Modernisieren");
        mclient.getBlack().setText("Schwarz");
        mclient.getGrey().setText("Grau");
        mclient.getGerman().setText("Deutsch");
        mclient.getEnglish().setText("Englisch");
        mclient.getServer().setText("Server Eigenschaften");
        
        
        about.getAboutWindow().setTitle("Über");
        about.getAbouttext().setText("Produzenten: Markus Kaufmann, Michael Dachs, Eva Pürmayr \nJahr: 2015/16 \nVersion: a0.0.1");
        
        update.getUpdateWindow().setTitle("Modernisierung");
        update.getUpdateText().setText("Keine Modernisierungsmöglichkeiten verfügbar");
        
        center.getVolumeLabel().setText("Lautstärke: ");
        
        left.getDisconnect().setText("Trennen");
        left.getSettingsButton().setText("Einstellungen");
        left.getServernameLabel().setText("Aktueller");
        
        prop.getServerWindow().setTitle("Server Eigenschaften");
        prop.getIpLabel().setText("IP-Adresse");
        prop.getDelayLabel().setText("Verzögerung:");
        prop.getDisconnectServer().setText("Verbindung Trennen");
    }
}
