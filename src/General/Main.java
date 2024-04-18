package General;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
	static Player selected;
	static ArrayList<Player> characters = new ArrayList<>();
	public static void main(String[] args) throws IOException, InterruptedException {
		ObjectMapper objectMapper = new ObjectMapper();
		Player person;
		try {
			person = objectMapper.readValue(new File("C:\\UFS04\\JavaExam\\src\\resources\\Immortalis.json"), Player.class);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
		characters.add(person);

		System.out.print("Welcome to the game\n");
		System.out.print("---------------------------------------------------------------------------------------------------------------\n");
		while(true){
			System.out.print("What do you want to do?\n");
			System.out.println("[1] Choose the character to start");
			System.out.println("[2] Add a new character");
			System.out.println("[3] Remove a character");
			System.out.println("[4] Start the game");
			System.out.println("[5] Exit");

			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();


			switch(choice) {
			case 1:
				String nameChoice;
				Utils.printAll();
				System.out.println("\nWho do you wanna play with?");
				scanner.nextLine();
				nameChoice = scanner.nextLine();
				for(Player p : characters) {
					if(p == null){
						break;
					}
					if(p.getName().equals(nameChoice)) {
						selected = p;
						System.out.printf("You have selected %s", selected.getName());
					}else {
						System.out.printf("Character not found\n");
					}
				}
				Game game = new Game(selected);
				game.start(selected);

				break;
			case 2:
				System.out.println("Do you a json file to load [Y/n]?");
				scanner.nextLine();
				if(scanner.nextLine().equalsIgnoreCase("y")) {
					System.out.println("Insert the file path");

					String path = scanner.nextLine();
					try {
						characters.add(objectMapper.readValue(new File("C:\\UFS04\\JavaExam\\src\\" + path + ".json"), Player.class));
					} catch(IOException e) {
						throw new RuntimeException(e);
					}
				}else {
					System.out.println("Manually add all the information");
					person = Utils.charBuilder();
					characters.add(person);
				}
				break;
			case 3:
				 System.out.println("Insert the name of the character you would like to remove");
				 scanner.nextLine();
				 nameChoice = scanner.nextLine();
				 for(Player p : characters) {
					 if(p.getName().equalsIgnoreCase(nameChoice)){
						 System.out.printf("You want to remove %s? [Y/n]\n", p.getName());
						 if(scanner.nextLine().equalsIgnoreCase("y")) {
							 characters.remove(p);
							 System.out.printf("You have removed %s\n", nameChoice);
							 break;
						 }else {
							 System.out.printf("Operation cancelled");
							 break;
						 }
					 }
				 }
				 break;
			case 4:
				 System.out.println("\nWho do you wanna play with?");
				 scanner.nextLine();
				 nameChoice = scanner.nextLine();
				 for(Player p : characters) {
					 if(p == null){
						 break;
					 }
					 if(p.getName().equals(nameChoice)) {
						 selected = p;
						 System.out.printf("You have selected %s \n", selected.getName());
					 }
				 }
				 Game game2 = new Game(selected);
				 game2.start(selected);
			case 5:
				System.exit(1);

			default:
				System.out.println("Invalid choice");
				break;
			}

	}
	}
}
