package entities;

public class Book {
    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private String publisher;
    private int totalPage;
    private String description;
    
	public Book(String isbn, String title, String subTitle, String author, String publisher, int totalPage, String description) {
		this.isbn = isbn;
		this.title = title;
		this.subTitle = subTitle;
		this.publisher = publisher;
		this.totalPage = totalPage;
		this.description = description;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getAuthor() {
		return subTitle;
	}
	public void setAuthor(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
}
