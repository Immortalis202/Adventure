package Monster;

import Equip.Weapon;

public class Dwarf extends Monster {
	public Dwarf(){
		setDex(1);
		setStr(2);
		setHealth(10);
		setWis(0);
		setSpeed(5);
		setWeapon(new Weapon("Hammer",
				2,
				1,
				2,
				2,
				Equip.Material.STEEL,
				"A common axe",
				Equip.WeaponType.HAMMER ));
		setDescription("A Dwarf with a hammer");
		setModifier();

	}
}
