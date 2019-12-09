package com.tyss.thread.createThread;

public class IRCTC {
	 void confirmtic() {
		 for(int i =0;i<5;i++) {
			 System.out.println(i);
			 try {
			Thread.sleep(1000);			}
				 catch (InterruptedException e) {
				System.out.println(e.getMessage());
			
		       }
			 try{
				 wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
		    }
	    }
	 
	  synchronized void leaveme() {
		System.out.println("notify called");  
		notifyAll();
	  }
}
