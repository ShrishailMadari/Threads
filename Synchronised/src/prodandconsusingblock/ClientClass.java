package prodandconsusingblock;

public class ClientClass {
    public static void main(String[] args) {
        Prodandconsusingblock bufferService = new Prodandconsusingblock();

        Thread producer = new Thread(() -> {
        for (int i=1; i<=10; i++){
            try {
                bufferService.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        },"producer");

        Thread consumer = new Thread(() -> {
        for (int i=1; i<=10; i++){
            try {
                bufferService.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        },"Consumer");

        producer.start();
        consumer.start();
    }
}
