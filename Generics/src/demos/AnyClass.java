package demos;
class GenericsDemo{
    Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
public class AnyClass {
    public static void main(String[] args) {
        GenericsDemo demo = new GenericsDemo();
        demo.setValue(100);
        int value = (int) demo.getValue();
        System.out.println(value);
    }
}

