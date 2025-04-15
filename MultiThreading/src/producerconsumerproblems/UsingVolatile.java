package producerconsumerproblems;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UsingVolatile {
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
    private static volatile boolean isRunning = true;
    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(() -> {
            Random random = new Random();
            while (isRunning){
                try {
                    int value = random.nextInt(100);
                    queue.put(value);
                    System.out.println("Produced: " + value);
                    Thread.sleep(5000); // Simulate time taken to produce
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Producer interrupted");
                }
            }
            System.out.println("Producer stopped");
        });

        Thread Consumer = new Thread(() -> {
            while (isRunning){
                try {
                    Integer take = queue.take();
                    System.out.println("Consumed: " + take);
                    Thread.sleep(5000); // Simulate time taken to consume
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Consumer interrupted");
                }
            }
            System.out.println("Consumer stopped");

        });
        producer.start();
        Consumer.start();

        Thread.sleep(10000); // Let them run for a while
        isRunning = false; // Stop the threads
        producer.join();
        Consumer.join(); // Wait for them to finish
        System.out.println("Main thread finished");

    }
}
