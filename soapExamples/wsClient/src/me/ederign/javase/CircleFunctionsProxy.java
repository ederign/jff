package me.ederign.javase;

public class CircleFunctionsProxy implements me.ederign.javase.CircleFunctions {
  private String _endpoint = null;
  private me.ederign.javase.CircleFunctions circleFunctions = null;
  
  public CircleFunctionsProxy() {
    _initCircleFunctionsProxy();
  }
  
  public CircleFunctionsProxy(String endpoint) {
    _endpoint = endpoint;
    _initCircleFunctionsProxy();
  }
  
  private void _initCircleFunctionsProxy() {
    try {
      circleFunctions = (new me.ederign.javase.CircleFunctionsServiceLocator()).getCircleFunctionsPort();
      if (circleFunctions != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)circleFunctions)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)circleFunctions)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (circleFunctions != null)
      ((javax.xml.rpc.Stub)circleFunctions)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public me.ederign.javase.CircleFunctions getCircleFunctions() {
    if (circleFunctions == null)
      _initCircleFunctionsProxy();
    return circleFunctions;
  }
  
  public double getArea(double arg0) throws java.rmi.RemoteException{
    if (circleFunctions == null)
      _initCircleFunctionsProxy();
    return circleFunctions.getArea(arg0);
  }
  
  public double getCircumference(double arg0) throws java.rmi.RemoteException{
    if (circleFunctions == null)
      _initCircleFunctionsProxy();
    return circleFunctions.getCircumference(arg0);
  }
  
  
}