package locks;

class MonitorEx {

    synchronized void  task1()  {
        try {
            System.out.println("inside task 1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void task2() {
        System.out.println("Before synchronized: ");
        synchronized (this){
            System.out.println("inside the synch block: ");
        }
    }

    void task3() {
        System.out.println("Without Synchronized ");
    }
}

public class MonitorExample {
    public static void main(String[] args) {
        MonitorEx runnableObj = new MonitorEx();
        Thread thread1 = new Thread(runnableObj::task1);
        Thread thread2 = new Thread(runnableObj::task2);
        Thread thread3 = new Thread(runnableObj::task3);

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
