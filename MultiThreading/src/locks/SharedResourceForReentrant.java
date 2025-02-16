package locks;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceForReentrant {
    private final ReentrantLock reentrantLock = new ReentrantLock();
    public void resource(){
        reentrantLock.lock();
        try {
            System.out.println("First method Lock is acquired");
            Thread.sleep(3000);
            secondMethod(); // Re-entering the lock
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }finally {
            reentrantLock.unlock();
            System.out.println("Lock is released");
        }
    }

    private void secondMethod() {
        reentrantLock.lock();
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" acquired lock in secondMethod");
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        finally {
            reentrantLock.unlock();
            System.out.println("lock released");
        }
    }
}
