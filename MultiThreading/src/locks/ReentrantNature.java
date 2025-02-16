package locks;

public class ReentrantNature {
    public static void main(String[] args) {
        SharedResourceForReentrant resource = new SharedResourceForReentrant();

        Runnable runnable = resource::resource;

        Thread thread1 = new Thread(runnable,"thread-1");
        Thread thread2 = new Thread(runnable,"thread-2");
        thread1.start();
        System.out.println("********************888");
        thread2.start();
    }
}
