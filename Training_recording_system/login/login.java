package login;

import java.util.Scanner;
import Community.addCommunity;
import Community.community_main;
import Training.list;
import Training.showRoutine;



// 로그인 후 이동하는 페이지..
public class login {
	public static Scanner scan = new Scanner(System.in);

	public static void loginTitle() {
		System.out.println("-------------------------------------------------");
		System.out.println("              [!!]회원전용 페이지 입니다.");
		System.out.println("-------------------------------------------------");
		System.out.println("1.운동루틴추가");
		System.out.println("2.운동루틴보기");
		System.out.println("3.운동커뮤니티 가입하기");
		System.out.println("4.나의 커뮤니티 보기");
		System.out.println("5.프로그램 초기화면으로 돌아가기");
		System.out.println("번호를 입력하세요:");
		String number = scan.next();


		if (number.equals("1")) {
			list.showList();
		} else if (number.equals("2")) {
			showRoutine.showRoutine();
		} else if (number.equals("3")) {
			community_main.comminityTitle();
		} else if (number.equals("4")) {
			showCommunity();
		} else {
			main.main(null);
		}



	}

	private static void showCommunity() {
		System.out.println("-------------------------------------------------");
		System.out.println("        [!!]" + main.id + "님이 현재 가입된 모임 리스트 입니다.");
		System.out.println("-------------------------------------------------");

		Community.addCommunity.load();
		for (String s : addCommunity.list) {
			System.out.println(s);
		}
		Community.addCommunity.save();


		System.out.println("[!!]프로그램을 종료합니다.");


	}

}
