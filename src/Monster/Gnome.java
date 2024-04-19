package Monster;

import Equip.Weapon;


public class Gnome extends Monster {
	public Gnome(){
		setDex(1);
		setStr(1);
		setHealth(5);
		setWis(0);
		setSpeed(10);
		setWeapon(new Weapon("Axe",
				2,
				1,
				0,
				0,
				Equip.Material.IRON,
				"A common axe",
				Equip.WeaponType.AXE ));
		setDescription("A gnome with an axe");
		setModifier();

	}
}
