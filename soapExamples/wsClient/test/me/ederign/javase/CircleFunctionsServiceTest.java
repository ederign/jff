package me.ederign.javase;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class CircleFunctionsServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void hello() throws RemoteException {
		CircleFunctionsProxy proxy = new CircleFunctionsProxy();
		assertEquals(28.274333882308138,proxy.getArea(3.0), 0.01);
	}

}
