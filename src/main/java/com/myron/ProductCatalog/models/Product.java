package com.myron.ProductCatalog.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=2, max=255)
	@JsonProperty("name")
	private String name;
	
	@Size(min=2, max=255)
	@JsonProperty("description")
	private String description;
	
	@Min((long) 0.01)
	@JsonProperty("price")
	private Float price;
	
	@DateTimeFormat(pattern = "MM/dd/yyy HH:mm:ss")
	private Date timeStamp;
	
	@PrePersist
    protected void onCreate(){
		this.setTimeStamp(new Date());
    }
	
	@PreUpdate
    protected void onUpdate(){
		this.setTimeStamp(new Date());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}
