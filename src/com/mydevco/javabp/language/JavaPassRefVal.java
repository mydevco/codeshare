package com.mydevco.javabp.language;

import java.awt.Point;

public class JavaPassRefVal {

	public JavaPassRefVal() { }
	
	public static void passByReference(Point ref) {
		ref.x = 50;
		ref.y = 50;
		System.out.println(ref);
		ref = new Point(20, 20);
		System.out.println(ref);
	}
	
	public static void passByCopyOfValue(long longValue) {
		longValue = 50;
		System.out.println(longValue);
	}
	
	
	public static void main(String[] args) {
		
		Point refIn = new Point(10,10);
		System.out.println(refIn);
		passByReference(refIn);
		System.out.println(refIn);
		
		long valIn = 30;
		System.out.println(valIn);
		passByCopyOfValue(valIn);
		System.out.println(valIn);
		
	}

}
