import java.lang.reflect.Array;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Player implements Action<Monster,Potion> {
	Scanner scanner = new Scanner(System.in);

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
	Weapon weapon = new Weapon();
	Spell[] spells = new Spell[MAX_SPELL];
	int cdSpecial;

	boolean skipTurn = false;
	boolean potionUsed = false;

	void doAction() {
	}

	//TODO controllare i calcoli
	@Override
	public boolean dodge(Monster monster) {
		boolean result = false;
		if(speed * wis > monster.speed * monster.wis) {
			return rand.nextBoolean();
		}else {
			return rand.nextInt() > 2;
		}
	}

	@Override
	public int attackLight() {
		return str / 10 + weapon.strModifier;
	}

	@Override
	public int attackHeavy() {
		skipTurn = true;

		return 2 * str / 10 + weapon.strModifier;
	}

	@Override
	public int attackSpecial() {
		cdSpecial = CD_SPECIAL;
		return str / 10 + wis / 10 + weapon.strModifier;
	}

	// TODO Implement
	@Override
	public void drinkPotion(Potion potion) {
		potionUsed = true;
		switch(potion.type) {
		case HP:
			health = health + potion.modifier;
			break;
		case SPEED:
			speed = speed + potion.modifier;
			break;
		case STRENGTH:
			str = str + potion.modifier;
			break;
		case WISDOM:
			wis = wis + potion.modifier;
			break;

		case DEXTERITY:
			dex = dex + potion.modifier;
			break;
		case COOLDOWN:
			for(Spell s : spells) {
				s.setCooldown(0);
			}
			break;

		}
	}


	public int attackSpell(Spell spell) {
		return wis / 10 + spell.damage;
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
}

