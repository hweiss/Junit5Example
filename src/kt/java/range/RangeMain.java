package kt.java.range;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class RangeMain {

    public static class UngeradeFilter implements Predicate<Integer> {

        @Override
        public boolean test(Integer integer) {
            return integer % 2 != 0;
        }
    }

    public static void main(String[] args) {
//        for (int i : Range.of(1, 16, 3)) {
//            int quadrat = i*i;
//            System.out.println(quadrat);
//        }

//        Stream<Integer> zahlen = StreamSupport.stream(Range.of(1,16, 3).spliterator(), false);
        long anzahl = Stream.of(1,4,7,10,13)
                .filter(new UngeradeFilter())
                .count();

        System.out.println(anzahl);
    }
}
