public class Bank {
    public synchronized void deposit(String threadName){
        System.out.println(threadName + " acquired Lock");
        try {
            System.out.println("This is critical item");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName + " exited Lock ");

    }
}
