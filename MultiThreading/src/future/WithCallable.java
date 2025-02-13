package future;

import java.util.concurrent.*;

public class WithCallable {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        Future<String> string = executor.submit(() -> {
            System.out.println("do something");
            return "hey sexy";
        });
        System.out.println(string.isDone());
    }
}
