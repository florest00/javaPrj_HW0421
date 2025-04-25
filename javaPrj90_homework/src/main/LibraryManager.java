package main;

//import java.time.LocalDate;
import java.util.Scanner;
import model.Book;

public class LibraryManager {
	
	//컨트롤러 - 관리 기능
	//Entity - Book, Member, Rental 등을 관리함

	private Scanner sc = new Scanner(System.in);
	private Book[] bookDataArr = new Book[100];
	private int cnt = 0;
	
	public void work() {
		while(true) {
			printMenu();
			//메뉴 보여주는 메서드
			int num = scanNumber();
			//만약 사용자가 선택한 번호가 0이면 프로그램 종료 출력하고 리턴
			if(num == 0) {
				System.out.println("프로그램 종료");
				return;
			}
			//기능 수행
			processFunction(num);
		}
	}
	
	//도서 관리 메뉴를 보여주는 메서드 
	public void printMenu() {
		System.out.println("---- MENU ----");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 목록 조회");
		System.out.println("3. 도서 상세 조회");
		System.out.println("4. 도서 수정");
		System.out.println("5. 도서 삭제");
	}
	
	//메뉴 번호를 입력받는 메서드
	public int scanNumber() {
		System.out.println("메뉴 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
	
	//기능 수행 메서드
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
			update();
			break;
		case 5 : 
			delete();
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	//도서 등록
	public void insert() {
		System.out.println("---- 도서 등록 ----");
		//데이터 입력 받기
		System.out.println("타이틀 : ");
		String title = sc.nextLine();
		System.out.println("작가 : ");
		String author = sc.nextLine();
		System.out.println("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		//데이터 객체로 뭉치기
		Book data = new Book();
		data.setTitle(title);
		data.setAuthor(author);
		data.setPrice(price);
		
		//데이터(객체) 저장
		bookDataArr[cnt]= data;
		cnt++;
		System.out.println("@@@@ 도서 등록 완료 @@@@");
		
		
		/*
		 * 
		 * 
		 * 변수로 얘네 추가
		 * 		String id; // 책 고유 ID(식별자)
		String title; // 책 제목
		String author; //저자
		String publisher; //출판사
		int price; //가격
		boolean isAvailable; //대여 가능 여부
		LocalDate rentDate; //대여일
		LocalDate dueDate; //반납 예정일
		String borrower; //대여자 정보
		 */
	}//등록/
	
	//목록 조회
	private void printList() {
		System.out.println("\n---- 도서 목록 조회 ----");
		//출력되는 도서 목록
		for(int i = 0; i < cnt; cnt++) {
			if(bookDataArr[i] == null) {
				continue;
			}
		}
	}
	
	//상세 조회
	public void printDetail() {
		System.out.println("---- 도서 상세 조회 ----");
		
		System.out.println("조회할 도서 번호 : ");
		int num = sc.nextInt();
		sc.nextInt();
		
		bookDataArr[num].toString();
	}
	
	//도서 수정
	public void update() {
		System.out.println("---- 도서 수정 ----");
		for(int i = 0; i < cnt; i++) {
			if(bookDataArr[i] != null) {
				System.out.println(bookDataArr[i].getTitle());
				String title = bookDataArr[i].getTitle();
			}
		}
		System.out.println("수정할 도서 번호를 입력하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		if(num < 0 || num >= cnt || bookDataArr[num] == null) {
			System.out.println("해당 도서 번호가 없습니다.");
			return;
		}
		
		System.out.println("update title : ");
		String title = sc.nextLine();
		System.out.println("update author : ");
		String author = sc.nextLine();
		System.out.println("update price : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		bookDataArr[num].setTitle(title);
		bookDataArr[num].setAuthor(author);
		bookDataArr[num].setPrice(price);
		
		System.out.println("도서 수정이 완료되었습니다.");
	}
	
	//도서 삭제
	public void delete() {
		System.out.println("\n---- 도서 삭제 ----");
		System.out.println("삭제할 도서 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		bookDataArr[num] = null;
	}
	
//	 얘네도 메뉴로 만들어야되나?
	//도서 등록/조회/수정/삭제 OK
	//회원 등록/조회/수정/삭제
	//도서 대여/반납
	//대여 이력 확인
	//연체 여부 확인(옵션)
	
	
	
	
	
}
