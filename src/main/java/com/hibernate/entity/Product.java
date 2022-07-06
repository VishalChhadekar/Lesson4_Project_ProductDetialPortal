package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductDetails")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "ProductId")
	private int pId;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "Name")
	private String pName;
	@Column(name = "Brand")
	private String pBrand;
	@Column(name = "Model")
	private String pModel;
	@Column(name = "Price")
	private double pPrice;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getpModel() {
		return pModel;
	}

	public void setpModel(String pModel) {
		this.pModel = pModel;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public Product(int pId, String pName, String pBrand, String pModel, double pPrice) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pModel = pModel;
		this.pPrice = pPrice;
	}

}