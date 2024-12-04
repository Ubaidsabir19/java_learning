package practiceWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayMethodClass {
    public static void main(String[] args) {

        // Simple Array
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.print("Length: " + arr.length);
        for (int result : arr){
            System.out.print(result);
        }
        System.out.println();

        // ------------------------- Array List
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Corolla");
        cars.add("BMW");
        cars.add("Honda");
        System.out.println("Before cars sorted: " + cars);
        // set value at index
        cars.set(0, "Suzuki");
        // sort a list
        Collections.sort(cars);
        // sort list in reverse order
        cars.sort(Collections.reverseOrder());
        // get specific index value
        cars.get(0);
        // remove value at specific index
        cars.remove(2);
        // clear all the list
        cars.clear();


        // --------------------------- Linked List
        LinkedList<String> users = new LinkedList<>();
        users.add("Ali");
        users.add("Aslam");
        users.add("Hadi");
        users.add("Ahmad");
        users.add("ubaid ur rehman");
        System.out.println("Users: " + users);
        // sort a linked list
        Collections.sort(users);
        // remove user at specific index
        users.remove(1);
        // print size of link list
        System.out.println("Size: " + users.size());
        // get first index value
        System.out.println("Get first index: " + users.getFirst());
        // get last index value
        System.out.println("Get last index: " + users.getLast());
        // remove first index value
        System.out.println("Remove first index: " + users.removeFirst());
        // remove last index value
        System.out.println("Remove last index: " + users.removeLast());
        // replace a value at specific index
        users.set(0, "Babar");


        // Iterator Method (look like a loop)
        Iterator<String> allUsers = users.iterator();
        while(allUsers.hasNext()) {
            System.out.println(allUsers.next());
        }
    }
}
