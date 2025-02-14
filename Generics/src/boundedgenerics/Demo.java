import java.util.HashSet;
import java.util.Set;

public class Demo{
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("John", 25));
        set.add(new Person("Jane", 30));
        set.add(new Person("John", 25));
        System.out.println(set.size());
    }
}


class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}