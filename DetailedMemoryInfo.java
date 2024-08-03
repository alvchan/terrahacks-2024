import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class DetailedMemoryInfo {
    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        System.out.println("Heap Memory Usage:");
        System.out.println("Init: " + heapMemoryUsage.getInit() / (1024 * 1024) + " MB");
        System.out.println("Used: " + heapMemoryUsage.getUsed() / (1024 * 1024) + " MB");
        System.out.println("Committed: " + heapMemoryUsage.getCommitted() / (1024 * 1024) + " MB");
        System.out.println("Max: " + heapMemoryUsage.getMax() / (1024 * 1024) + " MB");

        System.out.println("\nNon-Heap Memory Usage:");
        System.out.println("Init: " + nonHeapMemoryUsage.getInit() / (1024 * 1024) + " MB");
        System.out.println("Used: " + nonHeapMemoryUsage.getUsed() / (1024 * 1024) + " MB");
        System.out.println("Committed: " + nonHeapMemoryUsage.getCommitted() / (1024 * 1024) + " MB");
        System.out.println("Max: " + nonHeapMemoryUsage.getMax() / (1024 * 1024) + " MB");
    }
}

