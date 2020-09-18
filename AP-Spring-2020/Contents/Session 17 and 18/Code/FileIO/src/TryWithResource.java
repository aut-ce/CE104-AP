import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResource {
	public static void main(String args[]) {

		try (FileInputStream in = new FileInputStream("./Pics/java.png");
				FileOutputStream out = new FileOutputStream("./Pics/java1.jpg")) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			System.out.println("Finished");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
