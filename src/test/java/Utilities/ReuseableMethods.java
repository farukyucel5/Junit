package Utilities;

public class ReuseableMethods {
    public static void waiting(long second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
