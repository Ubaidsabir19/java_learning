package threadsAndstreams;

public class Thread2 extends Thread {
    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            try {
                Thread.sleep(1000);
                System.out.println("j: " + j);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
