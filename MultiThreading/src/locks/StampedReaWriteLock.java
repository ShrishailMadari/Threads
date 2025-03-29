package locks;

import java.util.concurrent.locks.StampedLock;

class SharedResourceForStampedLock{
    int a=10;
    StampedLock stampedLock = new StampedLock();
    public void producer(){
        long stamp = stampedLock.tryOptimisticRead(); //its storing the lock stamp
        System.out.println("taken optimistic lock:");
        a=120;
        try {
            Thread.sleep(2000);
            if (stampedLock.validate(stamp)){
                System.out.println("updated successfully");
            }else {
                System.out.println("roll Back Work");
                a=10;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
public class StampedReaWriteLock {
    public static void main(String[] args) {
        SharedResourceForStampedLock stampedLock = new SharedResourceForStampedLock();
        Runnable runnable = stampedLock::producer;
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

    }
}
