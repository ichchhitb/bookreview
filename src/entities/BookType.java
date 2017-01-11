package entities;

import java.io.Serializable;

public class BookType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String booktypeid;
	String booktypename;
	/**
	 * 
	 */
	public BookType() {
		
	}
	/**
	 * 
	 * @return
	 */
	public String getBooktypeid() {
		return booktypeid;
	}
	/**
	 * 
	 * @param booktypeid, booktypename
	 */
	public BookType(String booktypeid, String booktypename) {
		super();
		this.booktypeid = booktypeid;
		this.booktypename = booktypename;
	}
	/**
	 * 
	 * @param booktypeid
	 */
	public void setBooktypeid(String booktypeid) {
		this.booktypeid = booktypeid;
	}
	/**
	 * 
	 * @return
	 */
	public String getBooktypename() {
		return booktypename;
	}
	/**
	 * 
	 * @param booktypename
	 */
	public void setBooktypename(String booktypename) {
		this.booktypename = booktypename;
	}
	

}
