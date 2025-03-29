package semaphore;

import java.util.concurrent.Semaphore;

public class Demo {
    private static final Semaphore semaphore = new Semaphore(5); // 5 permits
    public void sharedResource(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" acquired access");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName()+" released access");
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo::sharedResource).start();
        }

    }
}
