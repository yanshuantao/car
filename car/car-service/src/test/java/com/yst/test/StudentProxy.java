package com.yst.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentProxy implements InvocationHandler{
	Person student;
	public StudentProxy(Person student){
		this.student=student;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before study");
		method.invoke(student, args);
		System.out.println("after study");
		return null;
	}

}
