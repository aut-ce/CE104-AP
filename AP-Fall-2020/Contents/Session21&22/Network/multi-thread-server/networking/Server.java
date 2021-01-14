package MultiThreadServer;

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
        try (ServerSocket welcomingSocket = new ServerSocket(7660)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            while (count < 3) {
                Socket connectionSocket = welcomingSocket.accept();
                count++;
                System.out.println("client accepted!");
                pool.execute(new ClientHandler(connectionSocket, count));
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

    private Socket connectionSocket;
    private int clientNum;

    public ClientHandler(Socket connectionSocket, int clientNum) {
        this.connectionSocket = connectionSocket;
        this.clientNum=clientNum;
    }

    @Override
    public void run() {
        try {
            OutputStream out = connectionSocket.getOutputStream();
            InputStream in = connectionSocket.getInputStream();
            byte[] buffer = new byte[2048];
            String[] messages = {"salam", "khubam!", "salamati!"};
            for (String msg: messages) {
                int read = in.read(buffer);
                System.out.println("RECV from "+clientNum+": " + new String(buffer, 0, read));
                out.write(msg.getBytes());
                System.out.println("SENT to "+clientNum+": " + msg);
                Thread.sleep(2000);
            }
            System.out.print("All messages sent.\nClosing client ... ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
            	connectionSocket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
