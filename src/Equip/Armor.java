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
