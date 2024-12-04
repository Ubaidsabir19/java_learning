package practiceWork;
import java.util.*;

public class IteratorMethods {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Ubaid");
        names.add("Bob");
        names.add("Mike");

        // Iterator Method
        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()){
            String namesValue1 = iterator.next();
            System.out.println(namesValue1);
        }
        System.out.println("-------------------------");

        // ListIterator
        ListIterator<String> ltr = names.listIterator();
        while(ltr.hasNext()){
            String namesValue2 = ltr.next();
            System.out.println(namesValue2);
        }
        ltr.nextIndex();
        ltr.previous();
        ltr.set("UMAR");
        System.out.println(ltr.previous());
        ltr.add("Hadi");
        System.out.println(ltr.previous());
        ltr.remove();

        // Enumeration
        Vector<Integer> numbers = new Vector<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Enumeration<Integer> ev = numbers.elements();
        while(ev.hasMoreElements()){
            int userName2 = ev.nextElement();
            System.out.println(userName2);
        }
    }
}
