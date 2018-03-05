package concurrent_assignment2.A1;

import concurrent_assignment2.A_intro.Queue;

/**Use condition synchronization by means of busy wait.
 * 
 * What kind of variable do you need to implement busy
 * wait synchronization?
 * 
 * Set a meaningful name for such variable.
 * */
 
class CS_Queue implements Queue{
	volatile int n=0;
	volatile boolean readerTurn=false;
	@Override
	public void read() {
		// TODO Auto-generated method stub
            while(!readerTurn);
            System.out.println(n);
            System.out.println("Writer turn");
            readerTurn=false;
            
	}

	@Override
	public void write(int x) {
		// TODO Auto-generated method stub
              while (readerTurn);
              
                  n=x;
              System.out.println(n);
              System.out.println("Reader turn");
              readerTurn=true;
              
	}

	@Override
	public void read(int ID) {
		// no need to implement this
		
	}
	
	
}





