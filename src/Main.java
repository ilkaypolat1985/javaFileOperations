import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pathName = "C:\\temp\\list.txt";
        readFile(pathName);
        writeFile(pathName, "test");
        readFile(pathName);
    }

    public static void createFile(String pathName){
        File file = new File(pathName);
        try {

            if(file.createNewFile()){
                System.out.println("Created a file!");
            }else{
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileInfo(String pathName){
        File file = new File(pathName);

        if(file.exists()){
            System.out.println("File Name: " + file.getName());
            System.out.println("File Path: " + file.getAbsolutePath());
            System.out.println("File Writable: " + file.canWrite());
            System.out.println("File Readable: " + file.canRead());
            System.out.println("File Size: " + file.length());
        }
    }

    public static void readFile(String pathName){
        File file = new File(pathName);

        try {
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String pathName, String text){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathName, true));
            writer.newLine();
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
