package Equip;

import java.util.Scanner;

public class Armor {
	Scanner armorScan = new Scanner(System.in);

	ArmorType armorType;
	String name;
	String description;
	Material material;
	int hpModifier;
	int speedModifier;


	public Armor(ArmorType armorType, String name, String description, Material material) {
		this.armorType = armorType;
		this.name = name;
		this.description = description;
		this.material = material;
		this.hpModifier = 0;
		this.speedModifier = 0;

	}

	public Armor(ArmorType armorType, String name, String description, Material material, int hpModifier, int speedModifier) {
		this.armorType = armorType;
		this.name = name;
		this.description = description;
		this.material = material;

	}

	public Armor(){

	}


// Add ArmorMethod
//	public static Equip.Armor addArmor(){
//		int tempHpModifier = 0;
//		int tempSpeedModifier = 0;
//
//		Equip.Armor armor;
//		armor = General.Utils.armorBuilder();
//
//		switch(armor.armorType){
//		case HEAVY:
//			tempHpModifier = tempHpModifier + 3;
//			tempSpeedModifier = tempSpeedModifier -1;
//			break;
//		case MEDIUM:
//			tempHpModifier = tempHpModifier + 2;
//
//			break;
//		case LIGHT:
//			tempHpModifier = tempHpModifier + 1;
//			tempSpeedModifier = tempSpeedModifier + 1;
//			break;
//		}
//
//		switch(armor.material){
//
//		case IRON:
//			tempHpModifier = tempHpModifier + 3;
//			break;
//
//		case WOOD:
//			tempHpModifier = tempHpModifier + 2;
//			tempSpeedModifier = tempSpeedModifier - 1;
//
//		case STEEL:
//			tempHpModifier = tempHpModifier + 3;
//		case BRONZE:
//			tempHpModifier = tempHpModifier + 3;
//			tempSpeedModifier = tempSpeedModifier - 2;
//
//		case SILVER:
//			tempHpModifier = tempHpModifier + 2;
//			tempSpeedModifier = tempSpeedModifier + 1;
//
//		case LEATHER:
//			tempHpModifier = tempHpModifier + 1;
//
//		case MITHRAL:
//			tempHpModifier = tempHpModifier + 4;
//			tempSpeedModifier = tempSpeedModifier - 1;
//
//		case CHAINMAIL:
//			tempHpModifier = tempHpModifier + 3;
//
//
//		case ADAMANTITE:
//			tempHpModifier = tempHpModifier + 5;
//			tempSpeedModifier = tempSpeedModifier - 2;
//		}
//		armor.hpModifier = tempHpModifier;
//		armor.speedModifier = tempSpeedModifier;
//		return armor;
//	}

	public void setArmorType(ArmorType armorType) {
		this.armorType = armorType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setHpModifier(int hpModifier) {
		this.hpModifier = hpModifier;
	}

	public void setSpeedModifier(int speedModifier) {
		this.speedModifier = speedModifier;
	}

	@Override
	public String toString() {
		return "Equip.Armor{" +
				"armorType=" + armorType +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", material=" + material +
				", hpModifier=" + hpModifier +
				", speedModifier=" + speedModifier +
				'}';
	}

	public ArmorType getArmorType() {
		return armorType;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Material getMaterial() {
		return material;
	}

	public int getHpModifier() {
		return hpModifier;
	}

	public int getSpeedModifier() {
		return speedModifier;
	}
}
