package serialization_deserialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerializeMethods {
    public static void main(String[] args) {

        try{

            FileInputStream fis =new FileInputStream("SDS.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ois.readObject();

            fis.close();
            ois.close();

        } catch (Exception e) {
           e.printStackTrace();
        }


    }
}
