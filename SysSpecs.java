import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SysSpecs {
    public static void main(String[] args) {
        try {
            // Execute the command to get detailed memory information
            Process process = Runtime.getRuntime().exec("wmic memorychip get /format:list");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Read and display the output
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
