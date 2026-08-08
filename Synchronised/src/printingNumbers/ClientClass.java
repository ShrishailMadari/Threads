package printingNumbers;

public class ClientClass {
    public static void main(String[] args) {
//        client will have threads and string the threads and calling the Printing service

        PrintingService printingService = new PrintingService();

        /*thread-1*/
        Thread thread1 = new Thread(()->{
            try {
                printingService.printOddNumbers();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Odd-Thread");
        /*thread-2*/
        Thread thread2 = new Thread(()->{
            try {
                printingService.printEvenNumbers();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Even-Thread");

        thread1.start();
        thread2.start();
    }
}
