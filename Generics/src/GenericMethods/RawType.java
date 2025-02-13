package GenericMethods;
class RawTypeDemo<T>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
public class RawType {
    public static void main(String[] args) {
        RawTypeDemo<String> stringRawTypeDemo = new RawTypeDemo<>();
        stringRawTypeDemo.setValue("Damodharay Namah:) ");
        String string = stringRawTypeDemo.getValue();
        System.out.println(string);

        RawTypeDemo rawTypeDemo = new RawTypeDemo();
        System.out.println("this is raw type: ");
        rawTypeDemo.setValue("Om Vamanay namah");
        Object value = rawTypeDemo.getValue();
        System.out.println(value);
    }
}
