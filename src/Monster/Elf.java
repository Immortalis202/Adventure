package Monster;

import Equip.Weapon;
import Equip.WeaponType;

public class Elf extends Monster {
	public Elf() {
		setDex(3);
		setStr(2);
		setHealth(7);
		setWis(4);
		setSpeed(15);
		setWeapon(new Weapon("Bow",
				2,
				1,
				2,
				2,
				Equip.Material.SILVER,
				"A common axe",
				WeaponType.BOW ));
		setDescription("An elf with a bow");
		setModifier();

	}
}
