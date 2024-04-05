import java.lang.reflect.Array;
import java.util.Random;

public class Player implements Action{
	Random rand = new Random();

	Weapon weapon = new Weapon();
	Spell[] spells = new Spell[MAX_SPELL];

	public int health;
	public int speed;
	public int str;
	public int wis;
	public int dex;

	int cdSpecial;

	boolean skipTurn = false;

	void doAction(){}

	//TODO controllare i calcoli
	@Override
	public boolean dodge(/*enemy*/) {
		boolean result = false;
		/*
		 if(curr Speed * wis > enemy speed * enemy wis){
		  	return rand.nextBoolean();
		 }else{
		 	if(rand.nextInt() > 2){
		 		return true
		 }else{
		 	return false
		 }
		 */

		return result;
	}

	@Override
	public int attackLight() {
		return str/10 + weapon.strModifier;
	}

	@Override
	public int attackHeavy() {
		skipTurn = true;

		return 2*str/10 + weapon.strModifier;
	}

	@Override
	public int attackSpecial() {
		cdSpecial = CD_SPECIAL;
		return str/10 + wis/10 + weapon.strModifier;
	}

	// TODO Implement
	@Override
	public int drinkPotion() {
		return 0;
	}


	public int attackSpell(Spell spell) {
		return wis/10 + spell.damage;
	}
	//TODO implement

	public boolean run(Monster monster) {
		boolean result = false;

		 if(speed * dex > monster.speed * monster.dex){
		  	return rand.nextBoolean();
		 }else{
		 	if(rand.nextInt() > 2){
		 		return true;
		 }else{
		 	return false;
		 }


		return result;
	}
}}

