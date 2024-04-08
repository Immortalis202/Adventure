public class Spell {
	String name;
	int damage;

	String description;

	int target;
	int cooldown;

	public Spell(String name, int damage, String description, int target, int cooldown) {
		this.name = name;
		this.damage = damage;
		this.description = description;
		this.target = target;
		this.cooldown = cooldown;
	}


	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	//TODO swapSpell method
}
