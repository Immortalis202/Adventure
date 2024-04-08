/**
 *
 */

public interface Action<M,P>{
	/*Constant for monster and player*/
	int CD_SPECIAL = 3;
	int MAX_SPELL = 4;
	//TODO generici oppure passa un object

	/*Action doable by player and monster*/
	boolean dodge(M object);

	int attackLight();
	/*similar to Light but more damage and turn cooldown*/
	int attackHeavy();
	int attackSpecial();
	void drinkPotion(P object);



}
