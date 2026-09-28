package com.car.entity;
import javax.persistence.*;

@Entity
@Table(name = "car")
public class car {


	public car(int id, String brand, String model, long price, String colour) {
		super();
		this.id = id;
		Brand = brand;
		Model = model;
		Price = price;
		Colour = colour;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String Brand;
    private String Model;
    private long Price;
    private String Colour;
    
 
    public car() {
		
		
	}
    
    
    
    
    

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