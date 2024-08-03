import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tracker {
	public void go() {
		try {
			String line;
			Process p = Runtime.getRuntime().exec("tasklist");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			line = input.readLine();
			while (line != null) {
				System.out.println(line);
			}
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
