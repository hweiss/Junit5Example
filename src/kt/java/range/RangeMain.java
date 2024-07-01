package kt.java.range;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class RangeMain {

    public static void main(String[] args) {
//        for (int i : Range.of(1, 16, 3)) {
//            int quadrat = i*i;
//            System.out.println(quadrat);
//        }

//        Stream<Integer> zahlen = StreamSupport.stream(Range.of(1,16, 3).spliterator(), false);
        long anzahl = Stream.of(1,4,7,10,13)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 != 0;
                    }
                })
                .count();

        System.out.println(anzahl);
    }
}
