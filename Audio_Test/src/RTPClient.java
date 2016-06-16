import uk.co.caprica.vlcj.component.AudioMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class RTPClient {

   private final AudioMediaPlayerComponent mediaPlayerComponent;

   public static void main(String[] args) {
       boolean found = new NativeDiscovery().discover();
       System.out.println(found);
       System.out.println(LibVlc.INSTANCE.libvlc_get_version());

       RTPClient client= new RTPClient();
       client.start(args[0]);
       try {
           Thread.currentThread().join();
       }
       catch(InterruptedException e) {
       }
   }

   private RTPClient() {
       mediaPlayerComponent = new AudioMediaPlayerComponent();
       mediaPlayerComponent.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
           @Override
           public void stopped(MediaPlayer mediaPlayer) {
               exit(0);
           }

           @Override
           public void finished(MediaPlayer mediaPlayer) {
               exit(0);
           }

           @Override
           public void error(MediaPlayer mediaPlayer) {
               exit(1);
           }
       });
   }

   private void start(String mrl) {
       mediaPlayerComponent.getMediaPlayer().playMedia(mrl);
   }

   private void exit(int result) {
       mediaPlayerComponent.release();
       System.exit(result);
   }
}