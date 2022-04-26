package Training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class shoulder {
	public static ArrayList<String> list = new ArrayList<String>();

	public static void load() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("C:\\shoulder.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {

				list.add(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\shoulder.txt"));
			for (String s : list) {


				String line = String.format("%s\n", s);

				writer.write(line);



			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
