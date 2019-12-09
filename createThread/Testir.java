package com.tyss.thread.createThread;

public class Testir {
public static void main(String[] args) {
	 System.out.println("main started....");
	 IRCTC il = new IRCTC();
	 User1 u1 = new User1(il);
	 u1.start();
	 
	 User1 u2 = new User1(il);
	 u2.start();
}
}
