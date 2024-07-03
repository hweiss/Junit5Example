package kt.java.patterns;

/**
 * Eine Klasse, von der nur eine einzige Instanz existieren darf,
 * nennen wir Singleton.
 */
public class LazySingleton {

    private static LazySingleton singleton;

    public static LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    private LazySingleton() {
        // Privater Konstruktor, um erzeugung weiterer Instanzen zu verhindern.
    }

}
