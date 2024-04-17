package General;

import Equip.Armor;
import Equip.Potion;
import Equip.Spell;
import Equip.Weapon;
import Monster.Monster;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


//TODO modificare l'accesso alle variabili con i getter
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

	int cdSpecial;

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
		Scanner scanner = new Scanner(System.in);
		System.out.print("""
				What action do you want to do?
				
				[1] Light Attack
				
				[2] Heavy Attack
				
				[3] Special attack 
				
				[4] Throw a spell
				
				[5] Dodge
				
				[6] Run away
				
				""");

		switch(scanner.nextLine()){
		case "1", "Light attack", "Light Attack", "light attack":
			damage = attackLight();
			System.out.printf("Light attack done");
			break;
		}

	}

	@Override
	public boolean dodge(Monster monster) {
		boolean result = false;
		if(speed * wis >= monster.speed * monster.wis) {
			return rand.nextBoolean();
		}else {
			return rand.nextInt() > 2;
		}

	}

	@Override
	public int attackLight() {
		return str / 10 + weapon.getStrModifier();
	}

	@Override
	public int attackHeavy() {
		skipTurn = true;

		return 2 * str / 10 + weapon.getStrModifier();
	}

	@Override
	public int attackSpecial() {
		cdSpecial = CD_SPECIAL;
		return str / 10 + wis / 10 + weapon.getStrModifier();
	}

	@Override
	public void drinkPotion(Potion potion) {
		potionUsed = true;
		switch(potion.getType()) {
		case HP:
			health = health + potion.getModifier();
			break;
		case SPEED:
			speed = speed + potion.getModifier();
			break;
		case STRENGTH:
			str = str + potion.getModifier();
			break;
		case WISDOM:
			wis = wis + potion.getModifier();
			break;

		case DEXTERITY:
			dex = dex + potion.getModifier();
			break;
		case COOLDOWN:
			for(Spell s : spells) {
				s.setCooldown(0);
			}
			break;

		}
	}

	public int attackSpell(Spell spell) {
		return wis / 10 + spell.getDamage();
	}

	public boolean run(Monster monster) {
		boolean result = false;

		if(speed * dex > monster.speed * monster.dex) {
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
		defSpeed = speed;
		defStr = str;
		defWis = wis;
		defDex = dex;
	}

	@Override
	public String toString() {

		return name  + "\n" +
				"\thealth\t" + health +
				"\n\tspeed\t" + speed +
				"\n\tstr\t\t" + str +
				"\n\twis\t\t" + wis +
				"\n\tdex\t\t" + dex +
				"\n\tarmor\t" + (armor != null ? armor.toString() : "Not Present") +
				"\n\tweapon\t" + (weapon != null ? weapon.toString() : "Not Present") +
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
}

