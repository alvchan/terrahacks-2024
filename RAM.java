import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RAM {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory(); // Maximum memory the JVM can use
        long totalMemory = runtime.totalMemory(); // Total memory currently allocated
        long freeMemory = runtime.freeMemory(); // Free memory currently available

        System.out.println("Max Memory: " + maxMemory / (1024 * 1024) + " MB");
        System.out.println("Total Memory: " + totalMemory / (1024 * 1024) + " MB");
        System.out.println("Free Memory: " + freeMemory / (1024 * 1024) + " MB");
    }
}
