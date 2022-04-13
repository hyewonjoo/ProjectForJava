import java.util.Scanner;

// 메인메뉴 1을 눌렀을때 로그인 클래스의 메소드들로 접근
public class userLogin {

	static Scanner scan = new Scanner(System.in);
	private static String id = "";
	private static String password = "";



	// 첫 로그인 화면
	public static void Login() {
		System.out.println("==================================================");
		System.out.println("                      [로그인]");
		System.out.println("==================================================");



		System.out.print("아이디: ");
		id = scan.nextLine();


		System.out.println("비밀번호: ");
		password = scan.nextLine();



		// 회원이나 관리자인 경우
		if (findUser() == true) {

		} else {
			// 등록된 회원이 아닌경우 -> 아이디,비밀번호 찾기로 넘어감
			whoareu();
		}



	}


	private static boolean findUser() {

		for (User u : Data.list) {
			if (u.getId().equals(id) && u.getPassword().equals(password)) {
				if (u.getId().equals(id) && u.getPassword().equals(password)) {
					System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
					System.out.println("           [회원]으로 로그인이 완료되었습니다.");
					System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

					return true;
				}

			}
		}

		if (id.equals("admin") && password.equals("1234")) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("           [관리자]로 로그인이 완료되었습니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

			return true;

		}
		return false;
	}



	public static void whoareu() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("               가입이 되어있지 않습니다");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		System.out.println("[Q]1 .아이디를 찾으시겠습니까?");
		System.out.println("[Q]2 .회원가입을 하시겠습니까?");
		System.out.println("숫자를 입력하세요 : ");
		String answer = scan.nextLine();
		if (answer.equals("1")) {
			findMyId();
		}
		if (answer.equals("2")) {
			SignUp.addMember();
			Data.Save();

		}

		else {
			System.out.println("프로그램을 종료합니다.");
			System.out.println();
		}

	}



	// 아이디 찾기 - 이름 전화번호 입력
	public static void findMyId() {
		System.out.println("-------------------------------------------------");
		System.out.println("                  아이디 찾기");
		System.out.println("-------------------------------------------------");
		System.out.println("[Q]이름을 입력하세요 :  ");
		String name = scan.nextLine();
		System.out.println("[Q]전화번호를 입력하세요 :  ");
		String telnumber = scan.nextLine();



		for (User u : Data.list) {
			if (u.getName().equals(name) && u.getTel().equals(telnumber)) {
				System.out.println(u.getName() + "의 아이디는" + u.getId() + "입니다.");
				break;
			}
		}



		System.out.println("비밀번호를 찾으시겠습니까?[Y/N]");
		String answer2 = scan.nextLine();

		if (answer2.equals("Y")) {

			System.out.println("-------------------------------------------------");
			System.out.println("                 비밀번호 찾기");
			System.out.println("-------------------------------------------------");
			System.out.println("[Q]아이디를 입력하세요 ");
			String userid = scan.nextLine();
			System.out.println("[Q]전화번호를 입력하세요");
			String usertell = scan.nextLine();
			System.out.println("[Q]본인의 출신 초등학교를 입력하세요");
			String userschool = scan.nextLine();



			for (User u : Data.list) {
				if (u.getId().equals(userid) && u.getTel().equals(usertell)
						&& u.getSchool().equals(userschool)) {
					System.out.println(u.getName() + "님의 비밀번호는" + u.getPassword() + "입니다");
					break;
				}
			} // for문



		}

		System.out.println("프로그램을 종료합니다");

	}

}
