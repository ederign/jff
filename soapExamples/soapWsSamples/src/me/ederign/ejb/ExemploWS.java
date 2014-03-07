package me.ederign.ejb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
@Stateless()
public class ExemploWS {

  @WebMethod(operationName = "olaMundo")
  public String olaMundo() {
    return "Ola Mundo!!!";
  }
}