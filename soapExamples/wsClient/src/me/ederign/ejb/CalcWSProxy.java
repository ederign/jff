package me.ederign.ejb;

public class CalcWSProxy implements me.ederign.ejb.CalcWS {
  private String _endpoint = null;
  private me.ederign.ejb.CalcWS calcWS = null;
  
  public CalcWSProxy() {
    _initCalcWSProxy();
  }
  
  public CalcWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalcWSProxy();
  }
  
  private void _initCalcWSProxy() {
    try {
      calcWS = (new me.ederign.ejb.CalcWSServiceLocator()).getCalcWSPort();
      if (calcWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calcWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calcWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calcWS != null)
      ((javax.xml.rpc.Stub)calcWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public me.ederign.ejb.CalcWS getCalcWS() {
    if (calcWS == null)
      _initCalcWSProxy();
    return calcWS;
  }
  
  public java.lang.Integer soma(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException{
    if (calcWS == null)
      _initCalcWSProxy();
    return calcWS.soma(arg0, arg1);
  }
  
  
}