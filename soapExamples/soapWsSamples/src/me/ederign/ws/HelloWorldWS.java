package me.ederign.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldWS {

	private String message = new String("Hello, ");

	@WebMethod
	public String sayHello(String name) {
		return message + name + ".";
	}

}
