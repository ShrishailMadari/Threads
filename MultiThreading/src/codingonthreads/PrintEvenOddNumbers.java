package codingonthreads;


public class PrintEvenOddNumbers {
    private static final Object lock = new Object();
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Runnable oddRunnable = () -> {
            for (int odd = 1; odd <= 50; odd=odd+2) {
                synchronized (lock) {
                    if (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(odd + " ");
                    flag = false;
                    lock.notify();
                }
            }
        };

        Runnable evenRunnable = () -> {
            for (int even = 2; even <= 50; even = even + 2) {
                synchronized (lock) {
                    if (flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(even + " ");
                    flag = true;
                    lock.notify();
                }

            }
        };

        Thread oddThread = new Thread(oddRunnable);
        Thread eveThread = new Thread(evenRunnable);

        oddThread.start();
        eveThread.start();

        oddThread.join();
        eveThread.join();

    }
}
