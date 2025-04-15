package codingonthreads;
class NumberAndLetter implements Runnable{
    static int count = 1;
    static char letter = 'A';
    final Object lock;
    static boolean isNumberTurn = true; // Control which thread runs

    NumberAndLetter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (count<=26){
            if (Thread.currentThread().getName().equalsIgnoreCase("Number")){
                synchronized (lock){
                    if(!isNumberTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(count+" ");
                    count++;
                    isNumberTurn = false;
                    lock.notify();
                }
            }
            if (Thread.currentThread().getName().equalsIgnoreCase("Letter")){
                synchronized (lock){
                    if (isNumberTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(letter+" ");
                    letter++;
                    isNumberTurn = true;
                    lock.notify();
                }
            }
        }
    }
}
public class PrintNumberAndLetter {
    public static void main(String[] args) {
        Object object = new Object();
        NumberAndLetter runnable1 = new NumberAndLetter(object);
        NumberAndLetter runnable2 = new NumberAndLetter(object);

        Thread numThread = new Thread(runnable1,"number");
        Thread letterThread = new Thread(runnable2,"letter");

        numThread.start();
        letterThread.start();

    }
}
