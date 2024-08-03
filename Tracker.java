import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Tracker {
    public void go() {
        try {
            String line;
            Process p = Runtime.getRuntime().exec("tasklist");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            LinkedList<String[]> list = new LinkedList<>();
			 HashMap<String,Integer> hashMap = new HashMap<>();
            // Skip header lines
            input.readLine();
            input.readLine();
            input.readLine();

            while ((line = input.readLine()) != null) {
                // Ensure line has sufficient length
                if (line.length() > 30) {
                    String A = line.substring(0, 27).trim();
                    String B = line.substring(27).trim();

                    String[] parts = new String[] { A };
                    String[] splitParts = B.split("\\s+");
                    String[] mergedArray = new String[parts.length + splitParts.length];

                    System.arraycopy(parts, 0, mergedArray, 0, parts.length);
                    System.arraycopy(splitParts, 0, mergedArray, parts.length, splitParts.length);

                    // Print the result
                    System.out.println(Arrays.toString(mergedArray));
					hashMap.put(mergedArray[0] ,removec(mergedArray[4]));
                    list.add(mergedArray);
                }
            }
            System.out.println(Arrays.toString(list.get(3)));
			List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());

        // Sort the list by value in descending order using a custom comparator
			entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

			// Create a LinkedHashMap to maintain the order of insertion
			LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
			for (Map.Entry<String, Integer> entry : entryList) {
				sortedMap.put(entry.getKey(), entry.getValue());
			}

			// Print the sorted map
			// System.out.println("Sorted by value (descending): " + sortedMap);
			int count=0;
			for(Map.Entry<String,Integer> entry:sortedMap.entrySet())
			{
				if(count<5)
				{
					count++;
					System.out.println(entry);
					continue;
				}
				break;
			}
			input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
	
	public static long total(LinkedList<String[]> list)
	{
		long number = 0;
        for (String[] array : list) {
            
                
			
			number += removec(array[4]);
                
            
        }
        return number;
		
	}
    public static int removec(String i) {
        String numberWithoutCommas = i.replace(",", "");
		return Integer.parseInt(numberWithoutCommas);
    }
}
