package GenericClass;
class GenericDemoTwo<T>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
public class DemoTow {
    public static void main(String[] args) {
        GenericDemoTwo<Integer> demoTwo = new GenericDemoTwo<Integer>();
         demoTwo.setValue(200);
        Integer value = demoTwo.getValue();
        System.out.println(value);

    }
}
