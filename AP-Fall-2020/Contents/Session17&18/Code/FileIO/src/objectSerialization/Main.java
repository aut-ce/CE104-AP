package objectSerialization;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String fileAddress = "students.ser";
		ReadObjectFromFile read = null;
		WriteObjectToFile write = null;
		
		File students = new File(fileAddress);
        if (students.exists())
        	students.delete();
		
		
		try {
			write = new WriteObjectToFile(fileAddress);
			read = new ReadObjectFromFile(fileAddress);

			write.writeToFile(new Student(27, "ehsan", "edalat", 10.8, false));
			write.writeToFile(new Student(26, "ahmad", "asadi", 15.9, true));

			write.closeConnection();

			while (true) {
				Student std = (Student) read.readFromFile();
				System.out.print(std.getAge() + "\t");
				System.out.print(std.getFamilyName() + "\t");
				System.out.print(std.getName() + "\t");
				System.out.print(std.getGrade() + "\t");
				System.out.println(std.isMarried());
			}
		} catch (FileNotFoundException | EOFException | ClassNotFoundException e) {
			try {
				read.closeConnection();
			} catch (IOException e1) {
				System.out.println("error in closing file!");
			} finally {
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
