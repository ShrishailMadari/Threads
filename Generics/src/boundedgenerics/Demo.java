package boundedgenerics;

import java.util.HashSet;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}