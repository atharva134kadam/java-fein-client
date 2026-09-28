package com.car.client;

public class MobileDto {
    private Integer id;
    private String brand;
    private String model;
    private long price;
    private String colour;

    public MobileDto() {}

    public MobileDto(String brand, String model, long price, String colour) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.colour = colour;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public long getPrice() { return price; }
    public void setPrice(long price) { this.price = price; }
    public String getColour() { return colour; }
    public void setColour(String colour) { this.colour = colour; }
}
