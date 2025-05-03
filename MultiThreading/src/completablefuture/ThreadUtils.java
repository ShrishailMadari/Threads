package completablefuture;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {
    public static void delay(int time) throws InterruptedException {
        TimeUnit.MINUTES.sleep(time);
    }
}
