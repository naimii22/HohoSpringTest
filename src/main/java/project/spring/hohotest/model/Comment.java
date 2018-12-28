package project.spring.hohotest.model;

public class Comment {

	private int id;
	private int member_id;
	private int review_id;
	private String content;
	private String reg_date;
	private String edit_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getEdit_date() {
		return edit_date;
	}
	public void setEdit_date(String edit_date) {
		this.edit_date = edit_date;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", member_id=" + member_id + ", review_id=" + review_id + ", content=" + content
				+ ", reg_date=" + reg_date + ", edit_date=" + edit_date + "]";
	}
}
