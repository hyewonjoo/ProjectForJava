package Training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Arm {
	public static ArrayList<String> list2 = new ArrayList<String>();

	public static void load2() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("C:\\arm.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {

				list2.add(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void save2() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\arm.txt"));
			for (String s : list2) {


				String line = String.format("%s\n", s);

				writer.write(line);



			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
