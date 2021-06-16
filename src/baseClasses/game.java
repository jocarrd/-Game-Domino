package baseClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class game {
	table match;
	List<player> players = new ArrayList<>();

	public game() throws InterruptedException {
		// Pre: table must have been initialized
		// Post: this method manages player turns and player-table interactions

		this.match = new table();
		System.out.println("Human Players :");
		Scanner entrada = new Scanner(System.in);
		int n = entrada.nextInt();
		int p = 0;
		do {
			System.out.println();
			System.out.println("Name of Human Player  " + p);

			String name = entrada.nextLine();

			human nuevo = new human(name);

			this.players.add(nuevo);
			p++;

		} while (p < n);

		System.out.println("IA Players:");
		int x = entrada.nextInt();
		for (int i = 0; i < x; i++) {
			IA nuevo = new IA("BOT" + i);
			this.players.add(nuevo);

		}

		System.out.println("Now is time to play , good luck");
		this.dealChips();
		
		player play=null;
		//allows the player with the 6 doubles to start playing
		for(player a : this.players) {
			for(chip z :a.all ) {
				if(z.isdouble() && z.value()==12) {
					 play=a;
					
				}
			}
		}
		this.players.remove(play);
		this.players.add(0, play);

		while (!this.finish()) {
			for (player a : this.players) {
				System.out.println("----------------------------------------------------------------");
				a.updateCanPut(this.match);
				a.playChip(this.match);
				a.updateCanPut(this.match);

			}

		}
	}

	public void dealChips() {
		// Pre: table must have been initialized
		// Post : deal 7 chips to each player

		for (player a : this.players) {
			for (int i = 0; i < 7; i++) {
				if (!this.match.free.isEmpty()) {
					a.all.add(this.match.free.get(0));
					this.match.free.remove(0);
				}
			}

		}
	}

	public boolean finish() {

		// table must have been initialized
		// returns true if the game ended false othercase
		
		

		for (player a : this.players) {
			if (a.isEmpty()) {
				System.out.println("Winner :" + a.name);
				return true;
			}
			
		}

		
		return false;

	}
}
