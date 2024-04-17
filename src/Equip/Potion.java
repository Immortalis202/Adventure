package Equip;

public class Potion {

	PotionType type;
	String name;
	String description;
	int modifier;

	public Potion(PotionType type, String name, String description, int modifier) {
		this.type = type;
		this.name = name;
		this.description = description;
		this.modifier = modifier;
	}


	public PotionType getType() {
		return type;
	}

	public void setType(PotionType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
}
