package com.yst.common.pojo;

public class T2 implements Cloneable{
	public T2(){
		System.out.println("I am T2");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
