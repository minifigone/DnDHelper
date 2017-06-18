package edu.wit.cs.castlet1.COMP1050.FinalProject;

/**
 * Computer Science II Final Project
 * COMP 1050-05 Spring 2017
 * Due: April 11th, 2017 5pm
 * 
 * This class serves as the object with which to create the structure for storing variables.
 * Creates an Inventory and a SpellBook for storing Item Spell objects, respectively.
 * 
 * @author Aiden Wells <wellsa1>
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DnDCharacter implements Serializable, Comparable<DnDCharacter> {
	private Map<String, Integer> stats=new HashMap<>();
	private Map<String, String> stringStats=new HashMap<>();
	private Map<String, Boolean> skills=new HashMap<>(); 
	//each character is "equipped" with an inventory and a spellbook
	Inventory inv;
	SpellBook spllBk;
	/**
	 * Constructor for each character (PC & NPC)
//	 * @param name character name (first and last)
	 * @return loaded character from specified file
	 */
	public static DnDCharacter loadChar(String filePath, DnDCharacter c){
		try {
			FileInputStream inFile=new FileInputStream(filePath);
			ObjectInputStream input=new ObjectInputStream(inFile);
			c=(DnDCharacter)input.readObject();
			input.close();
			inFile.close();
			return c;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//error return
		System.out.print("Null returned for loaded character.");
		return null;
	}
	/**
	 * Saves character Object to the save folder, DnDHelper, in the Documents folder.
//	 * @param name character name (stats.get("charNme"))
	 */
	public void saveChar(){
		String direc=System.getProperty("user.home")+File.separator+"Documents"+File.separator+"DnDHelper";
		File saveDir=new File(direc);
		if(!saveDir.exists()){
			saveDir.mkdirs();
		}
		try {
			OutputStream outFile = new FileOutputStream(direc+File.separator+stringStats.get("charNme")+".ser");
			ObjectOutput output=new ObjectOutputStream(outFile);
			output.writeObject(this);
			output.close();
			outFile.close();
		} catch (IOException e) {
			System.out.println("object was not successfully serialized.");
			e.printStackTrace();
		}	
	}
	/**
	 * Basic constructor for new character object with default values.
	 * Values can be filled in GUI or loaded from file.
	 */
	public DnDCharacter(){
		inv=new Inventory();
		spllBk=new SpellBook();	

		//main stats
		stats.put("str", 0);
		stats.put("dex", 0);
		stats.put("con", 0);
		stats.put("ntl", 0);
		stats.put("wis", 0);
		stats.put("cha", 0);

		//roll mods
		stats.put("strMod", 0);
		stats.put("dexMod", 0);
		stats.put("conMod", 0);
		stats.put("ntlMod", 0);
		stats.put("wisMod", 0);
		stats.put("chaMod", 0);

		//saving throws
		stats.put("strST", 0);
		stats.put("dexST", 0);
		stats.put("conST", 0);
		stats.put("ntlST", 0);
		stats.put("wisST", 0);
		stats.put("chaST", 0);

		//needs simple get/set
		stats.put("exp", 0);
		stats.put("lvl", 1);
		stats.put("ammo", 0);
		stats.put("mny", 0);
		stats.put("age", 0);
		stats.put("hght", 0);
		stats.put("wght", 0);
		stats.put("hlth", 0);

		stats.put("spd", 0);
		stats.put("ac", 0);
		stats.put("profBns", 0);
		stats.put("pasWis", 0);
		stats.put("init", 0);
		stats.put("initRoll", 0);
		stats.put("htDce", 0);
		
		//money
		stats.put("pp", 0);
		stats.put("gp", 0);
		stats.put("sp", 0);
		stats.put("cp", 0);

		//short string stats
		stringStats.put("clss", "");
		stringStats.put("plyrNme", "");
		stringStats.put("charNme", "");
		stringStats.put("race", "");
		stringStats.put("algmnt", "");

		//longer string
		stringStats.put("notes", "");

		//skill booleans
		skills.put("acro", false);
		skills.put("anim", false);
		skills.put("arca", false);
		skills.put("athl", false);
		skills.put("dece", false);
		skills.put("hist", false);
		skills.put("insi", false);
		skills.put("inti", false);
		skills.put("inve", false);
		skills.put("medi", false);
		skills.put("natu", false);
		skills.put("perc", false);
		skills.put("perf", false);
		skills.put("pers", false);
		skills.put("reli", false);
		skills.put("slei", false);
		skills.put("stea", false);
		skills.put("surv", false);
	}
	/**
	 * Grabs int value of given stat, formatted to return as a String.
	 * @param s stat to be grabbed
	 * @return value of specified stat
	 */
	public String getIntStat(String s){
		return String.valueOf(stats.get(s));
	}
	/**
	 * Sets an int stat in the map.
	 * Used for stats in the "stats" map.
	 * @param s stat to be adjusted
	 * @param value of stat
	 */
	public void set(String s, int value){
		stats.put(s, value);
	}
	/**
	 * Grabs String value of given stat.
	 * Use for short strings and notes.
	 * @param s stat to be grabbed
	 * @return value of specified stat
	 */
	public String getStringStat(String s){
		return stringStats.get(s);
	}
	/**
	 * Sets a string stat in the map.
	 * Use for short strings and notes.
	 * @param s stat to be adjusted
	 * @param info new value of stat
	 */
	public void set(String s, String info){
		stringStats.put(s, info);
	}
	/**
	 * Grabs the boolean value of given stat.
	 * Specifically, booleans for the skills.
	 * @param s stat to be grabbed
	 * @return
	 */
	public boolean getBooleanStat(String s){
		return skills.get(s);
	}
	/**
	 * Sets boolean that represents if the given skill should get a bonus modifier.
	 * @param s skill to check
	 * @param b value to assign
	 */
	public void set(String s, boolean b){
		skills.put(s, b);
	}
	/**
	 * Calculate roll modifier for given stat.
	 * @param s stat to be calculated
	 * @param v value of main stat whose modifier is being calculated
	 */
	public void setRollMod(String s, int v){
		stats.put(s+"Mod", v/2-5);
		
	}
	/**
	 * Set the main stats and their matching roll modifier.
	 * Only for use with str, dex, con, ntl, wis, and cha.
	 * @param s stat name
	 * @param v new value
	 */
	public void setStat(String s, int v){
		stats.put(s, v);
		setRollMod(s, v);
	}
	/**
	 * Sets proficiency bonus based on provided level.
	 * @param lvl 
	 */
	private void setProfBns(int lvl){
		stats.put("profBns", (lvl-1)/4+2);
	}
	/**
	 * Sets level and adjusts proficiency bonus if needed.
	 * @param lvl current character level
	 */
	private void setLvl(int lvl){
		stats.put("lvl", lvl);
		setProfBns(lvl);
	}
	/**
	 * Sets experience points and adjusts level and proficiency bonus if needed.
	 * @param exp total experience points
	 */
	public String CalculateLvl(int exp){
		int lvl;
		stats.put("exp", exp);
		if(exp<300){
			lvl=1;
		}else if(exp<900){
			lvl=2;
		}else if(exp<2700){
			lvl=3;
		}else if(exp<6500){
			lvl=4;
		}else if(exp<14000){
			lvl=5;
		}else if(exp<23000){
			lvl=6;
		}else if(exp<34000){
			lvl=7;
		}else if(exp<48000){
			lvl=8;
		}else if(exp<64000){
			lvl=9;
		}else if(exp<85000){
			lvl=10;
		}else if(exp<100000){
			lvl=11;
		}else if(exp<120000){
			lvl=12;
		}else if(exp<140000){
			lvl=13;
		}else if(exp<165000){
			lvl=14;
		}else if(exp<195000){
			lvl=15;
		}else if(exp<225000){
			lvl=16;
		}else if(exp<25000){
			lvl=17;
		}else if(exp<305000){
			lvl=18;
		}else if(exp<355000){
			lvl=19;
		}else{
			lvl=20;
		}
		setLvl(lvl);
		return String.valueOf(lvl);
	}
	/**
	 * Sets the saving throws bonus modifiers given a character class.
	 * @param clss of the character
	 */
	private void setST(String clss){
		int prof=stats.get("profBns");
		if(clss.equalsIgnoreCase("Barbarian")){
			stats.put("strST", prof);
			stats.put("conST", prof);
		}else if(clss.equalsIgnoreCase("Bard")){
			stats.put("dexST", prof);
			stats.put("chaST", prof);
		}else if(clss.equalsIgnoreCase("Cleric")){
			stats.put("wisST", prof);
			stats.put("chaST", prof);
		}else if(clss.equalsIgnoreCase("Druid")){
			stats.put("ntlST", prof);
			stats.put("wisST", prof);
		}else if(clss.equalsIgnoreCase("Fighter")){
			stats.put("strST", prof);
			stats.put("conST", prof);
		}else if(clss.equalsIgnoreCase("Monk")){
			stats.put("strST", prof);
			stats.put("dexST", prof);
		}else if(clss.equalsIgnoreCase("Paladin")){
			stats.put("wisST", prof);
			stats.put("chaST", prof);
		}else if(clss.equalsIgnoreCase("Ranger")){
			stats.put("strST", prof);
			stats.put("dexST", prof);
		}else if(clss.equalsIgnoreCase("Rogue")){
			stats.put("dexST", prof);
			stats.put("ntlST", prof);
		}else if(clss.equalsIgnoreCase("Sorcerer")){
			stats.put("conST", prof);
			stats.put("chaST", prof);
		}else if(clss.equalsIgnoreCase("Warlock")){
			stats.put("wisST", prof);
			stats.put("chaST", prof);
		}else if(clss.equalsIgnoreCase("Wizard")){
			stats.put("ntlST", prof);
			stats.put("wisST", prof);
		}else{
			//no bonus for non-basic character classes
		}
	}
	/**
	 * Determines the modifier for the given skill.
	 * @param skill to find modifier for
	 * @return modifier, formatted into a String
	 */
	public String getSkillMod(String skill){
		if (skills.get(skill)){
			String re="+";
			if(skill.equals("athl")){
				re+=getIntStat("strMod");
			}else if(skill.equals("acro")||skill.equals("stea")){
				re+=getIntStat("dexMod");
			}else if(skill.equals("arca")||skill.equals("hist")||skill.equals("inve")||skill.equals("natu")||skill.equals("reli")){
				re+=getIntStat("ntlMod");
			}else if(skill.equals("anim")||skill.equals("insi")||skill.equals("medi")||skill.equals("perc")||skill.equals("surv")){
				re+=getIntStat("wisMod");
			}else if(skill.equals("dece")||skill.equals("inti")||skill.equals("perf")||skill.equals("pers")){
				re+=getIntStat("chaMod");
			}else{
				//no other skills
			}
			return re;
		}
		//0 return if skill not checked
		return "+0";
	}
	/**
	 * Set the class of the character and the saving throws associated with it.
	 * @param s class to be set
	 */
	public void setClass(String s){
		stringStats.put("clss", s);
		setST(s);
	}
	/**
	 * Compare function used to determine order in the initiative queue.
	 * @return 1 if loaded character is less than, -1 if greater than, 0 if equal
	 */
	@Override
	public int compareTo(DnDCharacter dc) {
		if(Integer.parseInt(this.getIntStat("initRoll")) + Integer.parseInt(this.getIntStat("init")) < 
		Integer.parseInt(dc.getIntStat("initRoll")) + Integer.parseInt(dc.getIntStat("init"))){
			return 1;
		}else if(Integer.parseInt(this.getIntStat("initRoll")) + Integer.parseInt(this.getIntStat("init")) > 
		Integer.parseInt(dc.getIntStat("initRoll")) + Integer.parseInt(dc.getIntStat("init"))){
			return -1;
		}else{
			return 0;
		}
		//return 0;
	}
}