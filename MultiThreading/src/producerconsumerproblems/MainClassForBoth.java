package producerconsumerproblems;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClassForBoth {
    protected static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
    public static void main(String[] args) {


            Thread producerThread = new Thread(() -> {

                try {
                    producer();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Arrays.toString(e.getStackTrace()));
                }
            });



        Thread consumerThread = new Thread(() -> {

            try {
                consumer();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        });
        consumerThread.start();
        producerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }


    private static void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            System.out.println("Producer is trying to produce");
            int randomNumber = random.nextInt(100);
            queue.put(randomNumber);
            System.out.println("✅ Produced: " + randomNumber + " | Queue size: " + queue.size());
            Thread.sleep(10000); // simulate delay
        }
    }




    private static void consumer() throws InterruptedException {
        while (true){
            System.out.println("Consumer is trying to consume");
            Integer item = queue.take();
            System.out.println("🛒 Consumed: " + item + " | Queue size: " + queue.size());
            Thread.sleep(10000);
        }

    }
}