package com.thecodereveal.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "PRODUCT_ID",nullable = false,unique = true)
	private String  productId;
	
	@Column(name = "PRODUCT_NAME",nullable = false)
	private String  productName;
	@Column(name = "price",nullable = false)
	private Double  productPrice;
	
	@Column(name = "PRODUCT_CATEGORY",nullable = false)
	private String  productCategory;
	
	@Column(name = "IMAGE_URL")
	private String  productImgurl;
	
	@Column(name = "PRODUCT_NUMBER")
	private Integer productNum = 0;
	
	@Column(name = "PRODUCT_DESCRIPTION")
	private String  productDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductImgurl() {
		return productImgurl;
	}

	public void setProductImgurl(String productImgurl) {
		this.productImgurl = productImgurl;
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCategory=" + productCategory + "]";
	}
	
	
}
