package book;

public class BookData {
	
	public BookData() {
		
	}
	
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
	
	public String toString() {
		return "BookData [title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
}
