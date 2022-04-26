package Community;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class community_main {
	static Scanner scan = new Scanner(System.in);

	public static void comminityTitle() {

		addCommunity.load();
		Community_data.load();


		System.out.println("-------------------------------------------------");
		System.out.println("          [!!]커뮤니티 메인 페이지입니다.");
		System.out.println("-------------------------------------------------");
		System.out.println("현재 존재하는 커뮤니티를 확인하시겠습니까?[Y/N]");
		System.out.println("Y를 누르면 커뮤니티 페이지로 이동합니다.");
		System.out.println("N을 누르면 로그인 메인 페이지로 이동합니다.");
		String number = scan.next();

		if (number.toUpperCase().equals("Y")) {
			showCommunity();
		} else {// 대답이 예쓰가 아닐경우
			login.main.main(null);
		}

		addCommunity.save();
		Community_data.save();



	}



	private static void showCommunity() {
		try {
			BufferedReader reader =
					new BufferedReader(new FileReader("C:\\community\\community.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} // 여기까지 현재커뮤니티의 목록을 출력해줌


		// 여기서부터 커뮤니티안의 채팅목록을 출력시켜줌
		System.out.println("자세히 보고 싶은 모임 이름을 입력하세요 : ");
		String answer = scan.next();

		for (String s : Community_data.list) {
			if (answer.equals(s)) {
				String path = String.format("C:\\Users\\joo\\Desktop\\대진설2\\%s\\s.txt", answer);

				try {
					BufferedReader reader2 = new BufferedReader(new FileReader(path));

					String line2 = null;
					while ((line2 = reader2.readLine()) != null) {
						System.out.println(line2);

					}
					reader2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("[!!] 해당 모입에 가입하시겠습니까?");
				String input = scan.next();
				if (input.toLowerCase().equals("y")) {
					addCommunity(answer); // 해당 모임을 내 모임 리스트에 넣어주는 메소드
				}
			} // if문 종료

		} // for문 종료
	}// show community

	// 커뮤니티에 가입하는 메소드
	private static void addCommunity(String answer) {
		System.out.println("[!!]가입 완료되었습니다");
		addCommunity.list.add(answer); // 컬렉션에 사용자의 모임을 추가해줌
		System.out.println();
		System.out.println();

		showMyCommunity();


	}


	// 내가 가입한 모임 리스트를 출력해주는 메소드
	private static void showMyCommunity() {
		System.out.println("-------------------------------------------------");
		System.out.println("     현재" + login.main.id + "님이 가입한 모임 리스트 입니다.");
		System.out.println("-------------------------------------------------");
		for (String s : addCommunity.list) {
			System.out.println(s);
		}
		System.out.println("프로그램을 종료합니다");
	}


}// community_main


