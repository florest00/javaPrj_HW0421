package book;

import java.util.Scanner;

public class BookManager {
	
	private Scanner sc = new Scanner(System.in);
	private BookData[] bookDataArr = new BookData[100];
	private int cnt = 0;
	
	public void selectMenu() {
		while(true) {
			printMenu();
			int input = scanInput();
			if(input == 0) {
				System.out.println("EXIT !!!");
				break;
			}
			processFunction(input);
		}
	}
	
	public void printMenu() {
		System.out.println("\n\n\n\n\n");
		System.out.println("---- MENU ----");
		System.out.println("0. EXIT");
		System.out.println("1. INSERT BOOK");
		System.out.println("2. PRINT BOOK LIST");
		System.out.println("3. PRINT BOOK DETAIL");
		System.out.println("4. UPDATE BOOK");
		System.out.println("5. DELETE BOOK");
	}
	
	
	public int scanInput() {
		System.out.print("메뉴 번호 : ");
		int input = sc.nextInt();
		sc.nextLine();
		return input;
	}
	
	public void processFunction(int menu) {
		switch(menu) {
		case 1 : 
			insertBook();
			return;
		case 2 : 
			printBookList();
			return;
		case 3 : 
			printBookDetail();
			return;
		case 4 : 
			updateBook();
			return;
		case 5 : 
			deleteBook();
			return;
		}
	}
	
	//도서 등록
	public void insertBook() {
		System.out.println("\n\n---- INSERT BOOK ----");
		System.out.print("title : ");
		String title = sc.nextLine();
		System.out.print("author : ");
		String author = sc.nextLine();
		System.out.print("price : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		//data -> object
		BookData data = new BookData();
		data.setTitle(title);
		data.setAuthor(author);
		data.setPrice(price);
		
		//sabe object
		bookDataArr[cnt] = data;
		cnt++;
		System.out.println("@@@@ 도서 등록 완료 @@@@");
	}
		
	//도서 목록 조회
	public void printBookList() {
			System.out.println("\n---- PRINT BOOK LIST ----");
			for(int i = 0; i < cnt; i++) {
				if(bookDataArr[i] == null) {
					continue;
				}
//				bookDataArr[i].toString();
				System.out.println(i + "번 도서 : " + bookDataArr[i]);
			}
	}
	
	//도서 상세 조회
	public void printBookDetail() {
		System.out.println("\n---- PRINT BOOK DETAIL ----");
		System.out.print("BOOK NUMBER : ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.println(bookDataArr[num]);
	}
	
	//도서 수정
	public void updateBook() {
		System.out.println("---- 도서 수정 ----");
		for(int i = 0; i < cnt; i++) {
			if(bookDataArr[i] != null) {
				System.out.println(bookDataArr[i].getTitle());
				String title = bookDataArr[i].getTitle();
			}
		}
		System.out.print("수정할 도서 번호를 입력해주세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		if(num < 0 || num >= cnt || bookDataArr[num] == null) {
			System.out.println("해당 도서 번호가 없습니다.");
			return;
		}
		
		System.out.print("update title : ");
		String title = sc.nextLine();
		System.out.print("update author : ");
		String author = sc.nextLine();
		System.out.print("update price : ");
		int price = sc.nextInt();
		sc.nextLine();
		
//		BookData x = bookDataArr[num];
//		x.setTitle(title);
//		x.setAuthor(author);
//		x.setPrice(price);
		
		bookDataArr[num].setTitle(title);
		bookDataArr[num].setAuthor(author);
		bookDataArr[num].setPrice(price);
		
		System.out.println("도서 수정이 완료되었습니다.");
	}
	
	//도서 삭제
	public void deleteBook() {
		System.out.println("\n---- DELETE BOOK ----");
		System.out.print("BOOK NUMBER TO DELETE : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		bookDataArr[num] = null;
	}

}
