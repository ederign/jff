package me.ederign.ejb;

public class ExemploWSProxy implements me.ederign.ejb.ExemploWS {
  private String _endpoint = null;
  private me.ederign.ejb.ExemploWS exemploWS = null;
  
  public ExemploWSProxy() {
    _initExemploWSProxy();
  }
  
  public ExemploWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initExemploWSProxy();
  }
  
  private void _initExemploWSProxy() {
    try {
      exemploWS = (new me.ederign.ejb.ExemploWSServiceLocator()).getExemploWSPort();
      if (exemploWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)exemploWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)exemploWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (exemploWS != null)
      ((javax.xml.rpc.Stub)exemploWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public me.ederign.ejb.ExemploWS getExemploWS() {
    if (exemploWS == null)
      _initExemploWSProxy();
    return exemploWS;
  }
  
  public java.lang.String olaMundo() throws java.rmi.RemoteException{
    if (exemploWS == null)
      _initExemploWSProxy();
    return exemploWS.olaMundo();
  }
  
  
}