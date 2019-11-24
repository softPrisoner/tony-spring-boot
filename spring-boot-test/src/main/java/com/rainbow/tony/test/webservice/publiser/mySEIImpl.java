package com.rainbow.tony.test.webservice.publiser;

public class mySEIImpl implements mySEI {

	@Override
	public String sayHello(String name) {
		System.out.println("���" + name);
		return "hello" + name;
	}

}
