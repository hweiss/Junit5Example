package kt.java.beispiel;

public class StringHelper {
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
