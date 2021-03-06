package server_ping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    /*
     - Server benutzt Port 3141,
     */

    public static void main(String[] args) throws IOException {
        final ExecutorService pool;
        final ServerSocket serverSocket;
        int port = 3141;
        String var = "C";
        String zusatz;

        if (args.length > 0) {
            var = args[0].toUpperCase();
        }
        if (var == "C") {
            //Liefert einen Thread-Pool, dem bei Bedarf neue Threads hinzugefügt
            //werden. Vorrangig werden jedoch vorhandene freie Threads benutzt.
            pool = Executors.newCachedThreadPool();
            zusatz = "CachedThreadPool";
        } else {
            int poolSize = 4;
            //Liefert einen Thread-Pool für maximal poolSize Threads
            pool = Executors.newFixedThreadPool(poolSize);
            zusatz = "poolsize=" + poolSize;
        }
        serverSocket = new ServerSocket(port);
        //Thread zur Behandlung der Client-Server-Kommunikation, der Thread-
        //Parameter liefert das Runnable-Interface (also die run-Methode für t1).
        Thread t1 = new Thread(new NetworkService(pool, serverSocket));
        System.out.println("Start NetworkService(Multiplikation), " + zusatz
                + ", Thread: " + Thread.currentThread());
        //Start der run-Methode von NetworkService: warten auf Client-request
        t1.start();
    }
}

//Thread bzw. Runnable zur Entgegennahme der Client-Anforderungen
class NetworkService implements Runnable { //oder extends Thread

    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    ;
    
    public NetworkService(ExecutorService pool,
            ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.pool = pool;
    }

    public void run() { // run the service
        try {
            //Endlos-Schleife: warte auf Client-Anforderungen
            //Abbruch durch Strg+C oder Client-Anforderung 'Exit',
            //dadurch wird der ServerSocket beendet, was hier zu einer IOException
            //führt und damit zum Ende der run-Methode mit vorheriger Abarbeitung der
            //finally-Klausel.
            while (true) {
                /*
                 Zunächst wird eine Client-Anforderung entgegengenommen(accept-Methode).
                 Der ExecutorService pool liefert einen Thread, dessen run-Methode
                 durch die run-Methode der Handler-Instanz realisiert wird.
                 Dem Handler werden als Parameter übergeben:
                 der ServerSocket und der Socket des anfordernden Clients.
                 */
                Socket cs = serverSocket.accept();  //warten auf Client-Anforderung

                //starte den Handler-Thread zur Realisierung der Client-Anforderung
                pool.execute(new Handler(serverSocket, cs));
            }
        } catch (IOException ex) {
            System.out.println("--- Interrupt NetworkService-run");
        } finally {
            System.out.println("--- Ende NetworkService(pool.shutdown)");
            pool.shutdown();  //keine Annahme von neuen Anforderungen
            try {
                //warte maximal 4 Sekunden auf Beendigung aller Anforderungen
                pool.awaitTermination(4L, TimeUnit.SECONDS);
                if (!serverSocket.isClosed()) {
                    System.out.println("--- Ende NetworkService:ServerSocket close");
                    serverSocket.close();
                }
            } catch (IOException | InterruptedException e) {
            }
        }
    }
}

//Thread bzw. Runnable zur Realisierung der Client-Anforderungen
class Handler implements Runnable {  //oder 'extends Thread'

    private final Socket client;
    private final ServerSocket serverSocket;
    private List<Long> list = new ArrayList<Long>();

    Handler(ServerSocket serverSocket, Socket client) { //Server/Client-Socket
        this.client = client;
        this.serverSocket = serverSocket;
    }

    public void run() {
        StringBuffer sb = null;
        PrintWriter out = null;
        try {
            // read and service request on client
            int i = 0;
            do {
                sb = new StringBuffer();
                System.out.println("running service, " + Thread.currentThread());
                out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader bufferedReader
                        = new BufferedReader(
                                new InputStreamReader(
                                        client.getInputStream()));
                char[] buffer = new char[100];
                int anzahlZeichen = bufferedReader.read(buffer, 0, 100); // blockiert bis Nachricht empfangen
                if (anzahlZeichen < 0) {return;}
                    String nachricht = new String(buffer, 0, anzahlZeichen);
                    System.out.println(nachricht);
                    if (!nachricht.contains("start")) {
                        long time = System.currentTimeMillis() - Long.parseLong(nachricht.trim().toLowerCase());
                        System.out.println("Zeit: " + time);
                        this.list.add(time);
                    
                    sb.append(System.currentTimeMillis());
                    out.println(sb);
                    System.out.println(sb);
                    i++;
                }
            } while (i < 4);

        } catch (IOException e) {
            System.out.println("IOException, Handler-run");
        } finally {
            //out.println(sb);  //Rückgabe Ergebnis an den Client
            if (!client.isClosed()) {
                System.out.println("****** Handler:Client close");
                if (this.list.size() > 0) {
                    int sumtime = 0;
                    for (int i = 0; i < this.list.size(); i++) {
                        sumtime += this.list.get(i);
                    }
                    double avg = sumtime / list.size();
                    System.out.println("IP: " + this.client.getInetAddress() + " Timeavg: " + avg);
                    this.list.removeAll(list);
                    try {
                        client.close();
                    } catch (IOException e) {
                    }

                }
            }
        }
    }  //Ende run
}
