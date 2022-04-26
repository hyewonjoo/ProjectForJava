package Training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class showRoutine {
	public static Scanner scan = new Scanner(System.in);

	public static void showRoutine() {
		System.out.println("-------------------------------------------------");
		System.out.println("        [!!]" + login.main.id + "님의 운동루틴 기록 입니다.");
		System.out.println("-------------------------------------------------");


		try {
			String path = String.format("C:\\Users\\joo\\Desktop\\Players\\%s\\trainingList.txt",
					login.main.id);
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = null;

			while ((line = reader.readLine()) != null) {

				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println();

		System.out.println("1.프로그램 초기화면으로 돌아갑니다.");
		System.out.println("2.프로그램을 종료합니다.");
		System.out.println("번호를 선택하세요 :     ");
		String answer = scan.next();

		if (answer.equals("1")) {
			login.main.main(null);
		} else {
			System.out.println("[!!]나만의 운동 리스템을 종료합니다");
		}

	}

}

