package me.ederign.xml.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JavaToXmlObject<T> {

	public void marshalling(T t, String filePath, Class<T>... classes) {

		try {

			File file = new File(filePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(classes);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(t, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
