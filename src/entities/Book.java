package entities;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String bookname;
	private String bookauthor;
	private String bookimage;
	private String summary;
	private BookType booktype;
	public Book() {
		/**
		 * to create empty object
		 */
		
	}
	
	/**
	 * @param isbn
	 * @param bookname
	 * @param bookauthor
	 * @param bookimage
	 * @param summary
	 * @param booktype
	 */
	public Book(String isbn, String bookname, String bookauthor, String bookimage, String summary, BookType booktype) {
		this.isbn = isbn;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.bookimage = bookimage;
		this.summary = summary;
		this.booktype = booktype;
	}

	/**
	 * 
	 * @return
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
	 * @return
	 */
	public String getBookName() {
		return bookname;
	}
	/**
	 * 
	 * @param bookname
	 */
	public void setBookName(String bookName) {
		this.bookname = bookName;
	}
	/**
	 * 
	 * @return
	 */
	public String getBookAuthor() {
		return bookauthor;
	}
	/**
	 * 
	 * @param bookauthor
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookauthor = bookAuthor;
	}
	/**
	 * 
	 * @return
	 */
	public String getBookImage() {
		return bookimage;
	}
	/**
	 * 
	 * @param bookimage
	 */
	public void setBookImage(String bookimage) {
		this.bookimage = bookimage;
	}
	/**
	 * 
	 * @return
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
	 * @return
	 */
	public BookType getBooktype() {
		return booktype;
	}
	/**
	 * 
	 * @param booktype
	 */

	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}
	
	

}
