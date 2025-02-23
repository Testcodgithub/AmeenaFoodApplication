package com.ameena.model;

public class OrderIteam {
	private int orderIteamId;
	private int orderId;
	private int menuId;
	private int quantity;
	private float subTotal;
	public OrderIteam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderIteam(int orderIteamId, int orderId, int menuId, int quantity, float subTotal) {
		super();
		this.orderIteamId = orderIteamId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	public int getOrderIteamId() {
		return orderIteamId;
	}
	public void setOrderIteamId(int orderIteamId) {
		this.orderIteamId = orderIteamId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "OrderIteam [orderIteamId=" + orderIteamId + ", orderId=" + orderId + ", menuId=" + menuId
				+ ", quantity=" + quantity + ", subTotal=" + subTotal + "]";
	}
	
}
