package baseClasses;

public class chip {
	private int chip[] = new int[2];

	public chip(int iz, int de) {
		//Pre: non
		//Post initialize chip
		chip[0] = iz;
		chip[1] = de;
	}

	public int value() {
		//Pre: chip must have been initialized
		//Post: return value of chip
		return this.chip[0] + this.chip[1];
	}

	public void turn() {
		//Pre: chip must have been initialized
		//Post: turn chip
		int aux = this.chip[0];
		this.chip[0] = this.chip[1];
		this.chip[1] = aux;
	}

	public boolean contains(int d) {
		//Pre: chip must have been initialized
		//Post: return true if chip contains d , false in other case
		
		if (this.chip[0] == d || this.chip[1] == d) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isdouble() {
		//Pre: chip must have been initialized
		//Post: return true if chip is double , false in other case

		if (this.chip[0] == this.chip[1]) {
			return true;
		} else
			return false;
	}
	public int izq() {
		//Pre: chip must have been initialized
		//Post: returns the value of the left part of the chip
		return this.chip[0];
	}
	public int de() {
		//Pre: chip must have been initialized
		//Post: returns the value of the right part of the chip
		return this.chip[1];
	}
	
	public void show() {
		//Pre: chip must have been initialized
		//Print the chip
		System.out.print("["+this.chip[0]+"|"+this.chip[1]+"]");
	}
	
	public boolean equals(chip a ,chip b) {
		
		//Pre: chip must have been initialized
		//Post: returns true if the chips are equal false otherwise
		if(a.chip[0]==b.chip[1] && a.chip[1]==b.chip[0]) {
			return true;
		}
		
		if(a.chip[0]==b.chip[0] && a.chip[1]==b.chip[1]) {
			return true;
		}
		return false;
	}
	
}
