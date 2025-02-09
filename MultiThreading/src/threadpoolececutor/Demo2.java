package threadpoolececutor;

import java.util.concurrent.*;

public class Demo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,5,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

    }
}
