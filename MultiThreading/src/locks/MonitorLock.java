package locks;
class Monitor implements Runnable{

    @Override
    public void run() {
        System.out.println("This is under monitor lock:  ");
    }
}
public class MonitorLock {
    public static void main(String[] args) {
        Monitor runnableObj = new Monitor();
        Thread thread = new Thread(runnableObj);
        thread.start();
    }
}
