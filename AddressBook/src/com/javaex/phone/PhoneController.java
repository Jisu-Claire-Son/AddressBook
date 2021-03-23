package com.javaex.phone;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneController {
	
	// 메뉴 입력값에 따른 작업 처리
	public String menuProcess(String menuValue) {
		Scanner input = new Scanner(System.in);
		
		// dao 객채 생성
		PhoneDaoOracleImpl dao = new PhoneDaoOracleImpl();
		
		String result = "";		// 처리 결과를 return하기 위한 변수
		
		boolean success;
		PhoneVoDB vo;
		Iterator<PhoneVoDB> it;
		
		switch(menuValue) {
			case "1":
				List<PhoneVoDB> list = dao.getList();
				//	Iterator(반복자) 추출
				it = list.iterator();
				while(it.hasNext()) {	//	내용이 더 있으면
					vo = it.next();	//	내용 불러오기
					System.out.printf("%d, %s, %s, %s%n", vo.getId(), vo.getName(), vo.getHp(), vo.getTel());
				}
				break;
			case "2":
				System.out.print("이름:");
				String name = input.next();
				System.out.print("핸드폰:");
				String hp = input.next();
				System.out.print("전화:");
				String tel = input.next();
				
				vo = new PhoneVoDB(name, hp, tel);
				
				success = dao.insert(vo);
				
				System.out.println("Phone INSERT:" + (success ? "성공": "실패"));
				break;
			case "3":
				System.out.print("삭제할 아이디:");
				long id = input.nextLong();
				
				success = dao.delete(id);
				
				System.out.println("Author DELETE:" + (success ? "성공": "실패"));
				break;
			case "4":
				System.out.print("검색어:");
				String keyword = input.next();
				
				List<PhoneVoDB> search = dao.search(keyword);
				
				it = search.iterator();
				
				while(it.hasNext()) {
					vo = it.next();
					System.out.println(vo);
				}
				break;
			case "5":
				result = "End";
				break;
			default:
				result = "[다시입력해주세요.]\n";
				break;
		}
		return result;
	}

}
