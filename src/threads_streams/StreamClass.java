package threads_streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamClass {
    public static void main(String[] args) {
        List<String> arrayList = Arrays.asList("Apple", "Banana", "Cherry");
        Stream<String> stream = arrayList.stream();
        stream.filter(n -> n.startsWith("A")).forEach(System.out::println);


        String[] arr = {"Apple", "Banana", "Cherry"};
        Stream<String> stream1 = Arrays.stream(arr);
        System.out.println("Count: " + stream1.count());

        Stream<Integer> iS = Stream.of(1, 2, 3);
        System.out.println("Stream: " + iS);

        Stream<Integer> limit1 = Stream.iterate(0, n -> n + 1).limit(100);
        System.out.println("Used for loop: " + limit1.distinct());

        Stream<Double> limit = Stream.generate(Math::random).limit(5);
        System.out.println("Generate Method: "+ limit);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream2 = list.stream();
        stream2.filter(n -> n % 2 == 0).map(n -> n * 2).forEach(System.out::println);

    }
}
