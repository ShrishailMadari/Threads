package threadpoolececutor;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectionHandler());

        for (int i = 0; i <= 4; i++) {
            threadPoolExecutor.submit(
                    () -> {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e.getMessage());
                        }
                        System.out.println("task processed by: " + Thread.currentThread().getName());
                    }
            );
        }
        threadPoolExecutor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false); // default
        return thread;
    }
}

class CustomRejectionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        Thread thread = new Thread(() -> {
            System.out.println(r.toString() + " " + Thread.currentThread().getName());
        });
    }
}
