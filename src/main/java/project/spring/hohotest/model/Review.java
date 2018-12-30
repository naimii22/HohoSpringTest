package project.spring.hohotest.model;

public class Review {
	private int id;
	private int member_id;
	private int product_id;
	private String title;
	private String content;
	private int rating;
	private String image;
	private int hit;
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
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
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
		return "Review [id=" + id + ", member_id=" + member_id + ", product_id=" + product_id + ", title=" + title
				+ ", content=" + content + ", rating=" + rating + ", image=" + image + ", hit=" + hit + ", reg_date="
				+ reg_date + ", edit_date=" + edit_date + "]";
	}
}
