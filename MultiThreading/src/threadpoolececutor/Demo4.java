package threadpoolececutor;

import java.util.concurrent.*;

public class Demo4 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,5,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        Future<?> submitted = executor.submit(
                () -> {
                    System.out.println("this is the task when thread will execute:");
                }
        );
        System.out.println(submitted.isDone());
    }

}
