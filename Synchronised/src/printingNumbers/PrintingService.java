package printingNumbers;

public class PrintingService {
//    this is my Printing service where it will have the Logic of dividing the numbers
    private int initialNumber = 1;
    private final int max = 100;

    public synchronized void printOddNumbers() throws InterruptedException {
        while( initialNumber<=max ){
            while (initialNumber % 2 == 0){
                    wait();
            }
            System.out.println(Thread.currentThread().getName()+ " --> "+ initialNumber);
            initialNumber++;
            notifyAll();
        }

    }

    public synchronized void printEvenNumbers() throws InterruptedException {
        while (initialNumber <= max) {
            while (initialNumber % 2 != 0) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " --> " + initialNumber);
            initialNumber++;
            notifyAll();
        }
    }

}
