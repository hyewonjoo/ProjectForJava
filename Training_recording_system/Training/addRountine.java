package Training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class addRountine {

	public static ArrayList<String> list = new ArrayList<String>();

	public static void load() {
		try {
			String path = String.format("C:\\Users\\joo\\Desktop\\Players\\%s\\trainingList.txt",
					login.main.id);
			BufferedReader reader = new BufferedReader(new FileReader(path));
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
			String path = String.format("C:\\Users\\joo\\Desktop\\Players\\%s\\trainingList.txt",
					login.main.id);
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
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
