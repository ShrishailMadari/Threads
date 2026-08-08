//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      Thread thread1 = new Thread(()->{

      });

        Thread thread2 = new Thread(()->{

        });
        thread1.start();
        thread2.start();
    }
}