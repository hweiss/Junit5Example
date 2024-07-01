package kt.java.functional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Objektmethoden {

    public static void main(String[] args) {
        // Konstruktoren sind als Methodenreferenz möglich
        Supplier<List<String>> supplier = ArrayList::new;
        List<String> myList = supplier.get();
        myList.add("Hallo");

        Function<Collection<String>, List<String>> listCopy = ArrayList::new;

        // Instanzen können wie parameter behandelt werden.
        Function<List<?>, String> toString = Object::toString;
//        Function<Stack<?>, String> toString2 = stck -> stck.toString();
        String s = toString.apply(myList);       // myList.toString()
    }
}
