package GenericClass;
class GenericsDemoThree<B>{
    B value;

    public B getValue() {
        return value;
    }

    public void setValue(B value) {
        this.value = value;
    }
}
public class DemoThree extends GenericsDemoThree<String>{
    public static void main(String[] args) {
        DemoThree demoThree = new DemoThree();
        demoThree.setValue("Om Namo Narayana: ❤️❤️❤️❤️❤️");
        String string = demoThree.getValue();
        System.out.println(string);

    }
}
