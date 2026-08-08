package PrintingCharacters;

public class CharPrintingService {
    private char initialChar = 'A';
    private final char finalChar = 'Z';

    public synchronized void printingAtoZ() throws InterruptedException {
        while (initialChar <= finalChar){
            System.out.println(Thread.currentThread().getName()+ "->" + initialChar);
            initialChar++;
            notifyAll();

            if (initialChar > finalChar){
                break;
            }
            wait();
        }
    }

}
