class Singleton {

    private static Singleton obj;
    private Singleton() {}

    public static Singleton getInstance() {
        if(obj == null) {
            synchronized (Singleton.class) {
                if(obj == null) {
                    obj = new Singleton();
                }
            }
        }
        return obj;
    }

    public void doSomething() {
        System.out.println("Task run Successfully");
    }
}

public class PatternClass {
    public static void main(String[] args) {

        // Singleton.getInstance().doSomething();

        Runnable task = () -> Singleton.getInstance().doSomething();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}