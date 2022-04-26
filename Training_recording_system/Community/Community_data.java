package Community;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Community_data {
	public static ArrayList<String> list = new ArrayList<String>();

	public static void load() {



		try {// 파일에 있는 dummy데이터를 컬렉션으로 옮겨줌

			BufferedReader reader =
					new BufferedReader(new FileReader("C:\\community\\community.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				list.add(line); // arrayLis하나씩 생성

			}
			reader.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void save() {
		try {
			BufferedWriter writer =
					new BufferedWriter(new FileWriter("C:\\community\\community.txt"));

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
