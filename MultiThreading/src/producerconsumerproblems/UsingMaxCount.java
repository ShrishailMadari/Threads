package producerconsumerproblems;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UsingMaxCount {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
    private static final int MAX_ITEMS = 10;
    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> {
            for (int i= 0; i < MAX_ITEMS; i++) {
                try {
                    if (queue.remainingCapacity() == 0) { // Check if the queue is full
                        System.out.println("Queue is full, waiting for consumer to consume...");
                    }
                    queue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(6000); // Simulate time taken to produce an item
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
//            int i=0;
//            while (true){
//                try {
//                    if(queue.remainingCapacity() == 0){
//                        System.out.println("Queue is full, waiting for consumer to consume...");
//                    }
//                    queue.put(i);
//                    System.out.println("Produced: " + i);
//                    i++;
//                    Thread.sleep(6000); // Simulate time taken to produce an item
//                } catch (InterruptedException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i= 0; i < MAX_ITEMS; i++) {
                try {
                    if (queue.isEmpty()) { // Check if the queue is empty
                        System.out.println("Queue is empty, waiting for producer to produce...");
                    }
                    System.out.println("Consumed: " + queue.take());
                    Thread.sleep(6000); // Simulate time taken to consume an item
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
//            while (true){
//                try {
//                    if (
//                            queue.isEmpty() // Check if the queue is empty
//                    ){
//                        System.out.println("Queue is empty, waiting for producer to produce...");
//                    }
//                    queue.take();
//                    System.out.println("Consumed: " + queue.take());
//                    Thread.sleep(6000); // Simulate time taken to consume an item
//                } catch (InterruptedException e) {
//                    System.out.println(e.getMessage());
//                }
//            }

        });

        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
