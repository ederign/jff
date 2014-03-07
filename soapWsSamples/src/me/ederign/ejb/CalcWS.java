package me.ederign.ejb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
@Stateless()
public class CalcWS {
	
	  @WebMethod(operationName = "soma")
	  public Integer soma(Integer a, Integer b) {
	    return a+b;
	  }
}