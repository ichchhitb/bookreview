package entities;

import java.io.Serializable;
/**
 * BookType entity
 * @author ichchhitb
 *
 */
public class BookType implements Serializable{
	private static final long serialVersionUID = 1L;
	private String bookTypeId;
	private String bookTypeName;
	/**
	 * to create an empty object
	 */
	public BookType() {
		super();
	}
	/**
	 * 
	 * @param bookTypeid, bookTypeName
	 */
	public BookType(String bookTypeId, String bookTypeName) {
		super();
		this.bookTypeId = bookTypeId;
		this.bookTypeName = bookTypeName;
	}
	/**
	 * 
	 * @return
	 */
	public String getBookTypeId() {
		return bookTypeId;
	}
	
	/**
	 * 
	 * @param bookTypeid
	 */
	public void setBookTypeId(String bookTypeid) {
		this.bookTypeId = bookTypeid;
	}
	/**
	 * 
	 * @return
	 */
	public String getBookTypeName() {
		return bookTypeName;
	}
	/**
	 * 
	 * @param bookTypeName
	 */
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	

}
