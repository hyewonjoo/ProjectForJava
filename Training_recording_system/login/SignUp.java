package login;

import java.util.Scanner;

public class SignUp {

	static Scanner scan = new Scanner(System.in); // static을 붙이는 이유 - 하나의 클래스로 부터 만들어진 모든 객체가 공통으로
													// 갖는 데이터

	public static void whoareu() {
		System.out.println("아이디가 뭐에유?");
		String id = scan.next();

		while (true) {
			if (checkyourid(id) == true) {
				continue; // 유효성 검사에 걸리면 계속 루프 돌도록..
			}

			break; // 유효성 검사에 통과한다면 false값이 반환되어 break문을 빠져나가도록
		}


		System.out.println("비밀번호 뭐에유?");
		String password = scan.next();

		while (true) {
			if (checkyourpassword(password) == true) {
				continue;
			}
			break;
		}

		System.out.println("이름 뭐에유?");
		String name = scan.next();

		System.out.println("나이 뭐에유?");
		String age = scan.next();

		System.out.println("성별 뭐에유?");
		String gender = scan.next();

		System.out.println("좋아하는 운동 종목이 뭐에유?");
		String genre = scan.next();

		Player p = new Player(id, password, name, age, gender, genre);
		dummy_data.list.add(p);

		System.out.println("회원가입을 완료하였습니다." + id + "님 환영합니다.");
		dummy_data.save2();
		dummy_data.save();


		main.main(null);

	}



	// 아이디 유효성 검사
	private static boolean checkyourid(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	// 비밀번호 유효성 검사
	private static boolean checkyourpassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
