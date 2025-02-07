package lockfreemechanism;
class SharedResource{
    private boolean flag = false;

    public void setFlag() {
      flag = true;
    }

    public void printFlag(){
        while (!flag){
            System.out.println("do nothing");
        }
    }
}

public class VolatileKey {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedResource.setFlag();
        });

        Thread thread1 = new Thread(sharedResource::printFlag);

        thread.start();
        thread1.start();
    }
}
