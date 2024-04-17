package Monster;

import Equip.Potion;
import Equip.PotionType;
import Equip.Weapon;
import General.Action;
import General.Player;

public abstract class Monster implements Action<Player, Potion> {
	public int health;
	public int wis;
	public int speed;
	public int dex;
	public int str;
	String description;

	boolean skipTurn = false;
	boolean potionUsed = false;

	int cdSpecial;
	Weapon weapon = new Weapon();

	public Monster(int health,  int wis, int speed, int dex, int str, Weapon weapon) {
		this.health = health;
		this.wis = wis;
		this.speed = speed;
		this.dex = dex;
		this.str = str;
		this.weapon = weapon;
	}

	public Monster() {
	}

	public void setModifier(){
		if(weapon != null){
			str = str + weapon.getStrModifier();
			speed = speed + weapon.getSpModifier();
			wis = wis + weapon.getWisModifier();
			dex = dex + weapon.getDexModifier();
		}

	}

	@Override
	public  boolean dodge(Player object) {
		return false;
	}

	@Override
	public int attackLight() {
		if(this.str > this.dex) {
			return str + weapon.getStrModifier();
		}
		return dex + weapon.getDexModifier();
	}
	@Override
	public int attackHeavy() {
		skipTurn = true;

		if(this.str > this.dex){
			return 2 * str + weapon.getStrModifier();
		}
		return 2 * dex + weapon.getDexModifier();
	}

	@Override
	public int attackSpecial() {
		cdSpecial = Action.CD_SPECIAL;
		return str + wis + dex;
	}

	@Override
	public void drinkPotion(Potion potion) {
		potionUsed = true;
		switch(potion.getType()) {
		case PotionType.HP:
			health = health + potion.getModifier();
			break;
		case PotionType.SPEED:
			speed = speed + potion.getModifier();
			break;
		case PotionType.STRENGTH:
			str = str + potion.getModifier();
			break;
		case PotionType.WISDOM:
			wis = wis + potion.getModifier();
			break;

		case PotionType.DEXTERITY:
			dex = dex + potion.getModifier();
			break;

		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}
