package General;

import Monster.Goblin;
import Monster.Monster;

import java.util.concurrent.TimeUnit;

public class Game {
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
		System.out.printf("You find yourself at the entrance of a thick pine forest, the trees are so tall and dense that the sun barely lights the path that you barely recognized at first glance");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("You decide to venture inside the forest following the narrow trail bordered by thorns");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("While walking through the forest you feel being observed from the darkness but you quickly get over it thinking that the absence of light is making you paranoid");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("You already lost track of time since you went inside the woods, suddenly you hear someone moving between the trees at your left. You stop and try to focus to spot the creature");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Two goblins pop out from the darkness with their weapons unleashed ready to fight you");
		TimeUnit.SECONDS.sleep(1);
		encounter(player, new Goblin("Melee"), new Goblin("ranged"));
	}


	public void encounter(Player p,Monster ...monsters ){
		player.action();
	}
}


