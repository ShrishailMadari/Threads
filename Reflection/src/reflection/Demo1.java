package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

class Bird{
    public String breed;
    private boolean canSwim;

    public void eat(){
        System.out.println("bird eats");
    }
    public void fly(){
        System.out.println("Bird flies");
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Class birdClass = Bird.class;
        System.out.println(birdClass.getName());
        System.out.println(Arrays.toString(birdClass.getFields()));

        Method[] methods = birdClass.getMethods();
        System.out.print(Arrays.toString(methods)+" ");
    }
}
