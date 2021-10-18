//----------------------------------------------------
//Assignment #4
//Written by: Arsany Fahmy (40157267)
//----------------------------------------------------

import java.util.Scanner;

/**
 * 
 * @author arsollo
 * 
 */
public class CellPhone 
{
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	Scanner Keyboard = new Scanner(System.in);
	
	//Constructor
	/**
	 * 
	 * @param sn serial number
	 * @param b brand
	 * @param y year
	 * @param p price
	 */
	public CellPhone(long sn, String b, int y, double p)
	{
		serialNum = sn;
		brand = b;
		year = y;
		price = p;
	}
	
	//Copy constructor
	/**
	 * 
	 * @param copy object being copied
	 * @param s serial number
	 */
	public CellPhone (CellPhone copy,long s)
	{
		serialNum = s;
		brand = copy.brand;
		year = copy.year;
		price = copy.price;
	}
	
	//clone
	public Object clone() 
	{ 
		System.out.print("Please enter a new serial number: ");
		this.serialNum = Keyboard.nextLong();
		
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Eroor couldn't clone ";
		}
	}
	
	
	//Getters and Setters
	public long getSerialNum() 
	{
		return serialNum;
	}
	public void setSerialNum(long serialNum) 
	{
		this.serialNum = serialNum;
	}
	public String getBrand() 
	{
		return brand;
	}
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}
	public int getYear() 
	{
		return year;
	}
	public void setYear(int year) 
	{
		this.year = year;
	}
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	
	//Tostring
	public String toString()
	{
		return "The cellphone has a price of " + price + " . It was made in " + year + 
				" . The brand is: " + brand + " . The serial number i: " + serialNum;
	}
	
	//equals
	public boolean equals(CellPhone obj)
	{
		if((this.year == obj.year) && (this.price == obj.price) && (this.brand == obj.brand))
		{
			return true;
		}
		else
			return false;
	}
	
	
	
	
	
}
