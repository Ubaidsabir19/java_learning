package patterns.sigleton;

public class ThreadSingleton {

    // instance initialize as null
    private static ThreadSingleton instance = null;

    // private constructor
    private ThreadSingleton() {}

    // Firstly check instance with. sync block if null the created
    public static ThreadSingleton getInstance() {
        synchronized(ThreadSingleton.class) {
            if(instance == null) {
                instance = new ThreadSingleton();
            }
            return instance;
        }
    }

}
