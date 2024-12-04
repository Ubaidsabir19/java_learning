package patterns.sigleton;

public class LazySingleton {

    // instance firstly initialize as null
    private static LazySingleton instance = null;

    // private constructor
    private LazySingleton() {}

    // check if the instance is null, and if so, create the object.
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
