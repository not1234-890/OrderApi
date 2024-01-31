package com.naceAPI.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.naceDetails.util.OrderStatus;
import com.naceDetails.util.OrderType;

//mark class as an Entity 
@Entity
// defining class name as Table name
@Table
public class Nace {
	// Defining book id as primary key
	@Id
	@Column
	private int order;
	@Column
	private String level;
	@Column
	private String code;
	@Column
	private OrderStatus parent;
	@Column
	private OrderType description;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public OrderStatus getParent() {
		return parent;
	}

	public void setParent(OrderStatus parent) {
		this.parent = parent;
	}

	public OrderType getDescription() {
		return description;
	}

	public void setDescription(OrderType description) {
		this.description = description;
	}

}