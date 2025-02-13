package GenericClass;

class GenericDemoFive<K,V>{
    K key;
    V value;

    public void put(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
public class DemoFive<K,V> extends GenericDemoFive<K,V>{
    public static void main(String[] args) {
        DemoFive<String,Integer> demoFive = new DemoFive<>();
        demoFive.put("Om Namo Narasimhaya",500);
        String demoFiveKey = demoFive.getKey();
        System.out.println(demoFiveKey);
        Integer demoFiveValue = demoFive.getValue();
        System.out.println(demoFiveValue);
    }
}
