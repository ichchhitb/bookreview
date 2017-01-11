package entities;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String isbn;
	String bookname;
	String bookauthor;
	String bookimage;
	String summary;
	BookType booktype;
	/**
	 * 
	 */
	public Book() {
		
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
