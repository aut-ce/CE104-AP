package SingleThreadServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket welcomingSocket = new ServerSocket(7657)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            try (Socket connectionSocket = welcomingSocket.accept()) {
                System.out.println("client accepted!");
                OutputStream out = connectionSocket.getOutputStream();
                InputStream in = connectionSocket.getInputStream();
                byte[] buffer = new byte[2048];
                String[] messages = {"salam", "khubam!", "salamati!"};
                for (String msg: messages) {
                    int read = in.read(buffer);
                    System.out.println("RECV: " + new String(buffer, 0, read));
                    out.write(msg.getBytes());
                    System.out.println("SENT: " + msg);
                }
                System.out.print("All messages sent.\nClosing client ... ");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            System.out.print("done.\nClosing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}
