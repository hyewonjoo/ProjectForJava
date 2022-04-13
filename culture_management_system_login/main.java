import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Data.load();


		userLogin login = new userLogin();
		SignUp signup = new SignUp();



		boolean loop = true;

		Output.title();

		while (true) {

			Output.subtitle();
			Scanner scan = new Scanner(System.in);
			System.out.println("숫자를 입력하세요");
			String input = scan.nextLine();



			if (input.equals("1")) { // 로그인
				login.Login();

			} else if (input.equals("2")) {// 회원가입
				signup.addMember();
				Data.Save();

			} else if (input.equals("3")) { // 계정찾기
				login.findMyId();


			} else if (input.equals("4")) {

			} else if (input.equals("5")) {

			} else {
				loop = false;
			}
		}
	}

}


