package GenericMethods;
class Demo{
    public void m1(){
        System.out.println("Simple Method");
    }
    public <T> void m2(T obj){
        System.out.println("Generic Method: ");
        System.out.println(obj);
    }
}
public class DemoOne {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.m1();
        demo.m2("Om Namo Narayanay: ");
    }
}
