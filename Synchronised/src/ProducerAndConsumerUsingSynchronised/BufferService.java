package ProducerAndConsumerUsingSynchronised;

public class BufferService {
    private int item;
    private boolean isAvailable = false;

    public synchronized void produce(int item) throws InterruptedException {
        while (isAvailable){
            wait();
        }

        this.item = item;
        isAvailable = true;
        System.out.println(Thread.currentThread().getName()+ " " +item);
        notifyAll();
    }

    public synchronized void consume(int item) throws InterruptedException {
        while (!isAvailable){
            wait();
        }
        System.out.println(Thread.currentThread().getName()+ " " + item);
        isAvailable = false;
        notifyAll();
    }
}
