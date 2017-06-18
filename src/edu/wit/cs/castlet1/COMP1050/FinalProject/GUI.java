package edu.wit.cs.castlet1.COMP1050.FinalProject;

import java.io.File;
import java.util.PriorityQueue;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
* Computer Science II Final Project
* COMP 1050-05 Spring 2017
* Due: April 11th, 2017 5pm
*
****************************
* Description
****************************
*
* the program is the main for the package. the program makes a gui that the user can interact with. 
* once the user fills out the text field, the user can save the file, then load the file from a file created
* by the program. GUI also controls anychanges that need to be made to the document. it will update textfields and listviews when 
* needed.
* 
****************************
* Analysis
****************************
*
* Inputs: GUI.fxml
* 
* Outputs: user interface
* 
* 
* @author Scott Duncan
* @author Tom Castle <castlet1>
*
*/

public class GUI extends Application {
	
	/**
	 * static objects for working components of the program
	 */
	static ObservableList<String> currency = FXCollections.observableArrayList("cp", "sp", "gp", "pp");
	
	static DnDCharacter loadedCharacter = new DnDCharacter();

	static Inventory currentInv = new Inventory(); 
	static SpellBook currentSpellBook = new SpellBook();
	
	static PriorityQueue<DnDCharacter> initQueue = new PriorityQueue<>();
	
 	/**
 	 * way too many fxml imports
	 */
	@FXML
	private AnchorPane anchorpane;
	
	@FXML
    private MenuItem menuCharLoad;

    @FXML
    private MenuItem menuCharSave;

	@FXML
	private TextField str;

	@FXML
	private TextField intel;

	@FXML
	private TextField dex;

	@FXML
	private TextField wis;

	@FXML
	private TextField con;

	@FXML
	private TextField cha;

	@FXML
	private Text sm;

	@FXML
	private Text chm;

	@FXML
	private Text wm;

	@FXML
	private Text im;

	@FXML
	private Text com;

	@FXML
	private Text dm;

	@FXML
	private TextField Name;

	@FXML
	private TextField Class;

	@FXML
	private TextField Race;
	
    @FXML
    private TextField player;

    @FXML
    private TextField charLvl;

    @FXML
    private TextField wn;

    @FXML
    private TextField ab;

    @FXML
    private TextField damd;

    @FXML
    private Button wadd;

    @FXML
    private ListView<Item> wList;

    @FXML
    private TextField na;

    @FXML
    private TextField aacb;

    @FXML
    private TextField p;

    @FXML
    private Button aadd;

    @FXML
    private ListView<Item> aList;
    
	@FXML
	private TextField Alignment;

	@FXML
	private TextField ac;

	@FXML
	private TextField init;

	@FXML
	private TextField speed;

	@FXML
	private TextField hp;

	@FXML
	private TextField exp;

	@FXML
	private TextField hd;

	@FXML
	private CheckBox perc;

	@FXML
	private CheckBox stl;

	@FXML
	private CheckBox sof;

	@FXML
	private CheckBox rel;

	@FXML
	private CheckBox pers;

	@FXML
	private CheckBox nat;

	@FXML
	private CheckBox med;

	@FXML
	private CheckBox intimid;

	@FXML
	private CheckBox ins;

	@FXML
	private CheckBox arc;

	@FXML
	private CheckBox acro;

	@FXML
	private CheckBox his;

	@FXML
	private CheckBox dec;

	@FXML
	private CheckBox ath;

	@FXML
	private CheckBox ani;

	@FXML
	private CheckBox inv;

	@FXML
	private CheckBox sur;

	@FXML
	private CheckBox perf;

	@FXML
	private TextField sur_mod;

	@FXML
	private TextField sof_mod;

	@FXML
	private TextField rel_mod;

	@FXML
	private TextField pers_mod;

	@FXML
	private TextField perc_mod;

	@FXML
	private TextField nat_mod;

	@FXML
	private TextField med_mod;

	@FXML
	private TextField inv_mod;

	@FXML
	private TextField intimid_mod;

	@FXML
	private TextField ins_mod;

	@FXML
	private TextField his_mod;

	@FXML
	private TextField dec_mod;

	@FXML
	private TextField perf_mod;

	@FXML
	private TextField ath_mod;

	@FXML
	private TextField arc_mod;

	@FXML
	private TextField ani_mod;

	@FXML
	private TextField acro_mod;

	@FXML
	private TextField stl_mod;

	@FXML
	private TextArea notes;
	
	@FXML
	private Text invinfo;
	
	@FXML
	private ListView<Item> viewInv;

    @FXML
    private TextField fourRoll;

    @FXML
    private TextField sixRoll;

    @FXML
    private TextField eightRoll;

    @FXML
    private TextField tenRoll;

    @FXML
    private TextField twelveRoll;

    @FXML
    private TextField twentyRoll;

    @FXML
    private Button fourButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button tenButton;

    @FXML
    private Button twelveButton;

    @FXML
    private Button tewentyButton;
    
    @FXML
    private TextField noi;

    @FXML
    private TextField poi;

    @FXML
    private ComboBox<String> cw;

    @FXML
    private TextField woi;
    
    @FXML
    private TextField sn;

    @FXML
    private TextField sl;

    @FXML
    private TextField sr;

    @FXML
    private TextField aoe;

    @FXML
    private TextField sd;

    @FXML
    private TextField dd;

    @FXML
    private CheckBox v;

    @FXML
    private CheckBox m;

    @FXML
    private CheckBox s;

    @FXML
    private CheckBox c;

    @FXML
    private Button as;
    
    @FXML
    private TextField nocText;

    @FXML
    private TextField inText;

    @FXML
    private TextField hlthText;

    @FXML
    private TextField arclText;

    @FXML
    private TextField spText;

    @FXML
    private TextField dextText;

    @FXML
    private Button qadd;

    @FXML
    private Button qclear;

    @FXML
    private Text noc;

    @FXML
    private Text in;

    @FXML
    private Text hlth;

    @FXML
    private Text arcl;

    @FXML
    private Text sp;

    @FXML
    private Text dext;

    @FXML
    private ListView<Spell> viewSpells;
	
    @FXML
    private Button nxtInQ;
    
    @FXML
    private TextField copper;

    @FXML
    private TextField silver;

    @FXML
    private TextField gold;

    @FXML
    private TextField platinum;

	public static void main(String[] args) {
		launch(args);

	}

	/**
	 * start sets the stage for the user interface to show on screen
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));

		

		Scene scene = new Scene(root);
		primaryStage.setTitle("Dungeons & Dragons Helper");
		primaryStage.setScene(scene);
		primaryStage.show();


	}
	/**
	 * initialize set variables before the stage is set. 
	 */
	@FXML
	void initialize() {
		cw.setItems(currency);

	}
	/**
	 * when the user enters a number into strength
	 * the action calculates the modifier, and changes
	 * text field accordingly
	 */
	@FXML
	void strModChange(){
		int st;
		String str_string = str.toString();
		str_string = str.getText();
		st = Integer.parseInt(str_string);
		st = (st/2)-5;
		str_string = String.format("+%d", st);
		sm.setText(str_string);		
	}
	/**
	 * when the user enters a number into Dexterity
	 * the action calculates the modifier, and changes
	 * text field accordingly
	 */
	@FXML
	void dexModChange(){
		int de;
		String dex_string;
		dex_string = dex.getText();
		de = Integer.parseInt(dex_string);
		de = (de/2)-5;
		dex_string = String.format("+%d", de);
		dm.setText(dex_string);		
	}
	/**
	 * when the user enters a number into Constitution
	 * the action calculates the modifier, and changes
	 * text field accordingly
	 */
	@FXML
	void conModChange(){
		int co;
		String con_string;
		con_string = con.getText();
		co = Integer.parseInt(con_string);
		co = (co/2)-5;
		con_string = String.format("+%d", co);
		com.setText(con_string);		
	}
	/**
	 * when the user enters a number into Intelligence
	 * the action calculates the modifier, and changes
	 * text field accordingly
	 */
	@FXML
	void intModChange(){
		int in;
		String in_string;
		in_string = intel.getText();
		in = Integer.parseInt(in_string);
		in = (in/2)-5;
		in_string = String.format("+%d", in);
		im.setText(in_string);		
	}
	/**
	 * when the user enters a number into Wisdom
	 * the action calculates the modifier, and changes
	 * text field accordingly
	 */
	@FXML
	void wisModChange(){
		int wi;
		String wis_string;
		wis_string = wis.getText();
		wi = Integer.parseInt(wis_string);
		wi = (wi/2)-5;
		wis_string = String.format("+%d", wi);
		wm.setText(wis_string);		
	}
	/**
	 * when the user enters a number into Charisma
	 * the action calculates the modifier, and changes
	 * text field accordingly
	 */
	@FXML
	void chaModChange(){
		int ch;
		String cha_string;
		cha_string = cha.getText();
		ch = Integer.parseInt(cha_string);
		ch = (ch/2)-5;
		cha_string = String.format("+%d", ch);
		chm.setText(cha_string);		
	}
	
	/** 	
	 * lets the user find a .ser file to load into the program, reads the 
	 * file, and puts the information in the correct fields.
	 */
	@FXML
	void loadCharFromFile(){
		Stage stage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Character File");
		File file = fileChooser.showOpenDialog(stage);
		
		loadedCharacter = DnDCharacter.loadChar(file.getAbsolutePath(), loadedCharacter);
			
		Name.setText(loadedCharacter.getStringStat("charNme"));
		Class.setText(loadedCharacter.getStringStat("clss"));
		Race.setText(loadedCharacter.getStringStat("race"));
		Alignment.setText(loadedCharacter.getStringStat("algmnt"));
		ac.setText(loadedCharacter.getIntStat("ac"));
		init.setText(loadedCharacter.getIntStat("init"));
		speed.setText(loadedCharacter.getIntStat("spd"));
		hp.setText(loadedCharacter.getIntStat("hlth"));
		exp.setText(loadedCharacter.getIntStat("exp"));
		hd.setText(loadedCharacter.getStringStat("htDce"));
		str.setText(loadedCharacter.getIntStat("str"));
		dex.setText(loadedCharacter.getIntStat("dex"));
		con.setText(loadedCharacter.getIntStat("con"));
		intel.setText(loadedCharacter.getIntStat("ntl"));
		wis.setText(loadedCharacter.getIntStat("wis"));
		cha.setText(loadedCharacter.getIntStat("cha"));
		player.setText(loadedCharacter.getStringStat("plyrNme"));
		charLvl.setText(loadedCharacter.getIntStat("lvl"));
		notes.setText(loadedCharacter.getStringStat("notes"));
		
		platinum.setText(loadedCharacter.getIntStat("pp"));
		gold.setText(loadedCharacter.getIntStat("gp"));
		silver.setText(loadedCharacter.getIntStat("sp"));
		copper.setText(loadedCharacter.getIntStat("cp"));
		
		strModChange();
		dexModChange();
		conModChange();
		intModChange();
		wisModChange();
		chaModChange();
		
		acro.setSelected(loadedCharacter.getBooleanStat("acro"));
		acro_mod.setText(loadedCharacter.getSkillMod("acro"));
		ani.setSelected(loadedCharacter.getBooleanStat("anim"));
		ani_mod.setText(loadedCharacter.getSkillMod("anim"));
		arc.setSelected(loadedCharacter.getBooleanStat("arca"));
		arc_mod.setText(loadedCharacter.getSkillMod("arca"));
		ath.setSelected(loadedCharacter.getBooleanStat("athl"));
		ath_mod.setText(loadedCharacter.getSkillMod("athl"));
		dec.setSelected(loadedCharacter.getBooleanStat("dece"));
		dec_mod.setText(loadedCharacter.getSkillMod("dece"));
		his.setSelected(loadedCharacter.getBooleanStat("hist"));
		his_mod.setText(loadedCharacter.getSkillMod("hist"));
		ins.setSelected(loadedCharacter.getBooleanStat("insi"));
		ins_mod.setText(loadedCharacter.getSkillMod("insi"));
		intimid.setSelected(loadedCharacter.getBooleanStat("inti"));
		intimid_mod.setText(loadedCharacter.getSkillMod("inti"));
		inv.setSelected(loadedCharacter.getBooleanStat("inve"));
		inv_mod.setText(loadedCharacter.getSkillMod("inve"));
		med.setSelected(loadedCharacter.getBooleanStat("medi"));
		med_mod.setText(loadedCharacter.getSkillMod("medi"));
		nat.setSelected(loadedCharacter.getBooleanStat("natu"));
		nat_mod.setText(loadedCharacter.getSkillMod("natu"));
		perc.setSelected(loadedCharacter.getBooleanStat("perc"));
		perc_mod.setText(loadedCharacter.getSkillMod("perc"));
		perf.setSelected(loadedCharacter.getBooleanStat("perf"));
		perf_mod.setText(loadedCharacter.getSkillMod("perf"));
		pers.setSelected(loadedCharacter.getBooleanStat("pers"));
		pers_mod.setText(loadedCharacter.getSkillMod("pers"));
		rel.setSelected(loadedCharacter.getBooleanStat("reli"));
		rel_mod.setText(loadedCharacter.getSkillMod("reli"));
		sof.setSelected(loadedCharacter.getBooleanStat("slei"));
		sof_mod.setText(loadedCharacter.getSkillMod("slei"));
		stl.setSelected(loadedCharacter.getBooleanStat("stea"));
		stl_mod.setText(loadedCharacter.getSkillMod("stea"));
		sur.setSelected(loadedCharacter.getBooleanStat("surv"));
		sur_mod.setText(loadedCharacter.getSkillMod("surv"));
		
		currentInv = loadedCharacter.inv;
		currentSpellBook = loadedCharacter.spllBk;
		invControl();
		spellsControl();
		
		wListControl();
		aListControl();
	}
	/**
	 *lets the user save the inputs to a .ser file,
	 *which can be loaded at a later date
	 */
	@FXML
	void saveCharToFile(){
		loadedCharacter.set("charNme", Name.getText());
		loadedCharacter.set("clss", Class.getText());
		loadedCharacter.set("race", Race.getText());
		loadedCharacter.set("algmnt", Alignment.getText());
		loadedCharacter.set("plyrNme", player.getText());
		loadedCharacter.set("ac", Integer.parseInt(ac.getText()));
		loadedCharacter.set("init", Integer.parseInt(init.getText()));
		loadedCharacter.set("spd", Integer.parseInt(speed.getText()));
		loadedCharacter.set("hlth", Integer.parseInt(hp.getText()));
		loadedCharacter.set("exp", Integer.parseInt(exp.getText()));
		loadedCharacter.set("lvl", Integer.parseInt(charLvl.getText()));
		loadedCharacter.set("htDce", hd.getText());
		loadedCharacter.setStat("str", Integer.parseInt(str.getText()));
		loadedCharacter.setStat("dex", Integer.parseInt(dex.getText()));
		loadedCharacter.setStat("con", Integer.parseInt(con.getText()));
		loadedCharacter.setStat("ntl", Integer.parseInt(intel.getText()));
		loadedCharacter.setStat("wis", Integer.parseInt(wis.getText()));
		loadedCharacter.setStat("cha", Integer.parseInt(cha.getText()));
		loadedCharacter.set("notes", notes.getText());
		
		loadedCharacter.set("pp", Integer.parseInt(platinum.getText()));
		loadedCharacter.set("gp", Integer.parseInt(gold.getText()));
		loadedCharacter.set("sp", Integer.parseInt(silver.getText()));
		loadedCharacter.set("cp", Integer.parseInt(copper.getText()));
		
		loadedCharacter.set("acro", acro.isSelected());
		loadedCharacter.set("anim", ani.isSelected());
		loadedCharacter.set("arca", arc.isSelected());
		loadedCharacter.set("athl", ath.isSelected());
		loadedCharacter.set("dece", dec.isSelected());
		loadedCharacter.set("hist", his.isSelected());
		loadedCharacter.set("insi", ins.isSelected());
		loadedCharacter.set("inti", intimid.isSelected());
		loadedCharacter.set("inve", inv.isSelected());
		loadedCharacter.set("medi", med.isSelected());
		loadedCharacter.set("natu", nat.isSelected());
		loadedCharacter.set("perc", perc.isSelected());
		loadedCharacter.set("perf", perf.isSelected());
		loadedCharacter.set("pers", pers.isSelected());
		loadedCharacter.set("reli", rel.isSelected());
		loadedCharacter.set("slei", sof.isSelected());
		loadedCharacter.set("stea", stl.isSelected());
		loadedCharacter.set("surv", sur.isSelected());
		
		loadedCharacter.inv = currentInv;
		loadedCharacter.spllBk = currentSpellBook;
		
		loadedCharacter.saveChar();
	}
	/**
	 *controls and sets the ListView in the inventory tab.
	 */
	@FXML
	void invControl(){
		ObservableList<Item> currentInvList = FXCollections.observableArrayList(currentInv.invAsList()); 

		viewInv.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>(){
			 
            @Override
            public ListCell<Item> call(ListView<Item> p) {
                 
                ListCell<Item> cell = new ListCell<Item>(){
 
                    @Override
                    protected void updateItem(Item t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.toString());
                        }else{
                        	setText(null);
                        }
                    }
 
                };
                 
                return cell;
            }

        });
		
		viewInv.setItems(currentInvList);
	}
	
	/**
 	 * when the "roll d4' button is pressed in the 
 	 * dice roller tab, a number between 1 and 4 
	 * and returns it.
	 */
	@FXML
	void four(){
		String s;
		
		s = DiceRoller.roll(4);
		fourRoll.setText(s);
		
	}
 	/**
 	 * when the "roll d6' button is pressed in the 
 	 * dice roller tab, a number between 1 and 6 
 	 * and returns it.
	 */
	@FXML
	void six(){
		String s;
		
		s = DiceRoller.roll(6);
		sixRoll.setText(s);
		
	}
 	/**
 	 * when the "roll d8' button is pressed in the 
 	 * dice roller tab, a number between 1 and 8 
 	 * and returns it.
	 */
	@FXML
	void eight(){
		String s;
		
		s = DiceRoller.roll(8);
		eightRoll.setText(s);
		
	}
 	/**
 	 * when the "roll d10' button is pressed in the 
 	 * dice roller tab, a number between 1 and 10 
 	 * and returns it.
	 */
	@FXML
	void ten(){
		String s;
		
		s = DiceRoller.roll(10);
		tenRoll.setText(s);
		
	}
 	/**
 	 * when the "roll d12' button is pressed in the 
 	 * dice roller tab, a number between 1 and 12 
 	 * and returns it.
	 */
	@FXML
	void twelve(){
		String s;
		
		s = DiceRoller.roll(12);
		twelveRoll.setText(s);
		
	}
 	/**
 	 * when the "roll d20' button is pressed in the 
 	 * dice roller tab, a number between 1 and 20 
 	 * and returns it.
	 */
	@FXML
	void twenty(){
		String s;
		
		s = DiceRoller.roll(20);
		twentyRoll.setText(s);		
	}
	
	/**
 	 * takes the information from the text fields in the inventory tab
 	 * creates a Spell object from this information and adds it to the Inventory
 	 * updates the ListView in the inventory tab
	 */
	@FXML
	void addItem(){
		String n, p, c, w;
		int price;
		char cur;
		double weight;
		Item i;
		
		n = noi.getText();
		p = poi.getText();
		w = woi.getText();
		c = cw.getValue();
		
		cur = c.charAt(0);
		price = Integer.parseInt(p);
		weight = Double.parseDouble(w);
		
		i = new Item(n, price, cur, weight);
		
		currentInv.add(i);
		invControl();
	}
 	/**
 	 * controls and sets the ListView in the spellbook tab
	 */
	@FXML
	void spellsControl(){
		ObservableList<Spell> currentSBList = FXCollections.observableArrayList(currentSpellBook.sbAsList()); 

		viewSpells.setCellFactory(new Callback<ListView<Spell>, ListCell<Spell>>(){
			 
            @Override
            public ListCell<Spell> call(ListView<Spell> p) {
                 
                ListCell<Spell> cell = new ListCell<Spell>(){
 
                    @Override
                    protected void updateItem(Spell t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.toString());
                        }else{
                        	setText(null);
                        }
                    }
 
                };
                 
                return cell;
            }

        });
		
		viewSpells.setItems(currentSBList);
	}
 	/**
 	 * takes the information from the text fields in the spellbook tab
 	 * creates a Spell object from this information and adds it to the SpellBook
 	 * updates the ListView in the spellbook tab
	 */
	@FXML
	void addSpell(){
		String name, l, range, dur, dam, aidontcare;
		int lvl;
		boolean ver, mat, so, con;
		
		name = sn.getText();
		l = sl.getText();
		range = sr.getText();
		dur = sd.getText();
		dam = dd.getText();
		aidontcare = aoe.getText();
		
		lvl = Integer.parseInt(l);
		
		ver = v.isSelected();
		mat = m.isSelected();
		so = s.isSelected();
		con = c.isSelected();
		boolean[] comps = {ver, so, mat};
		
		Spell s = new Spell(name, lvl, comps, con, range, aidontcare, dur, dam);
		currentSpellBook.add(s);
		spellsControl();
	}
 	/**
 	 * controls and sets the ListView for ArmorItems in the stats tab
	 */
	@FXML
	void aListControl(){
		ObservableList<Item> currentInvList = FXCollections.observableArrayList(currentInv.invAsList()); 

		aList.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>(){
			 
            @Override
            public ListCell<Item> call(ListView<Item> p) {
                 
                ListCell<Item> cell = new ListCell<Item>(){
 
                    @Override
                    protected void updateItem(Item t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null && t instanceof ArmorItem) {
                            setText(t.toString());
                        }
                    }
 
                };
                 
                return cell;
            }

        });
		
		aList.setItems(currentInvList);
	}
 	/**
 	 * takes the information from the armor-related text fields in the stats tab
 	 * creates an ArmorItem object from this information and adds it to the Inventory
 	 * updates the ArmorItem ListView in the stats tab
	 */
	@FXML
	void armorAdd(){
		String n, ab;
		Item i;
		
		n = na.getText();
		ab = aacb.getText();
		
		i = new ArmorItem(n, ab);
		
		currentInv.add(i);
		aListControl();
	}
 	/**
 	 * controls and sets the ListView for WeaponItems in the stats tab
	 */
	@FXML
	void wListControl(){
		ObservableList<Item> currentInvList = FXCollections.observableArrayList(currentInv.invAsList()); 

		wList.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>(){
			 
            @Override
            public ListCell<Item> call(ListView<Item> p) {
                 
                ListCell<Item> cell = new ListCell<Item>(){
 
                    @Override
                    protected void updateItem(Item t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null && t instanceof WeaponItem) {
                            setText(t.toString());
                        }
                    }
 
                };
                 
                return cell;
            }

        });
		
		wList.setItems(currentInvList);
	}
 	/**
 	 * takes the information from the weapon-related text fields in the stats tab
 	 * creates an WeaponItem object from this information and adds it to the Inventory
 	 * updates the WeaponItem ListView in the stats tab
	 */
	@FXML
	void wAdd(){
		String n, atb, d;
		Item i;
		
		n = wn.getText();
		atb = ab.getText();
		d = damd.getText();
		
		i = new WeaponItem(n, atb, d);
		
		currentInv.add(i);
		wListControl();
	}
 	/**
 	 * takes information from the text fields in the initiative tab
 	 * creates a character from the information
 	 * and offers it to the initiative PriorityQueue
	 */
	@FXML
	void initAdd(){
		String n, inits, hps, acs, spds, dexs; 
		
		DnDCharacter c = new DnDCharacter();
		
		n = nocText.getText();
		inits = inText.getText();
		hps = hlthText.getText();
		acs = arclText.getText();
		spds = spText.getText();
		dexs = dextText.getText();
		
		c.set("charNme", n);
		c.set("initRoll", Integer.parseInt(inits));
		c.set("hlth", Integer.parseInt(hps));
		c.set("ac", Integer.parseInt(acs));
		c.set("spd", Integer.parseInt(spds));
		c.set("dex", Integer.parseInt(dexs));
		
		initQueue.offer(c);
	}
 	/**
 	 * polls the initiative PriorityQueue for the next character
 	 * displays information about the character on the screen in the initiative tab
 	 * offers the character back to the PriorityQueue with the initiative information changed so it goes to the end of the queue
	 */
	@FXML
	void initQNext(){
		DnDCharacter c = initQueue.poll();
		
		noc.setText(c.getStringStat("charNme"));
		hlth.setText(c.getIntStat("hlth"));
		arcl.setText(c.getIntStat("ac"));
		sp.setText(c.getIntStat("spd"));
		dext.setText(c.getIntStat("dex"));
		
		c.set("initRoll", (Integer.parseInt(c.getIntStat("initRoll")) - 30));
		
		initQueue.offer(c);
	}
 	/**
 	 * clears the initiative PriorityQueue
 	 * sets the text fields on the initiative tab to be blank
	 */
	@FXML
	void clearInitQ(){
		initQueue.clear();
		
		noc.setText("");
		hlth.setText("");
		arcl.setText("");
		sp.setText("");
		dext.setText("");
	}
 	/**
 	 * removes the selected item from the inventory
 	 * updates the ListView in the inventory tab
	 */
	@FXML
	void delInv(){
		currentInv.remove(viewInv.getSelectionModel().getSelectedIndex());
		invControl();
	}
	/**
	 * Grabs exp when new value is entered and calculates new level to display
	 */
	@FXML
	void setLevel(){
		int xp=Integer.parseInt(exp.getText());
		charLvl.setText(loadedCharacter.CalculateLvl(xp));
	}
	
}