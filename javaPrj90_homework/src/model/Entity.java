package model;

import java.time.LocalDate;

public abstract class Entity {

		String id; // 책 고유 ID(식별자)
		String title; // 책 제목
		String author; //저자
		String publisher; //출판사
		int price; //가격
		boolean isAvailable; //대여 가능 여부
		LocalDate rentDate; //대여일
		LocalDate dueDate; //반납 예정일
		String borrower; //대여자 정보
		
		
		
		//getter&setter
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
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
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public boolean isAvailable() {
			return isAvailable;
		}
		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		public LocalDate getRentDate() {
			return rentDate;
		}
		public void setRentDate(LocalDate rentDate) {
			this.rentDate = rentDate;
		}
		public LocalDate getDueDate() {
			return dueDate;
		}
		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}
		public String getBorrower() {
			return borrower;
		}
		public void setBorrower(String borrower) {
			this.borrower = borrower;
		}

		
		//toString
		public String toString() {
			return "Entity [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
					+ ", price=" + price + ", isAvailable=" + isAvailable + ", rentDate=" + rentDate + ", dueDate="
					+ dueDate + ", borrower=" + borrower + "]";
		}
		
		public abstract void breadcrumb();
		
	
}
