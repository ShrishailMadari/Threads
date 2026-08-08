package reflection;

import java.util.SimpleTimeZone;

class Eagle{
    Eagle(){

    }
    public void fly(int number, boolean bool, String name){
        System.out.println(number+" "+bool+" "+name);
    }
}
public class Demo2 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class eagleClass = Class.forName("reflection.Eagle");
        Object object = eagleClass.newInstance();
//        eagleClass.getMethod("jh",true,);
    }
}
