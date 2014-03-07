package me.ederign.javase;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class CircleFunctions {

	public double getArea(double r) {
		return java.lang.Math.PI * (r * r);
	}

	public double getCircumference(double r) {
		return 2 * java.lang.Math.PI * r;
	}

	public static void main(String[] args) {
		Endpoint.publish(
				"http://localhost:8888/WebServiceExample/circlefunctions",
				new CircleFunctions());
		while (true){
			
		}


	}
}