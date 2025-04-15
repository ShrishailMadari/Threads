package codingonthreads;

class EvenOdd implements Runnable {
    private static int count = 1;
    private final Object lock;

    public EvenOdd(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (count <= 10) {
            if (count % 2 == 0 && Thread.currentThread().getName().equalsIgnoreCase("even")) {
                synchronized (lock) {
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " value: " + count);
                    count++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (count % 2 != 0 && Thread.currentThread().getName().equalsIgnoreCase("Odd")) {
                synchronized (lock) {
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " value: " + count);
                    count++;
                    lock.notify();
                }
            }
        }

    }

}

public class EvenOddUsingWhile {
    public static void main(String[] args) {
        Object object = new Object();
    EvenOdd runnable1 = new EvenOdd(object);
    EvenOdd runnable2 = new EvenOdd(object);
    Thread t1 = new Thread(runnable1,"Odd");
    Thread t2 = new Thread(runnable2,"Even");
    t1.start();
    t2.start();
    }
}
