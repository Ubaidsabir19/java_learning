package threads_streams;

public class MainThread {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread t1 = new Thread(thread1);
        t1.start();

        Thread2 thread2 = new Thread2();
        Thread t2 = new Thread(thread2);
        t2.start();
    }
}
