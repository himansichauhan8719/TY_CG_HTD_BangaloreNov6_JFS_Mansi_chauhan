package com.tyss.thread.createThread;

public class ThreadTest1 {
  public static void main(String[] args) {
	System.out.println("main started");
	Thread1 th = new Thread1();
	
	Thread th1 = new Thread(th);
	th.start();
	System.out.println("main method");
}
}
