package threadpoolececutor;

import java.util.concurrent.*;

public class Demo2 {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 5,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new CustomRejectionHandler());
        for (int i=0; i<=10; i++){
            executor.submit(
                    () -> {
                        try {
                            Thread.sleep(4000);
                            System.out.println("task executed by: " + Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e.getMessage());
                        }
                    });
        }
    }
}


