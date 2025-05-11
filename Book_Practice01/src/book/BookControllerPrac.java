package book;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class BookControllerPrac {

	private Scanner sc = new Scanner(System.in);
//	private List<BookVo> bookList = new ArrayList<BookBo>();

	// 메뉴
	public void menu() throws Exception {
		while (true) {
			printMenu();
			int num = scanNumber();
			if (num == 0) {
				break;
			}
			callFunction(num);
		}
	}

	private void callFunction(int num) throws Exception {
		switch (num) {
		case 1:
			insertBook();
			break;
		case 2:
			selectBookList();
			break;
		default:
			System.out.println("wrong");
		}
	}

	private int scanNumber() {
		System.out.print("메뉴 번호 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	private void printMenu() {
		System.out.println("---- menu ----");
		System.out.println("0. 종료");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 목록 조회");
	}

	// 도서 등록
	public void insertBook() throws Exception {
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		//data -> 객체
		BookVo vo = new BookVo(title, price);
		
		//bookList 에 객체 담기 :data.txt라는 파일에 기록 : 통로 만들기
		File f = new File("C:\\Users\\user\\Desktop\\kh\\dev\\java_repo\\data.txt");
		FileWriter fw = new FileWriter(f, true);
		fw.write(vo.getTitle() + " / " + vo.getPrice());
		fw.write("\n");
		fw.flush();
	}
	
	//도서 목록 조회
	public void selectBookList() throws Exception {
		File f = new File("C:\\Users\\user\\Desktop\\kh\\dev\\java_repo\\data.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String str = br.readLine();
			if(str == null) {break;}
			System.out.println(str);
		}
	}

}
