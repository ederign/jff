package me.ederign.ejb;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class PessoaServiceWSTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void helloPessoa() throws RemoteException {
		CalcWSProxy proxy = new CalcWSProxy();
		assertEquals(2,proxy.soma(1,1).intValue());
	}

}
