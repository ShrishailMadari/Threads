package PrintingCharacters;

public class ClientClass {
    public static void main(String[] args) {
        CharPrintingService service = new CharPrintingService();
        /*thread-1*/
        Thread thread1 = new Thread(()->{
            try {
                service.printingAtoZ();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        /*thread-2*/
        Thread thread2 = new Thread(()->{
            try {
                service.printingAtoZ();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
    }
}
