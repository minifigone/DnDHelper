package edu.wit.cs.castlet1.COMP1050.FinalProject;

/**
 * COMP1050-05
 * Final Project (due 2017-4-11)
 * 
 * WeaponItem Class
 * 
 * Subclass of Item for for specific weapon items
 * 
 * Contains Damage and Attack Bonus for a specific weapon
 * 
 * @author Tom Castle <castlet1>
 *
 */

public class WeaponItem extends Item {
	/**
	 * Damage (dice rolled to get damage)
	 */
	private String damage;
	/**
	 * Attack Bonus (added to attack roll)
	 */
	private String attackBonus;
	
	/**
	 * Constructor for creating WeaponItems
	 * 
	 * @param name name of WeaponItem
	 * @param atkBns Attack Bonus
	 * @param damage Damage
	 */
	public WeaponItem(String name, String atkBns, String damage) {
		super(name, 0, 'c', 0);
		this.damage = damage;
		this.attackBonus = atkBns;
	}

	@Override
	/**
	 * @return formatted string containing name, attack bonus, and damage of ArmorItem object
	 */
	public String toString(){
		return String.format("%s: %s Attack Bonus, %s Damage", super.getName(), this.attackBonus, this.damage);
	}
}
