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
        /*mclient.getFile().setText("Datei");
        mclient.getSettings().setText("Einstellungen");
        mclient.getInfo().setText("Information");
        mclient.getAddMusic().setText("Musik hinzufügen");
        mclient.getQuit().setText("Beenden");
        mclient.getPreferences().setText("Details");
        mclient.getClients().setText("Klienten");
        mclient.getColor().setText("Farbe");
        mclient.getLanguage().setText("Sprache");
        mclient.getAbout().setText("Über");
        mclient.getUpdate().setText("Modernisieren");
        mclient.getBlack().setText("Schwarz");
        mclient.getGrey().setText("Grau");
        mclient.getEnglisch().setText("Englisch");
        mclient.getDeutsch().setText("Deutsch");
        
        about.getAboutWindow().setTitle("Über");
        about.getAbouttext().setText("Produzenten: Markus Kaufmann, Michael Dachs, Eva Pürmayr \nJahr: 2015/16 \nVersion: a0.0.1");
        
        client.getClientsWindow().setTitle("Klienten");
        client.getClientText().setText("Klienten");
        client.getIp().setText("IP-Adresse");
        client.getVerzoegerung().setText("Verzögerung");
        client.getKick().setText("Kicken");
        
        table.getDurations().setText("Dauer");
        table.getTitle().setText("Titel");
        
        pref.getPreferencesWindow().setTitle("Details");
        pref.getPreferencesText().setText("Musik Details");
        pref.getDurationLabel().setText("Dauer: ");
        pref.getTitleLabel().setText("Titel: ");
        
        update.getUpdateWindow().setTitle("Modernisierung");
        update.getUpdateText().setText("Keine Modernisierungsmöglichkeiten verfügbar");*/
    }
}
