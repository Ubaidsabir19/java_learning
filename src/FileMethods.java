import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileMethods {
    public static void main(String[] args) throws IOException {

        // Create File
        File myFile = new File("File1.txt");
        myFile.createNewFile();

        // Write File
        FileWriter fw = new FileWriter("File1.txt");
        fw.write("Hello World\n");
        fw.write("Hello Ubaid");
        fw.close();

        // Read File
        File rf = new File("File1.txt");
        Scanner sc = new Scanner(rf);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();

        // Delete File
        File df = new File("File1.txt");
        if(df.delete()){
            System.out.println("File deleted successfully: " + df.getName());
        } else {
            System.out.println("File could not be deleted");
        }

    }
}
