package atomicVsVolatile;


import java.util.concurrent.atomic.AtomicInteger;

public class WithAtomic {
    public static void main(String[] args) {
        AtomicInteger resource = new AtomicInteger();
        Thread t1 = new Thread(()->{
            for (int i=0; i<200; i++){
                resource.incrementAndGet();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i=0; i<200; i++){
                resource.incrementAndGet();
            }
        });

        t1.start();
        t2.start();
    }
}
