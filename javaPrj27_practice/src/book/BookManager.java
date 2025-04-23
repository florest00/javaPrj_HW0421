package book;

import java.util.Scanner;

public class BookManager {
	
	private Scanner sc = new Scanner(System.in);
	private BookData[] bookArr = new BookData[10];
	private int cnt = 0; //입력받는 횟수의 초기값

	public void work() {
		while(true) {
			// 메뉴 보여주는 메서드
			printMenu();
			
			//숫자 입력받기
			 int num = scanNumber();
			 
			 if(num == 0) {
				 System.out.println("프로그램 종료");
				 return;
			 }//if/
			 
			 //기능 수행
			 processFunction(num);
		}//while/
	}//work/



	public void printMenu() {
		System.out.println("---- MENU ----");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 목록 조회");
		System.out.println("3. 도서 상세 조회");
		System.out.println("4. 도서 삭제");
		System.out.println("5. 도서 수정");
		
	}//printMenu/
	
	public int scanNumber() {
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}//scanNumber/
	
	private void processFunction(int num) {
		switch(num) {
		case 1 : 
			insert();
			break;
		case 2 :
			printList();
			break;
		case 3 :
			printDetail();
			break;
		case 4 :
			delete();
			break;
		case 5 :
			update();
			break;
		default : 
			System.out.println("잘못 누르셨습니다.");	
		}//switch/
	}//processFunction/





	//insert (등록)
	public void insert() {
		System.out.println("---- 도서 등록 ----");
		//데이터 입력받기
		System.out.print("title : ");
		String title = sc.nextLine();
		
		System.out.print("price : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		//데이터 객체로 뭉치기
		BookData data = new BookData();
		data.title = title;
		data.price = price;
		
		//데이터(객체) 저장
		bookArr[cnt] = data;
		cnt++;
		System.out.println("@@@@ 도서 등록 완료 @@@@");
	}//insert/
	
	//list (목록 조회)
	private void printList() {
		System.out.println("---- 도서 목록 조회 ----");
		
		for(int i = 0; i < cnt; i++) {
			if(bookArr[i] == null) {
				continue; // 뭐가 컨티뉴가 되는거징?
			}//if/
			bookArr[i].printInfo();
		}//for/
	}//printList/
	
	//detail (상세조회)
	public void printDetail() {
		System.out.println("---- 도서 상세 조회 ----");
		System.out.print("조회할 도서 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		bookArr[num].printInfo();
	}//printDetail/
	
	//detail (삭제)
	public void delete() {
		System.out.println("---- 도서 삭제 ----");
		System.out.print("삭제할 도서 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		bookArr[num] = null;
	}//delete/
	//update (수정)
	public void update() {
		System.out.println("---- 도서 수정 ----");
		
		for(int i = 0; i < cnt; i++) {
			if(bookArr[i] != null) { //NullPointerException 에러 방지
				System.out.println(bookArr[i].title);
				String title = bookArr[i].title;
			}//if/
		}//for/
		
		System.out.print("수정할 도서 번호를 입력해주세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		if(num < 0 || num >= cnt || bookArr[num] == null) {
			System.out.println("해당 도서 번호가 없습니다.");
			return;
		}//if/
		
		System.out.print("new title : ");
		String title = sc.nextLine();
		System.out.print("new price : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		bookArr[num].title = title;
		bookArr[num].price = price;
		
		System.out.println("도서 수정이 완료되었습니다.");
	}//update/
	

}//BookManager
