package com.test.java.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

// 파일 데이터 <-> 메모리(배열)
public class Data {

	// 프로그램 전체에서 사용하게 될 자원(데이터)은 static을 선언하면 편하다.
	public static ArrayList<Student> slist = new ArrayList<Student>();
	public static ArrayList<Score> clist = new ArrayList<Score>();

	public static void load() {
		// 학생.txt읽기

		try {

			// 학생txt -> slit
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.학생)); // 학생 파일의 한줄한줄을
																						// 읽어온다.


			String line = null;

			while ((line = reader.readLine()) != null) {
				// 1, 박쌍제,16,1,인천시 강서구 압구정동 1번지
				String temp[] = line.split(",");
				Student s = new Student(temp[0], temp[1], temp[2], temp[3], temp[4]);

				slist.add(s); // slist에 생석한 학생s객체를 하나씩 넣어줌

			}

			reader.close();



			// 성적txt -> slit
			reader = new BufferedReader(new FileReader(DataPath.성적)); // 학생 파일의 한줄한줄을
																		// 읽어온다.


			line = null;

			while ((line = reader.readLine()) != null) { // 성적 파일을 한줄씩 받아서 읽음
				// 1,100,90,60
				String temp[] = line.split(",");
				Score s = new Score(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]),
						Integer.parseInt(temp[3]));
				clist.add(s); // clist에 방금 생성한 score객체 s를 하나씩 넣어줌

			}

			reader.close();



		} catch (Exception e) {

			e.printStackTrace();
		}
	}



	// 데이터 쓰기........
	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.학생));

			for (Student s : slist) {
				String line = String.format("%s,%s,%s,%s,%s\n", s.getSeq(), s.getName(), s.getAge(),
						s.getGender(), s.getAddress());

				writer.write(line);
			}

			writer.close();


			writer = new BufferedWriter(new FileWriter(DataPath.성적));

			for (Score s : clist) {

				String line = String.format("%s,%d,%d,%d\n", s.getSeq(), s.getKor(), s.getEng(),
						s.getMath());

				writer.write(line); // ************빼먹지 말도록 주의!!!!

			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

