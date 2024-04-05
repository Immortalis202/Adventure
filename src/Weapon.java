public class Weapon  {

	String name;
	int strModifier;
	int spModifier;
	String material;
	String description;
	WeaponType weaponType;

	public Weapon(String name, int strModifier, int spModifier, String material, String description, WeaponType weaponType) {
		this.name = name;
		this.strModifier = strModifier;
		this.spModifier = spModifier;
		this.material = material;
		this.description = description;
		this.weaponType = weaponType;
	}

	public Weapon() {
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setStrModifier(int strModifier) {
		this.strModifier = strModifier;
	}

	public void setSpModifier(int spModifier) {
		this.spModifier = spModifier;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}
}
