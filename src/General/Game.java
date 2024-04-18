package General;

import Equip.Material;
import Equip.Weapon;
import Equip.WeaponType;
import Monster.Goblin;
import Monster.Monster;
import Monster.Dragon;
import Monster.Dwarf;
import Equip.Spell;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.sql.Time;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
	Random rand = new Random();
	Player player;
	public Game(Player player1) {
		this.player = player1;
	}

	public void start(Player player) throws InterruptedException {
		System.out.printf("""
				          ///\\///\\\\\\     ///////\\\\\\               ///////\\\\\\
				          ///\\///\\\\\\     ///////\\\\\\/\\             ///////\\\\\\
				          //\\////\\\\\\\\       ////\\\\//\\\\           ////////\\\\\\
				          //\\\\///\\\\\\\\\\     /////\\///\\\\\\                 ||
				         ///\\\\\\//\\\\\\\\\\\\    /////\\///\\\\\\
				     /\\  ///\\\\\\ ||         /////\\///\\\\\\
				    //\\\\////\\\\/\\               ||///\\\\\\                 /\\
				   ///\\\\\\///\\//\\\\               ////\\\\\\\\               //\\\\
				   ///\\\\\\///\\//\\\\/\\         /\\  ////\\\\\\\\         /\\    //\\\\
				  ////\\\\\\\\/////\\//\\\\       //\\\\ ////\\\\\\\\        //\\\\   //\\\\
				  ////\\\\\\\\////////\\\\\\     /\\/\\\\  /\\||          ///\\\\\\  //\\\\
				 /////\\\\\\\\\\///////\\\\\\\\   //\\\\\\\\ //\\\\           ///\\\\\\ ///\\\\\\
				 /////\\\\\\\\\\///////\\\\\\\\   //\\\\\\\\ //\\\\          ////\\\\\\\\///\\\\\\
				 /////\\\\\\\\////////\\\\\\\\  ///\\\\\\\\ //\\\\        /\\////\\\\\\\\///\\\\\\
				     ||  /////////\\\\\\\\ ////\\\\\\\\\\//\\\\       //\\\\///\\\\\\\\\\//\\\\\\
				              ////\\\\\\\\/////\\\\\\\\///\\\\\\      //\\\\///\\\\\\\\\\\\||
				             /////\\\\\\//////\\\\\\\\///\\\\\\     ///\\\\\\//\\\\\\\\\\\\
				                 || ///////\\\\\\////\\\\\\\\   ////\\//\\||
				                    ///////\\\\/////\\\\\\\\\\ ////////\\\\
				                          ||     ||    /////////\\\\\\
				                                       /////////\\\\\\
				                                      //////////\\\\\\\\
				                                          //////\\\\\\\\
				                            /\\           ///////\\\\\\\\\\
				                           //\\\\          ///////\\\\\\\\\\\\
				   /\\                     ///\\\\\\        ////////\\\\\\\\\\\\\\
				  //\\\\                   ////\\\\\\\\             |||
				 ///\\\\\\                 /////\\\\\\\\\\
				 ///\\\\\\\\             /\\//////\\\\\\\\\\\\    /\\
				 ///\\\\\\\\\\           //\\\\/////\\\\\\\\\\\\\\  //\\\\
				 ///\\\\\\\\\\\\         ///\\\\\\////\\\\\\\\\\\\\\ /\\/\\\\
				 ///\\\\\\\\\\\\        ////\\\\\\\\///\\\\\\\\\\\\\\//\\\\\\\\
				 ///\\\\\\\\\\\\\\      /////\\\\\\\\\\ ||     ///\\\\\\\\
				 ///\\\\\\\\\\\\\\     //////\\\\\\\\\\\\      ////\\\\\\\\
				   ||   /\\ /\\   //////\\\\\\\\\\\\      ////\\\\\\\\
				       //\\//\\\\  //////\\\\\\\\\\\\     /////\\\\\\\\\\         /\\
				      ///\\//\\\\ ///////\\\\\\\\\\\\\\   //////\\\\\\\\\\\\       //\\\\
				     ///////\\\\\\      ||         //////\\\\\\\\\\\\       //\\\\
				     ///////\\\\\\\\               ///////\\\\\\\\\\\\\\     ///\\\\\\
				    /////\\//\\\\\\\\                     ||    /\\    ////\\\\\\\\
				    /////\\\\/\\\\\\\\                          //\\\\   ////\\\\\\\\
				    //////\\/\\\\\\\\                          //\\\\  /////\\\\\\\\\\
				    //////\\\\\\\\\\\\                          //\\\\  /////\\\\\\\\\\
				       ///\\\\|                            ///\\\\\\//////\\\\/\\\\\\
				      ////\\\\\\                           ////\\\\\\\\    ||//\\\\
				      ////\\\\\\\\                          ////\\\\\\\\     ///\\\\\\
				     /////\\\\\\\\                         /////\\\\\\\\\\   ////\\\\\\\\
				     /////\\\\\\\\                        //////\\\\\\\\\\\\  ////\\\\\\\\
				     /////\\\\\\\\\\                     /\\     ||       ////\\\\\\\\
				    //////\\\\\\\\\\\\                   //\\\\             ////\\\\\\\\
				         ||                        //\\\\             ////\\\\\\\\
				                                  ///\\\\\\           /////\\\\\\\\
				                                 ////\\\\\\\\              ||
				                                /////\\\\\\\\\\
				                               //////\\\\\\\\\\\\
				                              ///////\\\\\\\\\\\\\\
				                             ////////\\\\\\\\\\\\\\\\
				                                    ||
				""");
		System.out.println("You find yourself at the entrance of a thick pine forest, the trees are so tall and dense that the sun barely lights the path that you barely recognized at first glance");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("You decide to venture inside the forest following the narrow trail bordered by thorns");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("While walking through the forest you feel being observed from the darkness but you quickly get over it thinking that the absence of light is making you paranoid");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("You already lost track of time since you went inside the woods, suddenly you hear someone moving between the trees at your left. You stop and try to focus to spot the creature");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Two goblins pop out from the darkness with their weapons unleashed ready to fight you");
		TimeUnit.SECONDS.sleep(1);
		Goblin goblin1 = new Goblin("Melee");
		Goblin goblin2 = new Goblin("ranged");
		while((goblin1.getHealth() > 0 && goblin2.getHealth() > 0) || (player.getHealth() > 0)){
			encounter(player, goblin1, goblin2);
		}

		TimeUnit.SECONDS.sleep(1);
		if(player.getHealth() > 0){
			System.out.printf("After a bloody battle with two goblins you came out victorious\n");
			TimeUnit.SECONDS.sleep(1);
			System.out.printf("Lying at the feet of the defeated goblin there are simple wood weapon that don't interest you\n");
			player.resetStats();
		}else{
			System.out.println("Sadly you couldn't overcome the sheer force of two goblins");
			System.out.println("GAME OVER");
			return;
		}

		System.out.println("You proceed in the depth of the forest keeping aware of your surroundings waiting for another ambush...");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("As time passes you start to notice that the forest is slowly thinning away and after some metres you notice the path branching in two different ways");
		TimeUnit.SECONDS.sleep(1);
		System.out.printf("The right path seems to going in a clearing without trees\n");
		System.out.printf("The left path lead to an entrance of a cave\n");
		System.out.printf("Which would you take? [L/R]\n");
		boolean exit = true;
		Scanner scanner = new Scanner(System.in);
		while(exit){
			String input = scanner.nextLine();
			if(input.equals("L") || input.equals("Left") || input.equals("left") ){
				exit = false;
				cavePath();
			}else if(input.equals("R") || input.equals("Right") || input.equals("right")) {
				exit = false;
				clearingPath();
			}else{
				System.out.printf("Wrong input\n");
			}
		}


	}


	public void encounter(Player p,Monster ...monsters ) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);

		int damage = 0;
		boolean exit = true;
		boolean valid = true;
		String target = "";
		if(!player.isSkipTurn()){
			if(monsters.length > 1){
				while(valid) {
					System.out.printf("Choose the target\n");
					target = scanner.nextLine();
					if(Integer.parseInt(target) < monsters.length){
						valid = false;
					}else {
						System.out.printf("Invalid target\n");
					}
				}
			}
			while(exit) {
				player.action();
				switch(scanner.nextLine()) {
				case "1", "Light attack", "Light Attack", "light attack":
					damage = player.attackLight();
					System.out.printf("Light attack done: %d\n", damage);
					exit = false;
					break;
				case "2", "Heavy attack", "Heavy Attack", "heavy attack":
					damage = player.attackHeavy();
					System.out.printf("Heavy attack done: %d\n", damage);
					exit = false;
					break;
				case "3", "Special Attack", "Special attack", "special attack":
					if(player.getCdSpecial() > 0) {
						System.out.printf("Special attack in cooldown\n");
						break;
					}
					damage = player.attackSpecial();
					System.out.printf("Special attack done: %d\n", damage);
					exit = false;
					break;
				case "4", "spell", "spells":
					for(Spell spell : player.spells) {
						System.out.println(spell.toString());
					}
					String input = scanner.nextLine();
					if(input.equalsIgnoreCase(player.spells[1].getName())) {
						damage = player.attackSpell(player.spells[1]);
						System.out.printf("Spell launched: %d\n", damage);
					}else if(input.equalsIgnoreCase(player.spells[2].getName())) {
						damage = player.attackSpell(player.spells[2]);
						System.out.printf("Spell launched: %d\n", damage);
					}else if(input.equalsIgnoreCase(player.spells[3].getName())) {
						damage = player.attackSpell(player.spells[3]);
						System.out.printf("Spell launched: %d\n", damage);
					}else if(input.equalsIgnoreCase(player.spells[4].getName())) {
						damage = player.attackSpell(player.spells[4]);
						System.out.printf("Spell launched: %d\n", damage);
					}else {
						System.out.println("Spell not found");
					}
					exit = false;
					break;
				case "5", "run", "Run":
					if(player.run(monsters[1]) && player.run(monsters[2])) {
						System.out.println("You run away from the monsters");
					}else {
						System.out.println("You couldn't run away from the monsters");
					}
					exit = false;

				default:
					System.out.println("Invalid command");
				}
				TimeUnit.SECONDS.sleep(1);

				monsters[Integer.parseInt(target)].setHealth(monsters[Integer.parseInt(target)].getHealth() - damage);
				System.out.println(monsters[Integer.parseInt(target)].getHealth());
			}
		}else{
			System.out.printf("Turn Skipped\n");
		}
		int damageToPlayer = 0;
		if(monsters.length > 1){
			for(Monster m : monsters){
				switch(rand.nextInt(3)) {
				case 0:
					damageToPlayer = m.attackLight();
					break;
				case 1:
					damageToPlayer = m.attackHeavy();
					break;
				case 2:
					damageToPlayer = m.attackSpecial();
					break;
				}
				player.setHealth(player.getHealth() - damageToPlayer);
			}
		}
	}

	public void cavePath() throws InterruptedException {
		System.out.println("You choose the left path leading to the cavern");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("As you approach the entrance of the cave you notice some mine tools abandoned on the wall of the cave. You soon notice that the cave is a mine and is not abandoned\n");
		System.out.println("You cautiously enter the cave keeping an eye on suspect movement");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("After some turn you enter a well lit chamber where 2 dwarf are chatting while working");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Do you want to approach them in an hostile way? [Y/n]");
		Scanner scanner = new Scanner(System.in);
		if(scanner.nextLine().equalsIgnoreCase("Y")) {
			System.out.println("You decide to sheathe your sword and approach them");
			System.out.println("As soon as they see you with your sword they stand up and attack you ");
			TimeUnit.SECONDS.sleep(1);
			Dwarf dwarf = new Dwarf();
			Dwarf dwarf2 = new Dwarf();
			while((dwarf.getHealth() > 0 && dwarf2.getHealth() > 0) || (player.getHealth() > 0)){
				encounter(player, dwarf, dwarf2);
			}
		}else if(scanner.nextLine().equalsIgnoreCase("N")) {
			System.out.println("You decide to slowly walk towards them letting them notice you");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("They don't seems to be hostile to you but more curious");
			System.out.println("They ask if you want to swap your weapon with one ot their steel's hammer");
			TimeUnit.SECONDS.sleep(1);
			Weapon hammer = new Weapon("Hammer Time", 5,-1,4,3, Material.STEEL, "Hand manifactured by the dwarves", WeaponType.HAMMER);
			System.out.printf(player.getWeapon().toString());
			System.out.println(hammer.toString());
			boolean exit = true;
			while(exit){
				System.out.println("Do you want to swap weapon? [Y/n]");
				if(scanner.nextLine().equalsIgnoreCase("Y")) {
					player.setWeapon(hammer);
					System.out.println("Weapon swapped");
					exit = false;
				}else if(scanner.nextLine().equalsIgnoreCase("N")) {
					System.out.println("You declined the dwarves offer");
					exit = false;

				}else{
					System.out.println("Wrong input");
				}
			}
			System.out.println("After thanking the dwarves for their offer you decide to head out of the cave and go back to the path fork");
			TimeUnit.SECONDS.sleep(3);
		}
		clearingPath();
	}

	public void clearingPath() throws InterruptedException {
		System.out.println("You slowly walk towards the clearing, bathing, for the first time since entering the forest, in the sun filtering through the trees");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("You arrive in the clearing but you quickly see that the forest hide a secret");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("You find yourself at the edge of a crater where a red dragon lies at the center");
		TimeUnit.SECONDS.sleep(2);
		Dragon dragon  = new Dragon();
		System.out.println(dragon.getDescription());
		System.out.println("Just the size of the dragon petrify you, you want to move, to run in the opposite direction but the legs won't move");
		System.out.println("Only the scream of the dragon wakes you up but it is already too late, he approach you angrily");
		TimeUnit.SECONDS.sleep(1);
		while((dragon.getHealth() > 0)  || (player.getHealth() > 0)){
			encounter(player, dragon);
		}

		if(dragon.getHealth() < 0){
			System.out.println("The dragon lies dead at your feet. The air is almost unbreathable because of the fume emitted by his body");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("You stare at the dead body with sadness in your eyes for slaying such a beautiful creature but at the same time you know that it was necessary");
			TimeUnit.SECONDS.sleep(4);
			System.out.println("Thank you for playing");

		}else{
			System.out.println("Sadly you couldn't overcome the sheer force of the dragon");
			System.out.println("GAME OVER");
		}
		return;
	}

}


