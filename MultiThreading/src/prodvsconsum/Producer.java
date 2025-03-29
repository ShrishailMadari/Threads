package prodvsconsum;
class Consumer implements Runnable{
    Producer.ShareSrc shareSrc;
    Consumer(Producer.ShareSrc shareSrc){
        this.shareSrc = shareSrc;
    }

    @Override
    public void run() {
        System.out.println("Consumer Thread: "+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shareSrc.consumeItem();
    }
}
public class Producer implements Runnable{
    ShareSrc shareSrc;
    Producer(ShareSrc shareSrc){
        this.shareSrc = shareSrc;
    }
    @Override
    public void run() {
        System.out.println("Producer Thread: "+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shareSrc.addItem();
    }

    static class ShareSrc{
        boolean isItemAvailable = false;
        synchronized void addItem(){
            isItemAvailable = true;
            System.out.println("Item added to the cart: "+Thread.currentThread().getName());
            notifyAll();

        }

        synchronized void consumeItem(){
            System.out.println("consumer thread is consuming by: "+ Thread.currentThread().getName());
            while (!isItemAvailable){
                try {
                    System.out.println("thread : "+Thread.currentThread().getName()+" is waiting");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Item is consumed by :"+Thread.currentThread().getName());
            isItemAvailable = false;

        }

    }
    public static void main(String[] args) {
        ShareSrc shareSrc = new ShareSrc();
        Thread prodThread = new Thread(new Producer(shareSrc));
        Thread consThread = new Thread(new Consumer(shareSrc));

        prodThread.start();
        consThread.start();



    }
}
