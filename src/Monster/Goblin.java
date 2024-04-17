package Monster;

import Equip.Material;
import Equip.Weapon;
import Equip.WeaponType;

public class Goblin extends Monster {

	String type;

	public Goblin(String type) {
		this.type = type;

		if(type.equalsIgnoreCase("melee")){
			setDex(1);
			setStr(1);
			setHealth(5);
			setWis(0);
			setSpeed(10);
			setWeapon( new Weapon("Dagger", 1,1,0,0, Material.WOOD,"Simple dagger", WeaponType.DAGGER));
		}else if(type.equalsIgnoreCase("ranged")) {
			setDex(1);
			setStr(1);
			setHealth(5);
			setWis(1);
			setWeapon(new Weapon("Bow", 1,1,1,1, Material.WOOD,"Simple bow", WeaponType.BOW));
		}
		setModifier();
	}

	public void setType(String type) {
		this.type = type;
	}
}
