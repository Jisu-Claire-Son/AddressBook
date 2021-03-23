package com.javaex.phone;

import java.util.Scanner;

public class PhoneApp {
	public static void main(String[] args) {
		// Controller 객체 생성
		// 객체 용도 : 프로그램 동작에 해당하는 모든 부분을 담당
		PhoneController controller = new PhoneController();
		
		// View 객체 생성
		// 객체 용도 : 프로그램이 동작하면서 보여주는 문구 출력 담당
		PhoneView view = new PhoneView();
		
		// Scanner 객체 생성
		// 객체 용도 : 사용자의 입력값을 받는 역할 담당
		Scanner input = new Scanner(System.in);
		
		// 변수 생성
		String menuValue = "";		// 메뉴선택 값을 받는 변수
		String menuResult = "";		// 메뉴선택 후 처리결과를 받는 변수
		
		// 프로그램 시작문구 및 메뉴 출력
		view.start();
		
		while(true) {
			view.menu();
			menuValue = input.next();
			
			menuResult = controller.menuProcess(menuValue);
			
			if (menuResult.equals("End")) {
				break;
			} else {
				System.out.println(menuResult);
			}
		}
		
		// 프로그램 종료문구 출력
		view.end();
	}
	
	
}
