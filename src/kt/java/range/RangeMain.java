package kt.java.range;

import java.util.stream.Stream;

public class RangeMain {

    public static boolean istUngerade(int zahl) {
        System.out.println("istUngerade");
        return zahl % 2 != 0;
    }

    public static void main(String[] args) {

//        Stream<Integer> zahlen = StreamSupport.stream(Range.of(1,16, 3).spliterator(), false);
        Stream.of(1,4,7,10,13)
                .filter(RangeMain::istUngerade)
                .limit(2)
                .forEach(System.out::println)
                ;

    }
}
