package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "tickets")
public class Ticket {
	
	@Id
	private Integer id;
	private Integer quantity;
	private Integer price;
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(Integer id, Integer quantity, Integer price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public  void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public  void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", quantity=" + quantity + ", price=" + price + "]";
	}
	}