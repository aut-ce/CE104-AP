package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(7654)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            try (Socket client = server.accept()) {
                System.out.println("client accepted!");
                OutputStream out = client.getOutputStream();
                InputStream in = client.getInputStream();
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
