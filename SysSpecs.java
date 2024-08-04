import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SysSpecs {
    private static final double POWER_CONSUMPTION_PER_GB = 5.0; // Assumed power consumption per GB of RAM

    public static void main(String[] args) {
        try {
            // Get total memory capacity from 'wmic'
            long totalMemoryCapacityGB = getTotalMemoryCapacity();
            
            // Get total memory usage from 'tasklist'
            Tracker tracker = new Tracker();
            tracker.go();
            long totalMemoryUsageKB = tracker.getTotalMemoryUsageAllProcesses();
            
            // Estimate power consumption
            double estimatedPowerConsumptionWatt = calculatePowerConsumption(totalMemoryCapacityGB);

            // Print results
            System.out.println("Total memory capacity: " + totalMemoryCapacityGB + " GB");
            System.out.println("Total memory usage of all processes: " + totalMemoryUsageKB + " KB");
            System.out.println("Estimated power consumption: " + estimatedPowerConsumptionWatt + " Watts");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long getTotalMemoryCapacity() throws Exception {
        long totalCapacityGB = 0;
        Process process = Runtime.getRuntime().exec("wmic memorychip get /format:list");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Capacity=")) {
                long capacityBytes = Long.parseLong(line.substring("Capacity=".length()).trim());
                totalCapacityGB += capacityBytes / (1024L * 1024 * 1024);
            }
        }
        reader.close();
        return totalCapacityGB;
    }

    private static double calculatePowerConsumption(long totalMemoryCapacityGB) {
        return totalMemoryCapacityGB * POWER_CONSUMPTION_PER_GB;
    }
}