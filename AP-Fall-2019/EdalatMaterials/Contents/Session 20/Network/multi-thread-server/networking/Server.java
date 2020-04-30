package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        int count = 0;
        try (ServerSocket server = new ServerSocket(7654)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            while (count < 3) {
                Socket client = server.accept();
                count++;
                System.out.println("client accepted!");
                pool.execute(new ClientHandler(client));
            }
            pool.shutdown();
            System.out.print("done.\nClosing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }

}

class ClientHandler implements Runnable {

    private Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();
            byte[] buffer = new byte[2048];
            String[] messages = {"salam", "khubam!", "salamati!"};
            for (String msg: messages) {
                int read = in.read(buffer);
                System.out.println("RECV: " + new String(buffer, 0, read));
                out.write(msg.getBytes());
                System.out.println("SENT: " + msg);
                Thread.sleep(2000);
            }
            System.out.print("All messages sent.\nClosing client ... ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
