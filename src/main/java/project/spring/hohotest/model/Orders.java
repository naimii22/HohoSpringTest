package project.spring.hohotest.model;

public class Orders {
	private int id;
	private int member_id;
	private String reg_date;
	private int total;
	private int status;
	
	// member DB의 user_id 받을 것 추가
//	private String user_id;
	
	// 페이징 구현을 위해 추가
	private int limitStart;
	private int listCount;
	
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
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
//	public String getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(String user_id) {
//		this.user_id = user_id;
//	}
	public int getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", member_id=" + member_id + ", reg_date=" + reg_date + ", total=" + total
				+ ", status=" + status + ", limitStart=" + limitStart + ", listCount=" + listCount + "]";
	}
}