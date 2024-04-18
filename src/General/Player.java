package General;

import Equip.Armor;
import Equip.Potion;
import Equip.Spell;
import Equip.Weapon;
import Monster.Monster;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
AHAHAH la javadoc

 */
//TODO togliere pozioni o implementarle
public class Player implements Action<Monster, Potion> {
	Scanner scanner = new Scanner(System.in);

	public String name;
	public int health;
	public int speed;
	public int str;
	public int wis;
	public int dex;

	public int defSpeed = speed;
	public int defStr = str;
	public int defWis = wis;
	public int defDex = dex;


	Random rand = new Random();
	Armor armor;
	Weapon weapon;
	Spell[] spells = new Spell[MAX_SPELL];

	int cdSpecial = 0;

	boolean skipTurn = false;
	boolean potionUsed = false;

	public Player(String name, int health, int speed, int str, int wis, int dex) {
		this(name,health,speed,str,wis,dex,null,null);
	}

	public Player(String name,int dex, int wis, int str, int speed, int health, Armor armor, Weapon weapon ) {
		this.name = name;
		this.dex = dex;
		this.wis = wis;
		this.str = str;
		this.speed = speed;
		this.health = health;
		this.armor = armor;
		this.weapon = weapon;
		setModifier();

	}

	public Player() {
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}

	public void setModifier(){
		if(weapon != null){
			str = str + weapon.getStrModifier();
			speed = speed + weapon.getSpModifier();
			wis = wis + weapon.getWisModifier();
			dex = dex + weapon.getDexModifier();
		}

		if(armor != null){
				health = health + armor.getHpModifier();
				speed = speed + armor.getSpeedModifier();
		}
	}

	public void action(){
		int damage;
		System.out.print("""
				What action do you want to do?
				
				[1] Light Attack
				
				[2] Heavy Attack
				
				[3] Special attack 
				
				[4] Throw a spell
				
				[6] Run away
				
				""");
	}

	@Override
	public int attackLight() {
		if(this.str > this.wis) {
			return this.str / 10;
		}else{
			return this.wis / 10;
		}
	}

	@Override
	public int attackHeavy() {
		skipTurn = true;

		if(this.str > this.dex) {
			return this.str / 10;
		}else{
			return this.dex / 10;
		}
	}

	@Override
	public int attackSpecial() {
		this.cdSpecial = CD_SPECIAL;
		return this.str / 10 + this.dex / 10 + this.wis / 10;
	}

	@Override
	public void drinkPotion(Potion potion) {
		potionUsed = true;
		switch(potion.getType()) {
		case HP:
			this.health = this.health + potion.getModifier();
			break;
		case SPEED:
			this.speed = this.speed + potion.getModifier();
			break;
		case STRENGTH:
			this.str = this.str + potion.getModifier();
			break;
		case WISDOM:
			this.wis = this.wis + potion.getModifier();
			break;

		case DEXTERITY:
			this.dex = this.dex + potion.getModifier();
			break;
		case COOLDOWN:
			for(Spell s : spells) {
				s.setCooldown(0);
			}
			break;

		}
	}

	public int attackSpell(Spell spell) {
		return this.wis / 10 + spell.getDamage();
	}

	public boolean run(Monster monster) {
		boolean result = false;

		if(this.speed * this.dex > monster.getSpeed() * monster.getDex()) {
			return rand.nextBoolean();
		}else {
			return rand.nextInt() > 2;
		}
	}

	void addSpells(Spell spell){
		boolean full = true;
		for(Spell value : spells) {
			if(value == null){
				full = false;
				break;
			}
		}
		String response;
		if(full){
			System.out.print("All four spells slot are occupied, do you want to swap one of them? [Y/N]");
			response = scanner.nextLine();
			//if(response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"))
			if(new Scanner(response).nextLine().equalsIgnoreCase("y") || new Scanner(response).nextLine().equalsIgnoreCase("yes")){
				//call to swapSpell method
			}
		}
		int i = 0;
		while(spells[i] != null){
			i++;
		}
		spells[i] = spell;
	}




	void resetStats(){
		this.defSpeed = this.speed;
		this.defStr = this.str;
		this.defWis = this.wis;
		this.defDex = this.dex;
	}

	@Override
	public String toString() {

		return this.name  + "\n" +
				"\thealth\t" + this.health +
				"\n\tspeed\t" + this.speed +
				"\n\tstr\t\t" + this.str +
				"\n\twis\t\t" + this.wis +
				"\n\tdex\t\t" + this.dex +
				"\n\tarmor\t" + (this.armor != null ? this.armor.toString() : "Not Present") +
				"\n\tweapon\t" + (this.weapon != null ? this.weapon.toString() : "Not Present") +
				//TODO class Spells implement to String
				"\n\tspells\t" + Arrays.toString(spells) +"\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getCdSpecial() {
		return cdSpecial;
	}

	public void setCdSpecial(int cdSpecial) {
		this.cdSpecial = cdSpecial;
	}

	public boolean isSkipTurn() {
		return skipTurn;
	}

	public void setSkipTurn(boolean skipTurn) {
		this.skipTurn = skipTurn;
	}

	public Weapon getWeapon() {
		return weapon;
	}
}

