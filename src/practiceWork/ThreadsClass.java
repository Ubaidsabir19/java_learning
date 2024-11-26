package practiceWork;

// Threads allows a program to operate more efficiently by doing multiple things at the same time.
public class ThreadsClass extends Thread {
    public static void main(String[] args) {
        ThreadsClass thread = new ThreadsClass();
        thread.start();
        System.out.println("This code is outside of the thread");

        ThreadsClass2 tc = new ThreadsClass2();
        Thread thread2 = new Thread(tc);
        thread2.start();
        System.out.println("This code is outside of the thread");
    }
    public void run() {
        System.out.println("This code is running in a thread");
    }

    public static class ThreadsClass2 implements Runnable {
        @Override
        public void run() {
            System.out.println("ThreadClass2 Running");
        }
    }
}
