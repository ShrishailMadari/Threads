package synchronised;

import java.util.Arrays;

class SharedResource{
    public void normalMethod() {
        System.out.println(Thread.currentThread().getName() + " - Entering normalMethod");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        System.out.println(Thread.currentThread().getName() + " - Exiting normalMethod");
    }

    public synchronized void synchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " - Entering synchronizedMethod");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        System.out.println(Thread.currentThread().getName() + " - Exiting synchronizedMethod");
    }

    public void synchronizedBlock() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " - Entering synchronizedBlock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
            System.out.println(Thread.currentThread().getName() + " - Exiting synchronizedBlock");
        }
    }
}


public class NormalClass {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(resource::normalMethod, "Thread-1");
        Thread t2 = new Thread(resource::synchronizedMethod, "Thread-2");
        Thread t3 = new Thread(resource::synchronizedBlock, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
