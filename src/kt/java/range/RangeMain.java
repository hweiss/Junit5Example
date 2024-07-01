package kt.java.range;

import java.util.stream.Stream;

public class RangeMain {

    public static void main(String[] args) {

//        Stream<Integer> zahlen = StreamSupport.stream(Range.of(1,16, 3).spliterator(), false);
        Stream.of(1,4,7,10,13,15)
                .filter(zahl -> zahl % 2 != 0)
                .skip(1)
                .limit(2)
                .map(zahl -> zahl * zahl)
                .map(zahl -> 0.5 * zahl)
                .forEach(System.out::println)
                ;

    }
}
