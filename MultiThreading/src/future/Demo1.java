package future;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        Future<?> submitted = executor.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

                e.getStackTrace();
            }
            System.out.println("executing task: ");
        });
        System.out.println("future job is done: "+submitted.isDone());
        try {
            submitted.get(10,TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            submitted.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("is Done: "+submitted.isDone());
        System.out.println("task is cancelled: "+submitted.isCancelled());
    }
}
