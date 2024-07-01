package kt.java.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RangeMain {

    public static void bsp1() {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
        List<String> filteredNames = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("J")) {
                filteredNames.add(name);
            }
        }
        Collections.sort(filteredNames);
        for (String name : filteredNames) {
            System.out.println(name);
        }
    }

    public static void bsp2() {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
        Map<String, List<String>> groupedNames = names.stream()
//                .filter(name -> name.startsWith("J"))
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.groupingBy(name -> name.substring(0, 1)));
        System.out.println(groupedNames);
    }

    public static void main(String[] args) {

        bsp2();

//        Stream<Integer> zahlen = StreamSupport.stream(Range.of(1,16, 3).spliterator(), false);
        List<Integer> zwischenergebnis = Stream.of(1,4,7,10,13,15)
                .filter(zahl -> zahl % 2 != 0)
                .skip(1)
                .limit(2)
                .toList();
        List<Double> zahlen = zwischenergebnis.stream()
                .map(irgendwas -> irgendwas * irgendwas)
                .map(zahl -> 0.5 * zahl)
                .peek(System.out::println)
                .toList()
                ;
        System.out.println(zahlen);
    }
}
