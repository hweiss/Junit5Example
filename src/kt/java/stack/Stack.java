package kt.java.stack;

import java.util.List;

/**
 * Ein Stack (LIFO-Queue) mit beliebigem Elementtyp.
 * @param <E> Der Typ der Elemente auf dem Stack.
 */
public class Stack<E> { // new Stack<String>()...

    /**
     * Das oberste Element - null, wenn der Stack leer ist.
     */
    private Element<E> top;     // Element<String>

    /**
     * "Legt" einen Wert oben auf den Stack.
     * @param wert Der neue Wert.
     */
    public void push(E wert) {      // push(String wert)
        top = new Element<>(wert, top);     // new Element<String>()
    }

    /**
     * Nimmt den obersten Wert vom Stack und gibt ihn zurück.
     * @return Der oberste Wert, null bei einem leeren Stack.
     */
    public E pop() {            // public String pop()...
        if (isEmpty()) {
            return null;
        } else {
            Element<E> oldTop = top;        // Element<String>
            top = top.darunter;
            return oldTop.inhalt;
        }
    }

    /**
     * Gibt an, ob der Stack leer ist.
     * @return True, wenn leer; False, wenn mindestens ein Element vorhanden ist.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Gibt den obersten Wert des Stacks zurück, ohne es zu entfernen.
     * @return Den obersten Wert, null bei einem leeren Stack.
     */
    public E peek() {               // public String peek()
        if (isEmpty()) {
            return null;
        } else {
            return top.inhalt;
        }
    }

    public int size() {
        int count = 0;
        Element<E> current = this.top;
        while (current != null) {
            count++;
            current = current.darunter;
        }
        return count;
    }

    public int size_rec() {
        if (isEmpty()) {
            return 0;
        } else {
            return this.top.size();
        }
    }

    public static void main(String[] args) {
//        Stack<String> stack = new Stack<>();
//        for (String s : "Hallo Welt. Hier kommt unser Stack.".split(" ")) {
//            stack.push(s);
//        }

        Stack<Integer> stack = new Stack<>();
        for (Integer i : List.of(1,2,3,4,5)) {
            stack.push(i);
        }

        System.out.println(stack.size());
        System.out.println(stack.size_rec());

//        for (Integer i: stack) {
//            System.out.println(i);
//        }
    }

    /**
     * Ein "Container" für einen Wert auf dem Stack.
     * @param <V> Der Typ des Werts.
     */
    private static class Element<V> {       // new Element<String>() ...

        /**
         * Der Wert.
         */
        private final V inhalt;             // private final String inhalt

        /**
         * Das darunterliegende Stack-Element.
         */
        private final Element<V> darunter;     // [...] Element<String> darunter

        public Element(V inhalt, Element<V> darunter) {   // analog zu oben V -> String
            this.inhalt = inhalt;
            this.darunter = darunter;
        }

        public int size() {
            if (darunter == null) {
                return 1;
            } else {
                return 1 + darunter.size();
            }
        }

    }
}
