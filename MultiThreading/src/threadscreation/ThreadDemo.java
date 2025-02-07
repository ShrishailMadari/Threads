package threadscreation;

public class ThreadDemo extends Thread{

    @Override
    public void run() {
        System.out.println("thread execution started using extend key word: "+Thread.currentThread().getName());
        try {
            Thread.sleep(7000);
            System.out.println("Thread After sleeping: "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Thread creation "+Thread.currentThread().getName());

        ThreadDemo threadDemo = new ThreadDemo();

        threadDemo.start();
    }
}
