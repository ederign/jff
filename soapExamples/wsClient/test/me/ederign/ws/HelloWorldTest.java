package me.ederign.ws;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void hello() throws RemoteException {
		HelloWorldWSProxy proxy = new HelloWorldWSProxy();
		assertEquals("Hello, Eder.",proxy.sayHello("Eder"));
	}

}
