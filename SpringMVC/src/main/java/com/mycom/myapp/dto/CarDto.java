package com.mycom.myapp.dto;

public class CarDto {
	private String name;
	private int price;
	private String brand;
	
	public CarDto() {
		
	}
	
	public CarDto(String name, int price, String brand) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	@Override
	public String toString() {
		return "CarDto [name=" + name + ", price=" + price + ", brand=" + brand + "]";
	}
	
	
}
