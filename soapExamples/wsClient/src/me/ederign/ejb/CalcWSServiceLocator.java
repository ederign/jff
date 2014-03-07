/**
 * CalcWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package me.ederign.ejb;

public class CalcWSServiceLocator extends org.apache.axis.client.Service implements me.ederign.ejb.CalcWSService {

    public CalcWSServiceLocator() {
    }


    public CalcWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalcWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CalcWSPort
    private java.lang.String CalcWSPort_address = "http://localhost:8080/wsSamples/CalcWS";

    public java.lang.String getCalcWSPortAddress() {
        return CalcWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalcWSPortWSDDServiceName = "CalcWSPort";

    public java.lang.String getCalcWSPortWSDDServiceName() {
        return CalcWSPortWSDDServiceName;
    }

    public void setCalcWSPortWSDDServiceName(java.lang.String name) {
        CalcWSPortWSDDServiceName = name;
    }

    public me.ederign.ejb.CalcWS getCalcWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CalcWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalcWSPort(endpoint);
    }

    public me.ederign.ejb.CalcWS getCalcWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            me.ederign.ejb.CalcWSServiceSoapBindingStub _stub = new me.ederign.ejb.CalcWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCalcWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalcWSPortEndpointAddress(java.lang.String address) {
        CalcWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (me.ederign.ejb.CalcWS.class.isAssignableFrom(serviceEndpointInterface)) {
                me.ederign.ejb.CalcWSServiceSoapBindingStub _stub = new me.ederign.ejb.CalcWSServiceSoapBindingStub(new java.net.URL(CalcWSPort_address), this);
                _stub.setPortName(getCalcWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CalcWSPort".equals(inputPortName)) {
            return getCalcWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ejb.ederign.me/", "CalcWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ejb.ederign.me/", "CalcWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CalcWSPort".equals(portName)) {
            setCalcWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
