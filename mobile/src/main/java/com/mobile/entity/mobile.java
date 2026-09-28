package com.mobile.entity;
import javax.persistence.*;

@Entity
@Table(name = "mobile")
public class mobile{
	
	private String Brand;
    private String Model;
    private long Price;
    private String Colour;



	public mobile(String brand, String model, long price, String colour, int id) {
		super();
		Brand = brand;
		Model = model;
		Price = price;
		Colour = colour;
		this.id = id;
	}
	public mobile() {
		
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public long getPrice() {
		return Price;
	}
	public void setPrice(long price) {
		Price = price;
	}
	public String getColour() {
		return Colour;
	}
	public void setColour(String colour) {
		Colour = colour;
	}

    
 
    }
    
