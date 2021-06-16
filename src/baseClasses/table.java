package baseClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class table {
	public List<chip> free = new ArrayList<>();
	public LinkedList<chip> placed = new LinkedList<>();

	public table() {
		// Pre: non
		// Post: initialize table(generate chips)
		this.generateChips();
		Collections.shuffle(free);
	}

	private void generateChips() {
		// Pre: non
		// Post: this method generates all the chips of the game
		boolean repeat = false;
		chip ficha;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				repeat = false;
				ficha = new chip(i, j);
				for (chip b : this.free) {
					if (b.equals(ficha, b)) {
						repeat = true;
					}
				}
				if (repeat == false)
					this.free.add(ficha);

			}
		}

	}

	public void show() {
		// Pre: non
		// Post: show the tiles that are on the table

		Iterator<chip> iter = this.placed.iterator();
		System.out.println();
		System.out.println("Table :");
		while (iter.hasNext()) {
			iter.next().show();

		}
	}

	public boolean canPut(chip a) {
		// Pre: chip must have been initialized
		/*
		 * returns true if the chip can be put on the table, false othercase
		 */
		if (this.placed.isEmpty()) {
			return true;
		}
		if (this.placed.getFirst().izq() == a.izq() || this.placed.getFirst().izq() == a.de()
				|| this.placed.getLast().de() == a.izq() || this.placed.getLast().de() == a.de()) {
			return true;
		}
		return false;

	}

	public void put(chip a) {
		// Pre: chip and table must have been initialized
		//Post : put a chip on the table
		if (this.placed.isEmpty()) {
			this.placed.add(a);
		} else {

			if (this.canPut(a)) {
				if (this.placed.getFirst().izq() == a.izq()) {
					a.turn();
					this.placed.addFirst(a);
				} else {

					if (this.placed.getFirst().izq() == a.de()) {
						this.placed.addFirst(a);
					} else {

						if (this.placed.getLast().de() == a.de()) {
							a.turn();
							this.placed.addLast(a);
						} else {

							if (this.placed.getLast().de() == a.izq()) {
								this.placed.addLast(a);
							} else {
							}
						}
					}
				}
			}
		}
	}

}
