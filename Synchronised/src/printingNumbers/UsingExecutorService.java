package printingNumbers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutorService {
    public static void main(String[] args) {
        PrintingService printingService = new PrintingService();
/*
* Here Pool of threads Could be Used
* Number of threads are : 2
* thread-1 ==> odd
* thread-2 ==> even
* submitting and shutting down the Pool
* */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            try {
                printingService.printOddNumbers();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(()->{
            try {
                printingService.printEvenNumbers();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
    }
}
