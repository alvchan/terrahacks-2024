import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Tracker {
    public void go() {
        try {
            String line;
            Process p = Runtime.getRuntime().exec("tasklist");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            LinkedList<String[]> list = new LinkedList<>();

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

                    list.add(mergedArray);
                }
            }
            System.out.println(Arrays.toString(list.get(3)));
            System.out.println(removec(list));
			input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static long removec(LinkedList<String[]> list) {
        long number = 0;
        for (String[] array : list) {
            
                
			String i = array[4];
			String numberWithoutCommas = i.replace(",", "");
			number += Long.parseLong(numberWithoutCommas);
                
            
        }
        return number;
    }
}
