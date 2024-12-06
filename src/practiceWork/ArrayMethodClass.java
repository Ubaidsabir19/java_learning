package practiceWork;

import java.util.*;

public class ArrayMethodClass {
    public static void main(String[] args) {

        // Simple Array
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.print("Length: " + arr.length);
        for (int result : arr){
            System.out.print(result);
        }
        System.out.println();

        // ---------------- Array List----------------
        ArrayList<String> cars = new ArrayList<>();
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


        // -----------------Linked List-----------------
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

        // ---------------- HashSet-------------------
        // used to store the unique elements
        // Also implements Serializable and Cloneable interfaces.
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);

        System.out.println("Size: "  + hs.size());
        System.out.println("Elements: " + hs);

        // ------------------------ HashTable------------------------------
        //  Synchronized, providing thread safety
        //  Have Not null value
        Hashtable<Integer, String> h = new Hashtable<>();
        h.put(1, "Babar");
        h.put(2, "Hadi");
        h.put(3, "Ahmad");
        h.put(4, "ubaid");

        // Operations
        System.out.println("Size: " + h.size());
        System.out.println("Elements: " + h);
        System.out.println("Get value by key: " + h.get(2));
        System.out.println("Replace object 1: " + h.replace(1, "Babar", "Aslam" ));
        System.out.println("Remove object 2: " + h.remove(2));
        System.out.println("Remove object 3: " + h.remove(1,"Ahmad"));

        //--------------------------- HashMap--------------------------------
        //  non-synchronized, faster when single thread
        //  Have one null key. or several null values
        HashMap<Integer,  String> hashMap = new HashMap<>();
        hashMap.put(1, "Babar");
        hashMap.put(2, "Hadi");
        hashMap.put(3, "Ahmad");

        // Operations
        System.out.println("Size: " + hashMap.size());
        System.out.println("Elements: " + hashMap);
        System.out.println("Get value by key: " + hashMap.get(2));
        System.out.println("Remove object 2: " + hashMap.remove(1));
        System.out.println("Remove object 2: " + hashMap.remove(2, "Hadi"));
        hashMap.clear();

        //----------------------------TreeSet--------------------------------
        TreeSet<String> t = new TreeSet<>();
        t.add("Babar");
        t.add("Hadi");
        t.add("Ahmad");
        t.add("ubaid");

        // Operations
        System.out.println("Size: " + t.size());
        System.out.println("Elements: " + t);
        System.out.println("first: " + t.first());
        System.out.println("Last: " + t.last());
        System.out.println("Higher: " + t.higher("Babar"));
        System.out.println("Lower: " + t.lower("Hadi"));
        System.out.println("Ceiling: " + t.ceiling("Hadi"));
        System.out.println("Floor: " + t.floor("Hadi"));
        System.out.println("Pool First: " + t.pollFirst());
        System.out.println("remove: " + t.removeAll(t));
        t.remove("Babar");
        t.clear();

        //--------------------------LinkedHashMap------------------------------
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Babar", 1);
        linkedHashMap.put("Hadi", 2);
        linkedHashMap.put("Ahmad", 3);
        linkedHashMap.put("ubaid", 4);

        // Operations
        System.out.println("Size: " + linkedHashMap.size());
        System.out.println("Elements: " + linkedHashMap);
        System.out.println("get: " + linkedHashMap.get("Babar"));
        System.out.println("remove: " + linkedHashMap.remove(1));

        //---------------------------Stack----------------------------
        // LIFO Last in First out
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("Size: " + s.size());
        System.out.println("Elements: " + s);
        System.out.println("get: " + s.get(2));
        System.out.println("remove: " + s.pop());
        System.out.println("index 1 element: " + s.elementAt(1));
        System.out.println("add: " + s.add(5));
        System.out.println("Size: " + s.size());
        System.out.println("peak: " + s.peek());
        System.out.println("search: " + s.search(3));

        //---------------------------Queue-----------------------------
        // FIFO First In Last Out
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        //Operations
        System.out.println("Size: " + q.size());
        System.out.println("Elements: " + q);
        System.out.println("offer: " + q.offer(2));
        System.out.println("poll: " + q.poll());
        System.out.println("remove: " + q.remove());
        System.out.println("element: " + q.element());
        System.out.println("contains: " + q.contains(3));
        System.out.println(q.stream().findFirst());
        System.out.println(q.stream().count());
        System.out.println(q.stream().distinct().count());
        System.out.println(q.stream().max(Integer::compareTo).get());

        // -------------------------MAP--------------------------
        // No Duplicates in Keys
        // Thread-Safe Alternatives
        // Null Handling
        Map<String, Integer> map = new HashMap<>();
        map.put("Babar", 1);
        map.put("Hadi", 2);
        map.put("Ahmad", 3);
        map.put("ubaid", 4);

        System.out.println("Map elements: " + map);
        System.out.println("get: " + map.get(3));
        System.out.println("remove: " + map.remove(3));
        System.out.println("size: " + map.size());
        map.clear();
    }
}
