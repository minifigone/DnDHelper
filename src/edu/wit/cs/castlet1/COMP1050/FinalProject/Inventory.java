package edu.wit.cs.castlet1.COMP1050.FinalProject;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * COMP1050-05
 * Final Project (due 2017-4-11)
 * 
 * Inventory Class
 * 
 * Collection of Items, displayed in a ListView in the GUI
 * 
 * Implements Serializable of it can be stored in a serialized file format with other components of the character
 * 
 * @author Tom Castle <castlet1>
 *
 */

public class Inventory extends List implements Serializable {
	/**
	 * inv ArrayList of items that are in the inventory
	 */
	private ArrayList<Item> inv;
	
	/**
	 * Constructor for creating Inventory objects
	 */
	public Inventory(){
		this.inv = new ArrayList<>();
	}
	
	/**
	 * Adds the supplied item to the internal ArrayList
	 * 
	 * @param im Item to be added
	 */
	public void add(Item im){
		this.inv.add(im);
	}
	
	/**
	 * Removes the item at the specified index from the internal array
	 * 
	 * @param index index of item to be removed
	 */
	public void remove(int index){
		this.inv.remove(index);
	}
	
	/**
	 * Returns the total weight of the inventory, a sum of the weights of all of the items in the inventory
	 * 
	 * @return total weight
	 */
	public double totalWeight(){
		double w = 0;
		
		for(int i = 0; i < this.inv.size(); i++){
			w += this.inv.get(i).getWeight();
		}
		
		return w;
	}
	
	/**
	 * Returns the total value of the inventory, a sum of the values of all of the items in the inventory, in gold pieces
	 * 
	 * @return total value in gold pieces
	 */
	public double totalValueInGP(){
		int v = 0;
		
		for(int i = 0; i < this.inv.size(); i++){
			v += this.inv.get(i).priceInCopper();
		}
		
		double vGP = (double) v / 100;
		
		return vGP;
	}
	
	/**
	 * Returns the contents of the Inventory as an ArrayList
	 * 
	 * @return contents of Inventory in an ArrayList
	 */
	public ArrayList<Item> invAsList(){
		return this.inv;
	}
}
