package edu.wit.cs.castlet1.COMP1050.FinalProject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * COMP1050-05
 * Final Project (due 2017-4-11)
 * 
 * SpellBook Class
 * 
 * Collection of spells, displayed in a ListView in the GUI
 * 
 * Implements Serializable of it can be stored in a serialized file format with other components of the character
 * 
 * @author Tom Castle <castlet1>
 *
 */

public class SpellBook implements Serializable{
	/**
	 * Book ArrayList of spells that are in the spellbook
	 */
	private ArrayList<Spell> book;
	
	/**
	 * Constructor for creating SpellBook objects
	 */
	public SpellBook(){
		this.book = new ArrayList<>();
	}	
	
	/**
	 * Adds a spell to the internal ArrayList
	 * 
	 * @param spell spell item to add
	 */
	public void add(Spell spell){
		this.book.add(spell);
	}
	
	/**
	 * Gets the spell at the specified index, null if index is invalid
	 * 
	 * @param index of spell requested
	 * @return spell at requested index, null if index is invalid
	 */
	public Spell get(int index){
		if(index <= 0 && index < this.book.size()){
			return this.book.get(index);
		}
		return null;
	}
	
	/**
	 * Returns the contents of the SpellBook as an ArrayList
	 * 
	 * @return AraryList of contents of SpellBook
	 */
	public ArrayList<Spell> sbAsList(){
		return this.book;
	}
}
