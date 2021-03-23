package com.javaex.phone;

public class PhoneView {
	  // 프로그램 실행 시작문구 출력 메소드
	   public void start(){
	    System.out.println("*************************************");
	    System.out.println("* 전화번호 관리 프로그램 *");
	    System.out.println("*************************************");
	   }

	   public void menu(){
	    System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
	    System.out.println("--------------------------------------");
	    System.out.print(">메뉴번호: ");
	   }

	   // 프로그램 종료문구 출력 메소드
	   public void end(){
	    System.out.println("\n*************************************");
	    System.out.println("* 감사합니다 *");
	    System.out.println("*************************************");
	   }
}
