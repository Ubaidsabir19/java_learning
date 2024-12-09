package threadsAndstreams;

public class Thread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("i: " + i);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
