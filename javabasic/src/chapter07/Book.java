package chapter07;

public class Book {
	private String bookName;
	private String author;
	
	public Book() {};
	public Book(String bookName, String author)
		{
		this.bookName =bookName;
		this.author = author;
		}
	/**
	 * @return the bookName
	 */
	public String getBookname() {
		return bookName;
	}
	/**
	 * @param bookname the bookName to set
	 */
	public void setBookname(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void showBookInfo()
	{
		System.out.println(bookName + "," + author);
	}
}


