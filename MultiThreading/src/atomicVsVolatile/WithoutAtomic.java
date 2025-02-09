package atomicVsVolatile;
class SharedResource{
    int counter;
    public void setCounter(){
        counter++; // three operations : read, update, assign
//        this not atomic:
//        System.out.println("increment counter: ");
    }
    public int getCounter(){
        return counter;
    }

}
public class WithoutAtomic {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        for (int i=0; i<400; i++){
            sharedResource.setCounter();
        }
        System.out.println(sharedResource.getCounter());
    }
}
