package prodandconsusingblock;

public class Prodandconsusingblock {
    private int item;
    private boolean isAvailable = false;

    public void produce(int item) throws InterruptedException {
        synchronized (this){
            while (isAvailable){
                wait();
            }
            this.item = item;
            isAvailable = true;
            System.out.println(Thread.currentThread().getName()+ " " + item);
        notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this){
            while (!isAvailable){
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " " + item);
            isAvailable = false;
        notifyAll();
        }
    }
}
