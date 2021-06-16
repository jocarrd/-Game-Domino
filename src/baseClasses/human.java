package baseClasses;

import java.util.Scanner;

public class human extends player {

	public human(String n) {
		//Pre: non
		//Post initialize human
		this.name=n;

	}
	
	

	public void playChip(table a) {
		//Pre: Table must have been initialized
				/*
				 * this method manages how a player ​​selects a chip to put on the table
				 */

		System.out.println("it's "+this.name+"'s turn");
		System.out.println("---------------------------------------------------------------------");
		System.out.println();
		System.out.println("Your chips");	
		for(chip f : this.all) {
			f.show();
		}
		
		this.updateCanPut(a);
		a.show();

	
		if (this.canPlay(a)) {
			System.out.println();
			this.updateCanPut(a);
			System.out.println("You can put this chips :");
			for (chip put : this.canPlay) {
				put.show();	
			}
			System.out.println();
			System.out.println("Now select a chip (1,2,3,4,5,6 ...)");
			Scanner entrada = new Scanner(System.in);
			int n = entrada.nextInt();
			 a.put(this.canPlay.get(n));
			 this.all.remove(this.canPlay.get(n));

		} else {
			do {
			System.out.println();
			System.out.println("You cant play , steal :(");
			if(!a.free.isEmpty()){
			this.all.add(a.free.get(0));
			this.all.remove(a.free.get(0));
			this.updateCanPut(a);}
			
			
			}while (!this.canPlay(a)&&(!a.free.isEmpty() ));
			for (chip put : this.canPlay) {
				put.show();	
			}
			this.updateCanPut(a);
			if(this.canPlay.isEmpty()) {
				System.out.println("You cant put");
				return;
			}
			System.out.println("You can put this chips :");
			for (chip put : this.canPlay) {
				put.show();	
			
			
			
			System.out.println("Now select a chip (0,1,2,3,4,5,6 ...)");
			Scanner entrada = new Scanner(System.in);
			int n = entrada.nextInt();
			a.put(this.canPlay.get(n));
			this.canPlay.remove(this.canPlay.get(n));
			this.updateCanPut(a);
			}
			
			
		}

	}

}
