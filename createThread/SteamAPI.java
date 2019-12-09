package com.tyss.thread.createThread;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SteamAPI {
 public static void main(String[] args) {
	System.out.println("..........PREDICATE.........");
	Predicate<Integer> p = i -> i%2 == 0;
	boolean b1 = p.test(12);
	System.out.println(b1);
	System.out.println(p.test(45));
	
	
	
	System.out.println("......FUNCTION.........");
	Function<Integer,Integer> f1 = i -> i*100;
	int a = f1.apply(86);
	System.out.println(a);
	System.out.println(f1.apply(37));
	
	
	
	System.out.println(".......SUPPLIER.........");
	Supplier<Person> s1 = () -> new Person(24,"Anu");
	System.out.println(s1.get().getAge());
	System.out.println(s1.get().getName());
	
	
	
	System.out.println(".......CONSUMER..........");
	Consumer<Person> c1 = j ->{
    System.out.println(j.getAge());
    System.out.println(j.getName());
	};
	
	Person p1 = new Person(23,"himanshu");
	c1.accept(p1);
}
}
