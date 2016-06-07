/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream.at;

/**
 *
 * @author Eva
 */
public class GermanToEnglishTranslator {
    MenuClient mclient;
    About about;
    Client client;
    MusicTable table;
    Preferences pref;
    Update update;
    
    public GermanToEnglishTranslator(MenuClient c,About a, Client cl, MusicTable m, Preferences p, Update u)
    {
        mclient = c;
        about = a;
        client = cl;
        table = m;
        pref = p;
        update = u;
    }
    public void start() {
        mclient.getFile().setText("File");
        mclient.getSettings().setText("Settings");
        mclient.getInfo().setText("Info");
        mclient.getAddMusic().setText("Add Music");
        mclient.getQuit().setText("Quit");
        mclient.getPreferences().setText("Preferences");
        mclient.getClients().setText("Clients");
        mclient.getColor().setText("Color");
        mclient.getLanguage().setText("Language");
        mclient.getAbout().setText("About");
        mclient.getUpdate().setText("Update");
        mclient.getBlack().setText("Black");
        mclient.getGrey().setText("Grey");
        mclient.getEnglisch().setText("English");
        mclient.getDeutsch().setText("German");
        
        about.getAboutWindow().setTitle("About");
        about.getAbouttext().setText("Producers: Markus Kaufmann, Michael Dachs, Eva Pürmayr \nYear: 2015/16 \nVersion: a0.0.1");
        
        client.getClientsWindow().setTitle("Clients");
        client.getClientText().setText("Clients");
        client.getIp().setText("IP-Adress");
        client.getVerzoegerung().setText("Latency");
        client.getKick().setText("Kick");
        
        table.getDurations().setText("Duration");
        table.getTitle().setText("Title");
        
        pref.getPreferencesWindow().setTitle("Preferences");
        pref.getPreferencesText().setText("Music Preferences");
        pref.getDurationLabel().setText("Duration: ");
        pref.getTitleLabel().setText("Title: ");
        
        update.getUpdateWindow().setTitle("Update");
        update.getUpdateText().setText("No updates available");
    }
}
