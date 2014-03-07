package org.correios;

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
		CalcPrecoPrazoWSSoapProxy proxy = new CalcPrecoPrazoWSSoapProxy();
		String nCdServico = "40010";
		String sCepOrigem = "13087508";
		String sCepDestino = "86804290";
		
		CResultado calcPrazo = proxy.calcPrazo(nCdServico, sCepOrigem, sCepDestino);
		CServico[] servicos = calcPrazo.getServicos();
		assertEquals(3,servicos[0].getPrazoEntrega());
	}

}
