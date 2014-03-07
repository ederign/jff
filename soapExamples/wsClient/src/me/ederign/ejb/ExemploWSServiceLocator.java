/**
 * ExemploWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package me.ederign.ejb;

public class ExemploWSServiceLocator extends org.apache.axis.client.Service implements me.ederign.ejb.ExemploWSService {

    public ExemploWSServiceLocator() {
    }


    public ExemploWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ExemploWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ExemploWSPort
    private java.lang.String ExemploWSPort_address = "http://localhost:8080/wsSamples/ExemploWS";

    public java.lang.String getExemploWSPortAddress() {
        return ExemploWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ExemploWSPortWSDDServiceName = "ExemploWSPort";

    public java.lang.String getExemploWSPortWSDDServiceName() {
        return ExemploWSPortWSDDServiceName;
    }

    public void setExemploWSPortWSDDServiceName(java.lang.String name) {
        ExemploWSPortWSDDServiceName = name;
    }

    public me.ederign.ejb.ExemploWS getExemploWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ExemploWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getExemploWSPort(endpoint);
    }

    public me.ederign.ejb.ExemploWS getExemploWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            me.ederign.ejb.ExemploWSServiceSoapBindingStub _stub = new me.ederign.ejb.ExemploWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getExemploWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setExemploWSPortEndpointAddress(java.lang.String address) {
        ExemploWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (me.ederign.ejb.ExemploWS.class.isAssignableFrom(serviceEndpointInterface)) {
                me.ederign.ejb.ExemploWSServiceSoapBindingStub _stub = new me.ederign.ejb.ExemploWSServiceSoapBindingStub(new java.net.URL(ExemploWSPort_address), this);
                _stub.setPortName(getExemploWSPortWSDDServiceName());
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
        if ("ExemploWSPort".equals(inputPortName)) {
            return getExemploWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ejb.ederign.me/", "ExemploWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ejb.ederign.me/", "ExemploWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ExemploWSPort".equals(portName)) {
            setExemploWSPortEndpointAddress(address);
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
