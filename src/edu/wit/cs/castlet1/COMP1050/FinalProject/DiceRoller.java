package edu.wit.cs.castlet1.COMP1050.FinalProject;

/**
 * Computer Science II Final Project
 * COMP 1050-05 Spring 2017
 * Due: April 11th, 2017 5pm
 * 
 * Pseudo-random number generator that serves as a dice roller.
 * 
 * @author Aiden Wells <wellsa1>
 */

import java.util.Random;

public class DiceRoller {
	/**
	 * "Rolls a die" with the number of sides given.
	 * @param sides number of sides on the die
	 * @return pseudo-random number between 1 and number of sides
	 */
	public static String roll(int sides){
		Random rando=new Random();

		return String.valueOf(rando.nextInt(sides)+1);
	}
}
