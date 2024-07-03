package kt.java.patterns;

/**
 * Eine Klasse, von der nur eine einzige Instanz existieren darf,
 * nennen wir Singleton.
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

    private Singleton() {
        // Privater Konstruktor, um erzeugung weiterer Instanzen zu verhindern.
    }

}
