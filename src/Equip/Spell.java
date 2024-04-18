package Equip;

public class Spell {
	String name;
	int damage;

	String description;

	int cooldown;

	public Spell(String name, int damage, String description,int cooldown) {
		this.name = name;
		this.damage = damage;
		this.description = description;
		this.cooldown = cooldown;
	}


	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCooldown() {
		return cooldown;
	}
	//TODO fix
	@Override
	public String toString() {
		return "Spell{" +
				"name='" + name + '\'' +
				", damage=" + damage +
				", description='" + description + '\'' +
				", cooldown=" + cooldown +
				'}';
	}
}
