package com.orderAPI.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orderAPI.util.OrderStatus;
import com.orderAPI.util.OrderType;

//mark class as an Entity 
@Entity
// defining class name as Table name
@Table
public class Orders {
	// Defining book id as primary key
	@Id
	@Column
	private int orderid;
	@Column
	private String orderName;
	@Column
	private String orderQuantity;
	@Column
	private OrderStatus status;
	@Column
	private OrderType type;
	@Column
	private int price;
	@CreationTimestamp
	@Column
	private Date date;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	
}