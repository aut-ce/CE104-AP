package Main;

import FileProcessing.ReadingFromFile;

public class Main {

	public static void main(String[] args) {
		System.out.print((new ReadingFromFile()).readAllCustomerContents());
		System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.print((new ReadingFromFile()).readAllRestaurantContents());
	}

}
