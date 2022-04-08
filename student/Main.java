package com.test.java.student;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		/*
		 * 
		 * 학생 관리 프로그램
		 * - 프로젝트 가이드
		 * - 파일 입출력 + 컬렉션
		 * - 기본 행동: 생성하기, 읽기, 수정하기, 삭제하기 >CRUD
		 * 		-학생 정보 추가하기(C)
		 * 		-학생 정보 목록보기(R)
		 * 		-학생 정보 상세보기(R)
		 * 		-학생 정보 수정하기(U)
		 * 		-학생 정보 삭제하기(D)
		 * -업무별 >클래스 분배> 업무별 담당 클래스
		 * 
		 * -데이터 설계
		 * 		-졍보 수집> 이름, 나이, 성별, 주소, 국어, 영어, 수학
		 * 		-정보 분류> 신상(이름,나이,성별,주소) 성적(국어,영어,수학)
		 * 		-파일 > 학생.txt, 성적.txt
		 *		-학생.txt 구조
		 *			번호,이름,나이,성별,주소
		 *			1,홍길동,15,1,서울시 강남구 역삼동 
		 *		-성적.txt 구조	
		 *			학생번호,국어,영어,수학
		 *			1,100,80,90
		 *		-학생.txt <-> (시험) <-> 성적.txt
		 *		
		 *-데이터 파일 + 데이터 생성
		 *
		 *-클래스
		 *	파일 경로>DataPath.java
		 *
		 *
		 *
		 *- 프로그램의 순서도
		 *	1.타이틀
		 *	2.메인메뉴
		 *	3.선택
		 *	 -각각의 기능 실행
		 *	 -종료 > 2번 돌아가기
		 *	4.종료
		 *
		 * 
		 * 클래스 N개 생성
		 * 
		 * 
		 * 
		 * 
		 */



		Data.load(); // 학생,성적 파일을 컬렉션으로 옮겨넣어줌

		Work work = new Work(); // work객체 가져오기

		boolean loop = true;

		while (loop) {

			Output.title();
			Output.mainmenu();

			Scanner scan = new Scanner(System.in);

			String input = scan.nextLine();

			// 학생등록
			if (input.equals("1")) {
				work.add(); // 위임

				// 학생목록보기
			} else if (input.equals("2")) {
				work.list(); // 위임

			} else if (input.equals("3")) {
				work.search();
			} else {
			}
			loop = false;
		}

		Output.close();

		Data.save(); // 컬렉션을 다시 파일에 써줌 = 컬럭센에서 수정,삭제 다 하고 마지막에 프로그램 종료하고, 다시 파일에 출력!



	}
}


