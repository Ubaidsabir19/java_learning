package serialization_deserialization;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeMethods {
    public static void main(String[] args) {

        Student st = new Student("Hadi", 23);

        try{

            FileOutputStream fis = new FileOutputStream("SDS.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(st);

            oos.flush();
            fis.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
