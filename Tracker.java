import java.io.BufferedReader;         // Import BufferedReader to read text from an input stream
import java.io.InputStreamReader;     // Import InputStreamReader to convert byte stream to character stream
import java.util.*;                  // Import utility classes like HashMap, LinkedList, etc.
class Tracker {
    private HashMap<String, Long> retur = new HashMap<>();
    private long totalMemoryUsageAllProcesses = 0;
    private long totalMemoryUsageTop5Processes = 0;

    public void go() {
        try {
            Process p = Runtime.getRuntime().exec("tasklist");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            HashMap<String, Long> hashMap = new HashMap<>();

            for (int i = 0; i < 3; i++) {
                input.readLine();
            }

            String line;
            while ((line = input.readLine()) != null) {
                if (line.length() < 28) continue;
                String processName = line.substring(0, 27).trim();
                String restOfLine = line.substring(27).trim();
                String[] splitParts = restOfLine.split("\\s+");

                if (splitParts.length > 4) {
                    String memory = splitParts[3];
                    long memoryValue = parseMemoryValue(memory);
                    hashMap.merge(processName, memoryValue, Long::sum);
                    totalMemoryUsageAllProcesses += memoryValue;
                }
            }

            List<Map.Entry<String, Long>> entryList = new ArrayList<>(hashMap.entrySet());
            entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            totalMemoryUsageTop5Processes = 0;
            for (Map.Entry<String, Long> entry : entryList.stream().limit(5).toList()) {
                retur.put(entry.getKey(), entry.getValue());
                totalMemoryUsageTop5Processes += entry.getValue();
            }

            System.out.println("Top 5 processes by memory usage:");
            entryList.stream().limit(5).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " KB"));
            System.out.println("Total memory usage of all processes: " + totalMemoryUsageAllProcesses + " KB");
            System.out.println("Total memory usage of top 5 processes: " + totalMemoryUsageTop5Processes + " KB");

            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public long getTotalMemoryUsageAllProcesses() {
        return totalMemoryUsageAllProcesses;
    }

    public static long parseMemoryValue(String memory) {
        return Long.parseLong(memory.replace(",", ""));
    }
}