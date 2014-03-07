/**
 * HelloWorldWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package me.ederign.ws;

public class HelloWorldWSServiceLocator extends org.apache.axis.client.Service implements me.ederign.ws.HelloWorldWSService {

    public HelloWorldWSServiceLocator() {
    }


    public HelloWorldWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloWorldWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloWorldWSPort
    private java.lang.String HelloWorldWSPort_address = "http://localhost:8080/wsSamples/HelloWorldWS";

    public java.lang.String getHelloWorldWSPortAddress() {
        return HelloWorldWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloWorldWSPortWSDDServiceName = "HelloWorldWSPort";

    public java.lang.String getHelloWorldWSPortWSDDServiceName() {
        return HelloWorldWSPortWSDDServiceName;
    }

    public void setHelloWorldWSPortWSDDServiceName(java.lang.String name) {
        HelloWorldWSPortWSDDServiceName = name;
    }

    public me.ederign.ws.HelloWorldWS getHelloWorldWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloWorldWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloWorldWSPort(endpoint);
    }

    public me.ederign.ws.HelloWorldWS getHelloWorldWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            me.ederign.ws.HelloWorldWSServiceSoapBindingStub _stub = new me.ederign.ws.HelloWorldWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getHelloWorldWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloWorldWSPortEndpointAddress(java.lang.String address) {
        HelloWorldWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (me.ederign.ws.HelloWorldWS.class.isAssignableFrom(serviceEndpointInterface)) {
                me.ederign.ws.HelloWorldWSServiceSoapBindingStub _stub = new me.ederign.ws.HelloWorldWSServiceSoapBindingStub(new java.net.URL(HelloWorldWSPort_address), this);
                _stub.setPortName(getHelloWorldWSPortWSDDServiceName());
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
        if ("HelloWorldWSPort".equals(inputPortName)) {
            return getHelloWorldWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.ederign.me/", "HelloWorldWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.ederign.me/", "HelloWorldWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloWorldWSPort".equals(portName)) {
            setHelloWorldWSPortEndpointAddress(address);
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
