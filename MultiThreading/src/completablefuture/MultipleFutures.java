package completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleFutures {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<List<Integer>> future1 = service.submit(() -> {
            System.out.println("Thread is: " + Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3, 4, 5);
        });

        Future<List<Integer>> future2 = service.submit(() -> {
            System.out.println("Thread is: " + Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3, 4, 5);
        });
        Future<List<Integer>> future3 = service.submit(() -> {
            System.out.println("Thread is: " + Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3, 4, 5);
        });
    }
}
