package com.tyss.thread.createThread;

public class PVR {
 void confirmtic() {
	 for(int i =0;i<4;i++) {
		 System.out.println(i);
//		 try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			System.out.println(e.getMessage());
//		
//		}
		 try{
			 wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
	    }
    }
 
  synchronized void leaveme() {
	System.out.println("notify called");  
	notify();
  }
}
