package com.mydevco.javabp.language;

import java.awt.Point;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.Function;

public class InvokeDynamicExample {
	
	public MethodHandle getToStringMH() {
	    MethodHandle mh = null;
	    MethodType mt = MethodType.methodType(String.class);
	    MethodHandles.Lookup lk = MethodHandles.lookup();

	    try {
	        mh = lk.findVirtual(Point.class, "toString", mt);
	    } catch (NoSuchMethodException | IllegalAccessException mhx) {
	        throw (AssertionError)new AssertionError().initCause(mhx);
	    }

	    return mh;
	}
	
	public static void main(String[] args) {
		
		Point p = new Point(10, 20);
		
		InvokeDynamicExample ivde = new InvokeDynamicExample();
		MethodHandle mh = ivde.getToStringMH();
		try {
			String sp = (String) mh.invoke(p); //using method handle
			System.out.println(sp);
			
			Function<Point, String> f = point -> point.toString(); //using Function
			String si = f.apply(p);
			System.out.println(si);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
