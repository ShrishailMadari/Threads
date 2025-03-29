package locks;

import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteLockMechanism {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int data = 0;

    // Read method (multiple threads can access)
    public void read() {
        lock.readLock().lock();  // Acquire read lock
        try {
            System.out.println(Thread.currentThread().getName() + " is READING: " + data);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } finally {
            lock.readLock().unlock();  // Release read lock
        }
    }


    // Write method (only one thread can access)
    public void write(int value) {
        try {
            lock.writeLock().lock();  // Acquire write lock
            System.out.println(Thread.currentThread().getName() + " is WRITING: " + value);
            data = value;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println();
        } finally {
            lock.writeLock().unlock();  // Release write lock
        }
    }
}


    public class ReadWriteLockDemo {
        public static void main(String[] args) {

            ReadWriteLockMechanism demo = new ReadWriteLockMechanism();

            // Multiple readers
            new Thread(demo::read, "Reader-1").start();
            new Thread(demo::read, "Reader-2").start();

            // Writer (only one thread can write)
            new Thread(() -> demo.write(10), "Writer").start();



        }
    }





