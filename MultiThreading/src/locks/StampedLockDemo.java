package locks;

import java.util.concurrent.locks.StampedLock;

class SharedResource{
    int updatingValue = 10;
    StampedLock stampedLock = new StampedLock();
    void producer(){
        long stamp = stampedLock.tryOptimisticRead(); //stamp will be useful in validating
        try {
            updatingValue = 17; //updating the value
            Thread.sleep(5000);
            if(stampedLock.validate(stamp)){
                System.out.println("it will tell us any write operation has happened or not");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
public class StampedLockDemo {
    public static void main(String[] args) {

    }
}
