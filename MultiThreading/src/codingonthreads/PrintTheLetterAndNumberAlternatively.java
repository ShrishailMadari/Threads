package codingonthreads;

public class PrintTheLetterAndNumberAlternatively {
    private static final Object lock = new Object();
    private static boolean isLetter = true;

    public static void main(String[] args) throws InterruptedException {
        Runnable letters = () -> {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                synchronized (lock) {
                    if (!isLetter) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(ch + " ");
                    isLetter = false;
                    lock.notify();
                }
            }
        };

        Runnable numbers = () -> {
            for (int num = 1; num <= 26; num++) {
                synchronized (lock){
                    if (isLetter){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(num + " ");
                    isLetter = true;
                    lock.notify();
                }
            }
        };
        Thread thread1 = new Thread(letters);
        Thread thread2 = new Thread(numbers);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}
