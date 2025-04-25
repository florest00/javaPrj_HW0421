package model;

public class Book {

	//제목/저자/출판사/가격/대여 가능 여분
	
	private String title;
	private String author;
	private int price;

	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}



	public void breadcrumb() {
		System.out.println("==== book admin ====");
	}
	
	
}
