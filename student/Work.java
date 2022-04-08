package com.test.java.student;

import java.util.Scanner;

// 학생 관련 처리 업무 담당 클래스
public class Work {

	private Scanner scan;

	public Work() { // 생성자 초기화 !!!
		this.scan = new Scanner(System.in);
	}


	// CRUD
	// 학생추가
	// 사용자가 1번을 입력할경우 add실행
	public void add() {


		Output.subtitle("학생 추가하기");

		System.out.println("이름: ");
		String name = scan.nextLine();

		System.out.println("나이: ");
		String age = scan.nextLine();

		System.out.println("성별(1.남자 2.여자): ");
		String gender = scan.nextLine();

		System.out.println("주소: ");
		String address = scan.nextLine();

		String seq = getSeq(); // seq 고쳐주기 ..

		Student s = new Student(seq, name, age, gender, address);

		Data.slist.add(s); // 위에서 스캐너로 받은 학생겍체를 data클래스의 slist(ArrayList)컬렉션에 넣어준다.

		System.out.println();
		System.out.println("학생 추가 완료..");

		Output.pause();

	}

	private String getSeq() {
		// TODO Auto-generated method stub

		int max = 0;


		for (Student s : Data.slist) {
			int seq = Integer.parseInt(s.getSeq());



			if (seq > max) {
				max = seq;
			}
		}
		return (max + 1) + "";
	}


	// 학생 목록보기
	// 사용자가 2번을 클릭할경우 list메소드 실행
	public void list() {
		Output.subtitle("학생 목록보기");

		System.out.println("[번호]\t[이름]\t[나이]\t[성별]");
		for (Student s : Data.slist) {
			System.out.printf("%4s\t%s\t%s\t%s\n", s.getSeq(), s.getName(), s.getAge(),
					s.getGender());
		}

		System.out.println("");


		boolean loop = true;

		while (loop) {
			Output.submenu();
			String input = scan.nextLine();

			if (input.equals("1")) {
				// 상세보기
				view();
			} else if (input.equals("2")) {
				// 수정하기
				edit();
			} else if (input.equals("3")) {
				// 삭제하기
				delet();
			} else {
				// 상위메뉴
				loop = false;
			}

		} // while
	}


	// 2번을 클릭한 사용자가
	// 2번에서 1번(상세보기)을 클릭한경우
	private void view() {
		// 위의 출력 목록에서 한명 선택(번호) ->상세보기
		System.out.println("학생 번호 : ");
		String input = scan.nextLine(); // 학생번호(seq)

		Student result = null;

		// 모든학생의 정보를 하나씩 출력
		for (Student s : Data.slist) { // 여기서 slist는 ArrayList 컬렉션이다. slist의 student객체 s를 하나씩 출력한다.
			if (s.getSeq().equals(input)) {// 만약 Student s객체에 사용자가 입력한 input과 같다면
				result = s; // 그 s(객체)를 result에 넣어준다.
				break;
			}
		}
		if (result != null) { // 그 결과가 null이 아니라면, 출력
			System.out.println("[번호]" + result.getSeq());
			System.out.println("[이름]" + result.getName());
			System.out.println("[나이]" + result.getAge());
			System.out.println("[성별]" + result.getGender());
			System.out.println("[주소]" + result.getAddress());

			// 모든성적을 하나씩 출력
			for (Score s : Data.clist) {// clist의 socre객체 s하나하나를 하나씩 출력해준다.
				if (s.getSeq().equals(result.getSeq())) { // 만약, 위의 result(사용자가 입력한 번호와 일치한 학생의 번호)와
															// score의 번호가 일치한다면
					System.out.printf("국어 : %d 영어:%d 수학 :%d\n", s.getKor(), s.getEng(), // 그 값을
																						// 출력해준다.
							s.getMath());
				}
			}



		} else {
			System.out.println("입력하신 학생 번호가 올바르지 않습니다.");
		}


		Output.pause();
	}


	// 2번을 클릭한 사용자가
	// 2번에서 2번(수정하기)을 클릭한경우
	private void edit() {
		System.out.println("학생 번호 : ");
		String input = scan.nextLine();

		Student result = null;

		// 모든학생의 정보를 하나씩 출력해주고 input과 같은 객체를 result로 반환
		for (Student s : Data.slist) { // Arraylist의 slist에 있는 s객체를 하나씩 출력
			if (s.getSeq().equals(input)) { // 만약 s와 사용자가 입력한 input값과 같다면
				result = s; // 그 학생 객체를 result객체에 넣어줌
				break;
			}
		} // for

		if (result != null) { // 같은 결과값이 있다면(즉 result의 값이 널이 아니라면) 수정작업을 시작한다.
			// 수정작업
			// 수정하기 싫으면 그냥 엔터만 입력...

			// 이름수정
			System.out.println("[이름] " + result.getName());
			System.out.println("수정 : ");
			String name = scan.nextLine();

			if (!name.equals("")) {
				result.setName(name);
			}

			// 나이수정
			System.out.println("[나이] " + result.getAge());
			System.out.println("수정 : ");
			String Age = scan.nextLine();

			if (!Age.equals("")) {
				result.setAge(Age); // 이름수정
			}

			// 성별수정
			System.out.println("[성별] " + result.getGender());
			System.out.println("수정(1남자 2여자) : ");
			String Gender = scan.nextLine();

			if (!Gender.equals("")) {
				result.setGender(Gender); // 이름수정
			}

			// 주소수정
			System.out.println("[주소] " + result.getAddress());
			System.out.println("수정 : ");
			String Address = scan.nextLine();

			if (!Address.equals("")) {
				result.setAddress(Address); // 이름수정
			}

			System.out.println("수정 완료.");


		} // if문
		else {
			System.out.println("입력하신 학생 번호가 올바르지 않습니다.");
		}
	}


	// 2번을 클릭한 사용자가
	// 2번에서 3번(삭제하기)을 클릭한경우
	private void delet() {
		System.out.println("학생 번호 : ");
		String input = scan.nextLine();

		Student result = null;

		for (Student s : Data.slist) { // Arraylist의 slist에 있는 s객체를 하나씩 출력
			if (s.getSeq().equals(input)) { // 만약 s와 사용자가 입력한 input값과 같다면
				result = s;
				break;
			}
		}
		if (result != null) {
			Data.slist.remove(result);
			System.out.println("삭제완료");
		} else {
			System.out.println("입력하신 학생 번호가 올바르지 않습니다.");

		}
		Output.pause();

	}


	public void search() {
		Output.subtitle("학생 검색하기");

		// 검색 조건을 입력
		// 이름 or 주소 검색
		System.out.println("검색어(이름/주소):  ");
		String input = scan.nextLine();

		System.out.println("[번호]\t[이름]\t[나이]\t[성별]");
		for (Student s : Data.slist) {

			if (s.getName().contains(input)
					|| s.getAddress().replace(" ", "").contains(input.replace(" ", ""))) {

				System.out.printf("%4s\t%s\t%s\t%s\n", s.getSeq(), s.getName(), s.getAge(),
						s.getGender());
			}

		}
		Output.pause();
	}

}


