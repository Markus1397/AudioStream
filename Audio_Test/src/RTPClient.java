import javax.media.*;


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
}  