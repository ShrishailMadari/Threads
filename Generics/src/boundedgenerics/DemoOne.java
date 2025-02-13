package boundedgenerics;
class A<T extends Number>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
public class DemoOne {
    public static void main(String[] args) {
        A<Double> doubleA = new A<>();
        doubleA.setValue(500.98);
        Double value = doubleA.getValue();
        System.out.println(value);
    }
}
