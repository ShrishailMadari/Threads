package producerconsumerproblems;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UsingCounter {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            while (true) {
                int i = 0;
                try {
                    if (queue.remainingCapacity() == 0) {
                        System.out.println("Queue is full, waiting for consumer to consume");
                    }
                    queue.put(i);
                    i++;
                    System.out.println("Produced: " + i);
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    if (queue.isEmpty()) {
                        System.out.println("Queue is full, waiting for consumer to consume");
                    }
                    System.out.println("Produced: " + queue.take());
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

                }


            }
        });

        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
