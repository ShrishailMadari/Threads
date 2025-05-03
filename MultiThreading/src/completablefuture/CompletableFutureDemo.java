package completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static completablefuture.ThreadUtils.delay;

/*
* it cannot be completed manually
* we cannot chain the multiple future
* we cannot combine the multiple future together
* no proper exception handling
*
*/
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        //service.execute(); to just execute no response expected

        Future<List<Integer>> future = service.submit(
                () -> {
                    System.out.println("Thread is :"+Thread.currentThread().getName());
                    ThreadUtils.delay(1);
                    return Arrays.asList(1, 2, 3, 4, 5, 6, 7);
                }
        );
        System.out.println(future.get());
        System.out.println("Main Thread Executed:) ");
    }



    //u cant forcefully complete the future
    // it one of the disadvantage
}
