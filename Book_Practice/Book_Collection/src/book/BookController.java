package book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookController {
	
	private Scanner sc = new Scanner(System.in);
	private List<BookVo> bookList = new ArrayList<BookVo>();

	public void menu() {
		int num = -1;
		while(num != 0) {
			printMenu();
			num = scanInput();
			callFunction(num);
		}
	}
	
	public void printMenu() {
		System.out.println("---- MENU ----");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 목록 조회");
		System.out.println("3. 도서 상세 조회");
		System.out.println("4. 도서 수정");
		System.out.println("5. 도서 삭제");
	}
	
	public int scanInput() {
		System.out.println("메뉴 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		return num;
		
	}
	
	public void callFunction(int num) {
		switch(num) {
		case 0 :
			System.out.println("프로그램 종료");
			break;
		case 1:
			insert();
			break;
		case 2 :
			list();
			break;
		case 3 : 
			detail();
			break;
		case 4 :
			update();
			break;
		case 5 : 
			delete();
			break;
		default:
			System.out.println("잘못 입력하셨습니다 !");
		}
	}
	
	//insert
	public void insert() {
		System.out.println("\n---- 도서 등록 ----");
		
		//data 입력받기
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		//data 뭉치기 
		BookVo bookVo = new BookVo(title, price);
		
		//데이터 저장
		bookList.add(bookVo);
		System.out.println("\n 도서 등록 완ㄹ !");
	}
	
	//list
	public void list() {
		System.out.println("--- 도서 목록 ---");
		
		for(int i = 0; i < bookList.size(); ++i) {
			System.out.println(bookList.get(i));
		}
	}
	
	//detail
	public void detail() {
		System.out.println("--- 도서 상세 조회 ---");
		
		System.out.print("\n도서 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		if(num < 0 || num >= bookList.size()) {
			System.out.println("해당 번호의 도서 정보가 존재하지 않습니다.");
			return;
		}
		
		BookVo vo = bookList.get(num);
		System.out.printf("제목 : %s\n가격 : %,d원\n", vo.getTitle(), vo.getPrice());
	}
	
	//update
	private void update() {
		System.out.println("\n ---- 도서 수정 ----");
		
		System.out.print("\n수정할 도서 번호 : ");
		int index = Integer.parseInt(sc.nextLine());
		
		if(index < 0 || index >= bookList.size()) {
			System.out.println("해당 번호의 도서 정보가 존재하지 않습니다.");
			return;
		}
		
		BookVo vo = bookList.get(index);
		System.out.print("\n제목 : ");
		String title = sc.nextLine();
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		vo.setTitle(title);
		vo.setPrice(price);
		System.out.println("도서 수정 완료!");
	}
	
	//delete
	private void delete() {
		System.out.println("\n --- 도서 삭제 ----");
		
		System.out.print("\n삭제할 도서 번호 : ");
		int index = Integer.parseInt(sc.nextLine());
		
		if(index < 0 || index >= bookList.size()) {
			System.out.println("해당 번호의 도서 정보가 존재하지 않습니다.");
			return;
		}
		
		bookList.remove(index);
		System.out.println("도서 삭제 완료!");
	}
}
