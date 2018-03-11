package concurrent_assignment2.A3;

import concurrent_assignment2.A_intro.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use the synchronized keyword and signals.
 * 
 * You cannot decide whose's turn it is based on 
 * a 2 states variables, so now use a variable which
 * allows for more values (you need 3 states, that is, 3 turns).
 * 
 * Output should be: writer prints, both readers read, and so on...
 *
 */
 
class Signalled_2Readers_Queue implements Queue{
	volatile int n=0;
        volatile int turn=0;
	
	
	@Override
	synchronized public void read(int ID) {
		// TODO Auto-generated method stub
		if(turn==ID){ // SI ES IGUAL ID , PRINT Y LE SUMO 1 PARA QUE SEA EL TURNO DEL SIGUIENTE Y LUEGO LO PONGO A 0 PARA QUE VUELVA EL WRITER
                System.out.println("ID:  "+ID+"  Value:"+n);
                turn++;
                notifyAll();
    				}
    
    try {wait();} catch (InterruptedException ex) {}
	}
	

	@Override
	synchronized public void write(int x) {
		// TODO Auto-generated method stub
		if (turn!=2){
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                    }
                }
                n=x;
                turn=0;
                notifyAll();
	}
	
	@Override
	public void read() {
		// no need to implement this
		
	}

	
	
	
}



