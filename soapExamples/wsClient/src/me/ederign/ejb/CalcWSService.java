/**
 * CalcWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package me.ederign.ejb;

public interface CalcWSService extends javax.xml.rpc.Service {
    public java.lang.String getCalcWSPortAddress();

    public me.ederign.ejb.CalcWS getCalcWSPort() throws javax.xml.rpc.ServiceException;

    public me.ederign.ejb.CalcWS getCalcWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
