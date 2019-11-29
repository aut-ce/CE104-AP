package io;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class FileIO {

    public static void main(String[] args) {
        try {
            printFileInfo("phase1.pdf");
            bufferedTextFileIO("This is some line of text to be written and then read.");
            printNioFileInfo("file.txt");
            copyFile("phase1.pdf", "copy.pdf");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * Print file information using the old File class.
     * @param path  Path of the file to print its information
     */
    public static void printFileInfo(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("Name: " + file.getName());
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute-Path: " + file.getAbsolutePath());
            System.out.println("Canonical-Path: " + file.getCanonicalPath());
            System.out.println("Size: " + getSize(file.length()));
            System.out.println("Modified: " + new Date(file.lastModified()));
            if (file.isDirectory()) {
                System.out.println("Directory contents:");
                for (String name: file.list())
                    System.out.println("    " + name);
            }
        } else {
            System.out.println("File does not exist");
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
                System.err.println(ex);
            }
        } else {
            System.out.println(path + " does not exist!");
        }
        System.out.println("NIO file info done!\n");
    }
    /**
     * Demonstrates efficient binary read/write operations for files.
     * @param srcPath  Path of the source file to be copied
     * @param dstPath  Path of the destination copy file
     */
    public static void copyFile(String srcPath, String dstPath) {
        File src = new File(srcPath);
        File dst = new File(dstPath);
        if (!src.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }
        System.out.println("Copying \'" + src.getName() + "\' to \'" + dst.getName() + "\' ...");
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buffer = new byte[4096];
            while (in.available() > 0) {
                int count = in.read(buffer);
                out.write(buffer, 0, count);
                //System.out.println(count + " bytes copied.");
            }
            System.out.println("Copy finished.\n");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Demonstrates efficient read/write operations for large text files.
     * @param txt  The text to be written to the target text file
     */
    public static void bufferedTextFileIO(String txt) {
        File txtFile = new File("file.txt");
        // First write the text file
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(txtFile));
            for (int i = 0; i < 5; ++i)
                writer.write(txt + '\n');
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
            while (reader.ready()) {
                String line = reader.readLine();
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        System.out.println("Buffered text read/write done!\n");
    }

    /**
     * Return a human-readable representation of a file size.
     */
    public static String getSize(long size) {
        if (size < 1024)
            return size + " Bytes";
        if (size < 1024 * 1024)
            return String.format("%.2f KB", (float) size / 1024);
        if (size < 1024 * 1024 * 1024)
            return String.format("%.2f MB", (float) size / (1024 * 1024));
        //
        return String.format("%.2f GB", (float) size / (1024 * 1024 * 1024));
    }

}
