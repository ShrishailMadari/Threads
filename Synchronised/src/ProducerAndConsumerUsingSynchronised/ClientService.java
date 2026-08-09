package ProducerAndConsumerUsingSynchronised;

public class ClientService {
    public static void main(String[] args) {
        BufferService bufferService = new BufferService();

        Thread producer = new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    bufferService.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Produce");

        Thread consumer = new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    bufferService.consume(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Consumer");

        producer.start();
        consumer.start();
    }
}
