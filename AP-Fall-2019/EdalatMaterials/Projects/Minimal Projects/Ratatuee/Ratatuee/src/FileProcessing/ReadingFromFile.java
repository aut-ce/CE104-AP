package FileProcessing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadingFromFile {
	private final static String RESTAURANT_FILE_NAME = "restaurants.txt";

	private final static String CUSTOMER_FILE_NAME = "customers.txt";

	private static String FILES_DIRECTORY_ADDRESS;

	public ReadingFromFile() {
		FILES_DIRECTORY_ADDRESS = new File("Files").getAbsolutePath() + "/";
	}

	private String readAllContent(String fileAddress) {
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(fileAddress)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public String readAllRestaurantContents() {
		return readAllContent(FILES_DIRECTORY_ADDRESS + RESTAURANT_FILE_NAME);
	}

	public String readAllCustomerContents() {
		return readAllContent(FILES_DIRECTORY_ADDRESS  + CUSTOMER_FILE_NAME);
	}
}
