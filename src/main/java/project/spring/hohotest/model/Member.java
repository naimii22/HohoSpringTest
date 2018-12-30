package project.spring.hohotest.model;

public class Member {
	private int id;
	private String name;
	private String user_id;
	private String user_pw;
	private String email;
	private String gender;
	private String birthdate;
	private String tel;
	private String postcode;
	private String addr1;
	private String addr2;
	private String is_admin;
	private String newUserPw;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}
	public String getNewUserPw() {
		return newUserPw;
	}
	public void setNewUserPw(String newUserPw) {
		this.newUserPw = newUserPw;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", user_id=" + user_id + ", user_pw=" + user_pw + ", email="
				+ email + ", gender=" + gender + ", birthdate=" + birthdate + ", tel=" + tel + ", postcode=" + postcode
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", is_admin=" + is_admin + ", newUserPw=" + newUserPw + "]";
	}
}
