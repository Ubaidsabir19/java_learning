package practiceWork;

import java.util.*;

public class SetMethodsClass {

    enum Size {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }

    public static void main(String[] args) {

        //-------------------------------Set---------------------------------
        //--------------------Implementing HashSet Class---------------------
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("D");

        Set<String> set2 = new HashSet<>();
        set2.add("E");
        set2.add("B");
        set2.add("F");

        // Operations:
        System.out.println("Iterate: " + set1.iterator().next());
        System.out.println("Set Size: " + set1.size());
        System.out.println("Check set is empty: " + set1.isEmpty());
        System.out.println("Remove B: " + set1.remove("B"));
        System.out.println("Set Contains C: " + set1.contains("C"));
        System.out.println("Total Values in set: " + set1.stream().distinct().count());
        System.out.println(set1.stream().findFirst());
        System.out.println(set1.stream().findAny());
        System.out.println(set1.stream().limit(5).count());
        set2.addAll(set1);
        System.out.println("Union is: " + set2);

        //--------------------Implementing TreeSet Class---------------------
        Set<Integer> number = new TreeSet<>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);

        System.out.println("TreeSet Count: " + number.stream().distinct().count());
        System.out.println("TreeSet Size: " + number.size());
        System.out.println("TreeSet Contain: " + number.contains(4));
        System.out.println("TreeSet Remove: " + number.remove(3));
        System.out.println("TreeSet Sorted: " + number.stream().sorted());


        //--------------------Implementing ENUM Set---------------------
        // All enums will empty
        EnumSet<Size> size = EnumSet.noneOf(Size.class);
        System.out.println("EnumSet Size: " + size);
        size.add(Size.MEDIUM); // add
        size.remove(Size.MEDIUM);  // remove


        // It will take all enums
        EnumSet<Size> sizes = EnumSet.allOf(Size.class);
        System.out.println("EnumSet Size: " + sizes);

        Iterator<Size> iterate = sizes.iterator();
        System.out.print("EnumSet: ");
        while(iterate.hasNext()) {
            System.out.println(iterate.next());
            System.out.print(", ");
        }

        // Creating an EnumSet using range()
        EnumSet<Size> rangeSize = EnumSet.range(Size.MEDIUM, Size.EXTRALARGE);
        System.out.println("EnumSet Range: " + rangeSize);

        // Using of() with a single parameter
        // Of() Method -> Creates an enum set containing the specified elements
        EnumSet<Size> sizes1 = EnumSet.of(Size.SMALL, Size.LARGE);
        System.out.println("of() Method: " + sizes1);

        //-----------------------------LINKED HASH SET-------------------------------
        // Provide functionalities of both the hashtable and the linked list data structure.
        // Its capacity is 8. It can store 8 elements
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println("LinkedHashSet: " + numbers);
        System.out.println("LinkedHashSet Size: " + numbers.size());
        System.out.println("LinkedHashSet Contain: " + numbers.contains(1));
        System.out.println("LinkedHashSet Remove: " + numbers.remove(1));
        numbers.clear();




    }
}
