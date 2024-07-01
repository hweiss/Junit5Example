package kt.java.functional;

import java.util.stream.Stream;

public class LambdaDemo {

    public static void main(String[] args) {
        int z = 2;
        Stream.iterate(1, i -> i+1)
                .limit(15)
                .forEach(zahl -> {
                    if (zahl % z == 0) {
                        System.err.println(zahl);
                    } else {
                        System.out.println(zahl);
                    }
                });

    }
}
