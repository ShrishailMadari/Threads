package wildcards;

import java.util.Arrays;
import java.util.List;

class WildCards<T>{
    public void listOfAnimals(List<T> list){
        for (T object:list){
            System.out.println(object);
        }
    }

}
public class Demo1 {
    public static void main(String[] args) {
        WildCards<Integer> wildCards = new WildCards<>();
        List<String> list = Arrays.asList("cat","dog","horse","Mouse");
        System.out.println(list);
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7);
        wildCards.listOfAnimals(integerList);
    }
}
