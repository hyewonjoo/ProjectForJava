package login;

import java.util.Scanner;

public class main {
	public static String id;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player p = new Player();
		SignUp sign = new SignUp();


		dummy_data.load(); // 파일에 있는 걸 컬렉션으로 옮겨줌



		Scanner scan = new Scanner(System.in);
		TitleView.titleView();
		System.out.println("=================================================");
		System.out.println("               나만의 운동 루틴 시스템");
		System.out.println("=================================================");

		System.out.println("아이디를 입력하세요");
		id = scan.next();


		System.out.println("비밀번호를 입력하세요");
		String password = scan.next();



		if (checkId(id)) {
			if (checkPassword(password)) {
				// 로그인 하고 난 후 페이지가 들어간 함수 넣기
				System.out.println();
				login.loginTitle();

			}

		} else {
			System.out.println();
			System.out.println("등록되지 않은 아이디와 비밀번호입니다.");
			System.out.println("회원가입 하시겠습니까?");
			String answer = scan.next();
			if (answer.toLowerCase().equals("y")) {
				// 회원가입 페이지로 이동
				System.out.println();
				sign.whoareu();


			}


		}



	}



	public static boolean checkId(String id) {
		for (Player p : dummy_data.list) {
			if (id.equals(p.getId())) {
				return true;
			}
		}
		return false;

	}


	public static boolean checkPassword(String password) {
		for (Player p : dummy_data.list) {
			if (password.equals(p.getPassword())) {
				return true;
			}
		}

		return false;
	}


}

