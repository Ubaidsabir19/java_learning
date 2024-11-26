package practiceWork;

import java.util.HashMap;

public class HashMapClass {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        // Add data
        students.put(1, "Ali");
        students.put(2, "Hadi");

        System.out.println(students);
        // get data
        students.get(2);

        // remove data
        students.remove(2);
        students.remove(2, "Hadi");

        // clear all
        students.clear();
    }
}
