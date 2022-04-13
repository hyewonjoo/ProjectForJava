import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Data {

	public static ArrayList<User> list = new ArrayList<User>();

	public static void load() {

		// 1. 먼저 파일로부터 기존유저의 아이디와 비밀번호를 받아와서 컬렉션에 옮겨줘야함


		try {// 파일에 있는 dummy데이터를 컬렉션으로 옮겨줌
			BufferedReader reader = new BufferedReader(new FileReader("C:\\user_dummy\\user.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				// user03■pw0003■이름03■20010505■1■010-1122-3344■Y■코미디■다다초
				String temp[] = line.split("■");
				User u = new User(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6],
						temp[7], temp[8]);

				list.add(u);

			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	// 가입한 회원들을 다시 파일로 올려주는 메소드
	public static void Save() {
		try {
			/*
			 * userLogin.list -> 유저.txt
			 */
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\user_dummy\\user.txt"));

			for (User u : list) {
				String line = String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s\n", u.getId(),
						u.getPassword(), u.getName(), u.getBirth(), u.getGender(), u.getTel(),
						u.getFollow(), u.getGenre(), u.getSchool());


				// u.getId(),
				// u.getPassword(), u.getName(), u.getBirth(), u.getGender(), u.getTel(),
				// u.getFollow(), u.getSchool());

				writer.write(line);

			}

			writer.close();
		} catch (Exception e) {

		}
	}



}
