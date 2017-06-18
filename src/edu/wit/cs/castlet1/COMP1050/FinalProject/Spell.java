package edu.wit.cs.castlet1.COMP1050.FinalProject;

import java.io.Serializable;

import java.util.ArrayList;

/**
* Computer Science Final Project
* COMP1050, Spring 2017
* Due: April 11th, 2017
*
****************************
* Description
****************************
*
* Spell objects, to help players keep track of the all of the information spells in D&D contain 
* 
* Implements Serializable of it can be stored in a serialized file format with other components of the character
* 
****************************
* Analysis
****************************
*
* Inputs: name, level, components, range, aoe, via GUI
* 
* Outputs: formatted string
* 
* 
 * @author Scott Duncan
 * @author Tom Castle <castlet1>
 *
 */

public class Spell implements Serializable{
	/**
	 * Instance Variables
	 */
	
	/**
	 * Basic descriptors
	 * Name
	 * Level (0 - 9)
	 * School
	 */
	private String name;
	private int level;
	private String damage;
	
	/**
	 * Component types
	 * 0: Verbal
	 * 1: Somatic (Gestures)
	 * 2: Material
	 */
	private boolean[] components = {false, false, false};
	
	/**
	 * List for material components
	 */
	private ArrayList<String> materialComponents;
	
	/**
	 * Casting information
	 * Concentration: false - instant, true - concentrate
	 * Range (feet or self)
	 * AOE area of effect
	 * Duration time
	 */
	private boolean concentration;
	private String range;
	private String aoe;
	private String duration;
	
	/**
	 * Constructor for creating Spells
	 * 
	 * @param name
	 * @param level
	 * @param components
	 * @param concentration
	 * @param school
	 * @param materialComponents
	 * @param range
	 * @param aoe
	 * @param duration
	 */
	public Spell(String name, int level, boolean[] components, boolean concentration,
			String range, String aoe, String duration, String damage){
		this.name = name;
		this.level = level;
		this.components = components;
		this.concentration = concentration;
		this.range = range;
		this.aoe = aoe;
		this.duration = duration;
		this.damage = damage;
	}
	
	@Override
	/**
	 * "Name, level, Components (V, S, M), damage, range ft, area of effect"
	 * @return formatted string representation of the spell object
	 */
	public String toString(){
		StringBuilder components = new StringBuilder();
		
		if(this.components[0]){
			components.append('V');
			if(this.components[1] || this.components[2]){
				components.append(", ");
			}
		}
		if(this.components[1]){
			components.append('S');
			if(this.components[2]){
				components.append(", ");
			}
		}
		if(this.components[2]){
			components.append('M');
		}
		
		return String.format("%s: Level %d (%s); %s, %s ft %s", this.name, this.level, components.toString(), this.damage, this.range, this.aoe);
	}
}
