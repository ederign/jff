/**
 * HelloWorldWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package me.ederign.ws;

public interface HelloWorldWSService extends javax.xml.rpc.Service {
    public java.lang.String getHelloWorldWSPortAddress();

    public me.ederign.ws.HelloWorldWS getHelloWorldWSPort() throws javax.xml.rpc.ServiceException;

    public me.ederign.ws.HelloWorldWS getHelloWorldWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
