package entities;

import java.io.Serializable;

public class Review implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -652867132555411682L;
	private long reviewId;
	private String reviewTitle;
	private String comments;
	private int rating;
	private User user;
	private Book book;
	/**
	 * 
	 */
	public Review() {
		super();
	}
	/**
	 * @return the reviewId
	 */
	public long getReviewId() {
		return reviewId;
	}
	/**
	 * @return the reviewTitle
	 */
	public String getReviewTitle() {
		return reviewTitle;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * @param reviewId the reviewId to set
	 */
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	/**
	 * @param reviewTitle the reviewTitle to set
	 */
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * @param reviewId
	 * @param reviewTitle
	 * @param comments
	 * @param rating
	 * @param user
	 * @param book
	 */
	public Review(long reviewId, String reviewTitle, String comments, int rating, User user, Book book) {
		super();
		this.reviewId = reviewId;
		this.reviewTitle = reviewTitle;
		this.comments = comments;
		this.rating = rating;
		this.user = user;
		this.book = book;
	}
	
	
}
