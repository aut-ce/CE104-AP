/*** In The Name of Allah ***/
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Examples of different file I/O operations.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class FileIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cleanUp();
        formattedTextFileIO();
        bufferedTextFileIO("This is some large text to be written to a file!\n");
        copyFile("buffered.txt", "copy.txt");
        printFileInfo("formatted.txt");
        printNioFileInfo("copy.txt");
    }

    /**
     * Do some clean-up by deleting existing files.
     */
    public static void cleanUp() {
        File formatted = new File("formatted.txt");
        if (formatted.exists())
            formatted.delete();
        File buffered = new File("buffered.txt");
        if (buffered.exists())
            buffered.delete();
        File copy = new File("copy.txt");
        if (copy.exists())
            copy.delete();
        System.out.println("Clean up done!\n");
    }

    /**
     * Demonstrates formatted read/write operations for a text file.
     */
    public static void formattedTextFileIO() {
        Formatter output = null;
        Scanner input = new Scanner(System.in);
        try {
            output = new Formatter("formatted.txt");
            // Use CTRL+D on UNIX or CTRL+Z on Windows to end the loop
            System.out.println("Enter: first name,  last name,  student ID,  grade");
            while (input.hasNext()) {
                output.format("%s  %s  %d  %.2f", 
                        input.next(),     // first name
                        input.next(),     // last name
                        input.nextInt(),  // student ID
                        input.nextFloat() // grade
                );
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
        } finally {
            if (output != null)
                output.close();
        }
        System.out.println("Formatted text read/write done!\n");
    }
    
    /**
     * Demonstrates efficient read/write operations for large text files.
     * @param txt   The text to be written to the target text file
     */
    public static void bufferedTextFileIO(String txt) {
        File txtFile = new File("buffered.txt");
        // First write the text file
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(txtFile));
            for (int i = 0; i < 5; ++i)
                writer.write(txt);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            }
        }
        // Then read the text file
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(txtFile));
            int count;
            char[] buffer = new char[2048];
            while (reader.ready()) {
                count = reader.read(buffer);
                System.out.println(new String(buffer, 0, count));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            }
        }
        System.out.println("Buffered text read/write done!\n");
    }
    
    /**
     * Demonstrates efficient binary read/write operations for files.
     * @param src  Path of the source file to be copied
     * @param dst  Path of the destination copy file
     */
    public static void copyFile(String src, String dst) {
        File srcFile = new File(src);
        File dstFile = new File(dst);
        if (srcFile.exists()) {
            BufferedInputStream in = null;
            BufferedOutputStream out = null;
            try {
                int count;
                byte[] buffer = new byte[4096];
                in = new BufferedInputStream(new FileInputStream(srcFile));
                out = new BufferedOutputStream(new FileOutputStream(dstFile));
                while (in.available() > 0) {
                    count = in.read(buffer);
                    out.write(buffer, 0, count);
                }
                out.flush();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.err);
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            } finally {
                try {
                    if (in != null)
                        in.close();
                    if (out != null)
                        out.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        } else {
            System.out.println(src + " does not exist!");
        }
        System.out.println("File copy done!\n");
    }
    
    /**
     * Print file information using the old File class.
     * @param path  Path of the file to print its information
     */
    public static void printFileInfo(String path) {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("Name: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length());
            System.out.println("Modified: " + new Date(file.lastModified()));
            if (file.isDirectory()) {
                System.out.println("Directory contents:");
                String[] directory = file.list();
                for (String name: directory)
                    System.out.println("    " + name);
            }
        } else {
            System.out.println(path + " does not exist!");
        }
        System.out.println("File info done!\n");
    }
    
    /**
     * Print file information using the NIO Paths/Files utilities.
     * @param path  Path of the file to print its information
     */
    public static void printNioFileInfo(String path) {
        Path file = Paths.get(path);
        if (Files.exists(file)) {
            try {
                System.out.println("Name: " + file.getFileName());
                System.out.println("Path: " + file.toAbsolutePath());
                System.out.println("Size: " + Files.size(file));
                System.out.println("Modified: " + Files.getLastModifiedTime(file));
                if (Files.isDirectory(file)) {
                    System.out.println("Directory contents:");
                    DirectoryStream<Path> directory = Files.newDirectoryStream(file);
                    for (Path name: directory)
                        System.out.println("    " + name);
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            }
        } else {
            System.out.println(path + " does not exist!");
        }
        System.out.println("NIO file info done!\n");
    }
}
