package book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class BookController {

	private Scanner sc = new Scanner(System.in);
//	private List<BookVo> bookList = new ArrayList<BookVo>();
	
	//메뉴
	public void menu() throws Exception {
		while(true) {
			printMenu();
			int num = scanNumber();
			if(num == 0) {break;}
			callFunction(num);
		}
	}
	
	private void callFunction(int num) throws Exception {
		switch(num) {
		case 1 : insertBook(); break;
		case 2 : selectBookList(); break;
		default : System.out.println("잘못 누르셨습니다.");
		}
	}
	
	private int scanNumber() {
		System.out.print("메뉴 번호 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
	
	private void printMenu() {
		System.out.println("----- menu -----");
		System.out.println("0. 종료");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 목록 조회");
	}
	
	//도서 등록
	public void insertBook() throws Exception {
		//data
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		//data -> 객체
		BookVo vo = new BookVo(title , price);
		
		//bookList 에 객체 담기 : data.txt 라는 파일에 기록하기 : 통로 만들기
//		File f = new File("D:\\dev\\java_repo\\data.txt");
		File f = new File("C:\\Users\\user\\Desktop\\kh\\dev\\java_repo\\data.txt");
		FileWriter fw = new FileWriter(f , true);
		fw.write( vo.getTitle() + " / " + vo.getPrice() );
		fw.write("\n");
		fw.flush();
	}
	
	//도서 목록 조회
	public void selectBookList() throws Exception {
		//bookList 에 들어있는 객체들 전부 출력하기 : data.txt 파일 내용 출력
//		File f = new File("D:\\dev\\java_repo\\data.txt");
		File f = new File("C:\\Users\\user\\Desktop\\kh\\dev\\java_repo\\data.txt");
		FileReader fr = new FileReader( f );
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String str = br.readLine();
			if(str == null) {
				break;
			}
			System.out.println(str);
		}
	}
	
}
