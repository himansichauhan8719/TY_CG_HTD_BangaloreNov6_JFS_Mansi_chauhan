package com.tyss.thread.createThread;

public class User extends Thread {
 PVR p;

public User(PVR p) {
	super();
	this.p = p;
}
 public void run() {
	 p.confirmtic();
 }
}
