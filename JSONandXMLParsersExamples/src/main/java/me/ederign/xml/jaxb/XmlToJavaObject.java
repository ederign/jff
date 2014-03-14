package me.ederign.xml.jaxb;

import java.io.File;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class XmlToJavaObject<T> {

	public T getObject(String filePath, Class<T>... classes)
			throws JAXBException {

		File file = openFile(filePath);

		JAXBContext jaxbContext = creatingJAXBContext(classes);

		return (T) jaxbContext.createUnmarshaller().unmarshal(file);
	}

	private JAXBContext creatingJAXBContext(Class<T>... jaxbClass)
			throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(jaxbClass);
		return jaxbContext;
	}

	private File openFile(String filePath) {
		File file = new File(filePath);
		return file;
	}

}
