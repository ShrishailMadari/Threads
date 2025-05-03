package boundedgenerics;

class Vehicle<T>{
    void start(){
        System.out.println("vehicle will Start: ");
    }
}
interface Car<T>{

}
interface Bus<T>{

}
class MultiBound<T extends Vehicle<T> & Car<T> & Bus<T>>{

}
public class DemoTwo {
    public static void main(String[] args) {

    }
}
