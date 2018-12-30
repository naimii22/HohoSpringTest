package project.spring.hohotest.model;

public class Cart {
	private int id;
	private int member_id;
	private int product_id;
	private int amount;
	private int order_id;
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", member_id=" + member_id + ", product_id=" + product_id + ", amount=" + amount
				+ ", order_id=" + order_id + "]";
	}
}
