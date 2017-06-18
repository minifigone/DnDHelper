package edu.wit.cs.castlet1.COMP1050.FinalProject;

import java.io.Serializable;

/**
 * COMP1050-05
 * Final Project (due 2017-4-11)
 * 
 * Item Class
 * 
 * Item objects to represent items in the game of Dungeons and Dragons
 * 
 * Stores name, price, weight of the item
 * 
 * Implements Serializable of it can be stored in a serialized file format with other components of the character
 * 
 * @author Tom Castle <castlet1>
 *
 */

public class Item implements Serializable {
	/**
	 * Instance Variables
	 */
	
	/**
	 * Item name
	 */
	private String name;
	
	/**
	 * Item price, stored in copper pieces
	 */
	private int price;
	
	/**
	 * Weight of the currency of the price
	 * c for copper pieces (cp)
	 * s for silver pieces (sp)
	 * g for gold pieces (gp)
	 * p for platinum pieces (pp)
	 */
	private char currencyWeight;
	
	/**
	 * Item weight, in pounds
	 */
	private double weight;


	/**
	 * Constructor for creating items
	 * 
	 * @param name
	 * @param price
	 * @param currencyWeight c for cp, s for sp, g for gp, p for pp; created by radial buttons in GUI
	 */
	public Item(String name, int price, char currencyWeight, double weight){
		this.name = name;
		this.price = price;
		this.currencyWeight = currencyWeight;
		this.weight = weight;
	}
	
	@Override
	/**
	 * @return formatted string containing the name, weight, and value of the item object
	 */
	public String toString(){
		return String.format("%s: %.1f lbs, %s", this.getName(), this.weight, this.getPrice());
	}
	
	/**
	 * @return name of the item object
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * @return formatted string containing the price of the item object and the weight of the currency
	 */
	public String getPrice(){
		return String.format("%d %cp", this.price, this.currencyWeight);
	}
	
	/**
	 * Exchange rate:
	 * 
	 * Coin			cp		sp		gp		pp
	 * Copper	cp	1		1/10	1/100	1/1000
	 * Silver	sp	10		1		1/10	1/100
	 * Gold		gp	100		10		1		1/10
	 * Platinum	pp	1000	100		10		1
	 * 
	 * @return integer value of the price of the item object in copper pieces
	 */
	public int priceInCopper(){
		if(this.currencyWeight == 'c'){
			return this.price;
		}else if(this.currencyWeight == 's'){
			return this.price * 10;
		}else if(this.currencyWeight == 'g'){
			return this.price * 100;
		}else if(this.currencyWeight == 'p'){
			return this.price * 1000;
		}else{
			//this condition should not be triggered.
			return this.price;
		}
	}
	
	/**
	 * @return weight of the currency the value of the item object is measured in
	 */
	protected char getCurrencyWeight(){
		return this.currencyWeight;
	}
	
	/** 
	 * @return weight of the item object
	 */
	public double getWeight(){
		return this.weight;
	}
}
