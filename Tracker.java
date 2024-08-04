import java.io.BufferedReader;         // Import BufferedReader to read text from an input stream
import java.io.InputStreamReader;     // Import InputStreamReader to convert byte stream to character stream
import java.util.*;                  // Import utility classes like HashMap, LinkedList, etc.

public class Tracker {
    // HashMap to store process names and their corresponding memory usage
    HashMap<String, Long> retur = new HashMap<>();
    
    // Variables to store total memory usage of all processes and top processes
    private long totalMemoryUsageAllProcesses = 0;
    private long totalMemoryUsageTop5Processes = 0;

    // Method to execute the task and process the data
    public void go() {
    
        try {
            // Execute the "tasklist" command to get the list of running processes
            Process p = Runtime.getRuntime().exec("tasklist");
    
            // Create a BufferedReader to read the output of the process command
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
    
            // Create a HashMap to store process names and their cumulative memory usage
            HashMap<String, Long> hashMap = new HashMap<>();
    
            // Skip the first 3 lines of the output which are headers
            for (int i = 0; i < 3; i++) {
                input.readLine();
            }
    
            String line;
            // Read each line of the process list
            while ((line = input.readLine()) != null) {
                // Skip lines that are too short (less than 28 characters)
                if (line.length() < 28) continue;
    
                // Extract the process name from the line (first 27 characters)
                String processName = line.substring(0, 27).trim();
    
                // Extract the remaining part of the line after the process name
                String restOfLine = line.substring(27).trim();
    
                // Split the remaining line into parts based on whitespace
                String[] splitParts = restOfLine.split("\\s+");
    
                // Process and store values in the hashMap
                if (splitParts.length > 4) {
                    // Extract memory usage information (4th element in split parts)
                    String memory = splitParts[3];
                    
                    // Convert memory string to long value
                    long memoryValue = parseMemoryValue(memory);
    
                    // Update HashMap with cumulative memory usage for the process
                    hashMap.merge(processName, memoryValue, Long::sum);
                    
                    // Accumulate total memory usage for all processes
                    totalMemoryUsageAllProcesses += memoryValue;
                }
            }
    
            // Convert HashMap entries to a list and sort by memory usage in descending order
            List<Map.Entry<String, Long>> entryList = new ArrayList<>(hashMap.entrySet());
            entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
    
            // Calculate total memory usage for top 5 processes and add them to the 'retur' HashMap
            totalMemoryUsageTop5Processes = 0;  // Reset total memory usage for top 5
            for (Map.Entry<String, Long> entry : entryList.stream().limit(5).toList()) {
                retur.put(entry.getKey(), entry.getValue());
                totalMemoryUsageTop5Processes += entry.getValue();  // Accumulate memory usage for top 5
            }
    
            // Print out the 'retur' HashMap in descending order
            System.out.println("Top 5 processes by memory usage:");
            entryList.stream().limit(5).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " KB"));
            
            // Print total memory usage of all processes
            System.out.println("Total memory usage of all processes: " + totalMemoryUsageAllProcesses + " KB");
            
            // Print total memory usage of top 5 processes
            System.out.println("Total memory usage of top 5 processes: " + totalMemoryUsageTop5Processes + " KB");
    
            // Close the BufferedReader
            input.close();
        } catch (Exception err) {
            // Print stack trace if any exception occurs
            err.printStackTrace();
        }
    }

    // Method to convert memory string to long value
    public static long parseMemoryValue(String memory) {
        // Remove commas and parse the string to a long
        return Long.parseLong(memory.replace(",", ""));
    }

    // Method to get the 'retur' HashMap
    public HashMap<String ,Long> value() {
        go();  // Call the 'go' method to populate the HashMap
        return retur;  // Return the 'retur' HashMap
    }
}
