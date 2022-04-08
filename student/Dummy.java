package com.test.java.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

// Dummy는 학생과 성적 파일에다가, 랜덤함수를 이용하여서 학생의 정보와 성적의 정보르를 출력해주는 역활을 해주는 클래스이다.
public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 데이터 생성용
		try {
			createStudent();
			createScore();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private static void createStudent() {
		// 번호,이름,나이,성별,주소
		// 1,홍길동,15,1,서울시 강남구 역삼동

		// 난수생성
		// System.out.println((int)(Math.random()*10)+1);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.학생));
			// 데이터생성
			Random rnd = new Random();
			// System.out.println(rnd.nextInt()); //-21억~21억
			// System.out.println(rnd.nextInt(10)); //0~9억

			int size = 20;
			String[] name1 = {"김", "이", "박", "최", "정", "한", "유", "민", "고", "주"};
			String[] name2 = {"갈", "양", "동", "빡", "제", "광", "용", "식", "병", "충", "균", "창", "송", "쌍"};
			String[] address1 = {"서울시", "경기도", "부산시", "제주시", "인천시"};
			String[] address2 = {"강동구", "강서구", "강동구", "강북구", "중구"};
			String[] address3 = {"역삼동", "대치동", "둔천동", "천호동", "압구정동"};

			for (int i = 0; i < size; i++) {
				int seq = i + 1;
				String name = name1[rnd.nextInt(name1.length)] + name2[rnd.nextInt(name2.length)]
						+ name2[rnd.nextInt(name2.length)];

				String address = address1[rnd.nextInt(address1.length)] + " "
						+ address2[rnd.nextInt(address2.length)] + " "
						+ address3[rnd.nextInt(address3.length)] + " " + (rnd.nextInt(30) + 1)
						+ "번지";

				int age = rnd.nextInt(3) + 14;
				int gender = rnd.nextInt(2) + 1;



				// 이렇게 만든 데이터를 파일에 다시 써야됨
				writer.write(String.format("%d, %s,%d,%d,%s\n", seq, name, age, gender, address));



			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	// 국영수 만들기
	private static void createScore() throws FileNotFoundException {
		// 학생번호,국어,영어,수학
		// 학생20명 > 성적 3회 분량
		Random rnd = new Random();
		String temp = "";
		String output = "";

		try {

			for (int j = 0; j < 3; j++) {// 3번반복

				BufferedReader reader = new BufferedReader(new FileReader(DataPath.학생));

				String line = null;

				while ((line = reader.readLine()) != null) {// 학생파일을 한줄씩 읽어옴
					String seq = line.split(",")[0]; // 0번만 배열에 저장

					int kor = rnd.nextInt(51) + 50; // 가장 못본애 50 잘본친구 100점으로 랜덤돌리기
					int eng = rnd.nextInt(51) + 50; // 가장 못본애 50 잘본친구 100점으로 랜덤돌리기
					int math = rnd.nextInt(51) + 50; // 가장 못본애 50 잘본친구 100점으로 랜덤돌리기

					temp += String.format("%s,%d,%d,%d\n", seq, kor, eng, math); // 첫번째는 랜덤x

					// 랜덤
					System.out.println(temp);

				}
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.성적));
			writer.write(temp);
			writer.close();
			System.out.println("등록완료");

		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}


