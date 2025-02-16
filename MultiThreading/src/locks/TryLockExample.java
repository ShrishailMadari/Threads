package locks;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

class TryLockMechanism{
    private final ReentrantLock lock = new ReentrantLock();

    public void accessResource() {
        if (lock.tryLock()) { // Non-blocking attempt
            try {
                System.out.println(Thread.currentThread().getName() + " got the lock.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " released the lock.");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " couldn't get the lock.");
        }
    }

}
public class TryLockExample {
    public static void main(String[] args) {

        TryLockMechanism example = new TryLockMechanism();

        Thread t1 = new Thread(example::accessResource, "Thread-1");
        Thread t2 = new Thread(example::accessResource, "Thread-2");
        Thread t3 = new Thread(example::accessResource, "Thread-2");

        t1.start();
        t2.start();
        t3.start();

    }
}
