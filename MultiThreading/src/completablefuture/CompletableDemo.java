package completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableDemo {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        CompletableFuture.runAsync(
                ()->{
                    try {
                        Thread.sleep(2000);
                        System.out.println("Rinning the run method: ");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
        );
    }
}
