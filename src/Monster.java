public abstract class Monster implements Action<Player, Potion> {
	public int health;
	public int damage;
	public int wis;
	public int speed;
	public int dex;
	public int str;

	boolean skipTurn = false;
	boolean potionUsed = false;

	int cdSpecial;
	Weapon weapon = new Weapon();

	@Override
	public boolean dodge(Player object) {
		return false;
	}

	@Override
	public int attackLight() {
		return str / 10 + weapon.strModifier;
	}

	@Override
	public int attackHeavy() {
		skipTurn = true;

		return 2* str /10 + weapon.strModifier;
	}

	@Override
	public int attackSpecial() {
		cdSpecial = CD_SPECIAL;
		return str / 10 + wis / 10 + weapon.strModifier;
	}

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

		}
	}
}
