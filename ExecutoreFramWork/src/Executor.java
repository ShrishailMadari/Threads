import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Executor{
    public static void main(String[] args) {
        //this is fixed thread pool, where u can just mention the Fixed number of task
        ExecutorService service = Executors.newFixedThreadPool(3);
        /*these are my Task*/
        for (int i=1;i<=5;i++){
            int taskId = i;
            service.execute(()->{
                System.out.println("Task"+" "+ taskId +" Executed "+Thread.currentThread().getName());
            });
        }
        service.shutdown();
    }
}