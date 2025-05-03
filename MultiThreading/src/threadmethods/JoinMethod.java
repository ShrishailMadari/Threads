package threadmethods;
/*
* Join():
* it will wait the other thread to finish the execution
* */
public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+":"+ i);
                try {
                    Thread.sleep(2000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        // This will wait for thread to finish
        System.out.println(Thread.currentThread().getName());
    }

}
