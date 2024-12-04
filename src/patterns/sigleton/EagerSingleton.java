package patterns.sigleton;

public class EagerSingleton {

    // create an instance of the class.
    private static final EagerSingleton instance = new EagerSingleton();

    // private constructor
    private EagerSingleton() {}

    // get the only instance of the object created.
    public static EagerSingleton getInstance() {
        return instance;
    }
}
