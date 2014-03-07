package org.stockquote;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class CorreiosTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void hello() throws RemoteException {
		StockQuoteSoapProxy proxy = new StockQuoteSoapProxy();
		String quote = proxy.getQuote("RHT");
		System.out.println(quote);
		assertNotNull(quote);
	}

}
