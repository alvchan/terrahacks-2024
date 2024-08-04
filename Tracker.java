import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Tracker {
	HashMap<String, Long> retur = new HashMap<>();
    public void go() {
       
        try {
            Process p = Runtime.getRuntime().exec("tasklist");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            LinkedList<String[]> list = new LinkedList<>();
            HashMap<String, Long> hashMap = new HashMap<>();

            // Skip header lines
            for (int i = 0; i < 3; i++) {
                input.readLine();
            }

            String line;
            while ((line = input.readLine()) != null) {
                if (line.length() < 28) continue;  // Ensure line has sufficient length

                String processName = line.substring(0, 27).trim(); // Extract process name
                String restOfLine = line.substring(27).trim();     // Extract the rest of the line

                String[] parts = new String[] { processName };
                String[] splitParts = restOfLine.split("\\s+");
                String[] mergedArray = new String[parts.length + splitParts.length];

                System.arraycopy(parts, 0, mergedArray, 0, parts.length);
                System.arraycopy(splitParts, 0, mergedArray, parts.length, splitParts.length);

                // Add to list
                list.add(mergedArray);
            

                // Process and store values in the hashMap
                if (splitParts.length > 4) {
                    String memory = splitParts[3];
                    long memoryValue = parseMemoryValue(memory);

                    // Update HashMap with cumulative memory usage
                    hashMap.merge(processName, memoryValue, Long::sum);
                }
            }

            // Sort entries by value in descending order
            List<Map.Entry<String, Long>> entryList = new ArrayList<>(hashMap.entrySet());
            entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            // Print the top 5 entries and add them to the 'retur' HashMap
            System.out.println("Top 5 processes by memory usage:");
            entryList.stream().limit(5).forEach(entry -> {
                retur.put(entry.getKey(), entry.getValue());
            });

            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
         // Ensure a HashMap is always returned
    }

    // Method to convert memory string to long value
    public static long parseMemoryValue(String memory) {
        return Long.parseLong(memory.replace(",", ""));
    }
	public HashMap<String ,Long> value()
	{
		go();
		return retur;
	}
}
