package concurrenthashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapDemo {

    private static final int noOfThreads = 10;
    private static final int noOfOInsertions = 1000;
    private static final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>( );


    public static class Main {

        public static void main(String[] args) throws InterruptedException {
            System.out.println("Concurrent hash map:");
            ExecutorService executorService = Executors.newFixedThreadPool(noOfThreads);
            for (int i = 1; i <= noOfThreads; i++) {
                Runnable runnable = () -> {
                    for (int j = 0; j < noOfOInsertions; j++) {
                        map.put(j + Thread.currentThread().getName(), j);
                    }
                };
                executorService.execute(runnable);
            }
            executorService.shutdown();
            if (!executorService.isTerminated()) {
                Thread.sleep(1000);
            }
            System.out.println("size of the map: " + map.size());

        }
    }
}
