package com.tyss.thread.createThread;

public class TestC {
public static void main(String[] args) {
	System.out.println("main started");
	PVR p = new PVR();
//	for(int i=0;i<4;i++) {
//		System.out.println(i);
//   System.out.println("main ends.....");
	User u = new User(p);
	u.start(); 
	
	
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	      p.leaveme();
	      System.out.println("main ended..........");
	}
}

