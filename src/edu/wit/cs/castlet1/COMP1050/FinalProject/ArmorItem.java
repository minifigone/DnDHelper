package edu.wit.cs.castlet1.COMP1050.FinalProject;

/**
 * COMP1050-05
 * Final Project (due 2017-4-11)
 * 
 * ArmorItem Class
 * 
 * Subclass of Item for specific armor items
 * 
 * Contains Armor Class modifier for the piece of armor
 * 
 * @author Tom Castle <castlet1>
 * 
 */

public class ArmorItem extends Item {
	/**
	 * Armor Class modifier
	 */
	private String ac;
	
	/**
	 * Constructor for creating ArmorItems
	 * 
	 * @param name Name of item
	 * @param ac Armor Class modifier of piece of armor
	 */
	public ArmorItem(String name, String ac) {
		super(name, 0, 'c', 0);
		this.ac = ac;
	}

	@Override
	/**
	 * @return formatted string containing name and armor class modifier of ArmorItem object
	 */
	public String toString(){
		return String.format("%s: %s", super.getName(), this.ac);
	}
}
