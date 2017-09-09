package jp.co.sisolution.example2;

import java.sql.Timestamp;

public class DestinationBean {
	private String productId;

	private int price;

	private Timestamp date;

	private String productImage;

	private String[] shopList;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String[] getShopList() {
		return shopList;
	}

	public void setShopList(String[] shopList) {
		this.shopList = shopList;
	}
}
