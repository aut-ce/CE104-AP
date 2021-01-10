import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HttpDownloader implements Runnable{
    private URL url;
    private String directory;
	private String targetFileName;

    public HttpDownloader(String url, String targetFileName) throws MalformedURLException {
        this.url = new URL(url);
        this.targetFileName=targetFileName;
        directory = System.getProperty("user.home") +
                    File.separator + "Downloads" + File.separator;
    }

    private String getFileName() {
        return this.targetFileName;
    }

    @Override
    public void run() {
        System.out.printf("Starting Download:\n\t%s\n\t%s\n", url.getPath(), directory);
        HttpURLConnection connection;
        try {
            if ("http".equals(url.getProtocol())) {
                connection = (HttpURLConnection) url.openConnection();
            } else if ("https".equals(url.getProtocol())) {
                connection = (HttpsURLConnection) url.openConnection();
            } else {
                System.err.println("UNSUPPORTED PROTOCOL!");
                return;
            }
            connection.connect();
            // Make sure response code is in the 200 range.

            if (connection.getResponseCode() / 100 != 2)
                throw new IOException(connection.getResponseCode() + connection.getResponseMessage());
        } catch (IOException ex) {
            System.err.println("FAILED TO OPEN CONNECTION!" + ex);
            return;
        }

        File file = new File(directory + getFileName());
        long contentLength = connection.getContentLengthLong();
        System.out.println("Content Length = " + contentLength+" bytes.");

        try(InputStream in = connection.getInputStream();
            FileOutputStream out = new FileOutputStream(file)) {
            int totalRead = 0;
            byte[] buffer = new byte[1000000];
            while (totalRead < contentLength) {
                int read = in.read(buffer);
                if (read == -1)
                    break;
                out.write(buffer, 0, read);
                totalRead += read;
                System.out.println("Downloading>>total read is "+totalRead+" bytes.");
            }
            System.out.println("Download finished!\nTotal Read = " + totalRead);
        } catch (IOException ex) {
            System.err.println("");
        }
    }
    
    public static void main(String[] args) {
		ExecutorService executor= Executors.newCachedThreadPool();
		Scanner in =new Scanner(System.in);
		do {
			try {
				System.out.println("Enter the link for download file:");
				String linkURL=in.nextLine();
				System.out.println("Enter the target file name:");
				String targetFileName=in.nextLine();
				executor.execute(new HttpDownloader(linkURL,targetFileName));
				executor.awaitTermination(5, TimeUnit.MINUTES);
			} catch (MalformedURLException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Do you have new link for download? (yes or no)");
		}while (!in.nextLine().equals("no"));
		executor.shutdown();
	}
}
