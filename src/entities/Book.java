package entities;

import java.io.Serializable;
/**
 * Book Entity
 * @author Group4
 *
 */
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String bookName;
	private String bookAuthor;
	private String bookImage;
	private String summary;
	private BookType bookType;
	/**
	 * to create empty object
	 */
	public Book() {
		super();
	}
	
	/**
	 * @param isbn
	 * @param bookname
	 * @param bookauthor
	 * @param bookimage
	 * @param summary
	 * @param booktype
	 */
	public Book(String isbn, String bookName, String bookAuthor, String bookImage, String summary, BookType bookType) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookImage = bookImage;
		this.summary = summary;
		this.bookType = bookType;
	}

	/**
	 * 
	 * @return String
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * 
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * 
	 * @return String
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * 
	 * @param bookname
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * 
	 * @return String
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}
	/**
	 * 
	 * @param bookauthor
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	/**
	 * 
	 * @return
	 */
	public String getBookImage() {
		return bookImage;
	}
	/**
	 * 
	 * @param bookimage
	 */
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	/**
	 * 
	 * @return String
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * 
	 * @param summary
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 
	 * @return String
	 */
	public BookType getBookType() {
		return bookType;
	}
	/**
	 * 
	 * @param booktype
	 */

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	
	

}
