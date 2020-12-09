package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "events")
public class Event {
	
	@Id
	private long id;
	@NonNull
	private String eventName; 
	@NonNull
	private String imgURL;

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventNAme=" + eventName + ", imgUrl=" + imgURL + "]";
	}

	public Event(String eventNAme, String imgUrl, String eventName) {
		super();

		this.eventName = eventName;
		this.imgURL = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEventNAme() {
		return eventName;
	}

	public void setEventNAme(String eventName) {
		this.eventName = eventName;
	}

	public String getImgUrl() {
		return imgURL;
	}

	public void setImgUrl(String imgUrl) {
		this.imgURL = imgUrl;
	}

}