package com.yst.test;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ProxyTest {

	public static void main(String[] args) {
//		Person student = new Student();
//		StudentProxy proxy=new StudentProxy(student);
//		Person studentproxy = (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), student.getClass().getInterfaces(), proxy);
//		studentproxy.study();
		Map map=new HashMap();
		map.put(1, 1);
		Map map2=new Hashtable();
		map2.put(1, 1);
	}

}
