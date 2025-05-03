package threadmethods;
//Hint to the thread scheduler
// Note: yield() doesn’t guarantee another thread will run—it just suggests.
public class YieldMethod {
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                if (i == 2) {
                    Thread.yield();
                }
            }
        };
        Thread thread = new Thread(r, "Thread-1");
        Thread thread2 = new Thread(r, "Thread-2");
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();

    }

}
