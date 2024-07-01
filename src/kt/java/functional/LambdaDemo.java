package kt.java.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LambdaDemo {

    public static void main(String[] args) {
        // "effektiv finale" Variablen aus der Umgebung können
        // in Lambda verwendet werden
        final int z = 3;
        List<Integer> zahlen = new ArrayList<>();
        Stream.iterate(1, i -> i+1)
                .limit(15)
                .forEach(zahl -> {
                    if (zahl % z == 0) {
                        zahlen.add(z);
                        System.err.println(zahl);
                    } else {
                        System.out.println(zahl);
                    }
                });

    }
}
