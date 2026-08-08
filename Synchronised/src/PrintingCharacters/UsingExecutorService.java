package PrintingCharacters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutorService {
    public static void main(String[] args) {
        CharPrintingService service = new CharPrintingService();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                service.printingAtoZ();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                service.printingAtoZ();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
    }
}
