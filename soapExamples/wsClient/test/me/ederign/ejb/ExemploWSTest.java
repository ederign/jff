package me.ederign.ejb;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class ExemploWSTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void hello() throws RemoteException {
		ExemploWSProxy proxy = new ExemploWSProxy();
		assertEquals("Ola Mundo!!!",proxy.olaMundo());
	}

}
