/**
 * CircleFunctionsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package me.ederign.javase;

public class CircleFunctionsServiceLocator extends org.apache.axis.client.Service implements me.ederign.javase.CircleFunctionsService {

    public CircleFunctionsServiceLocator() {
    }


    public CircleFunctionsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CircleFunctionsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CircleFunctionsPort
    private java.lang.String CircleFunctionsPort_address = "http://localhost:8888/WebServiceExample/circlefunctions";

    public java.lang.String getCircleFunctionsPortAddress() {
        return CircleFunctionsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CircleFunctionsPortWSDDServiceName = "CircleFunctionsPort";

    public java.lang.String getCircleFunctionsPortWSDDServiceName() {
        return CircleFunctionsPortWSDDServiceName;
    }

    public void setCircleFunctionsPortWSDDServiceName(java.lang.String name) {
        CircleFunctionsPortWSDDServiceName = name;
    }

    public me.ederign.javase.CircleFunctions getCircleFunctionsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CircleFunctionsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCircleFunctionsPort(endpoint);
    }

    public me.ederign.javase.CircleFunctions getCircleFunctionsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            me.ederign.javase.CircleFunctionsPortBindingStub _stub = new me.ederign.javase.CircleFunctionsPortBindingStub(portAddress, this);
            _stub.setPortName(getCircleFunctionsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCircleFunctionsPortEndpointAddress(java.lang.String address) {
        CircleFunctionsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (me.ederign.javase.CircleFunctions.class.isAssignableFrom(serviceEndpointInterface)) {
                me.ederign.javase.CircleFunctionsPortBindingStub _stub = new me.ederign.javase.CircleFunctionsPortBindingStub(new java.net.URL(CircleFunctionsPort_address), this);
                _stub.setPortName(getCircleFunctionsPortWSDDServiceName());
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
        if ("CircleFunctionsPort".equals(inputPortName)) {
            return getCircleFunctionsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://javase.ederign.me/", "CircleFunctionsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://javase.ederign.me/", "CircleFunctionsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CircleFunctionsPort".equals(portName)) {
            setCircleFunctionsPortEndpointAddress(address);
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
