package demos;
class GenericDemoFour<X>{
    X value;

    public X getValue() {
        return value;
    }

    public void setValue(X value) {
        this.value = value;
    }
}
public class DemoFour<X> extends GenericDemoFour<X>{
    public static void main(String[] args) {
        DemoFour<String> stringDemoFour = new DemoFour<>();
        stringDemoFour.setValue("Om Achutay Namaha");
        String string = stringDemoFour.getValue();
        System.out.println(string);
    }
}
