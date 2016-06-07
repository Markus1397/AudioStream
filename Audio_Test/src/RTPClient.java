/*import javax.media.*;


public class RTPClient implements ControllerListener, Runnable {

    Player p;
    MediaLocator src;

    public static void main(String[] args) {
        RTPClient rtp = new RTPClient("192.168.2.1");
        Thread t = new Thread(rtp);
        t.start();

    }

    public RTPClient(String ip) {
        String srcUrl = "rtp://" + ip + ":8888/audio/1";
        DataSink sink;
        src = new MediaLocator(srcUrl);
    }
    public void run() {
        try {
            p = Manager.createPlayer(src);
            p.addControllerListener(this);
            p.start();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public synchronized void controllerUpdate(ControllerEvent evt) {
        if (evt instanceof EndOfMediaEvent) {
            System.exit(0);
        } else {
            System.out.println(evt.toString());
        }
    }
}  */

/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2009-2016 Caprica Software Limited.
 */



import uk.co.caprica.vlcj.component.AudioMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.test.VlcjTest;

/**
 * The smallest amount of code to play an audio file.
 * <p>
 * Audio is simple since there's no video surface to worry about (unless you want the audio
 * visualisations).
 */
public class RTPClient extends VlcjTest {

    public static void main(String[] args) throws Exception {
        if(args.length != 1) {
            System.out.println("Specify an MRL to play");
            System.exit(1);
        }

        AudioMediaPlayerComponent audioPlayer = new AudioMediaPlayerComponent() {
            @Override
            public void finished(MediaPlayer mediaPlayer) {
                System.exit(0);
            }

            @Override
            public void error(MediaPlayer mediaPlayer) {
                System.out.println("Failed to play media");
                System.exit(1);
            }
        };

        // Play the MRL specified by the first command-line argument
        audioPlayer.getMediaPlayer().playMedia(args[0]);
        // Wait forever
        Thread.currentThread().join();
    }
}
