package baseClasses;

import java.util.Scanner;

public class IA extends player {

	public IA(String n) {
		// Pre: non
		// Post initialized IA
		this.name = n;

	}

	public void playChip(table a) {

		// Pre: Table must have been initialized
		/*
		 * this method manages how the AI ​​selects a chip to put on the table
		 */
		System.out.println("it's " + this.name + "'s turn");
		System.out.println("---------------------------------------------------------------------");

		this.updateCanPut(a);
		a.show();

		if (this.canPlay(a)) {
			System.out.println();
			this.updateCanPut(a);
			
			
			int i=-1;
			for(chip x : this.canPlay) {
				
				if(x.isdouble()) {
					i=this.canPlay.indexOf(x);
					
				}
			}
			
			// the IA ​​will put the double chips first
			if(i!=-1) {
				a.put(this.canPlay.get(i));
				this.all.remove(this.canPlay.get(i));
				
			}else {
			
			a.put(this.canPlay.get(0));
			this.all.remove(this.canPlay.get(0));
			}

		} else {
			do {
				System.out.println();
				System.out.println("You cant play , steal :(");
				if (!a.free.isEmpty()) {
					this.all.add(a.free.get(0));
					this.all.remove(a.free.get(0));
					this.updateCanPut(a);
				}

			} while (!this.canPlay(a) && (!a.free.isEmpty()));

			this.updateCanPut(a);
			if (this.canPlay.isEmpty()) {
				System.out.println("You cant put");
				return;
			}
			a.put(this.canPlay.get(0));
			this.canPlay.remove(this.canPlay.get(0));
			this.updateCanPut(a);
		}

	}

}
