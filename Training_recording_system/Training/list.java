package Training;

import java.util.Scanner;
import login.Player;



public class list {
	public static Scanner scan = new Scanner(System.in);
	static Player p = new Player();
	Arm a = new Arm();


	public static void showList() {
		Arm.load2();
		lowerbody.load();
		shoulder.load();
		Back.load();
		addRountine.load();


		while (true) {

			System.out.println("[!!]운동할 부위를 선택하세요");
			System.out.println("1.팔");
			System.out.println("2.하체");
			System.out.println("3.어깨");
			System.out.println("4.등");
			System.out.println("5.로그인 화면으로 돌아가기");
			System.out.println("번호를 선택하시오:");
			String answer = scan.next();
			System.out.println();

			if (answer.equals("1")) {
				for (String s : Arm.list2) {
					System.out.println(s);
				}
				addArm();

			} else if (answer.equals("2")) {
				for (String s : lowerbody.list) {
					System.out.println(s);
				}
				addLowerbody();
			}
			// 하체와 과련된 운동들 전부 출력
			else if (answer.equals("3")) {
				// 어깨와 관련된 운동들 전부 출력
				for (String s : shoulder.list) {
					System.out.println(s);
				}
				addShoulder();
			} else if (answer.equals("4")) {
				// 등 운동 하는거 출력
				for (String s : Back.list) {
					System.out.println(s);

				}
				addBack();
			} else if (answer.equals("5")) {
				break;
			} ;
		}


		Arm.save2();
		lowerbody.save();
		shoulder.save();
		Back.save();

		addRountine.save();


		login.login.loginTitle(); // 운동루틴추가하고 다시 돌아오지않을 메인으로... ->바로 기록보기로 이동...



	}



	// 팔 운동 추가하는 메소드
	private static void addArm() {
		System.out.println();
		System.out.println("[!]추가 할 팔운동의 이름을 입력하세요 :  ");
		String answer = scan.next();
		try {
			for (String s : Arm.list2) {
				if (answer.equals(s)) {
					addRountine.list.add(answer);
					System.out.println("[!]" + answer + "가 운동루틴에 추가 되었습니다.");
					System.out.println();

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // if문 끝



	// 다리운동 추가하는 메소드
	private static void addLowerbody() {
		System.out.println();
		System.out.println("[!!]추가 할 다리운동의 이름을 입력해주세요 :   ");
		String answer = scan.next();
		try {
			for (String s : lowerbody.list) {
				if (s.equals(answer)) {
					addRountine.list.add(answer);
					System.out.println("[!]" + answer + "가 운동루틴에 추가 되었습니다.");
					System.out.println();


				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 어깨 운동 추가하는 메소드
	private static void addShoulder() {
		System.out.println();
		System.out.println("[!!]추가 할 어깨 운동의 이름을 입력해주세요 : ");
		String answer = scan.next();
		for (String s : shoulder.list) {
			if (s.equals(answer)) {
				addRountine.list.add(answer);
				System.out.println("[!]" + answer + "가 운동루틴에 추가 되었습니다.");
				System.out.println();
			}
		}
	}


	// 등 운동 추가하는 메소드
	private static void addBack() {
		System.out.println();
		System.out.println("[!!]추가 할 등 운동의 이름을 입력하세요 :  ");
		String answer = scan.next();
		for (String s : Back.list) {
			if (answer.equals(s)) {
				addRountine.list.add(answer);
				System.out.println("[!]" + answer + "가 운동루틴에 추가 되었습니다.");
				System.out.println();

			}
		}

	}


}


