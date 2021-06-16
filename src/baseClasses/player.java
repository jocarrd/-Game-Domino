package baseClasses;

import java.util.ArrayList;
import java.util.List;

public abstract class player {
	String name;
	List<chip> all= new ArrayList<>();
	List<chip> canPlay = new ArrayList<>();

	

	public abstract void playChip(table a);

	public boolean canPlay(table a) {
		//Pre: table must have been initialized
		//Pre : return true if the player can play , false in other case
		return !this.canPlay.isEmpty();
	}

	public int sumChips() {
		//Pre: Player must have been initialized
		//Post: sum value of Chips 
		int value = 0;
		for (chip a : this.all) {
			value = a.value() + value;
		}
		return value;

	}
	public void updateCanPut(table a) {
		//Pre: table must have been initialized
		//Post:  reset value of canPut
		this.canPlay.clear();
		for (chip d : this.all) {
			if (a.canPut(d)) {
				this.canPlay.add(d);
			}
		}
	}

	public int numOfChips() {
		//Pre: Player must have been initialized
		//Post return number of chips
		return this.all.size();

	}
	
	public boolean isEmpty() {
		//Pre: Player must have been initialized
		//Post: returns true if the player has no chips, false other case
		return this.all.isEmpty();
	}

}
