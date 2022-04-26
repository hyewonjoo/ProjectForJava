package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class dummy_data {



	public static ArrayList<Player> list = new ArrayList<Player>();


	// 파일에 있는 트레이닝선수들의 정보들을 콜렉션으로 옮기는 함수
	public static void load() {



		try {// 파일에 있는 dummy데이터를 컬렉션으로 옮겨줌

			BufferedReader reader = new BufferedReader(new FileReader("C:\\player_dummy.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {


				String temp[] = line.split("/");
				Player p = new Player(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);

				list.add(p);

			}
			reader.close();
		} catch (IOException e) {

			e.printStackTrace();
		}



	}

	// 트레이닝 선수들의 컬렉션들을 다시 파일로 옮겨주는 메소드
	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\player_dummy.txt"));

			for (Player p : list) {


				String line = String.format("%s/%s/%s/%s/%s/%s\n", p.getId(), p.getPassword(),
						p.getName(), p.getAge(), p.getGender(), p.getGenre());

				writer.write(line);



			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	// 한번 만들때마다 유저별로 폴더와 그 안에 training파일 만들어주는 메소드
	public static void save2() {

		try {

			for (Player p : list) {



				String path = String.format("C:\\Users\\joo\\Desktop\\Players\\%s", p.getId());
				File dir = new File(path);
				dir.mkdir(); // *입력한 유저대로 폴더 생성


				String path2 = String.format("C:\\Users\\joo\\Desktop\\Players\\%s\\training.txt",
						p.getId());
				File file = new File(path2);

				file.createNewFile(); // training으로 파일 생성

				String path3 = String.format(
						"C:\\Users\\joo\\Desktop\\Players\\%s\\trainingList.txt", p.getId());

				File file2 = new File(path3);

				file2.createNewFile(); // training으로 파일 생성

				BufferedWriter writer = new BufferedWriter(new FileWriter(path2));


				String line = String.format("%s/%s/%s/%s/%s/%s\n", p.getId(), p.getPassword(),
						p.getName(), p.getAge(), p.getGender(), p.getGenre());
				writer.write(line);
				writer.close();


				String path4 = String.format(
						"C:\\Users\\joo\\Desktop\\Players\\%s\\addCommunity.txt", p.getId());

				File file4 = new File(path4);

				file4.createNewFile(); // training으로 파일 생성


			} ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
