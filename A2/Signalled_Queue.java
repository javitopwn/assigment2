package concurrent_assignment2.A2;

import concurrent_assignment2.A_intro.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use the synchronized keyword and signals so that
 * you do not need to busy wait.
 * But of course you still need your variable to know
 * whose's turn it is.
 *
 */
 
class Signalled_Queue implements Queue{
	int n=0;
	boolean readerTurn=false;
	@Override
	synchronized public void read() {
		// TODO Auto-generated method stub
                if(!readerTurn){
                    try {
                        wait();
                    } catch (InterruptedException ex) {

                    }
                }
		System.out.println(n);
                readerTurn=false;
                notify();
	}

	@Override
	synchronized public void write(int x) {
		// TODO Auto-generated method stub
                // TODO Auto-generated method stub
                if(readerTurn){
                    try {
                        wait();
                    } catch (InterruptedException ex) {

                    }
                }
            n=x;
                System.out.println(n);
                readerTurn=true;
                notify();
	}

	@Override
	public void read(int ID) {
		// no need to implement this
		
	}
	
	
}

